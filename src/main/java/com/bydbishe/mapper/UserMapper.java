package com.bydbishe.mapper;

import com.bydbishe.vo.ProblemChartVo;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {

    void changePassword(Integer useruid, String password);

    ProblemChartVo chart(Integer useruid);
}
