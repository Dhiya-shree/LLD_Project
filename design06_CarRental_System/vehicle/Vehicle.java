package src.design06_CarRental_System.vehicle;

import src.design06_CarRental_System.vehicle.AvailabilityClass.Availability;
import src.design06_CarRental_System.vehicle.VehicleAttributes.Color;
import src.design06_CarRental_System.vehicle.VehicleAttributes.Manufacturer;
import src.design06_CarRental_System.vehicle.AvailabilityClass.Status;

public abstract class Vehicle {
    private String registrationNumber;
    private Color color;
    private int yearOfManufacture;
    private int kilometerDriven;
    private Manufacturer manufacturer;
    private String modelName;
    private int perDayRentalCharge;
    private Status status;
    private Availability availabiliy;

    public Vehicle(String registrationNumber, Color color, int yearOfManufacture, int kilometerDriven, Manufacturer manufacturer, String modelName, int perDayRentalCharge) {
        this.registrationNumber = registrationNumber;
        this.color = color;
        this.yearOfManufacture = yearOfManufacture;
        this.kilometerDriven = kilometerDriven;
        this.manufacturer = manufacturer;
        this.modelName = modelName;
        this.perDayRentalCharge = perDayRentalCharge;
        this.availabiliy= new Availability();
        this.status=Status.AVAILABLE;
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public Color getColor() {
        return color;
    }

    public int getYearOfManufacture() {
        return yearOfManufacture;
    }

    public int getKilometerDriven() {
        return kilometerDriven;
    }

    public Manufacturer getManufacturer() {
        return manufacturer;
    }

    public String getModelName() {
        return modelName;
    }

    public int getPerDayRentalCharge() {
        return perDayRentalCharge;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status){
         this.status=status;
    }

    public Availability getAvailabiliy() {
        return availabiliy;
    }
}
