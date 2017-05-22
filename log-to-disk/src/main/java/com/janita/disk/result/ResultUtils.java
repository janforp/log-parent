package com.janita.disk.result;

/**
 * Created by Janita on 2017-05-22 13:48
 */
public class ResultUtils {

    public static Result success (Object object) {
        Result result = new Result();
        result.setMsg("success");
        result.setData(object);
        result.setCode(0);

        return result;
    }

    public static Result error (String msg, Integer code) {
        Result result = new Result();
        result.setCode(code);
        result.setMsg(msg);

        return result;
    }
}
