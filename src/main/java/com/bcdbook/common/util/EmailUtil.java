//package com.bcdbook.common.util;
//
//
//import com.spibao.spring.agricultural.tools.model.Mail;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.mail.javamail.JavaMailSender;
//import org.springframework.mail.javamail.MimeMessageHelper;
//import org.springframework.stereotype.Component;
//import org.thymeleaf.TemplateEngine;
//import org.thymeleaf.context.Context;
//
//import javax.mail.internet.MimeMessage;
//import java.text.SimpleDateFormat;
//import java.util.Date;
//
///**
// * Created by 王锋磊 on 2017/4/11.
// * 邮件发送模板工具类
// */
//@Component
//public class EmailUtil {
//    /*
//     * 注入邮件发送器
//     */
//    @Autowired
//    private JavaMailSender mailSender;
//
//    @Autowired
//    private TemplateEngine templateEngine;
//
//    //定义静态常量
//    public static final  String ENCODE = "UTF-8";//格式
//    public static Date date = new Date();//获得当前时间
//
//    public static final  String MODEL_CODE = "发送邮件验证码";//发送验证码模板
//    public static final  String MODEL_LINK = "发送邮件链接";//发送链接模板
//
//
//    public static final String EMAIL_FROM = "xianforwork@163.com";
//    public  void sendHtmlMail(Mail mail , String type ,String param) throws Exception {
//	/**
//	 * 创建context对象
//	 */
//	  Context context = new Context();
//	  /**
//	   * 设置值
//	   */
//	  String text="";
//	  switch (type){
//		    case  MODEL_CODE :
//		    {
//		        //模板1(验证码)
//	    	  context.setVariable("code", param);
//
//	          text = templateEngine.process("emailModel/code", context);
//
//		      break;
//
//		    }
//		    case  MODEL_LINK :
//		    {
//		        //模板2(链接)
//		    	  context.setVariable("link", param);
//		    	  SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日");
//		    	  Date date = new Date();
//		    	  String time = sdf.format(date);
//		    	  context.setVariable("time", time);
//		    	text = templateEngine.process("emailModel/link", context);
//
//			      break;
//		    }
//		}
//      MimeMessage mimeMessage = mailSender.createMimeMessage();
//      MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);
//      helper.setFrom(EmailUtil.EMAIL_FROM); // 发送者邮箱
//      helper.setTo(mail.getMailTo());// 接收者邮箱
//      helper.setSentDate(date);// 发送日期
//      helper.setSubject(mail.getTheme());//发送邮件主题
//      helper.setText(text, true);//邮箱模板
//      mailSender.send(mimeMessage);
//
//    }
//
//
// }
