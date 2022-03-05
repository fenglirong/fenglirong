package com.example.hello.controller;

import com.example.hello.pojo.Addresses;
import com.example.hello.service.AddressService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Api(description = "Addresses API Interface")
@RestController
public class AddresesController {

    @Autowired
    private AddressService addressService;

    /**
     *@Title getAllAddresses
     *@Author:Frank Feng 
     *@Param:
     *@Description 
     *@Date:2022/3/5 17:22
     *
     */
    @PreAuthorize("hasAnyAuthority('write','read') and hasAnyRole('admin','normal') ")
    @ApiOperation(value="get All Addresses", notes="get All Addresses", produces="application/json")
    @GetMapping("/v1/getAllAddresses")
    public List<Addresses> getAllAddresses(){

        return addressService.getAllAddresses();
    }


}
