package com.bridgelabz;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class InvoiceGeneratorTest {

    InvoiceGenerator invoiceGenerator = new InvoiceGenerator();
    @Test
    public void givenDistanceAndTime_ShouldReturnTotalFare() {
        double fare = invoiceGenerator.calculateFare(2.0, 5);
        Assertions.assertEquals(25, fare);
    }
    @Test
    public void givenLessDistanceAndTime_ShouldReturnMinFare() {
        double fare = invoiceGenerator.calculateFare(0.1, 1);
        Assertions.assertEquals(5, fare);
    }

    @Test
    public void givenMultipleRides_ShouldReturnTotalFare() {
        Ride[] rides = {
                new Ride(2.0, 5),
                new Ride(0.1, 1)
        };
        double fare = invoiceGenerator.calculateFare(rides);
        Assertions.assertEquals(30, fare);
    }

    @Test
    public void givenMultipleRides_ShouldReturnInvoiceSummary() {
        Ride[] rides = { new Ride(25, 30),
                new Ride(12, 20)
        };
        InvoiceSummary invoiceSummary = invoiceGenerator.getInvoiceSummary(rides);
        InvoiceSummary summary = new InvoiceSummary(2, 420);
        Assertions.assertEquals(summary, invoiceSummary);
    }
    @Test
    public void givenUserId_shouldReturnInvoiceSummary() {
        String userId = "101";
        Ride[] rides ={new Ride(2.0,5),
                new Ride(0.1,1)};
        invoiceGenerator.addRides(userId,rides);
        InvoiceSummary summary=invoiceGenerator.getInvoiceSummary(rides);
        InvoiceSummary invoiceSummary = invoiceGenerator.getInvoiceSummary(userId);
        Assertions.assertEquals(invoiceSummary, summary);

    }

}
