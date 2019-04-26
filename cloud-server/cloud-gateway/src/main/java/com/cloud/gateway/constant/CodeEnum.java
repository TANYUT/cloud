package com.cloud.gateway.constant;


/**
 * <p>
 *
 * </p>
 *
 * @Title CodeEnum.java
 * @Package com.cloud.gateway.constant
 * @Author <a href="mailto:tuanyu@sinotn.com">au .T</a>
 * @Date 2019/4/6 23:37
 */
public enum CodeEnum {

    // 1xx Informational
    CONTINUE(100, "请继续发送请求的剩余部分"),
    SWITCHING_PROTOCOLS(101, "客户要求服务器根据请求转换HTTP协议版本"),
    PROCESSING(102, "Processing请求将继续执行"),
    CHECKPOINT(103, "Checkpoint 可以预加载"),
    // 2xx Success
    OK(200, "请求已经成功处理"),
    CREATED(201, "请求已经成功处理，并创建了资源"),
    ACCEPTED(202, "请求已经接受，等待执行"),
    NON_AUTHORITATIVE_INFORMATION(203, "请求已经成功处理，但是信息不是原始的"),
    NO_CONTENT(204, "请求已经成功处理，没有内容需要返回"),
    RESET_CONTENT(205, "请求已经成功处理，请重置视图"),
    PARTIAL_CONTENT(206, "部分Get请求已经成功处理"),
    MULTI_STATUS(207, "请求已经成功处理，将返回XML消息体"),
    ALREADY_REPORTED(208, "请求已经成功处理，一个DAV的绑定成员被前一个请求枚举，并且没有被再一次包括"),
    IM_USED(226, "请求已经成功处理，将响应一个或者多个实例"),
    // 3xx Redirection
    MULTIPLE_CHOICES(300, "提供可供选择的回馈"),
    MOVED_PERMANENTLY(301, "请求的资源已经永久转移"),
    FOUND(302, "请重新发送请求"),
    @Deprecated
    MOVED_TEMPORARILY(302, "暂时移动"),
    SEE_OTHER(303, "请以Get方式请求另一个URI"),
    NOT_MODIFIED(304, "资源未改变"),
    @Deprecated
    USE_PROXY(305, "使用代理服务器"),
    TEMPORARY_REDIRECT(307, "请求的资源临时从不同的URI响应请求"),
    RESUME_INCOMPLETE(308, "请求的资源已经永久转移"),
    // --- 4xx Client Error ---
    BAD_REQUEST(400, "请求错误，请修正请求"),
    UNAUTHORIZED(401, "没有被授权或者授权已经失效"),
    PAYMENT_REQUIRED(402, "预留状态"),
    FORBIDDEN(403, "请求被理解，但是拒绝执行"),
    NOT_FOUND(404, "资源未找到"),
    METHOD_NOT_ALLOWED(405, "请求方法不允许被执行"),
    NOT_ACCEPTABLE(406, "请求的资源不满足请求者要求"),
    PROXY_AUTHENTICATION_REQUIRED(407, "请通过代理进行身份验证"),
    REQUEST_TIMEOUT(408, "请求超时"),
    CONFLICT(409, "请求冲突"),
    GONE(410, "请求的资源不可用"),
    LENGTH_REQUIRED(411, "Content-Length未定义"),
    PRECONDITION_FAILED(412, "不满足请求的先决条件"),
    @Deprecated
    REQUEST_ENTITY_TOO_LARGE(413, "请求的实体太大"),
    URI_TOO_LONG(414, "URI太长了"),
    //    @Deprecated
//    REQUEST_URI_TOO_LONG(414, "请求URI太长"),
    UNSUPPORTED_MEDIA_TYPE(415, "Unsupported Media Type请求发送的实体类型不受支持 不支持的媒体类型"),
    REQUESTED_RANGE_NOT_SATISFIABLE(416, "Range指定的范围与当前资源可用范围不一致"),
    EXPECTATION_FAILED(417, "请求头Expect中指定的预期内容无法被服务器满足\""),
    I_AM_A_TEAPOT(418, "I'm a teapot"),
    @Deprecated
    INSUFFICIENT_SPACE_ON_RESOURCE(419, "资源空间不足Insufficient Space On Resource"),
    @Deprecated
    METHOD_FAILURE(420, "方法失败"),
    @Deprecated
    DESTINATION_LOCKED(421, "目的地已锁定"),
    UNPROCESSABLE_ENTITY(422, "请求格式正确，但是由于含有语义错误，无法响应"),
    LOCKED(423, "当前资源被锁定"),
    FAILED_DEPENDENCY(424, "由于之前的请求发生错误，导致当前请求失败"),
    UPGRADE_REQUIRED(426, "客户端需要切换到TLS1.0"),
    PRECONDITION_REQUIRED(428, "请求需要提供前置条件"),
    TOO_MANY_REQUESTS(429, "请求过多"),
    REQUEST_HEADER_FIELDS_TOO_LARGE(431, "请求头超大，拒绝请求"),
    UNAVAILABLE_FOR_LEGAL_REASONS(451, "法律原因不可用"),
    // --- 5xx Server Error ---
    INTERNAL_SERVER_ERROR(500, "服务器内部错误"),
    NOT_IMPLEMENTED(501, "服务器不支持当前请求的部分功能"),
    BAD_GATEWAY(502, "响应无效"),
    SERVICE_UNAVAILABLE(503, "服务器维护或者过载，拒绝服务"),
    GATEWAY_TIMEOUT(504, "上游服务器超时"),
    HTTP_VERSION_NOT_SUPPORTED(505, "不支持的HTTP版本"),
    VARIANT_ALSO_NEGOTIATES(506, "服务器内部配置错误"),
    INSUFFICIENT_STORAGE(507, "服务器无法完成存储请求所需的内容"),
    LOOP_DETECTED(508, "服务器处理请求时发现死循环"),
    BANDWIDTH_LIMIT_EXCEEDED(509, "服务器达到带宽限制"),
    NOT_EXTENDED(510, "获取资源所需的策略没有被满足"),
    NETWORK_AUTHENTICATION_REQUIRED(511, "需要进行网络授权");
    private final int code;

    private final String msg;
//    private final String us;


    CodeEnum(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }



    /**
     * Return the integer value of this status code.
     */
    public int code() {
        return this.code;
    }

    public String msg() {
        return this.msg;
    }



    public static CodeEnum resolve(int statusCode) {
        for (CodeEnum status : values()) {
            if (status.code == statusCode) {
                return status;
            }
        }
        return null;
    }


}
