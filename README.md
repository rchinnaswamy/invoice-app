# invoice-app
## Simple Invoice Generation Application
* Built using SpringBoot
* Uses JPA/H2 for persistence - Invoice and LineItems modeled as entities using Spring Data framework
* RESTFul services for Adding/Reading Invoices and LineItems (WORK IN PROGRESS)
* AngularJS Frontend consuming REST Services to Add invoices and Line Items (WORK IN PROGRESS)

## To Run the application:
* cd invoiceapp
* ./mvnw spring-boot:run

## The Application does the following:
* Adds two Invoices
* Adds LineItems for both the invoices
* Fetches Invoices and LineItems
* Computes total Invoice amount from the Line Items added
