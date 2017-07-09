package com.bcdbook.common.demo.hello;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by lason on 2017/7/7.
 */
/*
 * @RestController相当于
 * @Controler+@ResponseBody
 * @Controller表示在Spirng中注入一个bean,这个bean的类型是一个控制器
 * @ResponseBody表示返回的数据类型是JSON
 */
@Controller
/*
 * @RequestMapping用来定义请求的路径,
 * 定义在类上,则当前类下所有的映射路径均有这个前缀
 * 括号内传递的值是所映射的路径
 */
@RequestMapping("/demo/helloWorld")
public class HelloWorld {
    /**
     * SpringBoot的HelloWorld
     * 通过一个请求,返回一个对应的数据,最基础的一个接口
     * @return
     */
    /*
     * @GetMapping 相当于 @RequestMapping(method = RequestMethod.GET)
     * 同理@PostMapping 相当于 @RequestMapping(method = RequestMethod.POST)
     */
    @GetMapping("/helloWorld")
    @ResponseBody
    public String helloWorld(){
        return "Hello World";
    }

    /*
     * 返回一个页面的demo
     */
    @GetMapping("/helloTemplates")
    public String helloTemplates(){
        return "demo/hello/helloTemplate";
    }
}
