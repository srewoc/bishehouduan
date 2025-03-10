package com.bydbishe.mapper;

import com.bydbishe.entity.Admin;
import com.bydbishe.entity.Student;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface LoginMapper {

    Admin getByUsernameInAdmin(String username);

    Student getByUsernameInStudent(String username);
}
