package com.hust.exception;

import com.hust.enums.ResultEnum;

/**
 * Created by HYLJ on 2018/6/4 0004.
 * RuntimeException可以进行事务回滚
 */
public class GirlException extends RuntimeException{
    private Integer code;

    public GirlException(ResultEnum resultEnum){
        super(resultEnum.getMsg());
        this.code= resultEnum.getCode();

    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }
}
