package com.news.admin.service.Impl;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.news.admin.mapper.AdUserMapper;
import com.news.admin.service.AdUserService;
import com.news.model.admin.dtos.AdUserDto;
import com.news.model.admin.pojos.AdUser;
import com.news.model.common.dtos.ResponseResult;
import com.news.model.common.enums.AppHttpCodeEnum;
import com.news.utils.common.AppJwtUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.DigestUtils;

import java.util.HashMap;
import java.util.Map;

@Service
@Slf4j
@Transactional
public class AdUserServiceImpl extends ServiceImpl<AdUserMapper, AdUser> implements AdUserService {
    /**
     * 登录
     * @param dto
     * @return
     */
    @Override
    public ResponseResult login(AdUserDto dto) {
        //1.检查参数
        if(StringUtils.isBlank(dto.getName()) || StringUtils.isBlank(dto.getPassword())){
            return ResponseResult.errorResult(AppHttpCodeEnum.PARAM_INVALID,"用户名或密码为空");
        }

        //2.查询用户
        AdUser adUser = getOne(Wrappers.<AdUser>lambdaQuery().eq(AdUser::getName, dto.getName()));
        if(adUser == null){
            return ResponseResult.errorResult(AppHttpCodeEnum.DATA_NOT_EXIST);
        }

        //3.比对密码
        String salt = adUser.getSalt();
        String pswd = dto.getPassword();
        pswd = DigestUtils.md5DigestAsHex((pswd + salt).getBytes());
        if(pswd.equals(adUser.getPassword())){
            //4.返回数据  jwt
            Map<String,Object>  map  = new HashMap<>();
            map.put("token", AppJwtUtil.getToken(adUser.getId().longValue()));
            adUser.setSalt("");
            adUser.setPassword("");
            map.put("user",adUser);
            return ResponseResult.okResult(map);

        }else {
            return ResponseResult.errorResult(AppHttpCodeEnum.LOGIN_PASSWORD_ERROR);
        }

    }
}
