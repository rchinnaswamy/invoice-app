package com.rchinnas.invoiceapp;
/**
 * Created by rchinnaswamy on 8/29/17.
 */
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Collection;

public interface LineItemRepository extends JpaRepository<LineItem, Long> {
    Collection<LineItem> findByInvoiceCustomerName(String customerName);
    Collection<LineItem> findByInvoiceId(Long id);
    LineItem findById(Long id);

    /*Query("select SUM(amount) from LineItem where INVOICE_ID = ?1")
    Double findByLineItemTotalAmount(Long id);*/
}
