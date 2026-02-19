package src.design06_CarRental_System.search;

import src.design06_CarRental_System.car_rental_app.Location;
import src.design06_CarRental_System.vehicle.Vehicle;

import java.util.Date;
import java.util.List;

public interface iSearch {
     List<Vehicle> getVehicle(Date startDate, Date endDate, Location pickUp, Location dropOff,
                                    int searchRadius);
}
