package com.oyoyoyo.controller;

import cn.hutool.core.lang.Assert;
import cn.hutool.core.map.MapUtil;
import cn.hutool.crypto.SecureUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.oyoyoyo.common.CommonResult;
import com.oyoyoyo.common.dto.LoginDto;
import com.oyoyoyo.entity.User;
import com.oyoyoyo.service.UserService;
import com.oyoyoyo.util.JwtUtils;
import org.apache.catalina.security.SecurityUtil;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;

/**
 * Date:2020/11/8
 * Decription:<描述>
 *
 * @Author:oyoyoyoyoyoyo
 */
@RestController
public class AccountController {
    @Autowired
    UserService userService;
    @Autowired
    JwtUtils jwtUtils;

    /**
     * 登陆
     *
     * @param loginDto
     * @param response
     * @return
     */
    @PostMapping("/login")
    public CommonResult login(@Validated @RequestBody LoginDto loginDto, HttpServletResponse response) {
        //判断用户是否存在
        User user = userService.getOne(new QueryWrapper<User>().eq("username", loginDto.getUsername()));
        Assert.notNull(user, "账号不存在");
        System.out.println("user.toString() = " + user.toString());
        System.out.println("loginDto.getPassword() = " + loginDto.getPassword());
        //判断密码是否正确
        // if (!user.getPassword().equals(SecureUtil.md5(loginDto.getPassword()))) {
        if (!user.getPassword().equals(loginDto.getPassword())) {
            return CommonResult.failed("密码错误");
        }

        //根据用户id生成jwt
        String jwt = jwtUtils.generateToken(user.getId());
        response.setHeader("Authorization", jwt);
        response.setHeader("Access-control-Expose-Headers", "Authorization");

        //返回用户信息
        return CommonResult.success(MapUtil.builder()
                .put("id", user.getId())
                .put("username", user.getUsername())
                .put("avatar", user.getAvatar())
                .put("email", user.getEmail())
                .map()
        );
    }

    /**
     * 退出
     *
     * @return
     */
    @RequiresAuthentication
    @GetMapping("/logout")
    public CommonResult logout() {
        SecurityUtils.getSubject().logout();
        return CommonResult.success(null);
    }
}
