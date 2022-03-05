package com.example.hello.service.impl;

import com.example.hello.Utils.JwtTokenUtils;
import com.example.hello.domain.ResponseResult;
import com.example.hello.domain.UserDetail;
import com.example.hello.pojo.LoginUser;
import com.example.hello.service.LoginService;
import com.example.hello.service.LoginUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Objects;

@Service
public class LoginServiceImpl implements LoginService {
    @Autowired
    private LoginUserService loginUserService;
    @Autowired
    private AuthenticationManager authenticationManager;

    @Override
    public ResponseResult login(LoginUser loginUser) {
        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(loginUser.getUsername(),loginUser.getPassword());
        Authentication authenticate = authenticationManager.authenticate(authenticationToken);
        //no pass reminder user
        if(Objects.isNull(authenticate)){
            throw new RuntimeException("login failed");
        }
        //passs ,generate jwt token
        UserDetail userDetail = (UserDetail) authenticate.getPrincipal();
        String jwtToken = JwtTokenUtils.createJwtToken(userDetail.getLoginUser().getId());
        saveToken2DB(userDetail,jwtToken);
        HashMap<String, String> map = new HashMap<>();
        map.put("token",jwtToken);
        return new ResponseResult(200,"login success",map);
    }

    private void saveToken2DB(UserDetail user, String token) {
        LoginUser loginUser = new LoginUser();
        loginUser.setId(user.getLoginUser().getId());
        loginUser.setToken(token);
        loginUser.setUsername(user.getUsername());
        loginUser.setPassword(user.getPassword());
        loginUserService.saveToken(loginUser);
    }
}
