package com.rchinnas.invoiceapp;

/**
 * Created by rchinnaswamy on 8/29/17.
 */

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
@Table(name="LineItem")
public class LineItem {

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name="INVOICE_ID")
    public Invoice invoice;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String description;
    private Double amount;

    protected LineItem() {}

    public LineItem(Invoice invoice, String description, Double amount) {
        this.invoice = invoice;
        this.description = description;
        this.amount = amount;
    }

    public Invoice getInvoice() {
        return invoice;
    }

    public String getDescription() {
        return description;
    }

    public Double getAmount() {
        return amount;
    }

    @Override
    public String toString() {
        return String.format("LineItem[id='%d', description='%s', amount='%f'], invoiceID='%d']", id, description, amount, invoice.getId());
    }

}
