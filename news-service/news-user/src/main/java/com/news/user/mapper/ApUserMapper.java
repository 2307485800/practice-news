package com.news.user.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.news.model.user.pojos.ApUser;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ApUserMapper extends BaseMapper<ApUser> {
}
