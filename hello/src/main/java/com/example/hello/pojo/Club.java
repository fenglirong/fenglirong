package com.example.hello.pojo;

import lombok.Data;

import java.util.List;

@Data
public class Club {
    private int id;
    private String name;
    private List<PersonInfo> personInfos;
}
