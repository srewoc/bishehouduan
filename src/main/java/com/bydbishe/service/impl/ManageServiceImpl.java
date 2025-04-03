package com.bydbishe.service.impl;

import com.bydbishe.common.PageResult;
import com.bydbishe.dto.NewProblemDTO;
import com.bydbishe.dto.PageDTO;
import com.bydbishe.mapper.ManageMapper;
import com.bydbishe.service.ManageService;
import com.bydbishe.vo.ProblemManageVo;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ManageServiceImpl implements ManageService {

    @Autowired
    ManageMapper manageMapper;
    
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void newProblem(NewProblemDTO newProblemDTO) {
        manageMapper.newProblem(newProblemDTO);
    }

    @Override
    public PageResult getPage(PageDTO pageDTO) {
        PageHelper.startPage(pageDTO.getPage(), pageDTO.getPagesize());
        List<ProblemManageVo> records = manageMapper.getPage(pageDTO);
        return new PageResult(records.size(), records);
    }
}
