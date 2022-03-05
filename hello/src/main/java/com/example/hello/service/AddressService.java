package com.example.hello.service;

import com.example.hello.mapper.AddressesMapper;
import com.example.hello.pojo.Addresses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressService {
    @Autowired
    private AddressesMapper addressesMapper;

    public List<Addresses> getAllAddresses(){
        return addressesMapper.getAllAddresses();
    }
}
