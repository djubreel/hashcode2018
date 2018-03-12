package com.wakanda.hashcode;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        String[] inputFiles = {"a_example.in"};

        for (String inputFileName : inputFiles) {
            int bufferSize = 8 * 1024;
            BufferedReader bufferedReader = new BufferedReader(new FileReader(inputFileName), bufferSize);
            String line = bufferedReader.readLine();


            String[] worldInputs = line.split(" ");
            World world = new World(
                    Integer.parseInt(worldInputs[0]),
                    Integer.parseInt(worldInputs[1]),
                    Integer.parseInt(worldInputs[2]),
                    Integer.parseInt(worldInputs[3]),
                    Integer.parseInt(worldInputs[4]),
                    Integer.parseInt(worldInputs[5])
            );

            int numberOfRides = world.getNumberOfRides();

            for (int i = 0; i < numberOfRides; i++) {
                String[] rideInputs = bufferedReader.readLine().split(" ");
                Intersection startIntersection = new Intersection(Integer.parseInt(rideInputs[0]), Integer.parseInt(rideInputs[1]));
                Intersection finishIntersection = new Intersection(Integer.parseInt(rideInputs[2]), Integer.parseInt(rideInputs[3]));
                Ride ride = new Ride(startIntersection, finishIntersection, Integer.parseInt(rideInputs[4]), Integer.parseInt(rideInputs[5]), i);
                world.rides.add(ride);
            }

            world.runSimulation(inputFileName);
        }
    }
}
