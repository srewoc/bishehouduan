package com.bydbishe.mapper;

import com.bydbishe.vo.ChapterVo;
import com.bydbishe.vo.CollectVo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ShuaTiMapper {
    String getChapter();
    
    Object getProblemByUid(Integer uid);

    List<ChapterVo> getByKlg(String id, Integer useruid);

    Object getPreprob(String chapter, Integer uid);

    Object getNextprob(String chapter, Integer uid);

    void record(Integer problemuid, Integer flag, Integer useruid);

    Boolean getisFavorite(Integer problemuid, Integer useruid);

    void setcollect(Integer useruid, Integer problemuid, Boolean status);

    List<CollectVo> getCollect(Integer useruid);
}
