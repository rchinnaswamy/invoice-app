package com.rchinnas.invoiceapp;

/**
 * Created by rchinnaswamy on 8/29/17.
 */

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;


@Entity
@Table(name="Invoice")
public class Invoice {

    @OneToMany(mappedBy = "invoice", fetch=FetchType.EAGER)
    private Set<LineItem> lineItems = new HashSet<>();

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    public Set<LineItem> getLineItems() {
        return lineItems;
    }

    public Long getId() {
        return id;
    }

    public String getCustomerEmail() {
        return customerEmail;
    }

    public String getCustomerName() {
        return customerName;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public Double getInvoiceTotal() {
        if(lineItems.isEmpty())
            return 0.0;
        for(LineItem item : lineItems ) {
            invoiceTotal += item.getAmount();
        }
        return invoiceTotal;
    }

    private String customerEmail;
    private String customerName;
    private LocalDate dueDate;
    private Double invoiceTotal;

    public Invoice(String name, String customerEmail, LocalDate dueDate) {
        this.customerName = name;
        this.customerEmail = customerEmail;
        this.dueDate = dueDate;
        this.invoiceTotal = 0.0;
    }

    protected Invoice() {} // jpa only

    @Override
    public String toString() {
        return String.format("Invoice[id='%d', customerName='%s', customerEmail='%s', dueDate='%s, invoiceTotal='%f']", id, customerName, customerEmail, dueDate, this.getInvoiceTotal());
    }
}
