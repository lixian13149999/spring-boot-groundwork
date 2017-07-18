package com.bcdbook.common.demo.redis;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import org.junit.Assert;

/**
 * Created by lason on 2017/7/18.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class HellowRedisTest {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Test
    public void test(){
        stringRedisTemplate.opsForValue().set("name","summer");

//        stringRedisTemplate.opsForValue().set("name","summer2");
        stringRedisTemplate.delete("name");

        Assert.assertEquals("summer",stringRedisTemplate.opsForValue().get("name"));
    }
}