package com.bridgelabz;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class InvoiceGeneratorTest {

    @Test
    public void givenDistanceAndTime_ShouldReturnTotalFare() {
        InvoiceGenerator invoiceGenerator = new InvoiceGenerator();
        double fare = invoiceGenerator.calculateFare(2.0, 5);
        Assertions.assertEquals(25, fare);
    }
    @Test
    public void givenLessDistanceAndTime_ShouldReturnMinFare() {
        InvoiceGenerator invoiceGenerator = new InvoiceGenerator();
        double fare = invoiceGenerator.calculateFare(0.1, 1);
        Assertions.assertEquals(5, fare);
    }
}
