package com.bydbishe.service;

import com.bydbishe.common.PageResult;
import com.bydbishe.dto.NewProblemDTO;
import com.bydbishe.dto.PageDTO;

public interface ManageService {

    void newProblem(NewProblemDTO newProblemDTO);

    PageResult getPage(PageDTO pageDTO);
}
