package com.bcdbook.common.demo.hello;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

/**
 * Created by lason on 2017/7/7.
 *
 * Controller层的测试
 */
/*
 * 设定当前测试类的测试环境，底层为junit测试工具
 */
@RunWith(SpringRunner.class)
/*
 * TODO --等待解释
 * 表示将启动整个spring工程
 */
@SpringBootTest
/*
 * 引入模拟器的注解
 */
@AutoConfigureMockMvc
public class HelloWorldTest {
    //自动注入spring的mvc模拟器
    @Autowired
    private MockMvc mvc;


    /**
     * 测试HelloWorld的方法
     * @throws Exception
     */
    @Test
    public void helloWorld() throws Exception {
        //设定请求路径及请求方式并执行请求
        mvc.perform(MockMvcRequestBuilders.get("/demo/helloWorld/helloWorld"))
                //判断返回的状态是否ok
                .andExpect(MockMvcResultMatchers.status().isOk())
                //判断内容是否和预计内容一致
                .andExpect(MockMvcResultMatchers.content().string("Hello World"));
    }

    /**
     * 测试HelloWorld的方法
     * @throws Exception
     */
    @Test
    public void helloTemplates() throws Exception {
        //设定请求路径及请求方式并执行请求
        mvc.perform(MockMvcRequestBuilders.get("/demo/helloWorld/helloTemplates"))
                //判断返回的状态是否ok
                .andExpect(MockMvcResultMatchers.status().isOk());
                //判断内容是否和预计内容一致
//                .andExpect(MockMvcResultMatchers.);
    }

}