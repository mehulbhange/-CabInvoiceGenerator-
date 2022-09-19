package com.bridgelabz;

public class Ride {
    public final int time;
    public double distance;
    RideType type;
    public Ride(double distance, int time){
        this.distance = distance;
        this.time = time;
    }

    public Ride(double distance,int time, RideType type) {
        this.time = time;
        this.distance = distance;
        this.type = type;
    }
}
