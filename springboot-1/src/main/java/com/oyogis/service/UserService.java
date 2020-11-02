package com.oyogis.service;

import com.oyogis.entity.User;

import java.util.List;

/**
 * Author:zhanggang
 * Date:2020/11/3
 * Decription:<用户服务接口>
 */
public interface UserService {
    /**
     * 新增一个用户
     *
     * @param name
     * @param age
     * @return
     */
    int create(String name, Integer age);

    /**
     * 根据name查询用户
     *
     * @param name
     * @return
     */
    List<User> getByName(String name);

    /**
     * 根据name删除用户
     *
     * @param name
     * @return
     */
    int deleteByName(String name);

    /**
     * 获取所有用户
     *
     * @return
     */
    int getAllUsers();

    /**
     * 删除所有用户
     *
     * @return
     */
    int deleteAllUsers();
}
