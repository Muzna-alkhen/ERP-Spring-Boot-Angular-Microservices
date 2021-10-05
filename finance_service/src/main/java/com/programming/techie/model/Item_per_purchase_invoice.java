package com.programming.techie.model;


import javax.persistence.*;

@Entity
@Table(name = "item_per_purchase_invoice")
public class Item_per_purchase_invoice {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "quantity")
    private int quantity;

    @Column(name = "amount")
    private float amount;


    @ManyToOne
    @JoinColumn(name="invoice")
    private Purchase_Invoice invoice;


    @ManyToOne
    @JoinColumn(name="item")
    private Item item;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public float getAmount() {
        return amount;
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }

    public Purchase_Invoice getInvoice() {
        return invoice;
    }

    public void setInvoice(Purchase_Invoice invoice) {
        this.invoice = invoice;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }
}
