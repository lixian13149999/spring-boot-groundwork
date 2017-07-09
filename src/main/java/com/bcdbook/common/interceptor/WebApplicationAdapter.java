package com.bcdbook.common.interceptor;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * Created by lason on 2017/7/9.
 * web访问的主配置文件
 */
/*
 * 表明这是一个配置文件类
 */
@Configuration
public class WebApplicationAdapter extends WebMvcConfigurerAdapter {
    /**
     * 重写添加拦截器的方法
     * @param registry
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //加入一个拦截器,并设定其拦截范围
        registry.addInterceptor(new WebInterceptor())
                //拦截所有的请求路径
                .addPathPatterns("/**")
                //忽略掉以下这些路径
                .excludePathPatterns(
                        "/demo/**"

//                        "/static/**",
//                        "/phone/**",
//                        "/demo/html/**",
//                        "/demo/file/**",
//                        "/sms/**",
//                        "/mail/**",
//                        "/phone/index",//客户手机主页
//                        "/module/getListByIdKey",//首页react请求
//                        "/menu/getListByTypeOnPhone",//首页react请求
//                        "/phone/login",//客户手机登录页
//                        "/platform/login",//平台登录页
//                        "/merchant/login",//商家电脑登录页
//                        "/login",//登录方法
//                        "/signup",//注册方法
//                        "/signupForMerchant",//商家注册方法
//                        "/bindPhone",//绑定手机号
//                        "/user/isExist",//检测用户名是否存在
//                        "/user/checkCodeByPhone",//验证手机验证码
//                        "/user/checkCodeByEmail",//验证邮箱验证码
//                        "/user/isMailExist",//验证邮箱是否存在
//                        "/user/phone/changePasswordByPhone",//获取修改密码页面
//                        "/user/phone/changePasswordByEmail",//获取修改密码页面
//                        "/user/findPassword",//修改密码
//                        "/user/isBind",//检查手机号是否已绑定的方法
//                        "/paymentCotronller/*",//支付测试接口
//                        "/user/isBind",//检查手机号是否已绑定的方法
//                        "/user/checkActivationMail",//激活邮箱的链接
//                        "/user/activationMail",//激活邮箱的确定按钮
//                        "/user/checkCodeByPhoneForMerchantFindLoginPwd",//检查验证码（商家端）
//                        "/user/findPasswordRorMerchant",//找回密码（商家端）
//                        "/user/isExistForMerchant",//检测用户是否存在（商家端）
//                        "/user/isBindForMerchant",//检测是否时用户绑定的手机（商家端）
//                        "/user/findPasswordRorMerchant",//找回密码（商家端）
//                        "/oauth/token",//获取token
//                        "/oauth/interface/save"//添加
                );

        //添加拦截规则到拦截器
        super.addInterceptors(registry);
        
        /*
         * 添加另一个拦截器,并设定其拦截范围
         */
//        registry.addInterceptor(new WebAllInterceptor())
//        //拦截所有的请求路径
//        .addPathPatterns("/**") .excludePathPatterns();
        
//        super.addInterceptors(registry);
    }

    /**
     * 忽略静态资源的方法
     * @param registry
     */
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/static/**").addResourceLocations("classpath:/static/");
        registry.addResourceHandler("/templates/**").addResourceLocations("classpath:/templates/");
//        registry.addResourceHandler("/upload/**").addResourceLocations("file:///Users/lason/Downloads/upload/");
        registry.addResourceHandler("/upload/**").addResourceLocations("file:///datas/apps/files/");
//        registry.addResourceHandler("/**").addResourceLocations("file:///Users/lason/Downloads/upload/");
        registry.addResourceHandler("/**").addResourceLocations("file:///datas/apps/mp/");
        super.addResourceHandlers(registry);
    }
}
