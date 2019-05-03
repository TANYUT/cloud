package com.cloud.web.config;

import com.github.tobato.fastdfs.FdfsClientConfig;
import org.springframework.context.annotation.EnableMBeanExport;
import org.springframework.context.annotation.Import;
import org.springframework.jmx.support.RegistrationPolicy;

/**
 * <p>
 *
 * </p>
 *
 * @Title FdfsConnectionConfig.java
 * @Package com.cloud.web.config
 * @Author <a href="mailto:tuanyu@sinotn.com">au .T</a>
 * @Date 2019/5/2 18:30
 */
@Import(FdfsClientConfig.class)
// 解决jmx重复注册bean的问题
@EnableMBeanExport(registration = RegistrationPolicy.IGNORE_EXISTING)
public class FdfsConnectionConfig {
}
