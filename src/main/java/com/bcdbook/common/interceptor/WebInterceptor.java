package com.bcdbook.common.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by lason on 2017/7/9.
 * spring boot登录的全局拦截器
 */
public class WebInterceptor implements HandlerInterceptor {

    /**
     * 在请求执行之前
     * 在请求处理之前进行调用（Controller方法调用之前
     * @param req
     * @param resp
     * @param handler
     * @return
     * @throws Exception
     */
    @Override
    public boolean preHandle(HttpServletRequest req,
                             HttpServletResponse resp,
                             Object handler) throws Exception {
    	
    
        System.out.println("====执行登录====");
//        /**
//         * 获取session
//         */
//        HttpSession session = req.getSession();
//        /**
//         * 获取请求路径
//         */
//    	String path = req.getScheme() + "://" + req.getServerName() + ":" + req.getServerPort();
//        //String path = req.getScheme() + "://" + req.getServerName();
////        System.out.println(path);
//
////        User user=new User();
////        session.setAttribute(GlobalFinal.ON_LINE_USER,user);
//        User sessionUser = (User) session.getAttribute(GlobalFinal.ON_LINE_USER);
////        System.out.println(sessionUser);
//        if(sessionUser!=null&& (sessionUser.getState() == 1) ) {
////            System.out.println(sessionUser.getUsername());
//            return true;
//        }else{
//            String userType="";
//            Cookie[] cookies = req.getCookies();
//            if(cookies!=null){
//                for(int i = 0; i<cookies.length ; i++){
//                    if(cookies[i].getName().equals("agricultural")){
//                        userType=cookies[i].getValue();
//                    }
//                }
//            }
//            if(!StringUtils.isBlank(userType)){
//                if("1".equals(userType)){
//                    resp.sendRedirect(path + "/platform/login");
//                }else if("2".equals(userType)){
//                    resp.sendRedirect(path + "/merchant/login");
//                }else {
//                    resp.sendRedirect(path + "/phone/login");
//                }
//            }else{
//                String userAgent = req.getHeader("user-agent");
////                System.out.println(userAgent);
//                if(userAgent.indexOf("Windows")!=-1||(userAgent.indexOf("Mac")!=-1 && userAgent.indexOf("iPhone")==-1)){
//                    resp.sendRedirect(path + "/merchant/login");
//                }else{
//                    resp.sendRedirect(path + "/phone/login");
//
//                }
//            }
//
//        }
        
        return true;

    }


    /**
     * 在请求之后执行的
     * 但是在视图被渲染之前（Controller方法调用之后）
     * @param req
     * @param resp
     * @param handler
     * @param modelAndView
     * @throws Exception
     */
    @Override
    public void postHandle(HttpServletRequest req,
                           HttpServletResponse resp,
                           Object handler,
                           ModelAndView modelAndView) throws Exception {

    }


    /**
     * 在整个请求调用之后,视图渲染完成以后执行的
     * 也就是在DispatcherServlet 渲染了对应的视图之后执行（主要是用于进行资源清理工作）
     * @param req
     * @param resp
     * @param handler
     * @param ex
     * @throws Exception
     */
    @Override
    public void afterCompletion(HttpServletRequest req,
                                HttpServletResponse resp,
                                Object handler,
                                Exception ex) throws Exception {

    }
}
