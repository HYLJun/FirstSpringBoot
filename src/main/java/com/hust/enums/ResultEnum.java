package com.hust.enums;

/**
 * Created by HYLJ on 2018/6/4 0004.
 */
public enum ResultEnum {
    UNKONW_ERROR(-1,"未知错误"),
    PRIMARY_SCHOOL(100,"小学"),
    SUCCESS(0,""),
    MIDDLE_SCHOOL(101,"中学"),

    ;


    private Integer code;

    private String msg;

    ResultEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
