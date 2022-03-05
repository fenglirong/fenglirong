package com.example.hello.controller;

import com.alibaba.fastjson.JSONObject;
import com.example.hello.domain.ResponseResult;
import com.example.hello.pojo.LoginUser;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;


@RunWith(SpringRunner.class)
@SpringBootTest
@WebAppConfiguration
public class LoginControllerTest {


    @Autowired
    private WebApplicationContext webApplicationContext;
    private MockMvc mockMvc;
    private String token;
    @Before
    public void setUp() throws Exception {
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }

    @Test
    public void loginTest() throws Exception{
        LoginUser loginUser = new LoginUser();
        loginUser.setUsername("Frank");
        loginUser.setPassword("123456");
        String request = JSONObject.toJSONString(loginUser);
        mockMvc.perform(MockMvcRequestBuilders.post("/v1/login").contentType(MediaType.APPLICATION_JSON).content(request))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

}