package com.news.wemedia.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.news.model.common.dtos.ResponseResult;
import com.news.model.wemedia.dtos.ChannelDto;
import com.news.model.wemedia.pojos.WmChannel;

public interface WmChannelService extends IService<WmChannel> {

    /**
     * 查询所有频道
     * @return
     */
    public ResponseResult findAll();


    ResponseResult findByNameAndPage(ChannelDto dto);

    ResponseResult insert(WmChannel adChannel);

    ResponseResult update(WmChannel adChannel);

}