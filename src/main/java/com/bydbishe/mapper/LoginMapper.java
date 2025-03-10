package com.bydbishe.mapper;

import com.bydbishe.entity.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface LoginMapper {
    
    User login(String username);
}
