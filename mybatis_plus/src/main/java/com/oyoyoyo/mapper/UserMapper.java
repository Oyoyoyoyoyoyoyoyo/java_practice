package com.oyoyoyo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.oyoyoyo.pojo.User;
import org.springframework.stereotype.Repository;

/**
 * Date:2020/11/22
 * Decription:<继承Mybatisplus的BaseMapper类>
 *
 * @Author:oyoyoyoyoyoyo
 */
@Repository
//表示持久层
public interface UserMapper extends BaseMapper<User> {
}
