package com.news.wemedia.service;

import com.news.model.common.dtos.ResponseResult;
import com.news.model.wemedia.pojos.WmNews;

public interface WmNewsAutoScanService {

    /**
     * 自媒体文章审核
     * @param id  自媒体文章id
     */
    public void autoScanWmNews(Integer id);

    ResponseResult saveAppArticle(WmNews wmNews);
}
