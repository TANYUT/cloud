package com.cloud.jackson.entity;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Map;

/**
 * <p>
 *
 * </p>
 *
 * @Title: ExtendableBean.java
 * @Package: com.cloud.jackson.entity
 * @Description Copyright: Copyright (c) 2018 Company:北京信诺软通信息技术有限公司
 * @Author: <a href="mailto:tuanyu@sinotn.com">au .T</a>
 * @Date: 2019/5/17 18:56
 */
@Data

public class ExtendableBean {
	public String name;
	private Map<String, String> properties;

	@JsonAnyGetter
	public Map<String, String> getProperties() {
		return properties;
	}

	public ExtendableBean(String name) {
		this.name = name;
	}
}
