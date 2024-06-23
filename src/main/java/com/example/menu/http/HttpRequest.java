package com.example.menu.http;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
public class HttpRequest {
    @Getter
    @Setter
    private HttpMethod httpMethod;
    @Getter
    private final URI uri;
    @Getter
    @Setter
    private Map<String, List<String>> requestHeaders;

    public HttpRequest(HttpMethod httpMethod, URI uri, Map<String, List<String>> requestHeaders) {
        this.httpMethod = httpMethod;
        this.uri = uri;
        this.requestHeaders = requestHeaders != null ? requestHeaders : new HashMap<>();

        log.info("Http created with method: {}, Uri: {}, requestHeader: {}", httpMethod, uri, requestHeaders);
    }

    @Setter
    @Getter
    public static class Builder {
        private HttpMethod httpMethod;
        private URI uri;
        private Map<String, List<String>> requestHeaderBuilder;

        public Builder() throws URISyntaxException {
            this.uri = new URI("");
            requestHeaderBuilder = new HashMap<>();
        }


        public HttpRequest build() {
            return new HttpRequest(httpMethod, uri, requestHeaderBuilder);
        }
    }


}
