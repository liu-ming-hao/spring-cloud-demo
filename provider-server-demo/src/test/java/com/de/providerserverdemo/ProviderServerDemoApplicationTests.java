package com.de.providerserverdemo;


import com.de.providerserverdemo.dao.UserDao;
import com.de.providerserverdemo.model.User;
import com.de.providerserverdemo.service.IUserService;
import javafx.application.Application;
import lombok.SneakyThrows;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;


@SpringBootTest
public class ProviderServerDemoApplicationTests {
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
