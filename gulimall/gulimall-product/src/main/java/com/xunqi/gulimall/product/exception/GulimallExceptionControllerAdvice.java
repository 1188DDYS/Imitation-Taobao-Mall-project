package com.xunqi.gulimall.product.exception;

import com.xunqi.common.exception.BizCodeEnum;
import com.xunqi.common.utils.R;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
//统一处理异常类的整体

import java.util.HashMap;
import java.util.Map;

/**
 * @Description:  集中处理所有异常
 * @Created: with IntelliJ IDEA.
 * @author: 夏沫止水
 * @createTime: 2020-05-27 17:14
 *
 * 集中处理所有异常
 **/

@Slf4j
//统一处理异常类的整体
//处理的异常范围---整个controller中有可能出现的异常
@RestControllerAdvice(basePackages = "com.xunqi.gulimall.product.controller")
public class GulimallExceptionControllerAdvice {

    /**
     * 参数非法（效验参数）异常 MethodArgumentNotValidException
     * @param e
     * @return
     *
     * @ExceptionHandler(MethodArgumentNotValidException.class)
     * 说明可以处理的异常种类
     *
     * handleValidException是相应的方法名
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    //从而会感知到相应的异常种类
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public R handleValidException(MethodArgumentNotValidException e) {
        log.error("数据效验出现问题{},异常类型{}",e.getMessage(),e.getClass());
        BindingResult bindingResult = e.getBindingResult();
        //获取了错误的结果

        //在map中存放错误的结果
        Map<String,String> errMap = new HashMap<>();
        bindingResult.getFieldErrors().forEach((fieldError) -> {
            errMap.put(fieldError.getField(),fieldError.getDefaultMessage());
        });
        return R.error(
                BizCodeEnum.VAILD_EXCEPTION.getCode(),
                BizCodeEnum.VAILD_EXCEPTION.getMessage())
                .put("data",errMap);
    }


    //如果不能精准匹配异常，我们用一个大的异常种类去处理
    @ExceptionHandler(value = Throwable.class)
    public R handleException(Throwable throwable) {

        log.error("错误异常{}",throwable);

        return R.error(BizCodeEnum.UNKNOW_EXCEPTION.getCode(),
                BizCodeEnum.UNKNOW_EXCEPTION.getMessage());
        //返回的默认异常
    }

}
