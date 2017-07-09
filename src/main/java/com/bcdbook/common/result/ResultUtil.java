package com.bcdbook.common.result;


/**
 * Created by lason on 2017/3/16.
 * 统一返回值的调用的工具类（简单封装了Result，便于调用）
 */
public class ResultUtil {

    /**
     * 成功的返回值封装方法
     * 要有数据和提示消息
     * @param data
     * @param errorMsg
     * @return
     */
    public static Result success(Object data,String errorMsg){
        return new Result(Result.CODE_SUCCESS,errorMsg,data);
    }
    /**
     * 成功的返回值封装方法
     * 需要传入数据,返回消息默认为success
     * @param data
     * @return
     */
    public static Result success(Object data){
        return success(data,"success");
    }
    /**
     * 成功的返回值封装
     * 不需要传入任何参数
     * data默认为null,消息默认为success
     * @return
     */
    public static Result success(){
        return success(null);
    }

    /**
     * 错误的返回值封装方法
     * 要有数据和提示消息
     * @param data
     * @param errorMsg
     * @return
     */
    public static Result error(Integer errorCode,String errorMsg,Object data){
        return new Result(errorCode,errorMsg,data);
    }
    /**
     * 错误的返回值封装方法
     * 需要传入数据,返回消息默认为error
     * @param errorCode
     * @param errorMsg
     * @return
     */
    public static Result error(Integer errorCode,String errorMsg){
        return error(errorCode,errorMsg,null);
    }
    /**
     * 错误的返回值封装
     * 不需要传入任何参数
     * data默认为null,消息默认为error
     * @return
     */
    public static Result error(){
        return error(Result.CODE_UNKNOWN_ERROR,Result.MSG_UNKNOWN_ERROR);
    }

//    /**
//     * 分页返回值的封装
//     * @param data
//     * @param total
//     * @param pageSize
//     * @param errorMsg
//     * @return
//     */
//    public static PageResult genSuccess(Object data, Integer total, Integer pageSize,String errorMsg) {
//        return new PageResult(Result.CODE_SUCCESS,errorMsg,data,total,pageSize);
//    }
//
//    /**
//     * 分页返回值的封装
//     * @param errorMsg
//     * @return
//     */
//    public static PageResult genError(String errorMsg) {
//        return new PageResult(Result.CODE_NO_DATA,errorMsg,null,0,0);
//    }
}
