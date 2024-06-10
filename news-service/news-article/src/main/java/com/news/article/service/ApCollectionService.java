package com.news.article.service;

import com.news.model.article.dtos.CollectionBehaviorDto;
import com.news.model.common.dtos.ResponseResult;

public interface ApCollectionService {

    /**
     * 收藏
     * @param dto
     * @return
     */
    public ResponseResult collection(CollectionBehaviorDto dto);
}
