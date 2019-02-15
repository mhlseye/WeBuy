package com.wyd.seckill.rabbitmq;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.wyd.seckill.domain.SeckillOrder;
import com.wyd.seckill.domain.SeckillUser;
import com.wyd.seckill.redis.RedisService;
import com.wyd.seckill.service.GoodsService;
import com.wyd.seckill.service.OrderService;
import com.wyd.seckill.service.SeckillService;
import com.wyd.seckill.vo.GoodsVo;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MQReceiver {

    private static Logger log = LoggerFactory.getLogger(MQReceiver.class);

    @Autowired
    RedisService redisService;

    @Autowired
    GoodsService goodsService;

    @Autowired
    OrderService orderService;

    @Autowired
    SeckillService seckillService;

    @RabbitListener(queues=MQConfig.Seckill_QUEUE)
    public void receive(String message) {
        log.info("receive message:"+message);
        SeckillMessage mm  = RedisService.stringToBean(message, SeckillMessage.class);
        SeckillUser user = mm.getUser();
        long goodsId = mm.getGoodsId();

        GoodsVo goods = goodsService.getGoodsVoByGoodsId(goodsId);
        int stock = goods.getStockCount();
        if(stock <= 0) {
            return;
        }
        //判断是否已经秒杀到了
        SeckillOrder order = orderService.getSeckillOrderByUserIdGoodsId(user.getId(), goodsId);
        if(order != null) {
            return;
        }
        //减库存 下订单 写入秒杀订单
        seckillService.seckill(user, goods);
    }

    @RabbitListener(queues=MQConfig.QUEUE)
    public void receive2(String message) {
        log.info("receive message:"+message);
    }
}
