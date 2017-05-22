package com.janita.log.utils;

import com.janita.log.result.Result;

/**
 * Created by Janita on 2017-05-22 11:30
 */
public class ResultUtil {

    public  static Result success(Object object) {
        Result result = new Result();
        result.setCode(0);
        result.setMsg("success");
        result.setData(object);

        return result;
    }

    public  static Result success() {
        return success(null);
    }

    public static Result error (Integer code, String msg) {
        Result result = new Result();
        result.setCode(code);
        result.setMsg(msg);
        return result;
    }
}
