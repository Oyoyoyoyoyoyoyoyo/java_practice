package com.oyoyoyo;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.oyoyoyo.mapper.UserMapper;
import com.oyoyoyo.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
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

    /**
     * 测试乐观锁成功
     */
    @Test
    public void TestOptimisticLocker() {
        // 查询用户
        User user = userMapper.selectById(1L);
        //    修改用户
        user.setName("狂胜说");
        user.setEmail("123456@qq.com");
        //    更新
        userMapper.updateById(user);
    }

    /**
     * 测试批量查询
     */
    @Test
    public void testSelectById() {
        // final User selectByIdResult = userMapper.selectById(1);
        // System.out.println("selectByIdResult = " + selectByIdResult);
        final List<User> userList = userMapper.selectBatchIds(Arrays.asList(1, 2, 3));
        System.out.println("userList = " + userList);
    }

    /**
     * 测试条件查询
     */
    @Test
    public void testSelectByWhere() {
        final HashMap<String, Object> map = new HashMap<>();
        //    自定义查询
        map.put("name", "Tom");
        final List<User> users = userMapper.selectByMap(map);
        System.out.println("users = " + users);
    }

    /**
     * 测试分页
     */
    @Test
    public void testPage() {
        //当前页，页面大小
        final Page<User> page = new Page<>(2, 5);
        final Page<User> users = userMapper.selectPage(page, null);
        final long pageTotal = page.getTotal();
        System.out.println("pageTotal = " + pageTotal);
        System.out.println("users = " + users);
    }

    /**
     * 测试删除
     */
    @Test
    public void testDelete() {
        final int deleteById = userMapper.deleteById(1);
        System.out.println("deleteById = " + deleteById);
    }
}
