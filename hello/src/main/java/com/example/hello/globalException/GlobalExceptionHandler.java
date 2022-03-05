package com.example.hello.globalException;

import com.example.hello.domain.ResponseResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;

@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

    /**
     *@Title handleParameterException
     *@Author:Frank Feng
     *@Param:
     *@Description
     *@Date:2022/3/5 17:11
     *
     */
    @ExceptionHandler(Exception.class)
    public ResponseResult Exception(Exception e){
        log.error("Exception has been invoked");
        if(e instanceof DataIntegrityViolationException){
            return new ResponseResult(500,"Error updating database");
        }
        if(e instanceof AccessDeniedException){
            return new ResponseResult(500,"Access Denied,please contact admin");
        }
        return new ResponseResult(500,e.getMessage());
    }


}
