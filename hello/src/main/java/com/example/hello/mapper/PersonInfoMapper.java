package com.example.hello.mapper;

import com.example.hello.pojo.PersonInfo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.transaction.annotation.Transactional;

@Mapper
@Transactional
public interface PersonInfoMapper {
    public PersonInfo getPersonById(int id);

    public int insertPerson(PersonInfo personInfo);

    public int deletedPersonById(int id);
}
