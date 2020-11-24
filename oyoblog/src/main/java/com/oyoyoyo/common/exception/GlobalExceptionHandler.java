package com.oyoyoyo.common.exception;

import com.oyoyoyo.common.CommonResult;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.ShiroException;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * Date:2020/11/8
 * Decription:<全局异常处理>
 *
 * @Author:oyoyoyoyoyoyo
 */
@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {
    /**
     * 捕获shrio异常
     *
     * @param e
     * @return
     * @ExceptionHandler 可以用来统一处理方法抛出的异常
     */
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    @ExceptionHandler(value = ShiroException.class)
    public CommonResult handler(ShiroException e) {
        log.error("运行时异常：---------", e);
        return CommonResult.failed(401, e.getMessage());
    }

    /**
     * 捕获全局运行时异常
     *
     * @param e
     * @return
     */
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(value = RuntimeException.class)
    public CommonResult handler(RuntimeException e) {
        log.error("运行时异常：---------", e);
        return CommonResult.failed(e.getMessage());
    }

    /**
     * 实体校验异常
     *
     * @param e
     * @return
     */
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    public CommonResult handler(MethodArgumentNotValidException e) {
        log.error("实体校验异常:------------------>{}", e);
        //简化异常错误信息
        BindingResult bindingResult = e.getBindingResult();
        ObjectError objectError = bindingResult.getAllErrors().stream().findFirst().get();
        return CommonResult.failed(objectError.getDefaultMessage());
    }

    /**
     * 断言异常
     *
     * @param e
     * @return
     */
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(value = IllegalArgumentException.class)
    public CommonResult handler(IllegalArgumentException e) {
        log.error("IllegalArgumentException:------------------>{}", e);
        return CommonResult.failed(e.getMessage());
    }
}
