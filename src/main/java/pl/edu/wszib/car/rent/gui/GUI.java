package pl.edu.wszib.car.rent.gui;

import pl.edu.wszib.car.rent.authorization.Authenticator;
import pl.edu.wszib.car.rent.model.Car;
import pl.edu.wszib.car.rent.model.LuxuryCar;
import pl.edu.wszib.car.rent.model.User;
import pl.edu.wszib.car.rent.model.Vehicle;

import java.util.Collection;
import java.util.Scanner;

public class GUI {
    private final static Scanner scanner = new Scanner(System.in);
    public static String showMenuAndReadChoose() {
        System.out.println("1. List cars");
        System.out.println("2. Rent car");
        System.out.println("3. Return car");
        System.out.println("4. Exit");
        return scanner.nextLine();
    }

    public static void listCars(Car[] cars) {
        for(Car car : cars) {
            System.out.println(car);
        }
    }

    public static void listVehicles(Collection<Vehicle> vehicles) {
        for(Vehicle vehicle : vehicles) {
            if(vehicle instanceof LuxuryCar &&
                    !Authenticator.loggedUser.getRole().equals("ADMIN")) {
                continue;
            }
            System.out.println(vehicle);
        }
    }

    public static String readPlate() {
        System.out.println("Enter plate:");
        return scanner.nextLine();
    }

    public static void showResult(boolean result) {
        if(result) {
            System.out.println("Success !!");
        } else {
            System.out.println("Error !!");
        }
    }

    public static User readAuthData() {
        System.out.println("Login:");
        String login = scanner.nextLine();
        System.out.println("Password:");
        return new User(login, scanner.nextLine());
    }
}
