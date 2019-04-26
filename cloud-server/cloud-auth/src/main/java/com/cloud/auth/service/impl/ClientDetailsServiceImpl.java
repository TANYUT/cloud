package com.cloud.auth.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cloud.auth.entity.ClientDetails;
import com.cloud.auth.mapper.ClientDetailsMapper;
import com.cloud.auth.service.ClientDetailsService;
import org.springframework.stereotype.Service;

/**
 * <p>
 * ClientDetailsService实现类
 * </p>
 * @Title: ClientDetailsController.java
 * @Package:  com.cloud.service.impl
 *
 * @Author <a href="mailto:au_t@qq.com"">au.T</a>
 * @Date: 2019-04-06 16:52:22
 * @Version: 1.0.0
 */
@Service
public class ClientDetailsServiceImpl extends ServiceImpl<ClientDetailsMapper, ClientDetails> implements ClientDetailsService {


}