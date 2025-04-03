package com.bydbishe.service.impl;

import com.bydbishe.dto.*;
import com.bydbishe.entity.BigProblem;
import com.bydbishe.entity.GapFilling;
import com.bydbishe.entity.Judge;
import com.bydbishe.entity.SingleChoice;
import com.bydbishe.mapper.ShuaTiMapper;
import com.bydbishe.service.ShuaTiService;
import com.bydbishe.vo.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
public class ShuaTiServiceImpl implements ShuaTiService {
    @Autowired
    ShuaTiMapper shuaTiMapper;


    @Override
    public String getChapter() {
        return shuaTiMapper.getChapter();
    }

    @Override
    public List<ChapterVo> getChapterByKlg(String id, Integer useruid) {
        List<ChapterVo> list = shuaTiMapper.getByKlg(id, useruid);
        return new ArrayList<ChapterVo>(list);
    }

    @Override
    public ProblemVo getProblemByUid(Integer uid, Integer useruid) {
        Object problem = shuaTiMapper.getProblemByUid(uid);
        return classTransition(problem, useruid);
    }

    @Override
    public ProblemVo preprob(String chapter, Integer uid, Integer useruid) {
        Object problem = shuaTiMapper.getPreprob(chapter, uid);
        if(problem == null){
            return null;
        }
        return classTransition(problem,  useruid);
    }

    @Override
    public ProblemVo nextprob(String chapter, Integer uid, Integer useruid) {
        Object problem = shuaTiMapper.getNextprob(chapter, uid);
        if(problem == null){
            return null;
        }
        return classTransition(problem, useruid);
    }

    @Override
    public void record(RecordDTO recordDTO, Integer useruid) {
        shuaTiMapper.record(recordDTO.getProblemuid(), recordDTO.getFlag(), useruid);
    }

    @Override
    public void setcollect(Integer useruid, Integer problemuid, Boolean status) {
        shuaTiMapper.setcollect(useruid, problemuid, status);
    }

    @Override
    public List<CollectVo> getCollect(Integer useruid) {
        return shuaTiMapper.getCollect(useruid);
    }

    @Override
    public SingleChoiceSubmitVo submitSingleChoice(SingleChoiceSubmitDTO submitDTO) {
        SingleChoice singlechoice = (SingleChoice) shuaTiMapper.getProblemByUid(submitDTO.getUid());
        if (singlechoice.getAnswer().equals(submitDTO.getSelect())) {
            return SingleChoiceSubmitVo.builder()
                    .flag(true)
                    .ans(singlechoice.getAnswer())
                    .build();
        } else {
            return SingleChoiceSubmitVo.builder()
                    .flag(false)
                    .ans(singlechoice.getAnswer())
                    .build();
        }
    }

    @Override
    public GapfillingSubmitVo submitGapFilling(GapFillingSubmitDTO gapFillingSubmitDTO) {
        GapFilling gapFilling = (GapFilling) shuaTiMapper.getProblemByUid(gapFillingSubmitDTO.getUid());
        String[] realans = gapFilling.getAnswer().split(",");
        List<String> userans = gapFillingSubmitDTO.getGaps();
        Boolean flag = true;

        for (int i = 0; i < realans.length; i++) {
            if (!realans[i].equals(userans.get(i))) {
                flag = false;
                break;
            }
        }
        return new GapfillingSubmitVo(flag, gapFilling.getAnswer());
    }

    @Override
    public JudgeSubmitVo submitJudge(JudgeSubmitDTO judgeSubmitDTO) {
        Judge judge = (Judge) shuaTiMapper.getProblemByUid(judgeSubmitDTO.getUid());
        boolean flag = judgeSubmitDTO.getSelect().equals("true") ^ (judge.getAnswer() == 1);
        return new JudgeSubmitVo(flag ? "错" : "对", !flag);
    }

    @Override
    public BigProblemSubmitVo submitBigProblem(BigProblemSubmitDTO bigProblemSubmitDTO) {
        BigProblem bigProblem = (BigProblem) shuaTiMapper.getProblemByUid(bigProblemSubmitDTO.getUid());
        return new BigProblemSubmitVo(bigProblem.getAnswer());
    }

    private ProblemVo classTransition(Object problem, Integer useruid) {
        if (problem instanceof SingleChoice singleChoice) {
            // TODO 后续可能要改切片方式
            String[] text = singleChoice.getText().split("\n");
            return ProblemVo.builder().data(
                            SingleChoiceVo.builder()
                                    .title(text[0])
                                    .OPA(text[1])
                                    .OPB(text[2])
                                    .OPC(text[3])
                                    .OPD(text[4])
                                    .diff(singleChoice.getDifficulty())
                                    .picture(singleChoice.getPicture())
                                    .uid(singleChoice.getUid())
                                    .build()
                    )
                    .type(singleChoice.getType())
                    .isFavorite(shuaTiMapper.getisFavorite(singleChoice.getUid(), useruid))
                    .build();
        } 
        else if (problem instanceof GapFilling gapFilling) {
            return ProblemVo.builder().data(
                            GapfillingVo.builder()
                                    .title(gapFilling.getText())
                                    .diff(gapFilling.getDifficulty())
                                    .gapcnt(gapFilling.getKong())
                                    .picture(gapFilling.getPicture())
                                    .uid(gapFilling.getUid())
                                    .build()
                    )
                    .type(gapFilling.getType())
                    .isFavorite(shuaTiMapper.getisFavorite(gapFilling.getUid(), useruid))
                    .build();
        } 
        else if (problem instanceof Judge judge) {
            return ProblemVo.builder().data(
                            JudgeVo.builder()
                                    .title(judge.getText())
                                    .picture(judge.getPicture())
                                    .diff(judge.getDifficulty())
                                    .uid(judge.getUid())
                                    .build()
                    )
                    .type(judge.getType())
                    .isFavorite(shuaTiMapper.getisFavorite(judge.getUid(), useruid))
                    .build();
        } 
        else {
            BigProblem bigProblem = (BigProblem) problem;
            return ProblemVo.builder().data(
                            BigProblemVo.builder()
                                    .title(bigProblem.getText())
                                    .picture(bigProblem.getPicture())
                                    .diff(bigProblem.getDifficulty())
                                    .gapcnt(bigProblem.getKong())
                                    .uid(bigProblem.getUid())
                                    .build()
                    )
                    .type(bigProblem.getType())
                    .isFavorite(shuaTiMapper.getisFavorite(bigProblem.getUid(), useruid))
                    .build();
        }
    }
    
    

}
