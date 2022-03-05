package com.example.hello.service;

import com.example.hello.mapper.ClubMapper;
import com.example.hello.pojo.Club;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClubService {
    @Autowired
    private ClubMapper clubMapper;

    public List<Club> getAllClubs(int id){
        return clubMapper.getAllClubs(id);
    }

 }
