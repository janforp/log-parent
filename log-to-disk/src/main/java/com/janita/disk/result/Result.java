package com.janita.disk.result;

import lombok.Data;

/**
 * Created by Janita on 2017-05-22 13:47
 */
@Data
public class Result<T> {

    private Integer code;

    private String msg;

    private T data;
}
