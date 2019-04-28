package com.cloud.oauth2.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cloud.oauth2.entity.OauthCode;
import com.cloud.oauth2.mapper.OauthCodeMapper;
import com.cloud.oauth2.service.OauthCodeService;
import org.springframework.stereotype.Service;

/**
 * <p>
 * OauthCodeService实现类
 * </p>
 * @Title: OauthCodeController.java
 * @Package:  com.cloud.service.impl
 *
 * @Author <a href="mailto:au.t@foxmail.com">au.T</a>
 * @Date: 2019-04-28 17:14:07
 * @Version: 1.0.0-SNAPSHOT
 */
@Service
public class OauthCodeServiceImpl extends ServiceImpl<OauthCodeMapper, OauthCode> implements OauthCodeService {


}