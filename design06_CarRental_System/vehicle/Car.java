package src.design06_CarRental_System.vehicle;

import src.design06_CarRental_System.vehicle.VehicleAttributes.Color;
import src.design06_CarRental_System.vehicle.VehicleAttributes.Manufacturer;

public class Car extends Vehicle{

    private int seats;
    private int engineCapacity;
    private int mileage;
    public Car(String registrationNumber, Color color, int yearOfManufacture, int kilometerDriven, Manufacturer manufacturer, String modelName, int perDayRentalCharge) {
        super(registrationNumber, color, yearOfManufacture, kilometerDriven, manufacturer, modelName, perDayRentalCharge);
    }

    public Car(int seats,int cap,int mil,String registrationNumber, Color color, int yearOfManufacture, int kilometerDriven, Manufacturer manufacturer, String modelName, int perDayRentalCharge) {
        super(registrationNumber, color, yearOfManufacture, kilometerDriven, manufacturer, modelName, perDayRentalCharge);
        this.seats=seats;
        this.engineCapacity=cap;
        this.mileage=mil;
    }


}
