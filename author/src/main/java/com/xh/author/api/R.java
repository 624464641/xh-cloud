package com.xh.author.api;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * @author anders
 * @date 2018-12-03 11:20
 **/
public class R extends HashMap<String, Object> implements Serializable {
    private static final long serialVersionUID = 3383082789633748960L;

    private R() {
        put("code", 200);
        put("msg", "success");
    }


    public static R error(String msg) {
        return error(500, msg);
    }
    public static R error(int code, String msg) {
        R r = new R();
        r.put("code", code);
        r.put("msg", msg);
        return r;
    }

    public static R ok(String msg) {
        R r = new R();
        r.put("msg", msg);
        return r;
    }

    public static R ok(Map<String, Object> map) {
        R r = new R();
        r.putAll(map);
        return r;
    }

    public static R ok() {
        return new R();
    }

    @Override
    public R put(String key, Object value) {
        super.put(key, value);
        return this;
    }
    public R data( Object value) {
        super.put("data", value);
        return this;
    }
	public R page(long total, Object datas){
		Map<String, Object> map = new HashMap<>(2);
		map.put("totalSize", total);
		map.put("datas", datas);
		super.put("data", map);
		return this;
	}
}
