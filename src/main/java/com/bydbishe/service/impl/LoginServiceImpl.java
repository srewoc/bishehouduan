package com.bydbishe.service.impl;

import com.bydbishe.dto.LoginDTO;
import com.bydbishe.entity.Admin;
import com.bydbishe.entity.Student;
import com.bydbishe.exception.BaseException;
import com.bydbishe.mapper.LoginMapper;
import com.bydbishe.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    private LoginMapper loginMapper;

    public Object login(LoginDTO loginDTO) {

        Object object;

        // 1管理员，0学生
        if (loginDTO.getType() == 1) {
            Admin admin = loginMapper.getByUsernameInAdmin(loginDTO.getUsername());
            if (admin == null) {
                throw new BaseException("账号不存在");
            }
            if (!loginDTO.getPassword().equals(admin.getPassword())) {
                throw new BaseException("密码错误");
            }
            object = admin;
        } else {
            Student student = loginMapper.getByUsernameInStudent(loginDTO.getUsername());
            if (student == null) {
                throw new BaseException("账号不存在");
            }
            if (!loginDTO.getPassword().equals(student.getPassword())) {
                throw new BaseException("密码错误");
            }
            object = student;
        }
        return object;
    }
}
