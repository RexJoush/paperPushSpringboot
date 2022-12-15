package com.joush.util;

import com.alibaba.fastjson2.JSON;
import com.alibaba.fastjson2.JSONObject;

/**
 * @author Rex Joush
 * @time 2022.12.03
 */
public class Result {

    private static final int SUCCESS_CODE = 20000;
    private static final int INFO_CODE = 20001;
    private static final int ERROR_CODE = 20002;

    public static String ok() {
        JSONObject object = new JSONObject();
        object.put("code", SUCCESS_CODE);
        return JSON.toJSONString(object);
    }

    public static String ok(String message) {
        JSONObject object = new JSONObject();
        object.put("code", SUCCESS_CODE);
        object.put("message", message);
        return JSON.toJSONString(object);
    }

    public static String ok(String message, Object data) {
        JSONObject object = new JSONObject();
        object.put("code", SUCCESS_CODE);
        object.put("message", message);
        object.put("data", data);
        return JSON.toJSONString(object);
    }

    public static String error(String message) {
        JSONObject object = new JSONObject();
        object.put("code", ERROR_CODE);
        object.put("message", message);
        return JSON.toJSONString(object);
    }

    public static String info(String message) {
        JSONObject object = new JSONObject();
        object.put("code", INFO_CODE);
        object.put("message", message);
        return JSON.toJSONString(object);
    }

}
