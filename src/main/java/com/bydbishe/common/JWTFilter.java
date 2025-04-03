package com.bydbishe.common;

import com.bydbishe.exception.BaseException;
import io.jsonwebtoken.Claims;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.Date;

@Component
public class JWTFilter extends OncePerRequestFilter {

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String token = null;
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("token")) {
                    token = cookie.getValue();
                    break;
                }
            }
        }
        if(request.getRequestURI().equals("/login")){
            filterChain.doFilter(request, response);
            return;
        }
        if (token != null) {
            Claims claims = JWT.parse(token);
            if(new Date().after(claims.getExpiration())){
                throw new BaseException("账号已过期");
            }
        }else{
            throw new BaseException("账号已过期");
        }
        filterChain.doFilter(request, response);
    }
    
    
}
