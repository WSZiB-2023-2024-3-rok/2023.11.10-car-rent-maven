package pl.edu.wszib.car.rent;

import pl.edu.wszib.car.rent.authorization.Authenticator;
import pl.edu.wszib.car.rent.db.VehicleRepository;
import pl.edu.wszib.car.rent.gui.GUI;

public class App {
    public static void main(String[] args) {
        VehicleRepository vehicleRepository = new VehicleRepository();
        Authenticator authenticator = new Authenticator();
        boolean run = false;
        int counter = 0;

        while(!run && counter < 3) {
            run = authenticator.authenticate(GUI.readAuthData());
            counter++;
        }

        while(run) {
            switch(GUI.showMenuAndReadChoose()) {
                case "1":
                    GUI.listVehicles(vehicleRepository.getVehicles());
                    break;
                case "2":
                    GUI.showRentResult(vehicleRepository.rent(GUI.readPlate()));
                    break;
                case "3":
                    run = false;
                    break;
                default:
                    System.out.println("Wrong choose !!");
                    break;
            }
        }
    }
}
