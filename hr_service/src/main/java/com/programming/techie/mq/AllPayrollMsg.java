package com.programming.techie.mq;

import java.io.Serializable;


public class AllPayrollMsg implements Serializable {

    public Long[] employees_id;
    public String[] full_name;
    public int[] amount;
    public String month;
    public String year;



}
