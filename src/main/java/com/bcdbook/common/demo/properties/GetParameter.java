package com.bcdbook.common.demo.properties;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * Created by lason on 2017/7/7.
 * 从配置文件中获取参数
 */
@Component
public class GetParameter {

    //通过@Value("${属性名}")注解来加载对应的配置属性
    //原值在.yml文件中
    @Value("${sex}")
    private String sex;
    @Value("${age}")
    private int age;

    /**
     * 空参构造
     */
    public GetParameter() {
    }

    /**
     * getter and setter
     * @return
     */
    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
