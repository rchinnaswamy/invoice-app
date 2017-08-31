/**
 * Created by rchinnaswamy on 8/29/17.
 */
package com.rchinnas.invoiceapp;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.Collection;


public interface InvoiceRepository extends JpaRepository<Invoice, Long> {
    Collection<Invoice> findInvoiceByCustomerName(String customerName);
    Collection<Invoice> findInvoiceByCustomerEmail(String customerEmail);
    Invoice findInvoiceById(Long id);

    //TODO: Fix query to find total amount from the repository layer
    /*@Query(value= "select SUM(lm.amount) from Invoice iv, LineItem lm where iv.id = ?1 and iv.id = lm.invoice_id", nativeQuery = true)
    Double findTotalAmount(Long id);*/
}
