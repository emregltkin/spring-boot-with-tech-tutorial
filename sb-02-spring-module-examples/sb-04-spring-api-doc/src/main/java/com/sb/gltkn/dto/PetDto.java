package com.sb.gltkn.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@ApiModel(value = "Pet API Objesi", description = "API modelidir")
public class PetDto {

    @ApiModelProperty(value = "Pet Objesi Id")
    private int id;

    @ApiModelProperty(value = "Pet Objesi Name")
    private String name;

    @ApiModelProperty(value = "Pet Objesi Date")
    private Date date;
}
