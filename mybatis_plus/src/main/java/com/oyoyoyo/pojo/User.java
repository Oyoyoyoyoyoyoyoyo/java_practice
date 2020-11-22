package com.oyoyoyo.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Date:2020/11/22
 * Decription:<User实体类>
 *
 * @Author:oyoyoyoyoyoyo
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private long id;
    private String name;
    private Integer age;
    private String email;
}
