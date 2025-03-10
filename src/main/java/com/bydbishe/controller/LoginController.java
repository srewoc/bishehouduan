package com.bydbishe.controller;

import com.bydbishe.common.Result;
import com.bydbishe.dto.LoginDTO;
import com.bydbishe.service.LoginService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
//@CrossOrigin(origins = "http://localhost:7070")
public class LoginController {
    
    @Autowired
    LoginService loginService;
    
    @PostMapping("/login")
    public Result<String> login(@RequestBody LoginDTO loginDTO){
        String result = loginService.login(loginDTO);
        return Result.success(result);
    }
}
