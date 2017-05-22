package com.janita.log.enums;

/**
 * Created by Janita on 2017-05-22 12:55
 */
public enum ResultEnum {

    UNKNOW_ERROR(-1,"未知错误"),

    SUCCESS(0, "成功"),

    PRIMARY_SCHOOL(100, "你正在上小学"),

    MIDDLE_SCHOOL(101, "你正在上初中"),

    RAISE_SALARY(103, "加工资")

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
