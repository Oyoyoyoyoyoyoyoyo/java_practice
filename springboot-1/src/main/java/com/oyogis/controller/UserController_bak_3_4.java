package com.oyogis.controller;

import com.oyogis.entity.User;
import com.oyogis.repository.UserRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Author:zhanggang
 * Date:2020/11/2
 * Decription:<用户控制类>
 */


@Api(tags = "用户管理")
@RestController
@RequestMapping(value = "/users")
public class UserController_bak_3_4 {

  /*  @Autowired
    private UserRepository userRepository;

    @ApiOperation(value = "新建用户")
    @GetMapping("/add")
    public String addUser() {
        // 创建10条记录
        userRepository.save(new User("AAA", 10));
        userRepository.save(new User("BBB", 20));
        userRepository.save(new User("CCC", 30));
        userRepository.save(new User("DDD", 40));
        userRepository.save(new User("EEE", 50));
        userRepository.save(new User("FFF", 60));
        userRepository.save(new User("GGG", 70));
        userRepository.save(new User("HHH", 80));
        userRepository.save(new User("III", 90));
        userRepository.save(new User("JJJ", 100));
        return "创建用户成功";
    }

    @ApiOperation(value = "查询用户", notes = "根据name查询用户")
    @GetMapping("/select/{name}")
    public String getByName(@PathVariable("name") String name) {

        return userRepository.findByName(name).toString();
    }
    @ApiOperation(value = "查询用户", notes = "根据name查询用户")
    @GetMapping("/find/{name}")
    public String findUser(@PathVariable("name") String name) {

        return userRepository.findUser(name).toString();
    }
*/

}