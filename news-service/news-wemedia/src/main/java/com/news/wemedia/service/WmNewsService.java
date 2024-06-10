package com.news.wemedia.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.news.model.common.dtos.ResponseResult;
import com.news.model.wemedia.dtos.NewsAuthDto;
import com.news.model.wemedia.dtos.WmNewsDto;
import com.news.model.wemedia.dtos.WmNewsPageReqDto;
import com.news.model.wemedia.pojos.WmNews;
import org.springframework.web.bind.annotation.RequestBody;

public interface WmNewsService extends IService<WmNews> {

    /**
     * 条件查询文章列表
     * @param dto
     * @return
     */
    public ResponseResult findList(WmNewsPageReqDto dto);

    /**
     * 发布修改文章或保存为草稿
     * @param dto
     * @return
     */
    public ResponseResult submitNews(WmNewsDto dto);

    /**
     * 文章上下架
     * @param dto 对象
     * @returnok
     */
    ResponseResult downOrUp(@RequestBody WmNewsDto dto);

    ResponseResult findList(NewsAuthDto dto);

    ResponseResult findWmNewsVo(Integer id);

    ResponseResult updateStatus(Short wmNewsAuthPass, NewsAuthDto dto);
}
