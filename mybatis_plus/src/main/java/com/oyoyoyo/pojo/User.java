package com.oyoyoyo.pojo;

import com.baomidou.mybatisplus.annotation.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

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
    /**
     * 乐观锁
     */
    @Version
    private Integer version;
    /**
     * 插入创建的时候，填充数据
     */
    @TableField(fill = FieldFill.INSERT)
    private Date createTime;
    /**
     * 更新的时候，填充数据
     */
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date updateTime;
}
