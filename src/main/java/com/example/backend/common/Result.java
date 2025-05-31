package com.example.backend.common;

public class Result {
    private Integer code; // 状态码
    private String message; // 提示信息
    private Object data; // 返回数据

    public Result(Integer code, String message, Object data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
    public static Result success(Object data) {
        return new Result(200, "操作成功", data);
    }
    public static Result error(String code, String message) {
        return new Result(Integer.parseInt(code), message, null);
    }
}
