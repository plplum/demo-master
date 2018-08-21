package com.example.demo;
import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.bean.ResponseBean;

@ControllerAdvice
@ResponseBody
public class GlobalExceptionHandler {

    /**
     * @param request
     * @param exception
     * @return
     * @throws Exception
     */
    @ExceptionHandler(value=Exception.class)  
    public ResponseBean<String> allExceptionHandler(HttpServletRequest request,  
            Exception exception) throws Exception  
    {  
        String error = exception.getLocalizedMessage();
        return new ResponseBean<>(error);
    }  

}