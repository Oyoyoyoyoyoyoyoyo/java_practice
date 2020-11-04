package com.oyoyoyo.service.impl;

import com.oyoyoyo.entity.User;
import com.oyoyoyo.mapper.UserMapper;
import com.oyoyoyo.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author anonymous
 * @since 2020-11-04
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

}
