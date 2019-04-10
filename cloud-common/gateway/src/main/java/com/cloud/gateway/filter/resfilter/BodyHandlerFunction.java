package com.cloud.gateway.filter.resfilter;

import org.reactivestreams.Publisher;

import org.springframework.core.io.buffer.DataBuffer;
import org.springframework.http.server.reactive.ServerHttpResponse;
import reactor.core.publisher.Mono;

import java.util.function.BiFunction;

/**
 * <p>
 * 网关中经常需要通过获取ServerHttpResponse响应的信息后进行业务逻辑处理以及一些辅助的处理，
 * 例如：完整的请求，响应日志打印；登录成功后创建会话业务等等。
 * 下面通过代码来说明拦截ServerHttpResponse的body并重写body
 * <p>
 * 拦截接口方法
 * </p>
 *
 * @Title BodyHandlerFunction.java
 * @Package com.cloud.gateway.config.booyfilter
 * @Author <a href="mailto:au_t@qq.com">au .T</a>
 * @Date 2019/4/3 22:55
 */
public interface BodyHandlerFunction extends BiFunction<ServerHttpResponse, Publisher<? extends DataBuffer>, Mono<Void>> {
}
