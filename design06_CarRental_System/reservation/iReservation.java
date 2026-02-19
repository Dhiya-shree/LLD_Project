package src.design06_CarRental_System.reservation;

import src.design06_CarRental_System.car_rental_app.Location;
import src.design06_CarRental_System.car_rental_app.RentalLot;
import src.design06_CarRental_System.vehicle.Vehicle;

import java.util.Date;

public interface iReservation {
    boolean reserveVehicle(Vehicle vehicle, Date startDate, Date endDate, RentalLot pickUp, RentalLot DropOff);
}