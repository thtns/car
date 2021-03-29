package com.thtns.car.helper;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.thtns.car.util.R;

import cn.hutool.core.exceptions.ExceptionUtil;
import lombok.extern.slf4j.Slf4j;

/**
 * notes : 校验异常解析类
 *
 * @author :  liuyujun
 *         time : 2018-09-05:下午2:28
 */
@RestControllerAdvice
@Slf4j
public class ExceptionHelper {

    /**
     * 业务异常
     *
     * @param exception
     *
     * @return
     */
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    @ExceptionHandler(ServiceException.class)
    public R handleException(ServiceException exception) {
        log.error(exception.getMessage());
        log.error(ExceptionUtil.stacktraceToString(exception));
        return R.failed(exception.getCode(), exception.getMessage());
    }

    /**
     * token失效异常
     *
     * @param exception
     *
     * @return
     */
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    @ExceptionHandler(Exception.class)
    public R handleException(Exception exception) {
        log.error(ExceptionUtil.stacktraceToString(exception));
        return R.failed("系统异常");
    }

}
