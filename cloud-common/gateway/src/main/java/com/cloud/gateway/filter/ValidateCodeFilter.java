package com.cloud.gateway.filter;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

/**
 * <p>
 *
 * </p>
 *
 * @Title ValidateCodeFilter.java
 * @Package com.cloud.gateway.filter
 * @Author <a href="mailto:au_t@qq.com">au .T</a>
 * @Date 2019/3/20 17:29
 */
@Slf4j
@Component
@AllArgsConstructor
public class ValidateCodeFilter extends AbstractGatewayFilterFactory {
    @Override
    public GatewayFilter apply(Object config) {
        return null;
    }
//    private final ObjectMapper objectMapper;
//    private final RedisTemplate redisTemplate;
//    private final FilterIgnorePropertiesConfig filterIgnorePropertiesConfig;
//
//    @Override
//    public GatewayFilter apply(Object config) {
//        return (exchange, chain) -> {
//            ServerHttpRequest request = exchange.getRequest();
//
//            // 不是登录请求，直接向下执行
//            if (!StrUtil.containsAnyIgnoreCase(request.getURI().getPath()
//                    , SecurityConstants.OAUTH_TOKEN_URL)) {
//                return chain.filter(exchange);
//            }
//
//            // 刷新token，直接向下执行
//            String grantType = request.getQueryParams().getFirst("grant_type");
//            if (StrUtil.equals(SecurityConstants.REFRESH_TOKEN, grantType)) {
//                return chain.filter(exchange);
//            }
//
//            // 终端设置不校验， 直接向下执行
//            try {
//                String[] clientInfos = ExamWebUtils.getClientId(request);
//                if (filterIgnorePropertiesConfig.getClients().contains(clientInfos[0])) {
//                    return chain.filter(exchange);
//                }
//
//                //校验验证码
//                checkCode(request);
//            } catch (Exception e) {
//                ServerHttpResponse response = exchange.getResponse();
//                response.setStatusCode(HttpStatus.PRECONDITION_REQUIRED);
//                try {
//                    return response.writeWith(Mono.just(response.bufferFactory()
//                            .wrap(objectMapper.writeValueAsBytes(
//                                    ResponseEntity.builder().msg(e.getMessage())
//                                            .code(CommonConstants.FAIL).build()))));
//                } catch (JsonProcessingException e1) {
//                    log.error("对象输出异常", e1);
//                }
//            }
//
//            return chain.filter(exchange);
//        };
//    }
//
//    /**
//     * 检查code
//     *
//     * @param request
//     */
//    @SneakyThrows
//    private void checkCode(ServerHttpRequest request) {
//        String code = request.getQueryParams().getFirst("code");
//
//        if (StrUtil.isBlank(code)) {
//            throw new ValidateCodeException("验证码不能为空");
//        }
//
//        String randomStr = request.getQueryParams().getFirst("randomStr");
//        if (StrUtil.isBlank(randomStr)) {
//            randomStr = request.getQueryParams().getFirst("mobile");
//        }
//
//        String key = CommonConstants.DEFAULT_CODE_KEY + randomStr;
//        if (!redisTemplate.hasKey(key)) {
//            throw new ValidateCodeException("验证码不合法");
//        }
//
//        Object codeObj = redisTemplate.opsForValue().get(key);
//
//        if (codeObj == null) {
//            throw new ValidateCodeException("验证码不合法");
//        }
//
//        String saveCode = codeObj.toString();
//        if (StrUtil.isBlank(saveCode)) {
//            redisTemplate.delete(key);
//            throw new ValidateCodeException("验证码不合法");
//        }
//
//        if (!StrUtil.equals(saveCode, code)) {
//            redisTemplate.delete(key);
//            throw new ValidateCodeException("验证码不合法");
//        }
//
//        redisTemplate.delete(key);
//    }
}

