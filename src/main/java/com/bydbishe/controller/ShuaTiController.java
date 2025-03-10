package com.bydbishe.controller;

import com.bydbishe.service.ShuaTiService;
import com.bydbishe.vo.ChapterVo;
import com.bydbishe.vo.ProblemVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@RestController
public class ShuaTiController {
    @Autowired
    ShuaTiService shuaTiService;
    
    @GetMapping("/chapterselect")
    public String getChapter() {
        return shuaTiService.getChapter();
    }
    
    @GetMapping("/chapter{id}")
    public List<ChapterVo> getChapterByKlg(@PathVariable String id) {
        if(id.charAt(1) == '.' && id.length() <= 3){
            id = '-' + id + '-'; 
        }
        return shuaTiService.getChapterByKlg(id);
    }
    
    @GetMapping("/problems/{uid}")
    public ProblemVo getProblems(@PathVariable Integer uid) {
        return shuaTiService.getProblemByUid(uid);
    }
}
