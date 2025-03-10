package com.bydbishe.service.impl;

import com.bydbishe.entity.SingleChoice;
import com.bydbishe.mapper.ShuaTiMapper;
import com.bydbishe.service.ShuaTiService;
import com.bydbishe.vo.ChapterVo;
import com.bydbishe.vo.ProblemVo;
import com.bydbishe.vo.SingleChoiceVo;
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
    public List<ChapterVo> getChapterByKlg(String id) {
        List<ChapterVo> xuanzeti = shuaTiMapper.getByKlgInXuanzeti(id);
        return new ArrayList<ChapterVo>(xuanzeti);
    }

    @Override
    public ProblemVo getProblemByUid(Integer uid) {
        SingleChoice problem = shuaTiMapper.getProblemByUid(uid);
        String[] text = problem.getText().split("\n");
        return ProblemVo.builder().data(
                        SingleChoiceVo.builder()
                                .title(text[0])
                                .OPA(text[1])
                                .OPB(text[2])
                                .OPC(text[3])
                                .OPD(text[4])
                                .diff(problem.getDifficulty())
                                .build()
                )
                .type(1)
                .build();
    }
}
