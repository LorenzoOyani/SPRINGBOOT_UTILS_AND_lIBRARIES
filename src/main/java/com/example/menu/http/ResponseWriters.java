package com.example.menu.http;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class ResponseWriters {

    public void writeResponse(OutputStream outputStream, HttpResponse response) throws IOException {
        try {

            int statusCode = response.getStatusCode();
            final String statusCodeMessages = HttpStatusCodes.STATUS_CODES.get(statusCode);
            final List<String> responseHeaders = getMergedHeaders(response.getResponseHeaders());

            outputStream.write(("HTTP/1.1 " + statusCode + " " + statusCodeMessages + "\r\n").getBytes());
            for (String values : responseHeaders) {
                outputStream.write(values.getBytes());
            }
            /*
              @Func - flatMap - The flat map returns an Optional that checks for nullability,
             */
            final Optional<String> entityString = HttpResponse.getEntity().flatMap(ResponseWriters::getResponseString);
            if (entityString.isPresent()) {
                final String encoded = new String(entityString.get().getBytes(StandardCharsets.UTF_8), StandardCharsets.UTF_8);
                outputStream.write(("content-length" + encoded.getBytes().length + "\r\n").getBytes());
                outputStream.write("\r\n".getBytes());
                outputStream.write(encoded.getBytes());
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static Optional<? extends String> getResponseString(Object entity) {
        if (entity instanceof String) {
            try {

                return Optional.of(entity.toString());

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return Optional.empty();
    }

    private List<String> getMergedHeaders(final Map<String, List<String>> responseHeaders) {
        final List<String> responseHeadersList = new ArrayList<>();
        responseHeaders.forEach((name, value) -> {
            StringBuilder valueCombination = new StringBuilder();
            value.forEach(valueCombination::append);
            valueCombination.append(";");

            responseHeadersList.add(name + ": " + valueCombination + "\r\n");
        });
        return responseHeadersList;
    }
}
