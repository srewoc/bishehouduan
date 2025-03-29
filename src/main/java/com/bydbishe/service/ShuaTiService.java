package com.bydbishe.service;

import com.bydbishe.dto.BigProblemSubmitDTO;
import com.bydbishe.dto.GapFillingSubmitDTO;
import com.bydbishe.dto.JudgeSubmitDTO;
import com.bydbishe.dto.SingleChoiceSubmitDTO;
import com.bydbishe.vo.*;

import java.util.List;

public interface ShuaTiService {
    String getChapter();

    List<ChapterVo> getChapterByKlg(String id);

    ProblemVo getProblemByUid(Integer uid);

    SingleChoiceSubmitVo submitSingleChoice(SingleChoiceSubmitDTO submitDTO);

    ProblemVo preprob(String chapter, Integer uid);

    GapfillingSubmitVo submitGapFilling(GapFillingSubmitDTO gapFillingSubmitDTO);

    JudgeSubmitVo submitJudge(JudgeSubmitDTO judgeSubmitDTO);

    BigProblemSubmitVo submitBigProblem(BigProblemSubmitDTO bigProblemSubmitDTO);

    ProblemVo nextprob(String chapter, Integer uid);
}
