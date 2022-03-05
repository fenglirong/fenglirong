package com.example.hello.controller;

import com.example.hello.mapper.PersonInfoMapper;
import com.example.hello.pojo.PersonInfo;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

@RunWith(SpringRunner.class)
@SpringBootTest
@WebAppConfiguration
public class PersonControllerTest {

    @Autowired
    private PersonInfoMapper personInfoMapper;

    @Test
    public void insertPersonTest() throws Exception {
        PersonInfo personInfo = new PersonInfo();
        personInfo.setId(100);
        personInfo.setName("ceshi");
        int result = personInfoMapper.insertPerson(personInfo);
        Assert.assertEquals(1,result);
    }

    @Test
    public void deletedPersonByIdTest() throws Exception {
        int result = personInfoMapper.deletedPersonById(100);
        Assert.assertEquals(0,result);
    }


    @Test
    public void getPersonByIdTest() throws Exception {
        PersonInfo result = personInfoMapper.getPersonById(1);
        Assert.assertEquals(1,result.getId());
    }

    @Test
    public void getPersonByIdTest2() throws Exception {
        PersonInfo result = personInfoMapper.getPersonById(500);
        Assert.assertNull(result);
    }
}