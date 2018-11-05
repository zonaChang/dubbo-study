package com.carl.study.dubbo.webapp.response;

import java.util.HashMap;

import org.apache.commons.lang3.StringUtils;

public class JsonResponse extends HashMap {
    private static final String CODE_KEY = "error_no";//200 means success, other values means fail.
    private static final String MESSAGE_KEY = "error_info";
    public static final String DATA_KEY = "result";

    public JsonResponse(int code, String msg) {
        put(CODE_KEY, code);
        put(MESSAGE_KEY, msg == null ? "" : msg);
    }

    public JsonResponse add(String key, Object value) {
        if (CODE_KEY.equals(key)
                || MESSAGE_KEY.equals(key)) {
            throw new RuntimeException("Predefined key");
        }
        put(key, value);
        return this;
    }

    public static JsonResponse success() {
        return new JsonResponse(0, "调用成功");
    }
    
    public static JsonResponse success(String message) {
    	if(StringUtils.isBlank(message)) {
    		return success();
    	}
    	return new JsonResponse(0, message);
    }

    public static JsonResponse failure(int code, String message) {
        return new JsonResponse(code, message);
    }

    public static JsonResponse failure(String message) {
        return failure(-10000, message);
    }
}
