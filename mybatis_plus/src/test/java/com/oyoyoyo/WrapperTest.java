package com.oyoyoyo;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.oyoyoyo.mapper.UserMapper;
import com.oyoyoyo.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Map;

/**
 * Date:2020/11/22
 * Decription:<条件构造器测试类>
 *
 * @Author:oyoyoyoyoyoyo
 */
@SpringBootTest
public class WrapperTest {
    /**
     * 继承了BaseMapper所有的方法来自BaseMapper
     */
    @Autowired
    private UserMapper userMapper;

    /**
     * 查询name不为空，且邮箱不为空，年龄大于等于12的多个数据；
     */
    @Test
    void contextLoads() {

        //    和map查询类似
        final QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.isNotNull("name")
                .isNotNull("email")
                .ge("age", 12);
        final List<User> userList = userMapper.selectList(wrapper);
        System.out.println("userList = " + userList);
    }

    /**
     * 查询单个用户名字的单个数据
     */

    @Test
    void test2() {

        //    和map查询类似
        final QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.eq("name", "你大爷呀2222 ");
        final User user = userMapper.selectOne(wrapper);
        System.out.println("user = " + user);
    }

    /**
     * 查询年龄在20-30之间
     */

    @Test
    void test3() {

        //    和map查询类似
        final QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.between("age", 20, 30);
        final Integer count = userMapper.selectCount(wrapper);
        System.out.println("count = " + count);
    }


    /**
     * 模糊查询(查询name字段中不包含T，且邮箱以t开头的user)
     */

    @Test
    void test4() {

        //    和map查询类似
        final QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.notLike("name", "T")
                .likeRight("email", "t");
        final List<Map<String, Object>> maps = userMapper.selectMaps(wrapper);
        System.out.println("maps = " + maps);
    }
}
