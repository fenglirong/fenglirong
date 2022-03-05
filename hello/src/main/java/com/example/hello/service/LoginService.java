package com.example.hello.service;

import com.example.hello.domain.ResponseResult;
import com.example.hello.pojo.LoginUser;

public interface LoginService {
    public ResponseResult login(LoginUser loginUser);
}
