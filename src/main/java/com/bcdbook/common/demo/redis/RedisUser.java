package com.bcdbook.common.demo.redis;

import java.io.Serializable;

/**
 * Created by lason on 2017/7/18.
 */
//定义对象,并实现序列化
public class RedisUser  implements Serializable{


    private String username;
    private Integer age;


    public RedisUser() {
    }

    public RedisUser(String username, Integer age) {
        this.username = username;
        this.age = age;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "RedisUser{" +
                "username='" + username + '\'' +
                ", age=" + age +
                '}';
    }
}
