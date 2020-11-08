package com.oyoyoyo.common.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

/**
 * Date:2020/11/8
 * Decription:<描述>
 *
 * @Author:oyoyoyoyoyoyo
 */
@Data
public class LoginDto implements Serializable {
    @NotBlank(message = "账号不能为空")
    private String username;
    @NotBlank(message = "密码不能为空")
    private String password;


}
