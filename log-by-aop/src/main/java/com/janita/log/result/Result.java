package com.janita.log.result;

import lombok.Data;

import java.io.Serializable;

/**
 * Created by Janita on 2017-05-22 11:27
 * 统一返回格式
 */
@Data
public class Result<T> implements Serializable {

    private Integer code;

    private String msg;

    private T data;
}
