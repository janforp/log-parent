package com.janita.log.handle;

import com.janita.log.exception.UserException;
import com.janita.log.result.Result;
import com.janita.log.utils.ResultUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by Janita on 2017-05-22 11:51
 */
@ControllerAdvice
public class ExceptionHandle {

    private final static Logger logger = LoggerFactory.getLogger(ExceptionHandle.class);

    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public Result handle(Exception e) {
        if (e instanceof UserException) {
            UserException userException = (UserException) e;
            return ResultUtil.error(userException.getCode(), userException.getMessage());
        } else {
            logger.info(" [系统异常] {}", e);
            return ResultUtil.error(-1, "未知错误");
        }
    }
}
