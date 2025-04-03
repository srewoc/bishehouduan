package com.bydbishe.service;


import com.bydbishe.vo.ProblemChartVo;

public interface UserService {
    void changePassword(Integer useruid, String password);

    ProblemChartVo chart(Integer useruid);
}
