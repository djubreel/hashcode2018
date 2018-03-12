package com.wakanda.hashcode;

import java.util.ArrayList;

/**
 * @author Adeyemi Olaoye <yemi@cottacush.com>
 */
public class Vehicle {

    public Intersection location;

    public ArrayList<Ride> rides;

    private int number;

    public Vehicle(int number) {
        location = new Intersection(0, 0);
        rides = new ArrayList<Ride>();
        this.number = number;
    }

    public void setLocation(Intersection location) {
        this.location = location;
    }

    public int move(Intersection to) {
        int distance = World.getDistance(location, to);
        this.setLocation(to);
        return distance;
    }

    public int takeRide(Ride ride) {
        rides.add(ride);
        int startSteps = this.move(ride.getStartIntersection());
        int rideSteps = this.move(ride.getFinishIntersection());
        int totalSteps = startSteps + rideSteps;
        World.usedSteps += totalSteps;
        return totalSteps;
    }

    public boolean canTakeRide(Ride ride) {
        int distanceToStart = World.getDistance(location, ride.getStartIntersection());
        int totalDistance = distanceToStart + ride.getDistance();

        System.out.println("Total Distance: " + totalDistance);

        int totalSteps = totalDistance;
        return (totalSteps + World.getUsedSteps()) <= World.givenSteps && !ride.isTaken;
    }
}
