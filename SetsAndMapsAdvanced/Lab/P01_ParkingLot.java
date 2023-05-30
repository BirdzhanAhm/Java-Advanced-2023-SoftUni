/*
1. Parking Lot
        Write a program that:
        o Records car numbers for every car that enters the parking lot.
        o Removes car number when the car is out.
        When the parking lot is empty, print "Parking Lot is Empty".
        Input
        The input will be a string in the format "{direction, carNumber}".
        The input ends with the string "END".
        Output
        Print the output with all car numbers which are in the parking lot
*/


import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class P01_ParkingLot {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        Set<String> cars = new LinkedHashSet<>();

        while (!input.equals("END")) {
            String[] parts = input.split(", ");
            String direction = parts[0];
            String carsNumber = parts[1];

            if (direction.equals("IN")) {
                cars.add(carsNumber);

            } else if (direction.equals("OUT")) {
                cars.remove(carsNumber);
            } else {
                System.out.println("Undifine Direction");
            }

            input = scanner.nextLine();
        }

        if (cars.isEmpty()) {
            System.out.println("Parking Lot is Empty");
        } else {
            cars.forEach(numcars -> System.out.println(numcars));
        }

    }
}
