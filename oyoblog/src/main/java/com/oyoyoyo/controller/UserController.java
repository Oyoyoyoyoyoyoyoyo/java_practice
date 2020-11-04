package com.oyoyoyo.controller;


import com.oyoyoyo.common.CommonResult;
import com.oyoyoyo.entity.User;
import com.oyoyoyo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

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

    @GetMapping("/index")
    public CommonResult index() {
        User user = userService.getById(1L);
        return CommonResult.success(user);
    }

}
