package com.example.menu.http;

import lombok.Builder;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.net.URI;
import java.util.HashMap;
import java.util.Map;

@Builder
@Slf4j
public class HttpRequest {
    @Getter
    private final HttpMethod httpMethod;
    @Getter
    private final URI uri;
    @Getter
    private final Map<String, Object> requestHeaders;

    public HttpRequest(HttpMethod httpMethod, URI uri, Map<String, Object> requestHeaders) {
        this.httpMethod = httpMethod;
        this.uri = uri;
        this.requestHeaders = requestHeaders != null ? requestHeaders : new HashMap<>();

        log.info("Http created with method: {}, Uri: {}, requestHeader: {}", httpMethod, uri, requestHeaders);
    }



}
