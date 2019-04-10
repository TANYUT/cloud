package com.cloud.gateway.filter.serverfilter;

import org.springframework.cloud.gateway.filter.factory.rewrite.RewriteFunction;

import java.util.Map;

/**
 * <p>
 *
 * </p>
 *
 * @Title ResBodyConfig.java
 * @Package com.cloud.gateway.filter
 * @Author <a href="mailto:tuanyu@sinotn.com">au .T</a>
 * @Date 2019/4/7 10:44
 */
public  class  ResBodyConfig {
    private Class inClass;

    private Class outClass;

    private Map<String, Object> inHints;

    private Map<String, Object> outHints;

    private String newContentType;

    private RewriteFunction rewriteFunction;

    public Class getInClass() {
        return inClass;
    }

    public ResBodyConfig setInClass(Class inClass) {
        this.inClass = inClass;
        return this;
    }

    public Class getOutClass() {
        return outClass;
    }

    public ResBodyConfig setOutClass(Class outClass) {
        this.outClass = outClass;
        return this;
    }

    public Map<String, Object> getInHints() {
        return inHints;
    }

    public ResBodyConfig setInHints(Map<String, Object> inHints) {
        this.inHints = inHints;
        return this;
    }

    public Map<String, Object> getOutHints() {
        return outHints;
    }

    public ResBodyConfig setOutHints(Map<String, Object> outHints) {
        this.outHints = outHints;
        return this;
    }

    public String getNewContentType() {
        return newContentType;
    }

    public ResBodyConfig setNewContentType(String newContentType) {
        this.newContentType = newContentType;
        return this;
    }

    public RewriteFunction getRewriteFunction() {
        return rewriteFunction;
    }

    public ResBodyConfig setRewriteFunction(RewriteFunction rewriteFunction) {
        this.rewriteFunction = rewriteFunction;
        return this;
    }

    public <T, R> ResBodyConfig setRewriteFunction(Class<T> inClass, Class<R> outClass,
                                                                      RewriteFunction<T, R> rewriteFunction) {
        setInClass(inClass);
        setOutClass(outClass);
        setRewriteFunction(rewriteFunction);
        return this;
    }
}
