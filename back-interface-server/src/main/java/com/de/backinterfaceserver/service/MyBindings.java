package com.de.backinterfaceserver.service;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.SubscribableChannel;

public interface MyBindings {
    String INPUT_CHANNEL = "myInput";
    String OUTPUT_CHANNEL = "myOutput";

    /**
     * 输入通道
     * @return
     */
    @Input(MyBindings.INPUT_CHANNEL)
    SubscribableChannel input();

    /**
     * 输出通道
     * @return
     */
    @Output(MyBindings.OUTPUT_CHANNEL)
    MessageChannel output();
}
