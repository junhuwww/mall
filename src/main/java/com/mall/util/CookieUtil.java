package com.mall.util;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CookieUtil {
    private  final static Logger logger = LoggerFactory.getLogger(JsonUtil.class);

//    一级域名下
    private final static String COOKIE_DOMAIN = ".happymmall.com";
    private final static String COOKIE_NAME = "mmall_login_token";

    public static String readLoginToken(HttpServletRequest request){
        Cookie[] cks = request.getCookies();
        if (cks != null){
            for (Cookie cookie : cks){
                logger.info("read cookieName:{}, cookieValue:{}",cookie.getName(),cookie.getValue());
                if (StringUtils.equals(cookie.getName(), COOKIE_NAME)){
                    logger.info("return cookieName:{}, cookieValue:{}",cookie.getName(),cookie.getValue());
                    return cookie.getValue();
                }
            }
        }
        return null;
    }

    public static void writeLoginToken(HttpServletResponse response, String token){
        Cookie cookie = new Cookie(COOKIE_NAME, token);
        cookie.setDomain(COOKIE_DOMAIN);
        cookie.setPath("/"); //代表设置在根目录
        cookie.setHttpOnly(true);//提高安全性
        //单位是秒
        //如果这个maxage不设置的话，cookie就不会写入磁盘，而是写在内存，只在当前页面有效
        cookie.setMaxAge(60*60*24*365);//如果是-1，代表永久，如果是0，代表删除此cookie
        logger.info("write cookieName:{}, cookieValue:{}",cookie.getName(),cookie.getValue());
        response.addCookie(cookie);
    }

    public static void delLoginToken(HttpServletRequest request, HttpServletResponse response){
        Cookie[] cks = request.getCookies();
        if (cks != null){
            for (Cookie cookie : cks){
                if (StringUtils.equals(cookie.getName(), COOKIE_NAME)){
                    cookie.setPath("/");
                    cookie.setDomain(COOKIE_DOMAIN);
                    cookie.setMaxAge(0);//设置为0，代表删除此cookie
                    logger.info("del cookieName:{}, cookieValue:{}",cookie.getName(),cookie.getValue());
                    response.addCookie(cookie);
                    return;
                }
            }
        }
    }
}
