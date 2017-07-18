package com.bcdbook.common.error;

/**
 * Created by lason on 2017/7/18.
 */

import org.springframework.boot.autoconfigure.web.ErrorController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
public class IErrorErrorController implements ErrorController {

    private static final String ERROR_PATH = "/error";

    @RequestMapping(value=ERROR_PATH)
    public String handleError(HttpServletRequest req){

        return "handleError";
//        String userAgent = req.getHeader("user-agent");
//        System.out.println(userAgent);
//        if(userAgent.indexOf("Windows")!=-1||(userAgent.indexOf("Mac")!=-1 && userAgent.indexOf("iPhone")==-1)){
//            return "merchant/public/404";
//        }else{
//            return "client/html/public/404";
//        }
    }

    @Override
    public String getErrorPath() {
        return "errorPath";
//        return ERROR_PATH;
    }
}
