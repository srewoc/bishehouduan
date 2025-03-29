package com.bydbishe.controller;

import com.bydbishe.dto.BigProblemSubmitDTO;
import com.bydbishe.dto.GapFillingSubmitDTO;
import com.bydbishe.dto.JudgeSubmitDTO;
import com.bydbishe.dto.SingleChoiceSubmitDTO;
import com.bydbishe.service.ShuaTiService;
import com.bydbishe.vo.*;
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
    public List<ChapterVo> getChapterByKlg(@PathVariable String id) {
        if(id.charAt(1) == '.' && id.length() <= 3){
            id = '-' + id + '-'; 
        }
        return shuaTiService.getChapterByKlg(id);
    }
    
    //根据uid找问题
    @GetMapping("/problems/{uid}")
    public ProblemVo getProblems(@PathVariable Integer uid) {
        return shuaTiService.getProblemByUid(uid);
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
    public ProblemVo preprob(@PathVariable String chapter, @PathVariable Integer uid) {
        return shuaTiService.preprob(chapter, uid);
    }

    //下一题
    @GetMapping("/preprob/{chapter}/{uid}")
    public ProblemVo nextprob(@PathVariable String chapter, @PathVariable Integer uid) {
        return shuaTiService.nextprob(chapter, uid);
    }
}
