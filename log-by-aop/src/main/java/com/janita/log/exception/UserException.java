package com.janita.log.exception;

import com.janita.log.enums.ResultEnum;
import lombok.Data;

/**
 * Created by Janita on 2017-05-22 11:54
 */
@Data
public class UserException extends RuntimeException {

    private Integer code ;

    public UserException(Integer code, String message) {
        super(message);
        this.code = code;
    }

    public UserException(ResultEnum resultEnum) {
        super(resultEnum.getMsg());
        this.code = resultEnum.getCode();
    }
}
