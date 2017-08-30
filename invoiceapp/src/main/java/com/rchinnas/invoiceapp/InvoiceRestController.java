package com.rchinnas.invoiceapp;

/**
 * Created by rchinnaswamy on 8/29/17.
 */
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;

@RestController
@RequestMapping("/invoice")
public class InvoiceRestController {
    private final InvoiceRepository invoiceRepo;

    @Autowired
    InvoiceRestController(InvoiceRepository invoiceRepo) {
        this.invoiceRepo = invoiceRepo;
    }

    @RequestMapping(method = RequestMethod.GET)
    List<Invoice> readInvoiceByCustomerName(@RequestParam(value="customerName", defaultValue = "customer1") String customerName) {
        return this.invoiceRepo.findInvoiceByCustomerName(customerName);
    }

    /*@RequestMapping(method = RequestMethod.POST)
    ResponseEntity<?> addInvoice(@RequestBody Invoice input) {
        Invoice result = invoiceRepo.save(new Invoice(input.getCustomerName(), input.getCustomerEmail(), input.getDueDate()));

    }*/


}
