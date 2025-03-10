package com.bydbishe.service;

import com.bydbishe.dto.LoginDTO;
import org.springframework.stereotype.Service;

public interface LoginService {


    String login(LoginDTO loginDTO);
}
