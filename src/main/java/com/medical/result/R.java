package com.medical.result;

import cn.hutool.http.HttpStatus;

import java.util.HashMap;
import java.util.Map;

/**
 * 返回数据
 *
 * @author Mark sunlightcs@gmail.com
 */
public class R extends HashMap<String, Object> {
    private static final long serialVersionUID = 1L;

    public R() {
        put("code", 0);
        put("msg", "success");
    }

    public static com.medical.result.R error() {
        return error(HttpStatus.HTTP_INTERNAL_ERROR, "未知异常，请联系管理员");
    }

    public static com.medical.result.R error(String msg) {
        return error(HttpStatus.HTTP_INTERNAL_ERROR, msg);
    }

    public static com.medical.result.R error(int code, String msg) {
        com.medical.result.R r = new com.medical.result.R();
        r.put("code", code);
        r.put("msg", msg);
        return r;
    }

    public static com.medical.result.R ok(String msg) {
        com.medical.result.R r = new com.medical.result.R();
        r.put("msg", msg);
        return r;
    }

    public static com.medical.result.R ok(Map<String, Object> map) {
        com.medical.result.R r = new com.medical.result.R();
        r.putAll(map);
        return r;
    }

    public static com.medical.result.R ok() {
        return new com.medical.result.R();
    }

    public com.medical.result.R put(String key, Object value) {
        super.put(key, value);
        return this;
    }
}
