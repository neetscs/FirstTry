package edu.neetu.questions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * User: neetu
 * Date: 6/7/13
 * Time: 12:45 PM
 */
public class Question15 {

    public static void main(String[] args){

        ArrayList <Vehicle> vehicles= new ArrayList<>();
        int counter = 0;

        Bike bike = new Bike();
        vehicles.add(bike);

        Boat boat = new Boat();
        vehicles.add(boat);

        ToyotaCamry toyotaCamry = new ToyotaCamry();
        vehicles.add(toyotaCamry);

        SUV suv = new SUV();
        vehicles.add(suv);

        Helicopter helicopter = new Helicopter();
        vehicles.add(helicopter);

        while (counter < vehicles.size()){
            displayVehicles(vehicles.get(counter));
            counter++;
        }

        System.out.println("Enter the Vehicle name from the list above that u have access to (Separate your choices by space): ");
        Scanner scanner = new Scanner(System.in);

        String vehiclesChosen = scanner.nextLine();

        System.out.println("How far is your destination? (Enter distance in miles): ");
        int distance = new Integer(scanner.next());

        counter = 0;
        ArrayList<String> choice = findEachVehicleFrom(vehiclesChosen);

        while (counter < vehicles.size()) {
            displayResult(choice, vehicles.get(counter), distance);
            counter++;
        }
    }

    private static void displayResult(ArrayList<String> choice, Vehicle vehicle, int distance) {
        int time = 0;
        double noOfGallonsNeeded = 0, noOfGallonsUsed = 0;

        if (choice.contains(vehicle.getVehicleType())){
            System.out.println("For " + vehicle.getVehicleType() + ":");
            time = distance / vehicle.getMaximumSpeed();
            System.out.println("The total amount of time required to reach your destinations is: " + time + "hrs.");
            noOfGallonsUsed = time * vehicle.getFuelConsumedPerHour();

            if(noOfGallonsUsed > vehicle.getFuelInTank()){
                noOfGallonsNeeded = Math.ceil((noOfGallonsUsed - vehicle.getFuelInTank())/vehicle.getFuelInTank());
                System.out.println("You need " + noOfGallonsNeeded +" refills before you reach your destination");
            }
            else
                System.out.println("You need no refills before you reach your destination");
        }
    }

    private static ArrayList<String> findEachVehicleFrom(String vehiclesChosen) {
        ArrayList<String> choice = new ArrayList<>();
        int counter = 0;
        int spaceLocation = vehiclesChosen.indexOf(" ");
        if (spaceLocation == -1){
            choice.add(vehiclesChosen);
        }
        while (spaceLocation != -1) {

            choice.add(vehiclesChosen.substring(counter,spaceLocation));
            counter = spaceLocation + 1;
            spaceLocation = vehiclesChosen.indexOf(" ", counter + 1);
            if (spaceLocation == -1) {
                choice.add(vehiclesChosen.substring(counter));
            }
        }
        return choice;
    }

    private static void displayVehicles(Vehicle vehicle) {
        System.out.println(vehicle.getVehicleType() + " : " +vehicle.getCapacity() + " person, " + vehicle.getFuelInTank() + " gallons of fuel, "
                + vehicle.getFuelConsumedPerHour() + " gal/hr, " + "@" +vehicle.getMaximumSpeed() + "mph");

    }

    public static class Vehicle{
        int capacity;
        int fuelInTank;
        int maximumSpeed;
        double fuelConsumedPerHour;
        String vehicleType;

        public Vehicle(int newCapacity, int newFuelInTank, int newMaximumSpeed, double newFuelConsumedPerHour, String newType) {
            capacity = newCapacity;
            fuelInTank = newFuelInTank;
            maximumSpeed = newMaximumSpeed;
            fuelConsumedPerHour = newFuelConsumedPerHour;
            vehicleType = newType;
        }

        public int getCapacity() {
            return capacity;
        }

        public double getFuelConsumedPerHour() {
            return fuelConsumedPerHour;
        }

        public int getMaximumSpeed() {
            return maximumSpeed;
        }

        public int getFuelInTank() {
            return fuelInTank;
        }

        public String getVehicleType() {
            return vehicleType;
        }
    }

    public static class Bike extends Vehicle{

        public Bike() {
            super(1, 5, 65, 0.5, "Bike");
        }
    }

    public static class Boat extends Vehicle{

        public Boat() {
            super(3, 10, 35, 1, "Boat");
        }
    }

    public static class ToyotaCamry extends Vehicle{

        public ToyotaCamry() {
            super(4, 15, 80, 0.4, "Toyota Camry");
        }
    }

    public static class SUV extends Vehicle{

        public SUV() {
            super(8, 18, 80, 0.6, "SUV");
        }
    }

    public static class Helicopter extends Vehicle{

        public Helicopter() {
            super(2, 10, 100, 2.2, "Helicopter");
        }
    }
}
