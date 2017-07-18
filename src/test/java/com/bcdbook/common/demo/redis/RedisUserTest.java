package com.bcdbook.common.demo.redis;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by lason on 2017/7/18.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class RedisUserTest {

    @Autowired
    private RedisTemplate<String, RedisUser> redisTemplate;

    @Test
    public void testUser() throws Exception {
        // 保存对象
//        RedisUser redisUser = new RedisUser("超人", 20);
//        redisTemplate.opsForValue().set(redisUser.getUsername(), redisUser);
//        redisUser = new RedisUser("蝙蝠侠", 30);
//        redisTemplate.opsForValue().set(redisUser.getUsername(), redisUser);
//        redisUser = new RedisUser("蜘蛛侠", 40);
//        redisTemplate.opsForValue().set(redisUser.getUsername(), redisUser);
//        Assert.assertEquals(20, redisTemplate.opsForValue().get("超人").getAge().longValue());
//        Assert.assertEquals(30, redisTemplate.opsForValue().get("蝙蝠侠").getAge().longValue());
//        Assert.assertEquals(40, redisTemplate.opsForValue().get("蜘蛛侠").getAge().longValue());

        RedisUser redisUser = new RedisUser("超人", 20);
        redisTemplate.opsForValue().set(redisUser.getUsername(), redisUser);
        Assert.assertEquals(20, redisTemplate.opsForValue().get("超人").getAge().longValue());
    }

}
