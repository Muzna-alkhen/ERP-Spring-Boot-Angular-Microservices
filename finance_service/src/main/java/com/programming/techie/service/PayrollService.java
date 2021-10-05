package com.programming.techie.service;

import com.programming.techie.dto.Journal_EntryDto;
import com.programming.techie.dto.PayrollRequestDto;
import com.programming.techie.dto.PayrollResponseDto;
import com.programming.techie.model.Journal_Entry;
import com.programming.techie.model.Payroll;
import com.programming.techie.mq.AllPayrollMsg;
import com.programming.techie.mq.PayrollMsg;
import com.programming.techie.repository.PayrollRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

import javax.jms.Queue;
import java.util.ArrayList;
import java.util.List;

@Service
public class PayrollService {

    @Autowired
    PayrollRepository payrollRepository;

    @Autowired
    private Queue queue ;


    @Autowired
    private JmsTemplate jmsTemplate;


    public void request(PayrollRequestDto payrollDto) {

        PayrollMsg msg = new PayrollMsg();
        msg.name="payroll_request";
        msg.month =payrollDto.getMonth();
        msg.year =payrollDto.getYear();
        jmsTemplate.convertAndSend(queue,msg);


    }

    public void save(AllPayrollMsg dto)
    {
        int count = dto.employee_ids.size();

        for (int i=0;i<count;i++)
        {
            Payroll payroll = new Payroll();
            payroll.setEmployee_id(dto.employee_ids.get(i));
            payroll.setFull_name(dto.full_names.get(i));
            payroll.setAmount(dto.amounts.get(i));

            payroll.setMonth(dto.month);
            payroll.setYear(dto.year);
            payroll.setIs_taken(false);

            payrollRepository.save(payroll);
        }


    }

    public List<PayrollResponseDto> all() {
        List<Payroll> payrollList = payrollRepository.findAll();
        List<PayrollResponseDto> list = new ArrayList();
        for (Payroll payroll :
                payrollList) {
            PayrollResponseDto dto = new PayrollResponseDto();
            dto.setId(payroll.getId());
            dto.setAmount(payroll.getAmount());
            dto.setFull_name(payroll.getFull_name());
            dto.setIs_taken(payroll.isIs_taken());
            dto.setMonth(payroll.getMonth());
            dto.setYear(payroll.getYear());

            list.add(dto);


        }
            return list;
    }
}
