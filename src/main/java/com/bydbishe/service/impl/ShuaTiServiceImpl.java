package com.bydbishe.service.impl;

import com.bydbishe.dto.BigProblemSubmitDTO;
import com.bydbishe.dto.GapFillingSubmitDTO;
import com.bydbishe.dto.JudgeSubmitDTO;
import com.bydbishe.dto.SingleChoiceSubmitDTO;
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
import java.util.Objects;

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
    public List<ChapterVo> getChapterByKlg(String id) {
        List<ChapterVo> list = shuaTiMapper.getByKlg(id);
        return new ArrayList<ChapterVo>(list);
    }

    @Override
    public ProblemVo getProblemByUid(Integer uid) {
        Object problem = shuaTiMapper.getProblemByUid(uid);
        return classTransition(problem);
    }

    @Override
    public ProblemVo preprob(String chapter, Integer uid) {
        Object problem = shuaTiMapper.getPreprob(chapter, uid);
        return classTransition(problem);
    }

    @Override
    public ProblemVo nextprob(String chapter, Integer uid) {
        Object problem = shuaTiMapper.getNextprob(chapter, uid);
        return classTransition(problem);
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



    private ProblemVo classTransition(Object problem) {
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
                                    .build()
                    )
                    .type(singleChoice.getType())
                    .build();
        } else if (problem instanceof GapFilling gapFilling) {
            return ProblemVo.builder().data(
                            GapfillingVo.builder()
                                    .title(gapFilling.getText())
                                    .diff(gapFilling.getDifficulty())
                                    .gapcnt(gapFilling.getKong())
                                    .picture(gapFilling.getPicture())
                                    .build()
                    )
                    .type(gapFilling.getType())
                    .build();
        } else if (problem instanceof Judge judge) {
            return ProblemVo.builder().data(
                            JudgeVo.builder()
                                    .title(judge.getText())
                                    .picture(judge.getPicture())
                                    .diff(judge.getDifficulty())
                                    .build()
                    )
                    .type(judge.getType())
                    .build();
        } else {
            BigProblem bigProblem = (BigProblem) problem;
            return ProblemVo.builder().data(
                            BigProblemVo.builder()
                                    .title(bigProblem.getText())
                                    .picture(bigProblem.getPicture())
                                    .diff(bigProblem.getDifficulty())
                                    .gapcnt(bigProblem.getKong())
                                    .build()
                    )
                    .type(bigProblem.getType())
                    .build();
        }
    }


}
