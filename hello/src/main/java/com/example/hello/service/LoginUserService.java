package com.example.hello.service;

import com.example.hello.mapper.LoginUserMapper;
import com.example.hello.pojo.LoginUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginUserService {
    @Autowired
    private LoginUserMapper loginUserMapper;

    public LoginUser getUserByName(String username){
      return  loginUserMapper.getUserByName(username);
    }

    public void saveToken(LoginUser loginUser){
        loginUserMapper.saveToken(loginUser);
    }

    public LoginUser getUserById(int userid) {
        return  loginUserMapper.getUserById(userid);
    }
}
