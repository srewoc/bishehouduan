package com.bydbishe.mapper;

import com.bydbishe.entity.Chapter;
import com.bydbishe.entity.SingleChoice;
import com.bydbishe.vo.ChapterVo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ShuaTiMapper {
    String getChapter();

    List<ChapterVo> getByKlgInXuanzeti(String id);

    SingleChoice getProblemByUid(Integer uid);
}
