package com.oyoyoyo.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
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
    //主键配置,设置自增策略
    @TableId(type = IdType.AUTO)
    private long id;
    private String name;
    private Integer age;
    private String email;
}
