package com.bydbishe.service.impl;

import com.bydbishe.mapper.UserMapper;
import com.bydbishe.service.UserService;
import com.bydbishe.vo.ProblemChartVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserMapper userMapper;
    
    @Override
    public void changePassword(Integer useruid, String password) {
        userMapper.changePassword(useruid, password);
    }

    @Override
    public ProblemChartVo chart(Integer useruid) {
        return userMapper.chart(useruid);
    }
}
