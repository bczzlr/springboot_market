package com.example.demo090.error;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

/**
 * 全局捕获异常类
 *
 */
//从controllor扫异常
@ControllerAdvice(basePackages = "com.example.demo090.control")
public class GlobaExceptionHandler {

    /**
     * @ResponseBody返回json格式
     *
     * @return
     */
    @ExceptionHandler(RuntimeException.class)
    @ResponseBody
    public Map<String,Object> errorResult_500(){
        Map<String, Object> mapresult = new HashMap<>();
        mapresult.put("id",0);
        mapresult.put("err_message","用户名密码错误");
        return mapresult;

    }
}
