package com.mining.crypto.service;

import cn.hutool.core.lang.UUID;
import com.mining.crypto.vo.User;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
public class UserServiceTest {

    @Autowired
    private IUserService userService;

    @Test
    public void testSave() {
        System.out.println(("----- save method test ------"));
        User user = new User();
        user.setId(UUID.randomUUID().toString(true));
        user.setName("John Doe");
        user.setEmail("john.doe@example.com");
        Assert.assertTrue("", userService.save(user));
    }

}