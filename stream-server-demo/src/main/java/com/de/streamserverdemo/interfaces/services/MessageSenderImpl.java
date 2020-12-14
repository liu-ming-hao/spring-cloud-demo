package com.de.streamserverdemo.interfaces.services;

import com.de.streamserverdemo.interfaces.IMessageSender;
import com.de.streamserverdemo.interfaces.MyBindings;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

/**
 * MessageSenderImpl
 *
 * @author 刘明浩
 * @Description  消息发送demo
 * @since 2020/12/12 9:19
 */
/**
 * 这个注解给我们绑定消息通道的，Source是Stream给我们提供的，可以点进去看源码，
 * 可以看到output和input,这和配置文件中的output，input对应的。
 */
@EnableBinding(MyBindings.class)
@Slf4j
@Service
public class MessageSenderImpl implements IMessageSender {

    //注入Source
    @Autowired
    private MyBindings source;

    @Override
    public void sendMessage(String message) {
        boolean sendStatus = source.output().send(MessageBuilder.withPayload(message).build());
        log.info("发送数据：{},sendStatus: {}",message,sendStatus);
    }
}
