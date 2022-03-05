package com.example.hello.controller;

import com.example.hello.domain.ResponseResult;
import com.example.hello.pojo.PersonInfo;
import com.example.hello.service.PersonService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;



@Api(description = "PersonInfo  API Interface")
@RestController
public class PersonController {

    @Autowired
    private PersonService personService;

    /**
     *@Title getPersonById
     *@Author:Frank Feng 
     *@Param:
     *@Description 
     *@Date:2022/3/5 17:27
     *
     */
    @PreAuthorize("hasAnyAuthority('write','read') and hasAnyRole('admin','normal') ")
    @ApiOperation(value="Allowed a person to be selected based on ID", notes="Allowed a person to be selected based on ID", produces="application/json")
    @ApiImplicitParam(name="personId",value="person Id",dataType="int", paramType = "path",example="1",required = true)
    @GetMapping("/v1/get-person/{personId}")
    public ResponseResult<PersonInfo> getPersonById(@PathVariable("personId") int id){

        PersonInfo personInfo = personService.getPersonById(id);
        if(personInfo==null){
          return  new ResponseResult(500,"this personId not existing"+id);
        }
        return  new ResponseResult(200,"success",personInfo);
    }
    /**
     *@Title insertPerson
     *@Author:Frank Feng 
     *@Param:
     *@Description 
     *@Date:2022/3/5 17:14 
     *
     */
    @PreAuthorize("hasAnyAuthority('write') and hasRole('admin') ")
    @ApiImplicitParams({
            @ApiImplicitParam(name="id",value="personInfo id",dataType="int", paramType = "query",example="10",required = true),
            @ApiImplicitParam(name="name",value="name",dataType="string", paramType = "query",example="test10",required = true)
    })
    @ApiOperation(value="Allowed a person to be inserted", notes="Allowed a person to be inserted", produces="application/json")
    @PostMapping("/v1/post-person")
    public ResponseResult insertPerson(int id,String name){
        PersonInfo personInfo= new PersonInfo();
        personInfo.setId(id);
        personInfo.setName(name);
        int i = personService.insertPerson(personInfo);
        if(i==0){
          return  new ResponseResult(500,"insert error");
        }
        return  new ResponseResult(200,"success",i);

    }
    /**
     *@Title deletedPersonById
     *@Author:Frank Feng 
     *@Param:
     *@Description 
     *@Date:2022/3/5 17:14 
     *
     */
    @PreAuthorize("hasAnyAuthority('write') and hasRole('admin') ")
    @ApiOperation(value="Allowed a person to be deleted based on ID", notes="Allowed a person to be deleted based on ID", produces="application/json")
    @ApiImplicitParam(name="personId",value="person Id",dataType="int", paramType = "path",example="1",required = true)
    @DeleteMapping("/v1/delete-person/{personId}")
    public ResponseResult deletedPersonById(@PathVariable("personId") int personId){
        int i = personService.deletedPersonById(personId);
        if(i==0){
         return   new ResponseResult(500,"this personId not existing-"+personId);
        }
        return  new ResponseResult(200,"success",i);
    }
}