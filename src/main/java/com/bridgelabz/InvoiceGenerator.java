package com.bridgelabz;

import java.util.regex.Matcher;

public class InvoiceGenerator {

    private double COST_PER_KILOMETER;
    private int COST_PER_MINUTE;
    private double MINIMUM_FARE;

    private RideRepository rideRepository = new RideRepository();

    public InvoiceGenerator(){}

    private void setCost(RideType type){
        if (type == RideType.PREMIUM_RIDE){
            COST_PER_KILOMETER = 15.0;
            COST_PER_MINUTE = 2;
            MINIMUM_FARE = 20.0;
        }else {
            COST_PER_KILOMETER = 10.0;
            COST_PER_MINUTE = 1;
            MINIMUM_FARE = 5.0;
        }
    }

    public double calculateFare(double distance,int time){
        double fare = (distance * COST_PER_KILOMETER) + (time * COST_PER_MINUTE);
        return Math.max(MINIMUM_FARE,fare);
    }

    public double calculateFare(Ride[] rides){
        double totalFare = 0;
        for (Ride ride : rides){
            totalFare += this.calculateFare(ride.type,ride.distance, ride.time);
        }
        return totalFare;
    }

    public InvoiceSummary getInvoiceSummary(Ride[] rides) {
        double totalFare = calculateFare(rides);
        return new InvoiceSummary(rides.length, totalFare);
    }

    public void addRides(String userId, Ride[] rides) {
        rideRepository.addRide(userId, rides);
    }

    public InvoiceSummary getInvoiceSummary(String userId) {
        return this.getInvoiceSummary(rideRepository.getRides(userId));
    }

    public double calculateFare(RideType type,double distance,int time){
        setCost(type);
        double fare = (distance * COST_PER_KILOMETER) + (time * COST_PER_MINUTE);
        return Math.max(MINIMUM_FARE,fare);
    }

}
