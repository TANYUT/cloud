//package com.cloud.gateway.filter.resfilter;
//
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.cloud.gateway.config.HttpClientProperties;
//import org.springframework.cloud.gateway.filter.GatewayFilterChain;
//import org.springframework.cloud.gateway.filter.NettyWriteResponseFilter;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.core.io.buffer.NettyDataBuffer;
//import org.springframework.core.io.buffer.NettyDataBufferFactory;
//import org.springframework.http.MediaType;
//import org.springframework.http.server.reactive.ServerHttpResponse;
//import org.springframework.lang.Nullable;
//import org.springframework.stereotype.Component;
//import org.springframework.web.server.ServerWebExchange;
//import reactor.core.publisher.Flux;
//import reactor.core.publisher.Mono;
//import reactor.netty.Connection;
//import reactor.netty.http.client.HttpClient;
//
//import java.util.List;
//
//import static org.springframework.cloud.gateway.support.ServerWebExchangeUtils.*;
//
///**
// * <p>
// *
// * </p>
// *
// * @Title NettyWriteResponseImpl.java
// * @Package com.cloud.gateway.filter.resfilter
// * @Author <a href="mailto:tuanyu@sinotn.com">au .T</a>
// * @Date 2019/4/6 19:16
// */
//@SuppressWarnings("ALL")
//@Configuration
//@Slf4j
//@Component
//public class NettyWriteResponseImpl extends NettyWriteResponseFilter {
//
//    private final HttpClient httpClient;
//    private final HttpClientProperties properties;
//    private final List<MediaType> streamingMediaTypes;
//
//    public NettyWriteResponseImpl(List<MediaType> streamingMediaTypes, HttpClient httpClient, HttpClientProperties properties, List<MediaType> streamingMediaTypes1) {
//        super(streamingMediaTypes);
//        this.httpClient = httpClient;
//        this.properties = properties;
//        this.streamingMediaTypes = streamingMediaTypes1;
//    }
//
//    @Override
//    public int getOrder() {
//        return WRITE_RESPONSE_FILTER_ORDER;
//    }
//
//    @Override
//    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
//        return chain.filter(exchange).then(Mono.defer(() -> {
//            Connection connection = exchange.getAttribute(CLIENT_RESPONSE_CONN_ATTR);
//            if (connection == null) {
//                return Mono.empty();
//            }
//            log.trace("NettyWriteResponseFilter start");
//            ServerHttpResponse response = exchange.getResponse();
//
//            NettyDataBufferFactory factory = (NettyDataBufferFactory) response
//                    .bufferFactory();
//            final Flux<NettyDataBuffer> body = connection.inbound().receive().retain() // TODO:
//                    // needed?
//                    .map(factory::wrap);
//
//            MediaType contentType = null;
//            try {
//                contentType = response.getHeaders().getContentType();
//            } catch (Exception e) {
//                log.trace("invalid media type", e);
//            }
//            return (isStreamingMediaType(contentType)
//                    ? response.writeAndFlushWith(body.map(Flux::just))
//                    : response.writeWith(body));
//        }));
//    }
//
//    private boolean isStreamingMediaType(@Nullable MediaType contentType) {
//        return (contentType != null && this.streamingMediaTypes.stream()
//                .anyMatch(contentType::isCompatibleWith));
//    }
//}
