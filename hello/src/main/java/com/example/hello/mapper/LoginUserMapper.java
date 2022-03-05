package com.example.hello.mapper;

import com.example.hello.pojo.LoginUser;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface LoginUserMapper {
   public LoginUser getUserByName(String username);

   public void saveToken(LoginUser loginUser);

   public LoginUser getUserById(int userid);
}
