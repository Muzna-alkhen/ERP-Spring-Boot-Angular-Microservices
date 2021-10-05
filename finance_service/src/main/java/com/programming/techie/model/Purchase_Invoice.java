package com.programming.techie.model;


import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "purchase_invoice")
public class Purchase_Invoice {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "date")
    private Date date;

    @Column(name = "payment_date")
    private Date payment_date;

    @Column(name = "total_price")
    private float total_price;

    @Column(name = "tax")
    private float tax;

    @Column(name = "total_quantity")
    private int total_quantity;

    @Column(name = "is_paid")
    private boolean is_paid;

    @OneToMany(mappedBy="invoice")
    private List<Item_per_purchase_invoice> item_per_purchase_invoiceList;


    @ManyToOne
    @JoinColumn(name="supplier")
    private Supplier supplier;

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

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Date getPayment_date() {
        return payment_date;
    }

    public void setPayment_date(Date payment_date) {
        this.payment_date = payment_date;
    }

    public float getTotal_price() {
        return total_price;
    }

    public void setTotal_price(float total_price) {
        this.total_price = total_price;
    }

    public float getTax() {
        return tax;
    }

    public void setTax(float tax) {
        this.tax = tax;
    }

    public int getTotal_quantity() {
        return total_quantity;
    }

    public void setTotal_quantity(int total_quantity) {
        this.total_quantity = total_quantity;
    }

    public boolean isIs_paid() {
        return is_paid;
    }

    public void setIs_paid(boolean is_paid) {
        this.is_paid = is_paid;
    }

    public List<Item_per_purchase_invoice> getItem_per_purchase_invoiceList() {
        return item_per_purchase_invoiceList;
    }

    public void setItem_per_purchase_invoiceList(List<Item_per_purchase_invoice> item_per_purchase_invoiceList) {
        this.item_per_purchase_invoiceList = item_per_purchase_invoiceList;
    }

    public Supplier getSupplier() {
        return supplier;
    }

    public void setSupplier(Supplier supplier) {
        this.supplier = supplier;
    }
}
