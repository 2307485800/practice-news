package com.news.wemedia.controller.v1;

import com.news.model.common.dtos.ResponseResult;
import com.news.model.wemedia.dtos.WmMaterialDto;
import com.news.model.wemedia.pojos.WmMaterial;
import com.news.wemedia.service.WmMaterialService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import static com.news.model.common.enums.AppHttpCodeEnum.DATA_NOT_EXIST;
import static com.news.model.common.enums.AppHttpCodeEnum.PARAM_REQUIRE;
import static com.news.model.wemedia.pojos.WmNews.Status.SUCCESS;

@RestController
@RequestMapping("/api/v1/material")
public class WmMaterialController {

    @Autowired
    private WmMaterialService wmMaterialService;


    @PostMapping("/upload_picture")
    public ResponseResult uploadPicture(MultipartFile multipartFile){
        return wmMaterialService.uploadPicture(multipartFile);
    }

    @PostMapping("/list")
    public ResponseResult findList(@RequestBody WmMaterialDto dto){
        return wmMaterialService.findList(dto);
    }


    @ApiOperation("图片删除")
    @GetMapping("/del_picture/{id}")
    public ResponseResult delPicture(@PathVariable Integer   id){
        if(id==null)
            return ResponseResult.errorResult(PARAM_REQUIRE);
        WmMaterial wmMaterial = wmMaterialService.getById(id);
        if(wmMaterial==null){
            return ResponseResult.errorResult(DATA_NOT_EXIST);
        }
        boolean b = wmMaterialService.removeById(id);
        if(b){
            return ResponseResult.okResult(wmMaterial);
        }else{
            return ResponseResult.errorResult(501,"文件删除失败");
        }
    }

    @ApiOperation("收藏文章")
    @GetMapping("/collect/{id}")
    public ResponseResult collect(@PathVariable Integer id){
        if(id==null)
            return ResponseResult.errorResult(0,"传输的收藏id为空");
        WmMaterial wmMaterial = wmMaterialService.getById(id);
//        System.out.println(wmMaterial);
        wmMaterial.setIsCollection((short) 1);
        wmMaterialService.updateById(wmMaterial);

        return ResponseResult.okResult(SUCCESS);
    }

    @ApiOperation("取消收藏")
    @GetMapping("/cancel_collect/{id}")
    public ResponseResult cancelCollect(@PathVariable Integer id){
        if(id==null)
            return ResponseResult.errorResult(PARAM_REQUIRE);
        WmMaterial wmMaterial = wmMaterialService.getById(id);
//        System.out.println(wmMaterial);
        wmMaterial.setIsCollection((short) 0);
        wmMaterialService.updateById(wmMaterial);

        return ResponseResult.okResult(SUCCESS);
    }
}
