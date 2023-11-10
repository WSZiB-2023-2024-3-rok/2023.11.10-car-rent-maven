package pl.edu.wszib.car.rent.db;

import pl.edu.wszib.car.rent.model.Car;
import pl.edu.wszib.car.rent.model.Motorcycle;
import pl.edu.wszib.car.rent.model.Truck;
import pl.edu.wszib.car.rent.model.Vehicle;

public class VehicleRepository {
    private final Vehicle[] vehicles = new Vehicle[8];

    public VehicleRepository() {
        this.vehicles[0] = new Car("BMW", "5", 500.00, 2020, "KR11");
        this.vehicles[1] = new Car("Audi", "A5", 550.00, 2021, "KR22");
        this.vehicles[2] = new Car("Toyota", "Corolla", 300.00, 2019, "KR33");
        this.vehicles[3] = new Car("Kia", "Ceed", 200.00, 2018, "KR44");
        this.vehicles[4] = new Car("Fiat", "126p", 100.00, 1990, "KR55");
        this.vehicles[5] =
                new Motorcycle("BMW", "S1000", 200.00, 2020, "KR66", 2);
        this.vehicles[6] =
                new Motorcycle("Suzuki", "Super", 200.00, 2020, "KR77", 3);
        this.vehicles[7] =
                new Truck("Scania", "Turbo", 700.00, 2010, "KR88", 4000);
    }

    public Vehicle[] getVehicles() {
        return this.vehicles;
    }

    public boolean rent(String plate) {
        for(Vehicle vehicle : this.vehicles) {
            if(vehicle.getPlate().equals(plate) && !vehicle.isRent()) {
                vehicle.setRent(true);
                return true;
            }
        }
        return false;
    }
}
