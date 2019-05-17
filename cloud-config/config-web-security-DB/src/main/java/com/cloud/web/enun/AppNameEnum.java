package com.cloud.web.enun;

import lombok.Getter;

/**
 * <p>
 * App jar 枚举类
 * </p>
 *
 * @author <a href="mailto:tuanyu@sinotn.com">au .T</a>
 * @Title AppNameEnum.java
 * @Package com.cloud.web.enum
 * @Date 2019/5/5 14:01
 */
public enum AppNameEnum {
	/**
	 * gateway 网关服务
	 */
	GATEWAY_APP("cloud-gateway"),
	//oauth2  鉴权服务
	OAUTH_ADMIN_APP("cloud-oauth2-admin");

	@Getter
	private String appName;


	AppNameEnum(String appName) {
		this.appName = appName;
	}

}
