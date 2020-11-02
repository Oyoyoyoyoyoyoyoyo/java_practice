package com.oyogis.entity;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.*;


/**
 * Author:zhanggang
 * Date:2020/11/2
 * Decription:<用户实体类>
 * swagger实现API文档
 * JSR-303实现请求参数校验
 */

@Data
@ApiModel("用户实体")
@NoArgsConstructor
public class User {
    @ApiModelProperty("用户姓名")
    @NotNull
    private String name;
    @ApiModelProperty("用户年龄")
    @NotNull
    private Integer age;

}