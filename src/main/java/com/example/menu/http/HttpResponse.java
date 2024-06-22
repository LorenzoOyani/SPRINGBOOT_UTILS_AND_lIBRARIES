package com.example.menu.http;

import lombok.Getter;
import lombok.Setter;

import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;


public class HttpResponse {
    @Getter
    @Setter
    private final Map<String, List<String>> responseHeaders;
    @Getter
    @Setter
    private int statusCode;
    @Getter
    @Setter
    private  static Optional<Object> entity;

    HttpResponse(final Map<String, List<String>> responseHeaders, int statusCode, Optional<Object> entity) {
        this.responseHeaders = responseHeaders;
        this.statusCode = statusCode;
       HttpResponse.entity = entity;
    }

    public static class Builder {
        private static Map<String, List<String>> responseHeaders;
        private int statusCode;


        Builder() {
            responseHeaders = new HashMap<>();
            responseHeaders.put("server", List.of("myServer"));
            responseHeaders.put("Date", List.of(DateTimeFormatter.RFC_1123_DATE_TIME.format(ZonedDateTime.now(ZoneOffset.UTC))));


            entity = Optional.empty();

        }

        public Builder addHeader(final String name, String value) {
            responseHeaders.put(name, List.of(value));
            return this;
        }

        public int setStatusCode(int statusCode) {
            return this.statusCode = statusCode;
        }

        public Builder setEntity(final Object object) {
            if (entity != null) {
                entity = Optional.of(object);
            }
            return this;

        }

        public HttpResponse Build() {
            return new HttpResponse(responseHeaders, statusCode, entity);
        }

    }
}

