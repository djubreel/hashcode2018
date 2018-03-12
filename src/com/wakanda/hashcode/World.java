package com.wakanda.hashcode;

import java.io.*;
import java.util.ArrayList;

/**
 * @author Adeyemi Olaoye <yemi@cottacush.com>
 */
public class World {

    private int rows;
    private int columns;
    private int numberOfVehicles;
    private int numberOfRides;
    private int bonus;
    public static int usedSteps = 0;
    public static int givenSteps;
    public ArrayList<Vehicle> fleet = new ArrayList<>();
    public ArrayList<Ride> rides = new ArrayList<>();


    public World(int rows, int columns, int numberOfVehicles, int numberOfRides, int bonus, int steps) {
        this.setRows(rows);
        this.setColumns(columns);
        this.setNumberOfRides(numberOfRides);
        this.setBonus(bonus);

        for (int i = 0; i < numberOfVehicles; i++) {
            Vehicle vehicle = new Vehicle(i + 1);
            fleet.add(vehicle);
        }

        givenSteps = steps;
    }

    public int getRows() {
        return rows;
    }

    public void setRows(int rows) {
        this.rows = rows;
    }

    public int getColumns() {
        return columns;
    }

    public void setColumns(int columns) {
        this.columns = columns;
    }

    public int getNumberOfVehicles() {
        return numberOfVehicles;
    }

    public void setNumberOfVehicles(int numberOfVehicles) {
        this.numberOfVehicles = numberOfVehicles;
    }

    public int getNumberOfRides() {
        return numberOfRides;
    }

    public void setNumberOfRides(int numberOfRides) {
        this.numberOfRides = numberOfRides;
    }

    public int getBonus() {
        return bonus;
    }

    public void setBonus(int bonus) {
        this.bonus = bonus;
    }

    public static int getUsedSteps() {
        return usedSteps;
    }

    public void setUsedSteps(int usedSteps) {
        this.usedSteps = usedSteps;
    }

    public static int getDistance(Intersection start, Intersection end) {
        return Math.abs(start.getX() - end.getX()) + Math.abs(start.getY() - end.getY());
    }

    public void runSimulation(String inputFileName) throws FileNotFoundException, UnsupportedEncodingException {

        int current = 0;
        int stepsUsedInRun = 0;

        for (Ride ride : rides) {
            if (ride.isTaken) {
                current++;
                continue;
            }

            Vehicle vehicle = fleet.get(current);
            if (!vehicle.canTakeRide(ride)) {
                continue;
            }

            int stepsUsed = vehicle.takeRide(ride);
            System.out.println("Steps Used " + stepsUsed);
            stepsUsedInRun += stepsUsed;
            ride.isTaken = true;
            current++;
            if (current == fleet.size()) {
                current = 0;
            }
        }


        generateOutput("out/" + inputFileName + ".out");

    }

    public void generateOutput(String outPutFileName) throws FileNotFoundException, UnsupportedEncodingException {

        PrintWriter writer = new PrintWriter(outPutFileName, "UTF-8");
        for (Vehicle vehicle : fleet) {
            ArrayList<Ride> rides = vehicle.rides;
            writer.print(rides.size());
            writer.print(" ");

            for (Ride ride : rides) {
                writer.print(ride.number);
                writer.print(" ");
            }

            writer.println();
        }

        writer.close();
    }
}
