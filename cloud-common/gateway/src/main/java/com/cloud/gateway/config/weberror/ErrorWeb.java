//package com.cloud.gateway.config.weberror;
//
//import org.springframework.boot.autoconfigure.web.ErrorProperties;
//import org.springframework.boot.autoconfigure.web.ResourceProperties;
//import org.springframework.boot.autoconfigure.web.reactive.error.DefaultErrorWebExceptionHandler;
//import org.springframework.boot.web.reactive.error.ErrorAttributes;
//import org.springframework.cloud.gateway.support.NotFoundException;
//import org.springframework.context.ApplicationContext;
//import org.springframework.http.HttpStatus;
//import org.springframework.web.reactive.function.server.*;
//import org.springframework.web.server.ResponseStatusException;
//
//import java.util.HashMap;
//import java.util.Map;
//
///**
// * <p>
// *
// * </p>
// *
// * @Title ErrorWeb.java
// * @Package com.cloud.gateway.config.weberror
// * @Author <a href="mailto:tuanyu@sinotn.com">au .T</a>
// * @Date 2019/4/3 20:34
// */
//public class ErrorWeb extends DefaultErrorWebExceptionHandler {
//    /**
//     * Create a new {@code DefaultErrorWebExceptionHandler} instance.
//     *
//     * @param errorAttributes    the error attributes
//     * @param resourceProperties the resources configuration properties
//     * @param errorProperties    the error configuration properties
//     * @param applicationContext the current application context
//     */
//    public ErrorWeb(ErrorAttributes errorAttributes, ResourceProperties resourceProperties, ErrorProperties errorProperties, ApplicationContext applicationContext) {
//        super(errorAttributes, resourceProperties, errorProperties, applicationContext);
//    }
//
//    /**
//     * 获取异常属性
//     */
//    @Override
//    protected Map<String, Object> getErrorAttributes(ServerRequest request, boolean includeStackTrace) {
//        int code = 500;
//        Throwable error = super.getError(request);
//        if (error instanceof org.springframework.cloud.gateway.support.NotFoundException) {
//            code = 404;
//        }
//        return response(code, this.buildMessage(request, error));
//    }
//
//    /**
//     * 指定响应处理方法为JSON处理的方法
//     *
//     * @param errorAttributes
//     */
//    @Override
//    protected RouterFunction<ServerResponse> getRoutingFunction(ErrorAttributes errorAttributes) {
//        return RouterFunctions.route(RequestPredicates.all(), this::renderErrorResponse);
//    }
//
//    /**
//     * 根据code获取对应的HttpStatus
//     *
//     * @param errorAttributes
//     */
//    @Override
//    protected org.springframework.http.HttpStatus getHttpStatus(Map<String, Object> errorAttributes) {
//        int statusCode = (int) errorAttributes.get("code");
//        return org.springframework.http.HttpStatus.valueOf(statusCode);
//    }
//
//    /**
//     * 构建异常信息
//     *
//     * @param request
//     * @param ex
//     * @return
//     */
//    private String buildMessage(ServerRequest request, Throwable ex) {
//        StringBuilder message = new StringBuilder("Failed to handle request [");
//        message.append(request.methodName());
//        message.append(" ");
//        message.append(request.uri());
//        message.append("]");
//        HttpStatus httpStatus;
//        String body;
//        if (ex instanceof NotFoundException) {
//            httpStatus = org.springframework.http.HttpStatus.NOT_FOUND;
//            body = "Service Not Found";
//        } else if (ex instanceof ResponseStatusException) {
//            ResponseStatusException responseStatusException = (ResponseStatusException) ex;
//            httpStatus = responseStatusException.getStatus();
//            body = responseStatusException.getMessage();
//        } else {
//            httpStatus = org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR;
//            body = "Internal Server Error";
//        }
//        if (ex != null) {
//            message.append(": ");
//            message.append(ex.getMessage());
//        }
//        message.append(httpStatus).append("-----").append(body);
//        return message.toString();
//    }
//
//    /**
//     * 构建返回的JSON数据格式
//     *
//     * @param status       状态码
//     * @param errorMessage 异常信息
//     * @return
//     */
//    public static Map<String, Object> response(int status, String errorMessage) {
//        Map<String, Object> map = new HashMap<>();
//        map.put("code", status);
//        map.put("message", errorMessage);
//        map.put("data", null);
//        map.put("zdy", "111");
//        System.err.println(map);
//        return map;
//    }
//}
