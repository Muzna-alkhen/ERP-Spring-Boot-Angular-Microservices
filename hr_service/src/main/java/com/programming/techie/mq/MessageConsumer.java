package com.programming.techie.mq;

import com.programming.techie.service.Month_salaryService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;
import com.programming.techie.mq.PayrollMsg;

import javax.jms.Queue;

@Component
@EnableJms
public class MessageConsumer {


    @Autowired
    Month_salaryService month_salaryService;

    private final Logger logger = LoggerFactory.getLogger(MessageConsumer.class);

    @JmsListener(destination = "payrollRequest-queue")
    public void listener(PayrollMsg payrollMsg){

        logger.info("Message received {} ", payrollMsg.name);
         AllPayrollMsg allPayrollMsg = month_salaryService.generate();
         month_salaryService.send(allPayrollMsg);




    }

    @JmsListener(destination = "test1-queue")
    public void listener1(String node){

        logger.info("Message received {} ", node);
    }

}