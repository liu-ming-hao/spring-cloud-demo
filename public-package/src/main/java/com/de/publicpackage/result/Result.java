package com.de.publicpackage.result;

import java.io.Serializable;

/**
 * Result
 *
 * @author 刘明浩
 * @Description  封装公共返回实体
 * @since 2020/12/22 16:07
 */
public class Result<T> implements Serializable {
    private static final long serialVersionUID = -2903063547272237245L;

    private int code;
    private String msg;
    private T data;

    public Result(){}

    private Result(T data) {
        this.code = 1;
        this.msg = "success";
        this.data = data;
    }

    private Result(CodeMsg codeMsg){
        this.code = codeMsg.getCode();
        this.msg = codeMsg.getMag();
    }

    public static <T> Result<T> success(T data){
        return new Result<T>(data);
    }

    public static Result error(CodeMsg codeMsg){
        return new Result(codeMsg);
    }




    @Override
    public String toString() {
        return "Result{" +
                "code=" + code +
                ", msg='" + msg + '\'' +
                ", data=" + data +
                '}';
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
