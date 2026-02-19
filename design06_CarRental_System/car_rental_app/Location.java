package src.design06_CarRental_System.car_rental_app;

import src.design06_CarRental_System.vehicle.VehicleAttributes.Coordinate;

public class Location {
    private String id;
    private String city;
    private Coordinate coordinate;

    public Location(String id, String city, Coordinate coordinate) {
        this.id = id;
        this.city = city;
        this.coordinate = coordinate;
    }

    public String getId() {
        return id;
    }

    public String getCity() {
        return city;
    }

    public Coordinate getCoordinate() {
        return coordinate;
    }
}
