package com.example.hello.controller;

import com.example.hello.domain.ResponseResult;
import com.example.hello.pojo.Club;
import com.example.hello.service.ClubService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Api(description = "Club API Interface")
@RestController
public class ClubController {

    @Autowired
    private ClubService clubService;

    /**
     *@Title getAllClubsById
     *@Author:Frank Feng 
     *@Param:
     *@Description 
     *@Date:2022/3/5 17:33
     *
     */

    @PreAuthorize("hasAnyAuthority('write','read') and hasAnyRole('admin','normal') ")
    @ApiOperation(value="get All clubs by id", notes="get All clubs by id", produces="application/json")
    @ApiImplicitParam(name="cid",value="club Id",dataType="int", paramType = "path",example="2",required = true)
    @GetMapping("/v1/getAllClubs/{cid}")
    public ResponseResult getAllClubs(@PathVariable("cid")int id){
        List<Club> allClubs = clubService.getAllClubs(id);
        if(allClubs.isEmpty()){
            return  new ResponseResult(500,"This club not existing "+id);
        }
        return  new ResponseResult(200,"success",allClubs);
    }


}
