package com.xh.common.exportions;

/**
 * @author xt
 * @date 2020/9/7
 */
public class ApiException  extends RuntimeException{
    private static final long serialVersionUID = -195615042823508117L;
    private Integer code = 500;

    public ApiException(String msg) {
        super(msg);
    }

    public ApiException(String msg, Throwable e) {
        super(msg, e);
    }

    public ApiException(String msg, Integer code) {
        super(msg);
        this.code = code;
    }

    public ApiException(String msg, Integer code, Throwable e) {
        super(msg, e);
        this.code = code;
    }

    public int getCode() {
        return this.code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public Throwable fillInStackTrace() {
        return this;
    }
}
