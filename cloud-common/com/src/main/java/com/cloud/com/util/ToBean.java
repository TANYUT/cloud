package com.cloud.com.util;

import cn.hutool.json.JSONArray;
import cn.hutool.json.JSONUtil;
import com.alibaba.fastjson.JSONObject;
import com.cloud.com.constant.FinalConstant;
import lombok.Data;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * <p>
 * 详细见方法
 * </p>
 *
 * @Title ToBean.java
 * @Package com.cloud.com.util
 * @Author <a href="mailto:au_t@qq.com">au .T</a>
 * @Date 2019/4/9 22:57
 */
public class ToBean {


    /**
     * <p>
     * 此方法会忽略空值，但是对JSON字符串不影响<br/>
     * 不带null值得字符串
     * 注意： 如果Map 有 null 作为 key  就会被忽略 null 这对 K,V
     * 如果Map 有 null  作为 V  不会忽略
     * </p>
     *
     * @params: [obj]
     * @params: [Bean对象或者Map]
     * @return: java.lang.String
     * @Author: au .T
     * @Date: 2019/3/4 10:35
     */
    public static final String objToStr(Object obj) {
        return JSONUtil.parseObj(obj).toString();
    }


    /**
     * <p>
     * 此方法不会忽略空值，但是对JSON字符串不影响<br/>
     * User user=new User();
     * user.setId("123");
     * {"name":null,"id":"123"}
     * 带null值得字符串
     * </p>
     *
     * @params: [obj]
     * @params: [Bean对象或者Map]
     * @return: java.lang.String
     * @Author: au .T
     * @Date: 2019/3/4 10:35
     */
    public static final String objToStrNullVal(Object obj) {
        return JSONUtil.parseObj(obj, Boolean.FALSE).toString();
    }


    /**
     * <p>
     * 将对象里面的null 转成 undefined
     * </p>
     *
     * @params: [obj]
     * @params: [Bean对象或者Map]
     * @return: java.lang.String
     * @Author: au .T
     * @Date: 2019/3/4 10:36
     */
    public static final String objToStrUndefined(Object obj) {
        return objToStrNullVal(obj).replaceAll(FinalConstant.JAVA_STR_NULL, FinalConstant.HTML_UNDEFINED);
    }

    /**
     * <p>
     * 带null值得String JSON字符串
     * </p>
     *
     * @params: [array]
     * @params: [ 里面最好是Bean对象]
     * @return: java.util.List<java.lang.String>
     * @Author: au .T
     * @Date: 2019/3/4 10:36
     */
    public static final List<String> toArrayStrNullVal(List<?> array) {
        List<String> list = new ArrayList<>();
        array.forEach(obj -> list.add(objToStrNullVal(obj)));
        return list;
    }


    /**
     * <p>
     * 返回list  对象里面值如果是null 就会返回 undefined
     * 注意 如果Map 里面  null  作为 K  那么则会 忽略这组 K,V
     * </p>
     *
     * @params: [array]
     * @params: [array里面最好是 Bean]
     * @return: java.util.List<java.lang.String>
     * @Author: au .T
     * @Date: 2019/3/4 10:37
     */
    public static final List<String> toArrayStrUndefined(List<?> array) {
        List<String> list = new ArrayList<>();
        array.forEach(obj -> list.add(objToStrUndefined(obj)));
        return list;
    }

    /**
     * <p>
     * 不带null 值得字符串
     * </p>
     *
     * @params: [array]
     * @params: [array里面可以是 Bean 或 Map]
     * @return: java.util.List<java.lang.String>
     * @Author: au .T
     * @Date: 2019/3/6 22:08
     */
    public static final List<String> toArrayStr(List<?> array) {
        List<String> list = new ArrayList<>();
        array.forEach(obj -> list.add(objToStr(obj)));
        return list;
    }


    /**
     * <p>
     * 调用之前先做非空判断,没有数据的返回的是空List
     * </p>
     *
     * @params: [clazz, array]
     * @params: [List里面的对象, array里面可以是Bean 或 Map 或 String(json格式)]
     * @return: java.util.List<T>
     * @Author: au .T
     * @Date: 2019/3/6 13:37
     */
    public static final <T> List<T> toArrayBean(Class<T> clazz, List<?> array) {
        List<T> list = new ArrayList<>();
        array.forEach(obj -> list.add(toJavaBean(clazz, obj)));
        return list;
    }

    /**
     * <p>
     * 直接调用 hutool JSONUtil
     * </p>
     *
     * @params: [ clazz, obj]
     * @params: [返回的类型, Bean 或 Map 或 String(json格式)]
     * @return: T
     * @Author: au .T
     * @Date: 2019/4/9 23:24
     */
    public static final <T> T toJavaBean(Class<T> clazz, Object obj) {
        return JSONUtil.parseObj(obj).toBean(clazz);
    }

    public static void main(String[] args) {
        JSONArray array = JSONUtil.createArray();
        List<String> list = new ArrayList<>();
        list.add("!");
        list.add("?");
        JSONObject jsonObject = new JSONObject();
        System.err.println(new Date());
        jsonObject.put("date", new Date());
        jsonObject.put("list", "143241234");
//        jsonObject.put("list", list);
        System.err.println(jsonObject);
        System.err.println(ToBean.toJavaBean(User.class, jsonObject).getList());
    }

    @Data
    class User {
        private Date date;
        private List list;
    }
}
