package com.programming.techie.financeservice.mq;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
@EnableJms
public class MessageConsumer {

    private final Logger logger = LoggerFactory.getLogger(MessageConsumer.class);

        @JmsListener(destination = "test-queue")
    public void listener(String node){

        logger.info("Message received {} ", node);
    }

    @JmsListener(destination = "test1-queue")
    public void listener1(String node){

        logger.info("Message received {} ", node);
    }

}