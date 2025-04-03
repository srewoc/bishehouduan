package com.bydbishe.common;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;

public class HandleCookie {
    public static Integer getUseruid(HttpServletRequest request) {
        Cookie[] cookies = request.getCookies();
        String token = "";
        for(Cookie cookie : cookies){
            if(cookie.getName().equals("token")){
                token = cookie.getValue();
                break;
            }
        }
        return (Integer) JWT.parse(token).get("uid");
    }
}
