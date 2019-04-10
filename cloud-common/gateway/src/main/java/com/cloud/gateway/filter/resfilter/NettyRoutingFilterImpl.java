//package com.cloud.gateway.filter.resfilter;
//
//import io.netty.handler.codec.http.DefaultHttpHeaders;
//import io.netty.handler.codec.http.HttpMethod;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.beans.factory.ObjectProvider;
//import org.springframework.cloud.gateway.config.HttpClientProperties;
//import org.springframework.cloud.gateway.filter.GatewayFilterChain;
//import org.springframework.cloud.gateway.filter.NettyRoutingFilter;
//import org.springframework.cloud.gateway.filter.headers.HttpHeadersFilter;
//import org.springframework.cloud.gateway.support.TimeoutException;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.core.Ordered;
//import org.springframework.core.io.buffer.NettyDataBuffer;
//import org.springframework.http.HttpHeaders;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.server.reactive.AbstractServerHttpResponse;
//import org.springframework.http.server.reactive.ServerHttpRequest;
//import org.springframework.http.server.reactive.ServerHttpResponse;
//import org.springframework.stereotype.Component;
//import org.springframework.util.StringUtils;
//import org.springframework.web.server.ResponseStatusException;
//import org.springframework.web.server.ServerWebExchange;
//import reactor.core.publisher.Flux;
//import reactor.core.publisher.Mono;
//import reactor.netty.NettyPipeline;
//import reactor.netty.http.client.HttpClient;
//import reactor.netty.http.client.HttpClientResponse;
//
//import java.net.URI;
//import java.util.List;
//
//import static org.springframework.cloud.gateway.filter.headers.HttpHeadersFilter.filterRequest;
//import static org.springframework.cloud.gateway.support.ServerWebExchangeUtils.*;
//import static org.springframework.cloud.gateway.support.ServerWebExchangeUtils.CLIENT_RESPONSE_CONN_ATTR;
//
///**
// * <p>
// *
// * </p>
// *
// * @Title NettyRoutingFilterImpl.java
// * @Package com.cloud.gateway.filter.resfilter
// * @Author <a href="mailto:tuanyu@sinotn.com">au .T</a>
// * @Date 2019/4/6 19:41
// */
////@Configuration
//@Slf4j
////@Component
//public class NettyRoutingFilterImpl extends NettyRoutingFilter {
//    public NettyRoutingFilterImpl(HttpClient httpClient, ObjectProvider<List<HttpHeadersFilter>> headersFiltersProvider, HttpClientProperties properties, HttpClient httpClient1, HttpClientProperties properties1) {
//        super(httpClient, headersFiltersProvider, properties);
//        this.httpClient = httpClient1;
//        this.properties = properties1;
//    }
//
//    private final HttpClient httpClient;
//    private final HttpClientProperties properties;
//
//    @Override
//    public int getOrder() {
//        return Ordered.LOWEST_PRECEDENCE + 1;
//    }
//
//    @Override
//    @SuppressWarnings("Duplicates")
//    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
//        URI requestUrl = exchange.getRequiredAttribute(GATEWAY_REQUEST_URL_ATTR);
//
//        String scheme = requestUrl.getScheme();
//        if (isAlreadyRouted(exchange)
//                || (!"http".equals(scheme) && !"https".equals(scheme))) {
//            return chain.filter(exchange);
//        }
//        setAlreadyRouted(exchange);
//
//        ServerHttpRequest request = exchange.getRequest();
//
//        final HttpMethod method = HttpMethod.valueOf(request.getMethodValue());
//        final String url = requestUrl.toString();
//
//        HttpHeaders filtered = filterRequest(getHeadersFilters(), exchange);
//
//        final DefaultHttpHeaders httpHeaders = new DefaultHttpHeaders();
//        filtered.forEach(httpHeaders::set);
//
//        String transferEncoding = request.getHeaders()
//                .getFirst(HttpHeaders.TRANSFER_ENCODING);
//        boolean chunkedTransfer = "chunked".equalsIgnoreCase(transferEncoding);
//
//        boolean preserveHost = exchange
//                .getAttributeOrDefault(PRESERVE_HOST_HEADER_ATTRIBUTE, false);
//
//        Flux<HttpClientResponse> responseFlux = this.httpClient
//                .chunkedTransfer(chunkedTransfer).request(method).uri(url)
//                .send((req, nettyOutbound) -> {
//                    req.headers(httpHeaders);
//
//                    if (preserveHost) {
//                        String host = request.getHeaders().getFirst(HttpHeaders.HOST);
//                        req.header(HttpHeaders.HOST, host);
//                    }
//                    return nettyOutbound.options(NettyPipeline.SendOptions::flushOnEach)
//                            .send(request.getBody()
//                                    .map(dataBuffer -> ((NettyDataBuffer) dataBuffer)
//                                            .getNativeBuffer()));
//                }).responseConnection((res, connection) -> {
//                    System.err.println("responseConnection");
//                    ServerHttpResponse response = exchange.getResponse();
//                    // put headers and status so filters can modify the response
//                    HttpHeaders headers = new HttpHeaders();
//
//                    res.responseHeaders().forEach(
//                            entry -> headers.add(entry.getKey(), entry.getValue()));
//
//                    String contentTypeValue = headers.getFirst(HttpHeaders.CONTENT_TYPE);
//                    if (StringUtils.hasLength(contentTypeValue)) {
//                        exchange.getAttributes().put(ORIGINAL_RESPONSE_CONTENT_TYPE_ATTR,
//                                contentTypeValue);
//                    }
//
//                    HttpStatus status = HttpStatus.resolve(res.status().code());
//                    if (status != null) {
//                        response.setStatusCode(status);
//                    } else if (response instanceof AbstractServerHttpResponse) {
//                        // https://jira.spring.io/browse/SPR-16748
//                        ((AbstractServerHttpResponse) response)
//                                .setStatusCodeValue(res.status().code());
//                    } else {
//                        throw new IllegalStateException(
//                                "Unable to set status code on response: "
//                                        + res.status().code() + ", "
//                                        + response.getClass());
//                    }
//
//                    // make sure headers filters run after setting status so it is
//                    // available in response
//                    HttpHeaders filteredResponseHeaders = HttpHeadersFilter.filter(
//                            getHeadersFilters(), headers, exchange, HttpHeadersFilter.Type.RESPONSE);
//
//                    if (!filteredResponseHeaders
//                            .containsKey(HttpHeaders.TRANSFER_ENCODING)
//                            && filteredResponseHeaders
//                            .containsKey(HttpHeaders.CONTENT_LENGTH)) {
//                        // It is not valid to have both the transfer-encoding header and
//                        // the content-length header
//                        // remove the transfer-encoding header in the response if the
//                        // content-length header is presen
//                        response.getHeaders().remove(HttpHeaders.TRANSFER_ENCODING);
//                    }
//
//                    exchange.getAttributes().put(CLIENT_RESPONSE_HEADER_NAMES,
//                            filteredResponseHeaders.keySet());
//
//                    response.getHeaders().putAll(filteredResponseHeaders);
//
//                    // Defer committing the response until all route filters have run
//                    // Put client response as ServerWebExchange attribute and write
//                    // response later NettyWriteResponseFilter
//                    exchange.getAttributes().put(CLIENT_RESPONSE_ATTR, res);
//                    exchange.getAttributes().put(CLIENT_RESPONSE_CONN_ATTR, connection);
//
//                    return Mono.just(res);
//                });
//
//        if (properties.getResponseTimeout() != null) {
//            responseFlux = responseFlux.timeout(properties.getResponseTimeout(),
//                    Mono.error(new TimeoutException("Response took longer than timeout: "
//                            + properties.getResponseTimeout())))
//                    .onErrorMap(TimeoutException.class,
//                            th -> new ResponseStatusException(HttpStatus.GATEWAY_TIMEOUT,
//                                    th.getMessage(), th));
//        }
//
//        return responseFlux.then(chain.filter(exchange));
//    }
//}
