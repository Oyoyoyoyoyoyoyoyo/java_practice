package com.oyoyoyo;

import com.oyoyoyo.mapper.UserMapper;
import com.oyoyoyo.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class MybatisPlusApplicationTests {
    /**
     *继承了BaseMapper所有的方法来自BaseMapper
     */
    @Autowired
    private UserMapper userMapper;

    @Test
    void contextLoads() {

        //查询所有用户,wrapper参数是条件构造器，类似sql中的where
        final List<User> users = userMapper.selectList(null);
        users.forEach(System.out::println);
    }

}
