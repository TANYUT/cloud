package com.cloud.jackson;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Data;
import org.codehaus.jackson.map.SerializationConfig;

import java.io.IOException;

/**
 * <p>
 *
 * </p>
 *
 * @Title: Test.java
 * @Package: com.cloud.jackson
 * @Description Copyright: Copyright (c) 2018 Company:北京信诺软通信息技术有限公司
 * @Author: <a href="mailto:tuanyu@sinotn.com">au .T</a>
 * @Date: 2019/5/17 18:56
 */
public class Test {
	public static void main(String[] args) {
		ObjectMapper mapper = new ObjectMapper();
		String jsonString = "{\"name\":\"Mahesh\", \"age\":21}";

		//map json to student
		try {
			Student student = mapper.readValue(jsonString, Student.class);
			System.out.println(student);

			mapper.enable(JsonParser.Feature.INCLUDE_SOURCE_IN_LOCATION);
			jsonString = mapper.writeValueAsString(student);
			System.out.println(jsonString);
		} catch (JsonParseException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Data
	class Student {
		private String name;
		private int age;
	}
}
