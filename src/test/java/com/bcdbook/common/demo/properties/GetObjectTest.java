//package com.bcdbook.common.demo.properties;
//
//import org.junit.Assert;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
//
///**
// * Created by lason on 2017/7/7.
// */
//@RunWith(SpringJUnit4ClassRunner.class)
//@SpringBootTest
//public class GetObjectTest {
//
//    //注入参数,用于从中获取配置内容
//    @Autowired
//    private GetObject getObject;
//
//    @Test
//    public void getObject(){
//        int age = getObject.getTom().getAge();
//        String sex = getObject.getTom().getSex();
//
//        Assert.assertEquals("返回值不正确",18,age);
//        Assert.assertEquals("返回值不正确","男",sex);
//
//    }
//}
