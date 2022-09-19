package com.bridgelabz;

import java.util.regex.Matcher;

public class InvoiceGenerator {

    private final double COST_PER_KILOMETER =10.0 ;
    private  final int COST_PER_MINUTE = 1 ;
    private final double MINIMUM_FARE = 5;

    public double calculateFare(double distance,int time){
        double fare = (distance * COST_PER_KILOMETER) + (time * COST_PER_MINUTE);
        return Math.max(MINIMUM_FARE,fare);
    }

    public double calculateFare(Ride[] rides){
        double totalFare = 0;
        for (Ride ride : rides){
            totalFare += this.calculateFare(ride.distance, ride.time);
        }
        return totalFare;
    }

    public InvoiceSummary getInvoiceSummary(Ride[] rides) {
        double totalFare = calculateFare(rides);
        return new InvoiceSummary(rides.length, totalFare);
    }

}
