package com.xh.common.responses;

import java.io.Serializable;
import java.util.HashMap;

/**
 * @author xt
 * @date 2020/8/13
 *
 * 统一处理返回结果集
 */

public class R  extends HashMap<String, Object> implements Serializable {

    private static final long serialVersionUID = 8458730375005270316L;

    int code;
    String msg;



    private R(){
        this.put((String)"code", 200);
        this.put((String)"msg", "success");
    }

    public R(int code  , String msg){
        this.code = code;
        this.msg = msg;
    }

    public static R ok(){
        return new R();
    }

    public static R error(){
        R r = new R();
        r.put("code" , 500);
        return r;
    }


    public static R error(int code  , String mes){
        return new R(code , mes);
    }

    public  R data(Object value){
        super.put("data" , value);
        return this;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMeg() {
        return msg;
    }

    public void setMeg(String msg) {
        this.msg = msg;
    }
}
