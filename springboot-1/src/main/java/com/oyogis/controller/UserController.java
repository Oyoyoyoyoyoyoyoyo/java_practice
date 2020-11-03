package com.oyogis.controller;

import com.oyogis.entity.User;
import com.oyogis.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.*;

/**
 * Author:zhanggang
 * Date:2020/11/2
 * Decription:<用户控制类>
 */


@Api(tags = "sql用户管理")
@RestController
@RequestMapping(value = "/users")
public class UserController {

    @Autowired
    private UserService userService;

    @ApiOperation(value = "创建用户", notes = "根据User对象创建用户")
    @PostMapping("/add")
    public int create(@RequestBody User user) {
        System.out.println("user = " + user.toString());
        return userService.create(user.getName(), user.getAge());
    }


    @ApiOperation(value = "查询用户", notes = "根据name查询用户")
    @GetMapping("/select/{name}")
    public List<User> getByName(@PathVariable String name) {
        System.out.println("name = " + name);
        return userService.getByName(name);
    }


    @ApiOperation(value = "删除用户", notes = "根据name删除用户")
    @GetMapping("/delete/{name}")
    public int deleteByName(@PathVariable String name) {
        return userService.deleteByName(name);
    }


    @ApiOperation(value = "获取所有用户")
    @GetMapping("/selectAll")
    public int getAllUsers() {
        return userService.getAllUsers();
    }

    /**
     * 删除所有用户
     *
     * @return
     */
    @ApiOperation(value = "删除所有用户")
    @GetMapping("/deleteAll")
    public int deleteAllUsers() {
        return userService.deleteAllUsers();
    }

}