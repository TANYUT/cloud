package com.cloud.oauth2.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cloud.oauth2.entity.OauthRefreshToken;
import com.cloud.oauth2.mapper.OauthRefreshTokenMapper;
import com.cloud.oauth2.service.OauthRefreshTokenService;
import org.springframework.stereotype.Service;

/**
 * <p>
 * OauthRefreshTokenService实现类
 * </p>
 * @Title: OauthRefreshTokenController.java
 * @Package:  com.cloud.service.impl
 *
 * @Author <a href="mailto:au.t@foxmail.com">au.T</a>
 * @Date: 2019-04-28 17:14:08
 * @Version: 1.0.0-SNAPSHOT
 */
@Service
public class OauthRefreshTokenServiceImpl extends ServiceImpl<OauthRefreshTokenMapper, OauthRefreshToken> implements OauthRefreshTokenService {


}