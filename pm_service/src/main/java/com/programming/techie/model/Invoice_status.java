package com.programming.techie.model;

import javax.persistence.*;


@Entity
@Table(name = "invoice_status")
public class Invoice_status {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
}
