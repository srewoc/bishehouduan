package com.bydbishe.mapper;

import com.bydbishe.dto.NewProblemDTO;
import com.bydbishe.dto.PageDTO;
import com.bydbishe.vo.ProblemManageVo;
import com.github.pagehelper.Page;
import org.apache.ibatis.annotations.Mapper;


@Mapper
public interface ManageMapper {

    void newProblem(NewProblemDTO newProblemDTO);

    Page<ProblemManageVo> getPage(PageDTO pageDTO);
}
