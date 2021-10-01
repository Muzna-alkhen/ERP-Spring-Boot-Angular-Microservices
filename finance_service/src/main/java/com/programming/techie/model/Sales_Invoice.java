package com.programming.techie.model;


import javax.persistence.*;

@Entity
@Table(name = "sales_invoice")
public class Sales_Invoice {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


}
