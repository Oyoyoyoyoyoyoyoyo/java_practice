package com.oyoyoyo.shiro;


import lombok.Data;

import java.io.Serializable;

/**
 * Date:2020/11/5
 * Decription:<封装用户可公开的信息>
 *
 * @Author:oyoyoyoyoyoyo
 */
@Data
public class AccountProfile implements Serializable {

    private Long id;

    private String username;

    private String avatar;

    private String email;

}
