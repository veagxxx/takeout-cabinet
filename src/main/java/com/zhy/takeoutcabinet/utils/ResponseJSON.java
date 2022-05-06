package com.zhy.takeoutcabinet.utils;

import java.util.HashMap;
import java.util.Map;

public class ResponseJSON {
    private final static int SUCCESS_CODE = 200;
    private final static int ERROR_CODE_400 = 400;
    private final static int ERROR_CODE_500 = 500;

    public static Map<String, Object> success(String message) {
        Map<String, Object> map = new HashMap<>();
        map.put("code", SUCCESS_CODE);
        map.put("message", message);
        return map;
    }

    public static Map<String, Object> success(String message, Object data) {
        Map<String, Object> map = new HashMap<>();
        map.put("code", SUCCESS_CODE);
        map.put("message", message);
        map.put("data", data);
        return map;
    }

    public static Map<String, Object> error400(String message) {
        Map<String, Object> map = new HashMap<>();
        map.put("code", ERROR_CODE_400);
        map.put("message", message);
        return map;
    }
    public static Map<String, Object> error500(String message) {
        Map<String, Object> map = new HashMap<>();
        map.put("code", ERROR_CODE_500);
        map.put("message", message);
        return map;
    }
}
