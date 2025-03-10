package com.bydbishe.service.impl;

import com.bydbishe.common.JWT;
import com.bydbishe.dto.LoginDTO;
import com.bydbishe.entity.User;
import com.bydbishe.exception.BaseException;
import com.bydbishe.mapper.LoginMapper;
import com.bydbishe.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    private LoginMapper loginMapper;

    public String login(LoginDTO loginDTO) {

        User user = loginMapper.login(loginDTO.getUsername());
        
        if (user == null) {
            throw new BaseException("账号不存在");
        }
        if (!loginDTO.getPassword().equals(user.getPassword())) {
            throw new BaseException("密码错误");
        }
        
        return JWT.jwtBuilde(user.getUid());
    }
    
}
