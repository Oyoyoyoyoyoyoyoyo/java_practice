package com.oyogis.entity;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;


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
public class User_bak {

    // @ApiModelProperty("用户编号")
    // private Long id;
    //
    // @NotNull
    // @Size(min = 2, max = 5)
    // @ApiModelProperty("用户姓名")
    // private String name;
    //
    // @NotNull
    // @Max(100)
    // @Min(10)
    // @ApiModelProperty("用户年龄")
    // private Integer age;
    //
    // @NotNull
    // @Email
    // @ApiModelProperty("用户邮箱")
    // private String email;

}