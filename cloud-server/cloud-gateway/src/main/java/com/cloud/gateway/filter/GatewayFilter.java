package com.cloud.gateway.filter;

import com.cloud.gateway.constant.GatewayConstant;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.core.annotation.Order;

import org.springframework.http.HttpHeaders;
import org.springframework.http.server.reactive.ServerHttpRequest;
import reactor.core.publisher.Mono;


/**
 * <p>
 *
 * </p>
 *
 * @Title GatewayFilter.java
 * @Package com.cloud.gateway.filter
 * @Author <a href="mailto:tuanyu@sinotn.com">au .T</a>
 * @Date 2019/4/6 14:24
 */
//@Configuration
//@Slf4j
//@Component
public class GatewayFilter {


    @Bean
    @Order(-1)
    public GlobalFilter a() {
        return (exchange, chain) -> {
            //判断请求的客户端 是不是可以请求的客户客户端
            ServerHttpRequest request = exchange.getRequest().mutate()
                    //  .headers(httpHeaders -> httpHeaders.remove(FROM)) //清洗请求头中from 参数
                    .build();

            String webName = request.getHeaders().getFirst("webName");
            System.err.println(webName);
            System.err.println("1---pre");
            return chain.filter(exchange).then(Mono.fromRunnable(() -> {
                System.err.println("6---post");
            }));
        };
    }

    @Bean
    @Order(0)
    public GlobalFilter b() {
        return (exchange, chain) -> {
            System.err.println("2---pre");
            return chain.filter(exchange).then(Mono.fromRunnable(() -> {
                System.err.println("5---post");
            }));
        };
    }


    /**
     * <p>
     * 判断请求头
     * </p>
     *
     * @params: [request]
     * @return: boolean
     * @Author: au .T
     * @Date: 2019/4/6 17:21
     */
    private boolean head(ServerHttpRequest req) {
        HttpHeaders head = req.getHeaders();
        //如果已近授权  且不非法
        boolean flag = head.containsKey(HttpHeaders.AUTHORIZATION)
                && head.getFirst(HttpHeaders.AUTHORIZATION) != null;
        if (flag) {
            return Boolean.TRUE;
        } else {
            //判断是不是可以访问后台的UI项目
            boolean web = head.containsKey(GatewayConstant.WEN_HEAD);
            if (web) {
                String webPsw = head.getFirst(GatewayConstant.WEN_HEAD);
                String s[] = webPsw.split("-");
                flag = GatewayConstant.WEB_HTNL.equals(s[0]) && GatewayConstant.WEB_HTML_PAW.equals(s[1]);
                if (flag) {
                    return Boolean.TRUE;
                }
            }
        }
        return Boolean.FALSE;
    }


}