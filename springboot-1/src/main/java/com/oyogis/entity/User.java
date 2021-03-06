package com.oyogis.entity;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.*;


/**
 * Author:zhanggang
 * Date:2020/11/2
 * Decription:<用户实体类>
 */
@ApiModel("用户实体")
@Data
@NoArgsConstructor
@Entity
public class User {
    @Id
    @GeneratedValue
    @NotNull
    @ApiModelProperty("用户id")
    private Long id;
    @NotNull
    @Size(min = 2, max = 5)
    @ApiModelProperty("用户姓名")
    private String name;

    @NotNull
    @Max(100)
    @Min(10)
    @ApiModelProperty("用户年龄")
    private Integer age;

    public User(String name, Integer age) {
        this.name = name;
        this.age = age;
    }
}