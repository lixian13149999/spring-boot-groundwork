package com.bcdbook.common.demo.exception;

import com.bcdbook.common.exception.GlobalException;
import com.bcdbook.common.exception.GlobalExceptionEnum;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by lason on 2017/7/9.
 * 测试统一异常处理的接口
 */
@RestController
@RequestMapping("/demo/exception")
public class ExceptionController {

    /*
     * 测试访问globalException(自己封装的测试类)
     */
    @GetMapping("/globalException")
    public String globalException(){
        throw new GlobalException(GlobalExceptionEnum.NO_DATA);
    }

    /*
     * 测试运行时异常
     */
    @GetMapping("/runtimeException")
    public String runtimeException(){
        throw new RuntimeException();
    }
}
