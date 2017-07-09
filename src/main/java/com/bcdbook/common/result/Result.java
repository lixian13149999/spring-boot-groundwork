package com.bcdbook.common.result;

/**
 * Created by lason on 2017/7/9.
 * 统一返回值,公共类
 */
public class Result<T> {

    public static final Integer CODE_PERMISSION_DENIED = 102;//没有权限
    public static final Integer CODE_SUCCESS = 200;//成功
    public static final Integer CODE_NO_DATA = 403;//没有数据(应该有数据)
    public static final Integer CODE_UNKNOWN_ERROR = 500;//未知错误
    public static final Integer CODE_PARAMETER_IS_NULL = 502;//未知错误

    public static final String MSG_PERMISSION_DENIED = "没有权限";//没有权限
    public static final String MSG_SUCCESS = "成功";//成功
    public static final String MSG_NO_DATA = "没有数据";//没有数据(应该有数据)
    public static final String MSG_UNKNOWN_ERROR = "未知错误";//未知错误
    public static final String MSG_PARAMETER_IS_NULL = "传入数据为空";//传入数据为空


    /*
     * 返回值的编码,用于识别返回值的状态
     * 仿照http请求协议中的返回值设定,例如200是正常,500是未知错误
     */
    private Integer code;
    /*
     * 统一封装的返回信息
     * 用于解释返回数据及返回状态,并不一定是错误的提示信息,
     */
    private String errorMsg;
    /*
     * 返回的实际数据
     */
    private T data;

    /**
     * 空参构造
     */
    public Result() {
    }

    /**
     * 全参构造
     * @param code
     * @param errorMsg
     * @param data
     */
    public Result(Integer code, String errorMsg, T data) {
        this.code = code;
        this.errorMsg = errorMsg;
        this.data = data;
    }

    /**
     * getter and setter
     * @return
     */
    public Integer getCode() {
        return code;
    }
    public void setCode(Integer code) {
        this.code = code;
    }
    public String getErrorMsg() {
        return errorMsg;
    }
    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }
    public T getData() {
        return data;
    }
    public void setData(T data) {
        this.data = data;
    }
}
