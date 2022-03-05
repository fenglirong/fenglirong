package com.example.hello.pojo;

import lombok.Data;

@Data
public class Addresses {
    private int id;
    private String addressName;
    private PersonInfo personInfo;
}
