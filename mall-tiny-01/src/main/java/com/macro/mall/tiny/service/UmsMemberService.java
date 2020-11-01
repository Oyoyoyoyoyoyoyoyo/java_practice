package com.macro.mall.tiny.service;

import com.macro.mall.tiny.common.api.CommonResult;

/**
 * Author:zhanggang
 * Date:2020/11/1
 * Decription:<会员管理Service>
 *
 * @author oyoyoyoyoyoyo
 */
public interface UmsMemberService {
    /**
     * 生成验证码
     *
     * @param telephone
     * @return
     */
    CommonResult generateAuthCode(String telephone);

    /**
     * 判断验证码和手机号是否匹配
     *
     * @param telephone
     * @param authCode
     * @return
     */
    CommonResult verifyAuthCode(String telephone, String authCode);
}
