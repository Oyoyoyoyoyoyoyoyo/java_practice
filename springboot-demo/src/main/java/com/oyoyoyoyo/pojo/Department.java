package com.oyoyoyoyo.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Date:2021/1/14
 * Decription:<部门表>
 *
 * @Author:oyoyoyoyoyoyo
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Department {
    private Integer id;
    private String departmentName;
}
