package cn.itcast.service;

import cn.itcast.domain.User;

import java.util.List;

/**
 * Author:zhanggang
 * Date:2020/8/13
 * Decription:用户管理的业务接口
 */
public interface UserService {
    /**
     * 查询所有用户信息
     * @return
     */
    public List<User> findAll();
}
