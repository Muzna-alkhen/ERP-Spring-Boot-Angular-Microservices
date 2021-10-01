package com.programming.techie.model;


import javax.persistence.*;

@Entity
@Table(name = "item_per_purchase_invoice")
public class Item_per_purchase_invoice {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
}
