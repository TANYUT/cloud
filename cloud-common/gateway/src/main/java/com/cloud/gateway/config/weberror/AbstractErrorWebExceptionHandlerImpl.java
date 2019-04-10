//package com.cloud.gateway.config.weberror;
//
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.boot.autoconfigure.web.ErrorProperties;
//import org.springframework.boot.autoconfigure.web.ResourceProperties;
//import org.springframework.boot.autoconfigure.web.reactive.error.AbstractErrorWebExceptionHandler;
//import org.springframework.boot.web.reactive.error.ErrorAttributes;
//import org.springframework.context.ApplicationContext;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.core.annotation.Order;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.MediaType;
//import org.springframework.http.codec.HttpMessageWriter;
//import org.springframework.stereotype.Component;
//import org.springframework.util.Assert;
//import org.springframework.web.reactive.function.BodyInserters;
//import org.springframework.web.reactive.function.server.*;
//import reactor.core.publisher.Mono;
//
//import java.util.*;
//
///**
// * <p>
// *
// * </p>
// *
// * @Title AbstractErrorWebExceptionHandlerImpl.java
// * @Package com.cloud.gateway.config.weberror
// * @Author <a href="mailto:tuanyu@sinotn.com">au .T</a>
// * @Date 2019/4/3 20:45
// */
//@Slf4j
//@Component
//@Order(-1000)
//@Configuration
//public class AbstractErrorWebExceptionHandlerImpl extends AbstractErrorWebExceptionHandler {
//    private List<HttpMessageWriter<?>> messageWriters = Collections.emptyList();
//    public AbstractErrorWebExceptionHandlerImpl(ErrorAttributes errorAttributes, ResourceProperties resourceProperties, ApplicationContext applicationContext) {
//        super(errorAttributes, resourceProperties, applicationContext);
//    }
//
//
//    @Override
//    protected RouterFunction<ServerResponse> getRoutingFunction(
//            ErrorAttributes errorAttributes) {
//        return RouterFunctions.route(
//                RequestPredicates.all(), this::renderErrorResponse);
//    }
//
//    private Mono<ServerResponse> renderErrorResponse(
//            ServerRequest request) {
//        Map<String, Object> errorPropertiesMap = getErrorAttributes(request, false);
//        // 这里可以自定义处理逻辑
//        errorPropertiesMap.put("xttblog", "www.xttblog.com");
//        System.err.println(errorPropertiesMap);
//        return ServerResponse.status(HttpStatus.BAD_REQUEST)
//                .contentType(MediaType.APPLICATION_JSON_UTF8)
//                .body(BodyInserters.fromObject(errorPropertiesMap));
//    }
//}
