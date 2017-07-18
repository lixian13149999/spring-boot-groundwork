package com.bcdbook.common.demo.redis;

import com.alibaba.fastjson.JSON;
import com.bcdbook.common.result.Result;
import com.bcdbook.common.result.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by lason on 2017/7/18.
 */
@RestController
@RequestMapping("/demo/redis")
public class RedisController {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @GetMapping("/user")
    public Result getUser(){
        String redisUserString = stringRedisTemplate.opsForValue().get("summer");
        RedisUser redisUserBack = (RedisUser) JSON.parseObject(redisUserString,RedisUser.class);
        return ResultUtil.success(redisUserBack);
    }

    @GetMapping("/user2")
    public Result getUser2(){
        String redisUserString = stringRedisTemplate.opsForValue().get("summer");
        return ResultUtil.success(redisUserString);
    }


    @GetMapping("/user3")
    public Result getUser3(){
        return ResultUtil.success(new RedisUser("summer",18));
    }

}
