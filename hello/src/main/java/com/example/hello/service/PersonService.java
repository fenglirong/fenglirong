package com.example.hello.service;

import com.example.hello.mapper.PersonInfoMapper;
import com.example.hello.pojo.PersonInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class PersonService {
    @Autowired
    private PersonInfoMapper personInfoMapper;

    public PersonInfo getPersonById(int id){
        return personInfoMapper.getPersonById(id);
    }

    @Transactional
    public int insertPerson(PersonInfo personInfo) {
        return personInfoMapper.insertPerson(personInfo);
    }

    @Transactional
    public int deletedPersonById(int personId) {
        return personInfoMapper.deletedPersonById(personId);
    }
}
