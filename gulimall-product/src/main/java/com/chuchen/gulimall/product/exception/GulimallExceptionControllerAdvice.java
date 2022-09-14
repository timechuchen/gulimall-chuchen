package com.chuchen.gulimall.product.exception;

import com.chuchen.common.exception.BizCodeEnume;
import com.chuchen.common.utils.R;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author chuchen
 * @Date 2022/9/13
 * @Description 统一异常处理
 */
@Slf4j
@RestControllerAdvice(basePackages = "com.chuchen.gulimall.product.controller")
public class GulimallExceptionControllerAdvice {
    @ResponseBody
    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    public R handleValidException(MethodArgumentNotValidException e) {
//        log.error("数据校验出现异常{},异常类型：{}",e.getMessage(),e.getClass());
        Map<String,String> errMap = new HashMap<>();
        BindingResult bindingResult = e.getBindingResult();
        bindingResult.getFieldErrors().forEach((fieldErrors)->{
                errMap.put(fieldErrors.getField(),fieldErrors.getDefaultMessage());
            });
        return R.error(BizCodeEnume.VALID_EXCEPTION.getCode(),BizCodeEnume.VALID_EXCEPTION.getMessage()).put("data",errMap);
    }

    @ExceptionHandler(value = Throwable.class)
    public R handleException(Throwable throwable) {
        log.error("错误信息：",throwable);
        return R.error(BizCodeEnume.UNKNOWN_EXCEPTION.getCode(), BizCodeEnume.UNKNOWN_EXCEPTION.getMessage());
    }
}
