package com.bcdbook.common.exception;

/**
 * Created by lason on 2017/7/9.
 * 定义一个系统公共的异常类
 * 继承RuntimeException
 * 并魔方统一返回值的返回值结构
 */
public class GlobalException extends RuntimeException {

    private Integer code;//异常编码
    private String errorMsg;//异常提示信息
	private Object data;//异常数据

    /**
     * 空参构造
     */
    public GlobalException() {
    }

    /**
     * 全参构造
     * @param globalExceptionEnum
     */
    public GlobalException(GlobalExceptionEnum globalExceptionEnum) {
        super(globalExceptionEnum.getErrorMsg());
        this.code = globalExceptionEnum.getCode();
        this.data = globalExceptionEnum.getData();
	}

	public String getErrorMsg() {
		return errorMsg;
	}

	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}

    /*
     * getter and setter
     */
    public Integer getCode() {
        return code;
    }
    public void setCode(Integer code) {
        this.code = code;
    }
    public Object getData() {
        return data;
    }
    public void setData(Object data) {
        this.data = data;
    }
}
