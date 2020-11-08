package com.oyoyoyo.controller;


import com.oyoyoyo.common.CommonResult;
import com.oyoyoyo.entity.User;
import com.oyoyoyo.service.UserService;
import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author anonymous
 * @since 2020-11-04
 */
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService userService;

    @RequiresAuthentication
    @GetMapping("/index")
    public CommonResult index() {
        User user = userService.getById(1L);
        return CommonResult.success(user);
    }

    @PostMapping("/save")
    public CommonResult save(@Validated @RequestBody User user){
        return CommonResult.success(user);
    }

}
