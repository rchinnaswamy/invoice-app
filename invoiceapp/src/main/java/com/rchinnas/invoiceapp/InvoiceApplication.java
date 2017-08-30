package com.rchinnas.invoiceapp;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;
import java.time.Month;

@SpringBootApplication
public class InvoiceApplication {
    private static final Logger log = LoggerFactory.getLogger(InvoiceApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(InvoiceApplication.class, args);
	}

	@Bean
	CommandLineRunner demo(InvoiceRepository invoiceRepo, LineItemRepository lineItemRepo) {

		return (args) -> {
            log.info("Saving Invoice1 with 2 line items...\n");
			Invoice invoice1 = invoiceRepo.save(new Invoice("Customer1", "customer1@intuit.com", LocalDate.of(2017, Month.DECEMBER, 20)));
			lineItemRepo.save(new LineItem(invoice1, "item1", 88.88));
			lineItemRepo.save(new LineItem(invoice1, "item2", 10.50));

            log.info("Saving Invoice2 with 4 line items...\n");
            Invoice invoice2 = invoiceRepo.save(new Invoice("Customer2", "customer2@intuit.com", LocalDate.of(2017, Month.SEPTEMBER, 5)));
			lineItemRepo.save(new LineItem(invoice2, "item1", 88.88));
			lineItemRepo.save(new LineItem(invoice2, "item2", 200.00));
			lineItemRepo.save(new LineItem(invoice2, "item3", 35.50));
			lineItemRepo.save(new LineItem(invoice2, "item4", 99.99));

            log.info("Fetching Invoice1...\n");
            Invoice fetchedInvoice1 = invoiceRepo.findInvoiceById(1L);
            log.info(fetchedInvoice1.toString());

            log.info("Fetching Line Items for Invoice2...\n");
            Double total1 = 0.0;
            for(LineItem item: lineItemRepo.findByInvoiceId(1L)) {
                log.info(item.toString() + "\n");
                total1 += item.getAmount();
            }
            log.info("Total Invoice Amount for Invoice1: " + total1);


            log.info("Fetching Invoice2...\n");
            Invoice fetchedInvoice2 = invoiceRepo.findInvoiceById(2L);
            log.info(fetchedInvoice2.toString());

            log.info("Fetching Line Items for Invoice2...\n");
            Double total2 = 0.0;
            for(LineItem item: lineItemRepo.findByInvoiceId(2L)) {
                log.info(item.toString() + "\n");
                total2 += item.getAmount();
            }
            log.info("Total Invoice Amount for Invoice2: " + total2);

            //log.info("Fetching Total Amount for Invoice1.../n");
            //log.info("Total Amount = " + lineItemRepo.findByLineItemTotalAmount(1L));

		};

	}
}
