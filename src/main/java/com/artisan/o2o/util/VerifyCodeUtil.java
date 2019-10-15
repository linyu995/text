package com.artisan.o2o.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;

public class VerifyCodeUtil {
    public static final Logger logger= LoggerFactory.getLogger(VerifyCodeUtil.class);

    public static boolean verifyCode(HttpServletRequest request){
        /**
         * 图片中的验证码
         */
        String  verifyCodeExpected= (String) request.getSession().getAttribute(com.google.code.kaptcha.Constants.KAPTCHA_SESSION_KEY);
        /**
         * 用户的验证码
         */
        String verifyCodeActual=HttpServletRequestUtil.getString(request,"verifyCodeActual");
        if(verifyCodeActual==null||!verifyCodeActual.equalsIgnoreCase(verifyCodeExpected)){
            return false;
        }
        return true;
    }
}
