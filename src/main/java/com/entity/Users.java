package com.entity;

import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @ProjectName
 * @ClassName Users
 * @Author: lichuanming
 * @Date: 2023-04-04
 * @Description:
 **/
@Data
@Accessors(chain = true)
@ApiModel(value = "Users对象", description = "")
public class Users implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer id;


}
