package com.bydbishe.service;

import com.bydbishe.vo.ChapterVo;
import com.bydbishe.vo.ProblemVo;

import java.util.List;

public interface ShuaTiService {
    String getChapter();

    List<ChapterVo> getChapterByKlg(String id);

    ProblemVo getProblemByUid(Integer uid);
}
