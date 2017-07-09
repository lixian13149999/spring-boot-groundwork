package com.bcdbook.common.demo.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by lason on 2017/3/17.
 * 日志记录的切面
 */
/*
 * 定义当前类是一个切面类
 */
@Aspect
/*
 * 把当前类放入Spring容器中
 */
@Component
public class LogAspect {
    /**
     * 从loggerFactory中获取一个logger对象
     */
    private final static Logger logger = LoggerFactory.getLogger(LogAspect.class);


    /**
     * 定义切面
     * 当前定义的切面是api,web下的所有的公共方法
     */
    @Pointcut("execution(public * com.bcdbook.common.demo.hello.HelloWorld.*(..))")
    public void log() {
    }

    /**
     * 在方法执行之前做的操作
     * @param joinPoint
     */
    /*
     * @Before表示在切面方法执行之前做的操作的注解,
     * 传入的值是一个切面
     */
    @Before("log()")
    public void doBefore(JoinPoint joinPoint) {
        /*
         * 获取请求中的所有参数
         */
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        //从attributes中获取request对象
        HttpServletRequest request = attributes.getRequest();

        //url
        logger.info("url={}", request.getRequestURL());

        //method
        logger.info("method={}", request.getMethod());

        //ip
        logger.info("ip={}", request.getRemoteAddr());

        //类方法
        logger.info("class_method={}", joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName());

        //参数
        logger.info("args={}", joinPoint.getArgs());

//        Object[] obj = joinPoint.getArgs();
//        for (int i = 0; i < obj.length; i++) {
//            Object o = obj[i];
//            System.out.println(o);
//        }
//        System.out.println(obj.length);
    }

    @After("log()")
    public void doAfter() {
//        logger.info("222222222222");
    }

    @AfterReturning(returning = "object", pointcut = "log()")
    public void doAfterReturning(Object object) {
//        logger.info("response={}", object.toString());
    }
}
