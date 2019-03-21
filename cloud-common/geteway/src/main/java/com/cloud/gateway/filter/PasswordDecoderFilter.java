package com.cloud.gateway.filter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Component;
import org.springframework.web.util.UriComponentsBuilder;
import reactor.core.publisher.Mono;

import java.net.URI;
import java.util.Map;

/**
 * <p>
 *
 * </p>
 *
 * @Title PasswordDecoderFilter.java
 * @Package com.cloud.gateway.filter
 * @Author <a href="mailto:tuanyu@sinotn.com">au .T</a>
 * @Date 2019/3/20 17:28
 */
@Slf4j
@Component
public class PasswordDecoderFilter extends AbstractGatewayFilterFactory {
    @Override
    public GatewayFilter apply(Object config) {
        return null;
    }
//    private static final String PASSWORD = "password";
//    @Value("${security.encode.key:1234567887654321}")
//    private String encodeKey;
//
//    String OAUTH_TOKEN_URL = "/oauth/token";
//    String UTF_8 = "UTF-8";
//
//    @Override
//    public GatewayFilter apply(Object config) {
//        return (exchange, chain) -> {
//            ServerHttpRequest request = exchange.getRequest();
//
//            // 不是登录请求，直接向下执行
//            if (!StrUtil.containsAnyIgnoreCase(request.getURI().getPath(), OAUTH_TOKEN_URL)) {
//                return chain.filter(exchange);
//            }
//
//            URI uri = exchange.getRequest().getURI();
//            String queryParam = uri.getRawQuery();
//            Map<String, String> paramMap = HttpUtil.decodeParamMap(queryParam, UTF_8);
//
//            String password = paramMap.get(PASSWORD);
//            if (StrUtil.isNotBlank(password)) {
//                try {
//                    password = AESUtil.decryptAES(password, encodeKey);
//                } catch (Exception e) {
//                    log.error("密码解密失败:{}", password);
//                    return Mono.error(e);
//                }
//                paramMap.put(PASSWORD, password.trim());
//            }
//
//            URI newUri = UriComponentsBuilder.fromUri(uri)
//                    .replaceQuery(HttpUtil.toParams(paramMap))
//                    .build(true)
//                    .toUri();
//
//            ServerHttpRequest newRequest = exchange.getRequest().mutate().uri(newUri).build();
//            return chain.filter(exchange.mutate().request(newRequest).build());
//        };
//    }

}
