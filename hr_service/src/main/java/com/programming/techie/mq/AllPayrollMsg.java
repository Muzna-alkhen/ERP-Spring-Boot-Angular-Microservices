package com.programming.techie.mq;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


public class AllPayrollMsg implements Serializable {

    public List<Long> employee_ids ;
    public List<String> full_names;
    public List<Integer> amounts;
    public String month;
    public String year;

    public AllPayrollMsg() {
        this.employee_ids = new ArrayList();
        this.full_names = new ArrayList();
        this.amounts = new ArrayList();

    }
}
