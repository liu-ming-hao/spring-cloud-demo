package com.de.userserver;


import com.de.userserver.dao.UserDao;
import com.de.userserver.model.User;
import com.de.userserver.service.IUserService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;


@SpringBootTest
public class UserServerApplicationTests {
    @Autowired
    IUserService iUserService;

    @Autowired
    UserDao thisMapper;

    @Test
    public void contextLoads() {
        User user = new User();
        List<User> res = iUserService.findList(user);
        System.out.println("ok");
    }

}
