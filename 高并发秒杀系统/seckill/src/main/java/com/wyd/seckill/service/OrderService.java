package com.wyd.seckill.service;

import com.wyd.seckill.dao.OrderDao;
import com.wyd.seckill.domain.OrderInfo;
import com.wyd.seckill.domain.SeckillOrder;
import com.wyd.seckill.domain.SeckillUser;
import com.wyd.seckill.redis.OrderKey;
import com.wyd.seckill.redis.RedisService;
import com.wyd.seckill.vo.GoodsVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

@Service
public class OrderService {
	
	@Autowired
	OrderDao orderDao;
	
	@Autowired
	RedisService redisService;
	
	public SeckillOrder getSeckillOrderByUserIdGoodsId(long userId, long goodsId) {
		//return orderDao.getSeckillOrderByUserIdGoodsId(userId, goodsId);
		return redisService.get(OrderKey.getSeckillOrderByUidGid, ""+userId+"_"+goodsId, SeckillOrder.class);
	}
	
	public OrderInfo getOrderById(long orderId) {
		return orderDao.getOrderById(orderId);
	}
	

	@Transactional
	public OrderInfo createOrder(SeckillUser user, GoodsVo goods) {
		OrderInfo orderInfo = new OrderInfo();
		orderInfo.setCreateDate(new Date());
		orderInfo.setDeliveryAddrId(0L);
		orderInfo.setGoodsCount(1);
		orderInfo.setGoodsId(goods.getId());
		orderInfo.setGoodsName(goods.getGoodsName());
		orderInfo.setGoodsPrice(goods.getSeckillPrice());
		orderInfo.setOrderChannel(1);
		orderInfo.setStatus(0);
		orderInfo.setUserId(user.getId());
		orderDao.insert(orderInfo);

		SeckillOrder seckillOrder = new SeckillOrder();
		seckillOrder.setGoodsId(goods.getId());
		seckillOrder.setOrderId(orderInfo.getId());
		seckillOrder.setUserId(user.getId());
		orderDao.insertSeckillOrder(seckillOrder);
		
		redisService.set(OrderKey.getSeckillOrderByUidGid, ""+user.getId()+"_"+goods.getId(), seckillOrder);
		 
		return orderInfo;
	}

	public void deleteOrders() {
		orderDao.deleteOrders();
		orderDao.deleteSeckillOrders();
	}

}
