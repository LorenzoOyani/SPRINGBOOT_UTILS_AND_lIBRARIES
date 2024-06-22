package com.example.menu.http;

import java.util.Map;

public class HttpStatusCodes {
    public static Map<Integer, String> STATUS_CODES =
            Map.of(
                    200, "OK",
                    400, "BAD REQUEST",
                    404, "NOT FOUND",
                    500, "INTERNAL SERVER ERROR"

            );

}

