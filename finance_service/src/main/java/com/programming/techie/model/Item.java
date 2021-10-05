package com.programming.techie.model;


import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "item")
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;


    @Column(name = "price")
    private float price;

    @OneToMany(mappedBy="item")
    private List<Item_per_purchase_invoice> item_per_purchase_invoiceList;


    @OneToMany(mappedBy="item")
    private List<Item_per_sales_invoice> item_per_sales_invoiceList;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public List<Item_per_purchase_invoice> getItem_per_purchase_invoiceList() {
        return item_per_purchase_invoiceList;
    }

    public void setItem_per_purchase_invoiceList(List<Item_per_purchase_invoice> item_per_purchase_invoiceList) {
        this.item_per_purchase_invoiceList = item_per_purchase_invoiceList;
    }

    public List<Item_per_sales_invoice> getItem_per_sales_invoiceList() {
        return item_per_sales_invoiceList;
    }

    public void setItem_per_sales_invoiceList(List<Item_per_sales_invoice> item_per_sales_invoiceList) {
        this.item_per_sales_invoiceList = item_per_sales_invoiceList;
    }
}
