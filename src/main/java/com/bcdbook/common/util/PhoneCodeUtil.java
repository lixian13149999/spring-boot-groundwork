//package com.bcdbook.common.util;
//
//import com.taobao.api.ApiException;
//import com.taobao.api.DefaultTaobaoClient;
//import com.taobao.api.TaobaoClient;
//import com.taobao.api.request.AlibabaAliqinFcSmsNumSendRequest;
//import com.taobao.api.response.AlibabaAliqinFcSmsNumSendResponse;
//
//import java.util.Arrays;
//import java.util.Collections;
//import java.util.List;
//
///**
// * Created by lason on 2017/4/5.
// */
//public class PhoneCodeUtil {
//    /**
//     * 验证码发送参数
//     */
//    public static final String URL = "http://gw.api.taobao.com/router/rest";//发送短信请求的地址
//    public static final String APPKEY = "23737233";// 账号
//    public static final String SECRET = "06416849556e1560aef0104afa914c69";// 密钥
//
//    public static final String SMS_TYPE = "normal";//定义短信类型
//    public static final String SMS_FREE_SIGN_NAME = "飞食科技";//定义签名
//
//
//    public static final String ALTER_PHONE = "SMS_67610149";//修改绑定手机模板  ID
//    public static final String BIND_PHONE = "SMS_67680151";//手机绑定模板          ID
//    public static final String FIND_PAYPWD = "SMS_67760258";//找回支付密码模板     ID
//    public static final String FIND_LOGINPWD = "SMS_67675138";//找回登录密码模板     ID
//    public static final String ALTER_EMAIL = "SMS_67600297";//修改绑定邮箱模板     ID
//    public static final String ALTER_PAYPWD = "SMS_67600296";//修改支付密码模板 ID
//
//
//
//    /**
//     *
//     * @Discription 短信验证的方法
//     * @author lason
//     * @created 2016年7月26日 下午1:32:16
//     * @param mobile  手机号码
//     * @param TEMPLATE
//     * @param parame
//     */
//    public static void sendSms(String mobile, String TEMPLATE,String parame) {
//        //创建一个发送客户
//        TaobaoClient client = new DefaultTaobaoClient(URL, APPKEY, SECRET);
//        //创建一个阿里request对象
//        AlibabaAliqinFcSmsNumSendRequest req = new AlibabaAliqinFcSmsNumSendRequest();
//        //设置短信类型
//        req.setSmsType(SMS_TYPE);
//        //设置短信签名
//        req.setSmsFreeSignName(SMS_FREE_SIGN_NAME);
//
//        //设置短信中需要替换的内容
//        req.setSmsParam(parame);
//        //设置接收方的手机号码
//        req.setRecNum(mobile);
//        //设置模板
//        req.setSmsTemplateCode(TEMPLATE);
//
//        //获取发送对象,执行发送操作
//        AlibabaAliqinFcSmsNumSendResponse rsp = null;
//        try {
//            rsp = client.execute(req);
//        } catch (ApiException e) {
//            e.printStackTrace();
//            throw new RuntimeException("短信发送失败");
//        }
//    }
//
//    /**
//     * 生成6位数验证码
//     * @return 例如:123456
//     */
//    public static String buildVerifyCode() {
//        List<String> list = Arrays.asList(new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9"});
//        Collections.shuffle(list);
//        StringBuilder sb = new StringBuilder();
//        for (int i = 0; i < list.size(); i++)
//            sb.append(list.get(i));
//        return sb.substring(0, 6);
//    }
//
//    public static void main(String[] args) {
////        String code = buildVerifyCode();
////        String product = "lixian13149999@163.com";
////        String parame = "{'code':'" + code + "',name:'"+product+"'}";
////        System.out.println(parame);
////        sendSms("18862397382", SMS_CODE_BIND, parame);
//    }
//}
