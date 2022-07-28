package com.qfedu.vhr.framework.execption;

import com.qfedu.vhr.framework.entity.RespBean;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.sql.SQLIntegrityConstraintViolationException;

/**
 * @author weepppp 2022/7/27 15:09
 **/
@RestControllerAdvice
public class GlobalException {

    @ExceptionHandler(SQLIntegrityConstraintViolationException.class)
    public RespBean sQLIntegrityConstraintViolationException(SQLIntegrityConstraintViolationException e){
        return RespBean.error("该数据有关联数据，操作失败");
    }
}
