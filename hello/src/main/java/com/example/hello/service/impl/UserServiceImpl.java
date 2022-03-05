package com.example.hello.service.impl;

import com.example.hello.domain.UserDetail;
import com.example.hello.pojo.LoginUser;
import com.example.hello.service.LoginUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserDetailsService {
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private LoginUserService loginUserService;

    @Override
    public UserDetails loadUserByUsername(String username) {
       //search database
        LoginUser loginUser = loginUserService.getUserByName(username);
        if(loginUser==null){
            throw new BadCredentialsException("username or password wrong");
        }
        //save access
        String password = passwordEncoder.encode(loginUser.getPassword());
        loginUser.setPassword(password);
        return new UserDetail(loginUser);
    }


}
