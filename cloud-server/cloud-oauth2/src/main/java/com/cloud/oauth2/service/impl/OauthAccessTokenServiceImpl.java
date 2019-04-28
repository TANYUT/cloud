package com.cloud.oauth2.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cloud.oauth2.entity.OauthAccessToken;
import com.cloud.oauth2.mapper.OauthAccessTokenMapper;
import com.cloud.oauth2.service.OauthAccessTokenService;
import org.springframework.stereotype.Service;

/**
 * <p>
 * OauthAccessTokenService实现类
 * </p>
 * @Title: OauthAccessTokenController.java
 * @Package:  com.cloud.service.impl
 *
 * @Author <a href="mailto:au.t@foxmail.com">au.T</a>
 * @Date: 2019-04-28 17:14:07
 * @Version: 1.0.0-SNAPSHOT
 */
@Service
public class OauthAccessTokenServiceImpl extends ServiceImpl<OauthAccessTokenMapper, OauthAccessToken> implements OauthAccessTokenService {


}