package com.rchinnas.invoiceapp;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Created by rchinnaswamy on 8/30/17.
 */
@ResponseStatus(HttpStatus.NOT_FOUND)
public class InvoiceNotFoundException extends RuntimeException {
    public InvoiceNotFoundException(String customerName) {
        super("Could not find invoice for customer --> " + customerName);
    }

    public InvoiceNotFoundException(Long id) {
        super("Could not find invoice with ID --> " + id);
    }
}
