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
     * 继承了BaseMapper所有的方法来自BaseMapper
     */
    @Autowired
    private UserMapper userMapper;

    @Test
    void contextLoads() {

        //查询所有用户,wrapper参数是条件构造器，类似sql中的where
        final List<User> users = userMapper.selectList(null);
        users.forEach(System.out::println);
    }

    /**
     * 测试插入
     */
    @Test
    public void testInsert() {
        User user = new User();
        user.setName("你大爷呀2222");
        user.setAge(17);
        user.setEmail("645590975@qq.com");
        //插入会自动生成id,并自动回填
        final int userResult = userMapper.insert(user);
        System.out.println("userResult = " + userResult);
        System.out.println("user = " + user);
    }

    /**
     * 测试更新
     */
    @Test
    public void testUpdate() {
        User user = new User();
        user.setName("你大爷呀2222");
        user.setId(9);
        user.setAge(19);
        user.setEmail("645590975@qq.com");

        final int updateResult = userMapper.updateById(user);
        System.out.println("updateResult = " + updateResult);
    }

}
