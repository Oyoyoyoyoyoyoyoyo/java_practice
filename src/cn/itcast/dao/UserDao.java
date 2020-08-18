package cn.itcast.dao;

import cn.itcast.domain.User;

import java.util.List;

/**
 * Author:zhanggang
 * Date:2020/8/13
 * Decription:<用户操作的Dao>
 */
public interface UserDao {
    public List<User> findAll();
}
