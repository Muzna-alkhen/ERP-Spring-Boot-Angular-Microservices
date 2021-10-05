package com.programming.techie.mq;

import com.programming.techie.service.PayrollService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
@EnableJms
public class MessageConsumer {


    @Autowired
    PayrollService payrollService;

    private final Logger logger = LoggerFactory.getLogger(MessageConsumer.class);

    @JmsListener(destination = "allPayroll-queue")
    public void listener(AllPayrollMsg allPayrollMsg){

        logger.info("Message received {} ", allPayrollMsg);

        payrollService.save(allPayrollMsg);

    }



}