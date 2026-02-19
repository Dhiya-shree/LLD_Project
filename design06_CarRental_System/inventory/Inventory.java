package src.design06_CarRental_System.inventory;

import src.design06_CarRental_System.car_rental_app.Location;
import src.design06_CarRental_System.vehicle.Vehicle;

import java.util.Date;
import java.util.List;

public interface Inventory {
    List<Vehicle> getVehicles(Date startDate, Date endDate);
    void addVehicle(Vehicle vehicle);
    void removeVehicle(String regNo);
}

