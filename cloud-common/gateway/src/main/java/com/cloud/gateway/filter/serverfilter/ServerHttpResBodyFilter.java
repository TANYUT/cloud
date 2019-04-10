//package com.cloud.gateway.filter.serverfilter;
//
//import org.reactivestreams.Publisher;
//import org.springframework.cloud.gateway.filter.GatewayFilter;
//import org.springframework.cloud.gateway.filter.GatewayFilterChain;
//import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
//import org.springframework.cloud.gateway.support.BodyInserterContext;
//import org.springframework.cloud.gateway.support.CachedBodyOutputMessage;
//import org.springframework.cloud.gateway.support.DefaultClientResponse;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.core.Ordered;
//import org.springframework.core.io.buffer.DataBuffer;
//import org.springframework.http.HttpHeaders;
//import org.springframework.http.codec.ServerCodecConfigurer;
//import org.springframework.http.server.reactive.ServerHttpResponseDecorator;
//import org.springframework.stereotype.Component;
//import org.springframework.web.reactive.function.BodyInserter;
//import org.springframework.web.reactive.function.BodyInserters;
//import org.springframework.web.reactive.function.client.ExchangeStrategies;
//import org.springframework.web.server.ServerWebExchange;
//import reactor.core.publisher.Flux;
//import reactor.core.publisher.Mono;
//
//import static org.springframework.cloud.gateway.support.ServerWebExchangeUtils.ORIGINAL_RESPONSE_CONTENT_TYPE_ATTR;
//
///**
// * <p>
// *
// * </p>
// *
// * @Title ServerHttpResBodyFilter.java
// * @Package com.cloud.gateway.filter.serverfilter
// * @Author <a href="mailto:tuanyu@sinotn.com">au .T</a>
// * @Date 2019/4/7 16:48
// */
//@Component
//@Configuration
//@SuppressWarnings("unchecked")
//public class ServerHttpResBodyFilter extends AbstractGatewayFilterFactory
//        <ResBodyConfig> {
//    @Override
//    public GatewayFilter apply(ResBodyConfig config) {
//        return new ResBodyFilter(config);
//    }
//
//    private final ServerCodecConfigurer codecConfigurer;
//
//    public ServerHttpResBodyFilter(ServerCodecConfigurer codecConfigurer) {
//        super(ResBodyConfig.class);
//        this.codecConfigurer = codecConfigurer;
//    }
//    public class ResBodyFilter implements GatewayFilter, Ordered {
//        private final ResBodyConfig config;
//
//        public ResBodyFilter(ResBodyConfig config) {
//            this.config = config;
//        }
//
//        public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
//            System.err.println("ServerHttpResBodyFilter");
//            ServerHttpResponseDecorator response = new ServerHttpResponseDecorator(
//                    exchange.getResponse()) {
//                @Override
//                public Mono<Void> writeWith(Publisher<? extends DataBuffer> body) {
//                    String originalResponseContentType = exchange.getAttribute(ORIGINAL_RESPONSE_CONTENT_TYPE_ATTR);
//                    HttpHeaders httpHeaders = new HttpHeaders();
//                    //以这种方式显式添加它而不是 'httpHeaders.setContentType（originalResponseContentType）'
//                    //这将防止在使用非标准媒体​​时发生异常  类似“Content-Type：image
//                    httpHeaders.add(HttpHeaders.CONTENT_TYPE, originalResponseContentType);
//                    ResponseAdapter responseAdapter = new ResponseAdapter(body, httpHeaders);
//                    DefaultClientResponse clientResponse = new DefaultClientResponse(
//                            responseAdapter, ExchangeStrategies.withDefaults());
//                    Class inClass = config.getInClass();
//                    Class outClass = config.getOutClass();
//                    // TODO: flux or mono
//                    Mono modifiedBody = clientResponse.bodyToMono(inClass)
//                            .flatMap(originalBody -> config.getRewriteFunction().apply(exchange, originalBody));
//                    BodyInserter bodyInserter = BodyInserters.fromPublisher(modifiedBody,
//                            outClass);
//                    CachedBodyOutputMessage outputMessage = new CachedBodyOutputMessage(
//                            exchange, exchange.getResponse().getHeaders());
//                    return bodyInserter.insert(outputMessage, new BodyInserterContext())
//                            .then(Mono.defer(() -> {
//                                Flux<DataBuffer> messageBody = outputMessage.getBody();
//                                HttpHeaders headers = getDelegate().getHeaders();
//                                if (!headers.containsKey(HttpHeaders.TRANSFER_ENCODING)) {
//                                    messageBody = messageBody.doOnNext(data -> headers
//                                            .setContentLength(data.readableByteCount()));
//                                }
//                                // TODO: use isStreamingMediaType?
//                                return getDelegate().writeWith(messageBody);
//                            }));
//                }
//
//                @Override
//                public Mono<Void> writeAndFlushWith(
//                        Publisher<? extends Publisher<? extends DataBuffer>> body) {
//                    return writeWith(Flux.from(body).flatMapSequential(p -> p));
//                }
//            };
//
//            return chain.filter(exchange.mutate().response(response).build());
//        }
//
//        @Override
//        public int getOrder() {
//            return 999999999;
//        }
//    }
//
//
//}
