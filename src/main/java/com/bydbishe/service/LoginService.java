package com.bydbishe.service;

import com.bydbishe.dto.LoginDTO;
import org.springframework.stereotype.Service;

public interface LoginService {


    Object login(LoginDTO loginDTO);
}
