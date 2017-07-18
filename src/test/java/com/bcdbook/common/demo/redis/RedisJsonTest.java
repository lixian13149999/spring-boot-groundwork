package com.bcdbook.common.demo.redis;

import com.alibaba.fastjson.JSON;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by lason on 2017/7/18.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class RedisJsonTest {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Test
    public void test(){

        System.out.println("=================================");

        RedisUser redisUser = new RedisUser("summer",18);


        stringRedisTemplate.opsForValue().set(redisUser.getUsername(), JSON.toJSONString(redisUser));

//        stringRedisTemplate.opsForValue().set("name","summer2");
        String redisUserString = stringRedisTemplate.opsForValue().get(redisUser.getUsername());
        System.out.println(redisUserString);

        RedisUser redisUserBack = (RedisUser) JSON.parseObject(redisUserString,RedisUser.class);
        System.out.println(redisUserBack);

        System.out.println("*********************************");

//        Assert.assertEquals("summer",stringRedisTemplate.opsForValue().get("name"));
    }

}