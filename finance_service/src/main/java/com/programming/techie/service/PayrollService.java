package com.programming.techie.service;

import com.programming.techie.dto.PayrollDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

import javax.jms.Queue;

@Service
public class PayrollService {


    @Autowired
    private Queue queue ;


    @Autowired
    private JmsTemplate jmsTemplate;


    public void request(PayrollDto payrollDto) {

        jmsTemplate.convertAndSend(queue,payrollDto);
        

    }
}
