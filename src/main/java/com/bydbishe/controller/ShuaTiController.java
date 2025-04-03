package com.bydbishe.controller;

import com.bydbishe.common.HandleCookie;
import com.bydbishe.common.JWT;
import com.bydbishe.dto.*;
import com.bydbishe.service.ShuaTiService;
import com.bydbishe.vo.*;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@RestController
public class ShuaTiController {
    @Autowired
    ShuaTiService shuaTiService;
    
    //返回章节目录
    @GetMapping("/chapterselect")
    public String getChapter() {
        return shuaTiService.getChapter();
    }
    
    //根据章节找题目列表
    @GetMapping("/chapter{id}")
    public List<ChapterVo> getChapterByKlg(HttpServletRequest request, @PathVariable String id) {
        if(id.charAt(1) == '.' && id.length() <= 3){
            id = '-' + id + '-'; 
        }
        return shuaTiService.getChapterByKlg(id, HandleCookie.getUseruid(request));
    }
    
    //根据uid找问题
    @GetMapping("/problems/{uid}")
    public ProblemVo getProblems(@PathVariable Integer uid, HttpServletRequest request) {
        return shuaTiService.getProblemByUid(uid, HandleCookie.getUseruid(request));
    }
    
    //单选题验证答案
    @PostMapping("/submitsinglechoice")
    public SingleChoiceSubmitVo submitSingleChoice(@RequestBody SingleChoiceSubmitDTO submitDTO) {
        return shuaTiService.submitSingleChoice(submitDTO);
    }
    
    @PostMapping("/submitgapfilling")
    public GapfillingSubmitVo submitGapFilling(@RequestBody GapFillingSubmitDTO gapFillingSubmitDTO){
        return shuaTiService.submitGapFilling(gapFillingSubmitDTO);
    }
    
    @PostMapping("/submitjudge")
    public JudgeSubmitVo submitJudge(@RequestBody JudgeSubmitDTO judgeSubmitDTO){
        return shuaTiService.submitJudge(judgeSubmitDTO);
    }
    
    @PostMapping("/submitbigproblem")
    public BigProblemSubmitVo submitBigProblem(@RequestBody BigProblemSubmitDTO bigProblemSubmitDTO){
        return shuaTiService.submitBigProblem(bigProblemSubmitDTO);
    } 
    
    //上一题
    @GetMapping("/preprob/{chapter}/{uid}")
    public ProblemVo preprob(@PathVariable String chapter, @PathVariable Integer uid, HttpServletRequest request) {
        if(chapter.charAt(1) == '.' && chapter.length() <= 3){
            chapter = '-' + chapter + '-';
        }
        return shuaTiService.preprob(chapter, uid, HandleCookie.getUseruid(request));
    }

    //下一题
    @GetMapping("/nextprob/{chapter}/{uid}")
    public ProblemVo nextprob(@PathVariable String chapter, @PathVariable Integer uid, HttpServletRequest request) {
        if(chapter.charAt(1) == '.' && chapter.length() <= 3){
            chapter = '-' + chapter + '-';
        }
        return shuaTiService.nextprob(chapter, uid, HandleCookie.getUseruid(request));
    }
    
    @PostMapping("/record")
    public void record(HttpServletRequest request, @RequestBody RecordDTO recordDTO) {
        shuaTiService.record(recordDTO, HandleCookie.getUseruid(request));
    }
    
    @GetMapping("/collect/{uid}/{status}")
    public void setcollect(HttpServletRequest request, @PathVariable Integer uid, @PathVariable Boolean status) {
        shuaTiService.setcollect(HandleCookie.getUseruid(request), uid, status);
    }
    
    @GetMapping("/collectselect")
    public List<CollectVo> getCollect(HttpServletRequest request) {
        return shuaTiService.getCollect(HandleCookie.getUseruid(request));
    }
}
