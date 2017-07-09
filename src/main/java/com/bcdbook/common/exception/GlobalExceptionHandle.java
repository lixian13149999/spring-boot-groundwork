package com.bcdbook.common.exception;

import com.bcdbook.common.result.Result;
import com.bcdbook.common.result.ResultUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by lason on 2017/3/16.
 * 定义异常的统一监听类
 */
/*
 * 定义统一的异常处理类
 */
@ControllerAdvice
public class GlobalExceptionHandle {
    private final static Logger logger = LoggerFactory.getLogger(GlobalExceptionHandle.class);

    /*
     * 异常监听把手,value用于定义异常的监听类型
     */
    @ExceptionHandler(value = Exception.class)
    /*
     * 表示返回值是json数据
     */
    @ResponseBody
    public Result handle(Exception e) {
        if (e instanceof GlobalException) {
            GlobalException globalException = (GlobalException) e;
            return ResultUtil.error(globalException.getCode(),globalException.getMessage(),globalException.getData());
        }else {
            logger.error("【系统异常】{}", e);
            return ResultUtil.error();
        }
    }
}
