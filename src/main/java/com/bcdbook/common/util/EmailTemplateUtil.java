//package com.bcdbook.common.util;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Component;
//import org.thymeleaf.TemplateEngine;
//import org.thymeleaf.context.Context;
//
//import java.text.SimpleDateFormat;
//import java.util.Date;
//import java.util.Map;
//
///**
// * Created by wuyifeng on 2017/4/20.
// */
//@Component
//public class EmailTemplateUtil {
//    @Autowired
//    private TemplateEngine templateEngine;
//
//    public static final String EMAIL_FROM = "xianforwork@163.com";
//
//    public static final int BIND_EMAIL = 1;//绑定邮箱模板
//    public static final int FIND_LOGINPWD = 1;//找回登录密码模板
//    public static final int ALTER_EMAIL = 2;//修改绑定邮箱模板
//    /**
//     * @Discription 找回登录密码的模板
//     * @author wuyifeng
//     */
//    public Map findLoginPasswordTemplate() {
//        String code = PhoneCodeUtil.buildVerifyCode();
//        Context model = new Context();
//        model.setVariable("code", code);
//        String text = templateEngine.process("emailModel/code", model);
//        Map<String,Object> map=new HashedMap();
//        map.put("theme","找回登录密码");
//        map.put("content",text);
//        map.put("code",code);
//        return map;
//    }
//
//    /**
//     * @Discription 绑定邮箱的模板
//     * @author wuyifeng
//     */
//    public Map bindEmailTemplate(String basePath,String email,int roleType,User user) {
//        Context model = new Context();
//        String param = basePath+"user/checkActivationMail?test="+DateUtil.getTimeInt10()+"&email="+email+"&roleType="+roleType+"&pin="+user.getPin();
//        model.setVariable("link", param);
//        SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日");
//        Date date = new Date();
//        String time = sdf.format(date);
//        model.setVariable("time", time);
//        String text = templateEngine.process("emailModel/link", model);
//        Map<String,Object> map=new HashedMap();
//        map.put("theme","激活邮箱");
//        map.put("content",text);
//        return map;
//    }
//
//    /**
//     * @Discription 修改绑定邮箱的模板
//     * @author wuyifeng
//     */
//    public Map changeBindEmailTemplate() {
//        String code = PhoneCodeUtil.buildVerifyCode();
//        Context model = new Context();
//        model.setVariable("code", code);
//        SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日");
//        Date date = new Date();
//        String time = sdf.format(date);
//        model.setVariable("time", time);
//        String text = templateEngine.process("emailModel/code", model);
//        Map<String,Object> map=new HashedMap();
//        map.put("theme","修改绑定邮箱");
//        map.put("content",text);
//        map.put("code",code);
//        return map;
//    }
//
//}
