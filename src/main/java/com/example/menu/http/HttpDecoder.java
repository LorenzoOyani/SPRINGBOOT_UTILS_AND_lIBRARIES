package com.example.menu.http;

import java.io.*;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.*;

public class HttpDecoder {
    public Optional<HttpRequest> decode(InputStream inputStream) throws IOException {
        return readMessageEncoded(inputStream).flatMap(HttpDecoder::buildRequest);
    }

    private static Optional<? extends HttpRequest> buildRequest(List<String> message) {
        if (message.isEmpty()) {
            return Optional.empty();
        }
        String firstByte = message.getFirst();
        String[] requestHttpStrings = firstByte.split(" ");
        String protocolHttpVersionString = requestHttpStrings[2];
        if (!protocolHttpVersionString.equals("HTTP/1.1")) {
            return Optional.empty();
        }

        try {
            HttpRequest.Builder requestBuilders = new HttpRequest.Builder();
            requestBuilders.setHttpMethod(HttpMethod.valueOf(requestHttpStrings[0]));
            requestBuilders.setUri(new URI(requestHttpStrings[1]));
            return Optional.ofNullable(addHeaders(message, requestBuilders));
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        }

    }

    private static HttpRequest addHeaders(List<String> message, HttpRequest.Builder requestBuilders) {
        final Map<String, List<String>> requestHeaders = new HashMap<>();
        if (!message.isEmpty()) {
            for (int i = 0; i < message.size(); i++) {
                String header = message.get(i);

                int index = header.indexOf(':');
                String headerName;
                String headerValue;
                if (index > 1) {
                    headerName = header.substring(0, index);
                    headerValue = header.substring(index + 1);
                } else {
                    return null;
                }

                requestHeaders.compute(headerName, (key, value) -> {
                    if (value != null) {
                        value.add(headerValue);
                        return value;
                    } else {
                        value = new ArrayList<>();
                    }
                    return value;
                });
            }
        }
        requestBuilders.setRequestHeaderBuilder(requestHeaders);
        return requestBuilders.build();
    }

    /**
     * return {@code true} if present and {@code false}  if not present
     *
     * @throws IOException when there is an error with the inputStream for this method.
     **/
    Optional<List<String>> readMessageEncoded(InputStream inputStream) throws IOException {
        if (!(inputStream.available() > 0)) {
            return Optional.empty();
        }
        final char[] streamBytes = new char[inputStream.available()];
        final BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
        final int read = reader.read(streamBytes);

        List<String> messageStream = new ArrayList<>();
        try (Scanner sc = new Scanner(new String(streamBytes))) {
            if (sc.hasNextLine()) {
                String line = sc.nextLine();
                messageStream.add(line);
            }
            return Optional.of(messageStream);
        } catch (Exception ignored) {
            return Optional.empty();
        }

    }
}
