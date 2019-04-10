package com.cloud.gateway.filter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.core.io.buffer.DataBuffer;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;
import org.springframework.util.PatternMatchUtils;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

/**
 * <p>
 *
 * </p>
 *
 * @Title AuthorizationFilter.java
 * @Package com.cloud.gateway.filter
 * @Author <a href="mailto:tuanyu@sinotn.com">au .T</a>
 * @Date 2019/4/7 14:49
 */
@Configuration
@Slf4j
@Component
public class AuthorizationFilter implements GatewayFilter, Ordered
{
    @Override
    public Mono<Void> filter(
            ServerWebExchange exchange, GatewayFilterChain chain) {
//        List<String> authorization = exchange.getRequest().getHeaders().get("Authorization");
        if (true) {
            exchange.getResponse().setStatusCode(HttpStatus.UNAUTHORIZED);
            //Add some custom data in body of the response
            DataBuffer b = exchange.getResponse().bufferFactory().allocateBuffer(256);
            b.write("12345".getBytes());
            return exchange.getResponse().writeWith(s -> Flux.just(b));
//            return exchange.getResponse().setComplete();
        }
//        String token = authorization.get(0).split(" ")[1];
        // token validation
        return chain.filter(exchange);
    }

    @Override
    public int getOrder() {
        return -10;
    }
}