package com.example.hello.mapper;

import com.example.hello.pojo.Addresses;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface AddressesMapper {

    public List<Addresses> getAllAddresses();
}
