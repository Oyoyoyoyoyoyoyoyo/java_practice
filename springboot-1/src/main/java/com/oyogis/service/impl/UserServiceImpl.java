package com.oyogis.service.impl;

import com.oyogis.entity.User;
import com.oyogis.service.UserService;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Author:zhanggang
 * Date:2020/11/3
 * Decription:<描述>
 */

@Service
public class UserServiceImpl implements UserService {
    /**
     * 引入jdbcTemplate
     */
    private JdbcTemplate jdbcTemplate;

    UserServiceImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    /**
     * 新增一个用户
     *
     * @param name
     * @param age
     * @return
     */
    @Override
    public int create(String name, Integer age) {
        return jdbcTemplate.update("insert into user(name, age) values (?, ?)", name, age);
    }

    /**
     * 根据name查询用户
     *
     * @param name
     * @return
     */
    @Override
    public List<User> getByName(String name) {
        List<User> users = jdbcTemplate.query(
                "select name, age from user where name=?", (resultSet, i) -> {
                    User user = new User();
                    user.setName(resultSet.getString("name"));
                    user.setAge(resultSet.getInt("age"));
                    return user;
                }, name

        );
        return users;
    }

    /**
     * 根据name删除用户
     *
     * @param name
     * @return
     */
    @Override
    public int deleteByName(String name) {
        return jdbcTemplate.update("delete from user where name = ?", name);
    }

    /**
     * 获取所有用户
     *
     * @return
     */
    @Override
    public int getAllUsers() {
        return jdbcTemplate.queryForObject("select count(1) from user", Integer.class);
    }

    /**
     * 删除所有用户
     *
     * @return
     */
    @Override
    public int deleteAllUsers() {
        return jdbcTemplate.update("delete from user");
    }
}
