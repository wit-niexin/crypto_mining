package com.mining.crypto.mapper;

import cn.hutool.core.lang.UUID;
import com.mining.crypto.vo.User;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import java.util.List;

@SpringBootTest
@RunWith(SpringRunner.class)
public class UserMapperTest {

    @Autowired
    private UserMapper userMapper;

    @Test
    public void testSelect() {
        System.out.println(("----- selectAll method test ------"));
        List<User> userList = userMapper.selectList(null);
        Assert.assertTrue("", 5 == userList.size());
        userList.forEach(System.out::println);
    }

    @Test
    public void testInsert() {
        System.out.println(("----- insert method test ------"));
        User user = new User();
        user.setName("test_user");
        user.setPassword("test_user");
        user.setCommonValue("admin");
        Assert.assertTrue("", 1 == userMapper.insert(user));
    }

}