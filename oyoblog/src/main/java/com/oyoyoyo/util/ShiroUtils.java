package com.oyoyoyo.util;

/**
 * Date:2020/11/5
 * Decription:<Shiro工具类>
 *
 * @Author:oyoyoyoyoyoyo
 */

import com.oyoyoyo.shiro.AccountProfile;
import org.apache.shiro.SecurityUtils;


public class ShiroUtils {

    /**
     * 获取当前登录用户的信息
     *
     * @return
     */
    public static AccountProfile getProfile() {
        return (AccountProfile) SecurityUtils.getSubject().getPrincipal();
    }
}
