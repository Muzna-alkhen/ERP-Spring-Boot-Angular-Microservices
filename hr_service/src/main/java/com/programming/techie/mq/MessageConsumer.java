package com.programming.techie.mq;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;
import com.programming.techie.mq.PayrollMsg;

@Component
@EnableJms
public class MessageConsumer {

    private final Logger logger = LoggerFactory.getLogger(MessageConsumer.class);

    @JmsListener(destination = "erp-queue")
    public void listener(PayrollMsg msg){

        logger.info("Message received {} ", msg.name);


    }

    @JmsListener(destination = "test1-queue")
    public void listener1(String node){

        logger.info("Message received {} ", node);
    }

}