package com.news.wemedia.service;

import com.news.model.wemedia.dtos.NewsAuthDto;
import com.news.wemedia.WemediaApplication;
import com.news.wemedia.mapper.WmNewsMapper;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest(classes = WemediaApplication.class)
@RunWith(SpringRunner.class)
class WmNewsAutoScanServiceTest {

    @Autowired
    private WmNewsMapper wmNewsMapper;

    @Test
    void autoScanWmNews() {
        NewsAuthDto dto=new NewsAuthDto();
        dto.setId(6253);
        dto.setTitle("啊实打实水水水水水水水水");
        System.out.println(wmNewsMapper.findListAndPage(dto));
    }
}