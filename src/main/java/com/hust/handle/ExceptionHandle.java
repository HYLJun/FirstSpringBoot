package com.hust.handle;

import com.hust.domain.Girl;
import com.hust.domain.Result;
import com.hust.exception.GirlException;
import com.hust.utils.ResultUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by HYLJ on 2018/6/4 0004.
 */
@ControllerAdvice
public class ExceptionHandle {
    private static  final Logger logger = LoggerFactory.getLogger(ExceptionHandle.class);

    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public Result handle(Exception e){
        if (e instanceof GirlException) {
            GirlException girlException = (GirlException) e;
            return ResultUtil.error(girlException.getCode(),girlException.getMessage());
        }else {
            logger.info("【系统异常】{}",e);
            return ResultUtil.error(-1,"未知错误");
        }

    }
}
