package com.example.hello.mapper;

import com.example.hello.pojo.Club;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ClubMapper {

    public List<Club> getAllClubs(int id);
}
