package com.example.hello.controller;

import com.example.hello.domain.ResponseResult;
import com.example.hello.pojo.LoginUser;
import com.example.hello.service.LoginService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {
    @Autowired
    private LoginService loginService;

    /**
     *@Title login
     *@Author:Frank Feng 
     *@Param:
     *@Description 
     *@Date:2022/3/5 17:28
     *
     */
    @ApiImplicitParams({
            @ApiImplicitParam(name="username",value="username",dataType="string", paramType = "query",example="Frank",required = true),
            @ApiImplicitParam(name="password",value="password",dataType="string", paramType = "query",example="123456",required = true)
    })
    @ApiOperation(value="login", notes="Login interface", produces="application/json")
    @PostMapping("/login")
    public ResponseResult login(String username,String password){
        LoginUser loginUser = new LoginUser();
        loginUser.setUsername(username);
        loginUser.setPassword(password);
        return loginService.login(loginUser);
    }

}
