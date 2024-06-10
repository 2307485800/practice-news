package com.news.wemedia.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.news.model.wemedia.dtos.NewsAuthDto;
import com.news.model.wemedia.pojos.WmNews;
import com.news.model.wemedia.vo.WmNewsVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface WmNewsMapper  extends BaseMapper<WmNews> {

    List<WmNewsVo> findListAndPage(@Param("dto") NewsAuthDto dto);

    int findListCount(@Param("dto") NewsAuthDto dto);
}