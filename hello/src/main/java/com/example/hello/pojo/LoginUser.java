package com.example.hello.pojo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@ApiModel("login user")
@Data
public class LoginUser {
    private String id;
    @ApiModelProperty("Frank")
    private String username;
    @ApiModelProperty("123456")
    private String password;
    private String permission;
    private String role;
    private String token;

}
