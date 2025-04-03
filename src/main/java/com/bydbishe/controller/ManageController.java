package com.bydbishe.controller;

import com.bydbishe.common.PageResult;
import com.bydbishe.dto.NewProblemDTO;
import com.bydbishe.dto.PageDTO;
import com.bydbishe.service.ManageService;
import com.bydbishe.vo.ProblemManageVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
public class ManageController {
    @Autowired
    ManageService manageService;
    
    //题目表分页查询
    @GetMapping("/page")
    public PageResult getPage(PageDTO pageDTO) {
        System.out.println(pageDTO.toString());
        return manageService.getPage(pageDTO);
    }
    
    //新增题目
    @PostMapping("/newproblem")
    public void newProblem(@RequestBody NewProblemDTO newProblemDTO) {
        manageService.newProblem(newProblemDTO);
    }

    //根据uid查询题目信息
    @GetMapping("/geteditproblem/{uid}")
    public ProblemManageVo geteditproblem(@PathVariable Integer uid) {
//        return problemManageService.geteditproblem(uid);
        return null;
    }
    
    //修改题目
    @PutMapping("/upgrateproblem")
    public void upgradeProblem(@RequestBody NewProblemDTO newProblemDTO) {
//        problemManageService.updateProblem(newProblemDTO);
        System.out.println(newProblemDTO.toString());
    }
    
    
}
