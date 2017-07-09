package com.bcdbook.common.exception;


import com.bcdbook.common.result.Result;

/**
 * Created by lason on 2017/3/16.
 * 异常枚举类的封装
 */
public enum GlobalExceptionEnum {

    //    SUCCESS(Result.CODE_SUCCESS,Result.MSG_SUCCESS,null),

    /**
     * 无数据问题(本应该有数据的)
     */
    NO_DATA(Result.CODE_NO_DATA,Result.MSG_NO_DATA,null),
    /**
     * 没有权限异常
     */
    PERMISSION_DENIED(Result.CODE_PERMISSION_DENIED,Result.MSG_PERMISSION_DENIED,null),
    /**
     * 未知错误
     */
    UNKNOWN_ERROR(Result.CODE_UNKNOWN_ERROR,Result.MSG_UNKNOWN_ERROR,null),
    /**
     * 参数为空异常
     */
    PARAMETER_IS_NULL(Result.CODE_PARAMETER_IS_NULL,Result.MSG_PARAMETER_IS_NULL,null);

    private Integer code;
    private String errorMsg;
    private Object data;

    /**
     * 空参
     */
    GlobalExceptionEnum() {
    }

    /**
     * 全参
     * @param code
     * @param errorMsg
     * @param data
     */
    GlobalExceptionEnum(Integer code, String errorMsg, Object data) {
        this.code = code;
        this.errorMsg = errorMsg;
        this.data = data;
    }

    /*
     * getter
     */
    public Integer getCode() {
        return code;
    }
    public String getErrorMsg() {
        return errorMsg;
    }
    public Object getData() {
        return data;
    }
}