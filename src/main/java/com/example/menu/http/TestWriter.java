package com.example.menu.http;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class TestWriter {
    public void writeResponse(OutputStream outputStream, HttpResponse response) {
        try {
            final int statusCode = response.getStatusCode();
            String actualStatusCode = HttpStatusCodes.STATUS_CODES.get(statusCode);
            final List<String> requestHeaders = compressToList(response.getResponseHeaders());

            outputStream.write((statusCode + actualStatusCode + "\r\n").getBytes());

            for (String headerValues : requestHeaders) {
                outputStream.write(headerValues.getBytes());
            }

            final Optional<String> entity = HttpResponse.getEntity().flatMap(TestWriter::getRealEntity);
            if (entity.isPresent()) {
                String encodedMessage = new String(entity.get().getBytes(StandardCharsets.UTF_8), StandardCharsets.UTF_8);
                outputStream.write("\r\n".getBytes());
                outputStream.write(encodedMessage.getBytes());
            } else {
                outputStream.write("\r\n".getBytes());
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    private static Optional<? extends String> getRealEntity(Object realEntity) {
        if (realEntity instanceof String) {
            return Optional.of(realEntity.toString());
        }
        return Optional.empty();
    }

    private List<String> compressToList(Map<String, List<String>> responseHeaders) {
        List<String> responseHeaderList = new ArrayList<>();


        responseHeaders.forEach((key, value) -> {
            StringBuilder getCharList = new StringBuilder();
            value.forEach(getCharList::append);
            getCharList.append(";");

            responseHeaderList.add(key + getCharList + "\r\n");
        });
        return responseHeaderList;
    }
}
