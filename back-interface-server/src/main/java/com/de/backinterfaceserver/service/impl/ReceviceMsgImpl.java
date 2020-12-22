package com.de.backinterfaceserver.service.impl;


import com.de.backinterfaceserver.service.MyBindings;
import com.de.backinterfaceserver.service.ReceviceMsg;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.stereotype.Service;

/**
 * ReceviceMsgImpl
 *
 * @author 刘明浩
 * @Description  消息消费
 * @since 2020/12/12 10:14
 */
@Service
@Slf4j
@EnableBinding(value = {MyBindings.class})
public class ReceviceMsgImpl implements ReceviceMsg {
    @Value("${server.port}")
    private String port;

    @StreamListener(MyBindings.INPUT_CHANNEL)
    @Override
    public void receive(String message) {
        log.info(port + "客户端接收消息："+message);
    }
}
