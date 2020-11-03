package com.oyogis;

import com.oyogis.entity.User;
import com.oyogis.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cache.CacheManager;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@SpringBootTest
public class ApplicationTests {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private CacheManager cacheManager;
    @Test
    public void test() throws Exception {
        System.out.println("测试开始------------------------------------");
        // 创建1条记录
        userRepository.save(new User("AAA", 10));
        User u1 = userRepository.findByName("AAA");
        System.out.println("第一次查询：" + u1.getAge());
        User u2 = userRepository.findByName("AAA");
        System.out.println("第二次查询：" + u2.getAge());
    }

}
