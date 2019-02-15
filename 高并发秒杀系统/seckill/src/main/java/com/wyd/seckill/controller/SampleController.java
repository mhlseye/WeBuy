package com.wyd.seckill.controller;

import com.wyd.seckill.domain.User;
import com.wyd.seckill.rabbitmq.MQSender;
import com.wyd.seckill.redis.RedisService;
import com.wyd.seckill.redis.UserKey;
import com.wyd.seckill.result.CodeMsg;
import com.wyd.seckill.result.Result;
import com.wyd.seckill.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("/demo")
public class SampleController {

    @Autowired
    UserService userService;

    @Autowired
    RedisService redisService;

    @Autowired
    MQSender sender;

    @RequestMapping("/mq")
    @ResponseBody
    public Result<String> mq() {
        sender.send("hello,imooc");
        return Result.success("Hello，world");
    }

    @RequestMapping("/hello")
    @ResponseBody
    public Result<String> home() {
        return Result.success("Hello，world");
    }

    @RequestMapping("/error")
    @ResponseBody
    public Result<String> error() {
        return Result.error(CodeMsg.SESSION_ERROR);
    }

    @RequestMapping("/hello/themaleaf")
    public String themaleaf(Model model) {
        model.addAttribute("name", "Joshua");
        return "hello";
    }

    @RequestMapping("/db/get")
    @ResponseBody
    public Result<User> dbGet() {
        User user = userService.getById(1);
        return Result.success(user);
    }

    @RequestMapping("/db/tx")
    @ResponseBody
    public Result<Boolean> dbTx() {
        userService.tx();
        return Result.success(true);
    }

    @RequestMapping("/redis/get")
    @ResponseBody
    public Result<User> redisGet() {
        User  user  = redisService.get(UserKey.getById, ""+1, User.class);
        return Result.success(user);
    }

    @RequestMapping("/redis/set")
    @ResponseBody
    public Result<Boolean> redisSet() {
        User user  = new User();
        user.setId(1);
        user.setName("1111");
        redisService.set(UserKey.getById, ""+1, user);//UserKey:id1
        return Result.success(true);
    }

    @RequestMapping("/redis/setnxex")
    @ResponseBody
    public Result<String> redisSetnxex() {
        User user  = new User();
        user.setId(1);
        user.setName("1111");
        boolean ret1 = redisService.setNXEX(UserKey.getById, ""+1, user);
        boolean ret2 = redisService.setNXEX(UserKey.getById, ""+1, user);
        return Result.success(ret1+","+ret2);
    }

    @RequestMapping("/array")
    @ResponseBody
    public Result<List<String>> array(@RequestParam("names")String[] names) {
        return Result.success(Arrays.asList(names));
    }
}
