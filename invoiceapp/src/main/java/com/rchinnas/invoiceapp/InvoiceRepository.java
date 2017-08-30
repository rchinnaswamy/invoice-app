/**
 * Created by rchinnaswamy on 8/29/17.
 */
package com.rchinnas.invoiceapp;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


public interface InvoiceRepository extends JpaRepository<Invoice, Long> {
    List<Invoice> findInvoiceByCustomerName(String customerName);
    List<Invoice> findInvoiceByCustomerEmail(String customerEmail);
    Invoice findInvoiceById(Long id);

    /*@Query(value= "select SUM(lm.amount) from Invoice iv, LineItem lm where iv.id = ?1 and iv.id = lm.invoice_id", nativeQuery = true)
    Double findTotalAmount(Long id);*/
}
