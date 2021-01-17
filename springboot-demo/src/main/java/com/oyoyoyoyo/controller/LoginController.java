package com.oyoyoyoyo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Date:2021/1/17
 * Decription:<登陆控制类>
 *
 * @Author:oyoyoyoyoyoyo
 */
@Controller
public class LoginController {
    @RequestMapping("/user/login")
    public String login(@RequestParam("username") String username, @RequestParam("password") String password, Model model) {
        if (!StringUtils.isEmpty(username) && "123456".equals(password)) {
            // return "dashboard";
            //重定向到main.html 实际为dashboard.html
            return "redirect:/main.html";
        } else {
            model.addAttribute("msg", "用户名或密码错误");
            return "index";
        }
    }
}
