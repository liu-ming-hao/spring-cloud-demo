package com.de.streamserverdemo.controller;

import com.de.streamserverdemo.interfaces.IMessageSender;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * TestController
 *
 * @author 刘明浩
 * @Description  消息发送测试demo
 * @since 2020/12/12 9:35
 */
@RestController
@Slf4j
public class TestController {
    @Autowired
    private IMessageSender iMessageSender;

    @GetMapping("send")
    public void send() {
        iMessageSender.sendMessage("Ronnie O'Sullivan");
    }
}
