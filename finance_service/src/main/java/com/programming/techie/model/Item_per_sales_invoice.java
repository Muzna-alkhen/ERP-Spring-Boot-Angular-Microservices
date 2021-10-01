package com.programming.techie.model;

import javax.persistence.*;


@Entity
@Table(name = "item_per_sales_invoice")
public class Item_per_sales_invoice {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
}
