package com.de.publicpackage.result;

import com.sun.org.apache.bcel.internal.classfile.Code;

/**
 * CodeMsg
 *
 * @author 刘明浩
 * @Description 封装错误分类
 * @since 2020/12/22 16:23
 */
public class CodeMsg {
    private int code;
    private String mag;

    public CodeMsg(int code,String msg){
        this.code = code;
        this.mag = msg;
    }

    public static CodeMsg FIND_LIST_ERROR = new CodeMsg(2,"DIND_LIST 列表查询失败");

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMag() {
        return mag;
    }

    public void setMag(String mag) {
        this.mag = mag;
    }

    @Override
    public String toString() {
        return "CodeMsg{" +
                "code=" + code +
                ", mag='" + mag + '\'' +
                '}';
    }
}
