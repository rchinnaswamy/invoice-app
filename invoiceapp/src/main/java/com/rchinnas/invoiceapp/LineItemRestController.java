package com.rchinnas.invoiceapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;


/**
 * Created by rchinnaswamy on 8/29/17.
 */
@RestController
@RequestMapping("/{invoiceCustomerName}/lineitems")
public class LineItemRestController {
    private final LineItemRepository lineItemRepo;
    private final InvoiceRepository invoiceRepo;

    @Autowired
    LineItemRestController(LineItemRepository lineItemRepo, InvoiceRepository invoiceRepo) {
        this.lineItemRepo = lineItemRepo;
        this.invoiceRepo = invoiceRepo;
    }

    @RequestMapping(method = RequestMethod.GET)
    Collection<LineItem> readLineItems(@PathVariable String invoiceCustomerName) {
        this.validateInvoice(invoiceCustomerName);
        return this.lineItemRepo.findByInvoiceCustomerName(invoiceCustomerName);
    }

    @RequestMapping(method = RequestMethod.POST)
    ResponseEntity<String> addLineItems(@PathVariable String invoiceCustomerName, @RequestBody LineItem input) {
        this.validateInvoice(invoiceCustomerName);
        Collection<Invoice> invoices = this.invoiceRepo.findInvoiceByCustomerName(invoiceCustomerName);
        LineItem item = lineItemRepo.save(new LineItem(invoices.iterator().next(),input.getDescription(),input.getAmount()));
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    private void validateInvoice(String invoiceCustomerName) {
        Collection<Invoice> invoices = this.invoiceRepo.findInvoiceByCustomerName(invoiceCustomerName);
        if(invoices == null || invoices.isEmpty())
            throw new InvoiceNotFoundException(invoiceCustomerName);
    }

    private void validateInvoice(Long id) {
        Invoice invoice = this.invoiceRepo.findInvoiceById(id);
        if(invoice == null)
            throw new InvoiceNotFoundException(id);
    }




}
