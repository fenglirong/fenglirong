package com.example.hello.pojo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
@ApiModel("PersonInfo")
@Data
public class PersonInfo {
    @ApiModelProperty(value="10", required=true)
    private int id;
    @ApiModelProperty(value="Jack chen", required=true)
    private String name;

}
