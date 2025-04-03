package com.bydbishe.controller;

import com.bydbishe.common.HandleCookie;
import com.bydbishe.service.UserService;
import com.bydbishe.vo.ProblemChartVo;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {
    @Autowired
    UserService userService;
    
    
    @GetMapping("/changepassword")
    public void changePassword(HttpServletRequest httpServletRequest, @RequestParam String password) {
        userService.changePassword(HandleCookie.getUseruid(httpServletRequest), password);
    }
    
    @GetMapping("/chart")
    public ProblemChartVo chart(HttpServletRequest httpServletRequest) {
        return userService.chart(HandleCookie.getUseruid(httpServletRequest));
    }
}
