package com.programming.techie.model;


import javax.persistence.*;

@Entity
@Table(name = "purchase_invoice")
public class Purchase_Invoice {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
}
