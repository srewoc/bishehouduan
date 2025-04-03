package com.bydbishe.service;

import com.bydbishe.dto.*;
import com.bydbishe.vo.*;

import java.util.List;

public interface ShuaTiService {
    String getChapter();

    List<ChapterVo> getChapterByKlg(String id, Integer useruid);

    ProblemVo getProblemByUid(Integer uid, Integer useruid);

    SingleChoiceSubmitVo submitSingleChoice(SingleChoiceSubmitDTO submitDTO);

    ProblemVo preprob(String chapter, Integer uid, Integer useruid);

    GapfillingSubmitVo submitGapFilling(GapFillingSubmitDTO gapFillingSubmitDTO);

    JudgeSubmitVo submitJudge(JudgeSubmitDTO judgeSubmitDTO);

    BigProblemSubmitVo submitBigProblem(BigProblemSubmitDTO bigProblemSubmitDTO);

    ProblemVo nextprob(String chapter, Integer uid, Integer useruid);

    void record(RecordDTO recordDTO, Integer useruid);

    void setcollect(Integer useruid, Integer problemuid, Boolean status);

    List<CollectVo> getCollect(Integer useruid);
}
