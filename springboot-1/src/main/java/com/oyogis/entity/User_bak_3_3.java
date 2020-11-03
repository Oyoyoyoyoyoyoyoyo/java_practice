package com.oyogis.entity;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


/**
 * Author:zhanggang
 * Date:2020/11/2
 * Decription:<用户实体类>
 * swagger实现API文档
 * JSR-303实现请求参数校验
 */
@ApiModel("用户实体")
@Data
@NoArgsConstructor
public class User_bak_3_3 {
/*    @NotNull
    @Size(min = 2, max = 5)
    @ApiModelProperty("用户姓名")
    private String name;

    @NotNull
    @Max(100)
    @Min(10)
    @ApiModelProperty("用户年龄")
    private Integer age;*/
}