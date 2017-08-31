package com.rchinnas.invoiceapp;

/**
 * Created by rchinnaswamy on 8/29/17.
 */
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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

    @GetMapping
    Collection<Invoice> readInvoiceByCustomerName(@RequestParam(value="customerName") String customerName) {
            return this.invoiceRepo.findInvoiceByCustomerName(customerName);
    }

    @PostMapping
    ResponseEntity<String> addInvoice(@RequestBody Invoice input) {
        Invoice result = invoiceRepo.save(new Invoice(input.getCustomerName(), input.getCustomerEmail(), input.getDueDate()));
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }


}
