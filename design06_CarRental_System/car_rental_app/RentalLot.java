package src.design06_CarRental_System.car_rental_app;

import src.design06_CarRental_System.inventory.Inventory;
import src.design06_CarRental_System.inventory.VehicleInventory;

public class RentalLot {

    private Location location;
    private Inventory inventory;

    public void RentalLot(Location location){
         this.location=location;
         this.inventory=new VehicleInventory();
     }

    public Location getLocation() {
        return location;
    }

    public Inventory getInventory() {
        return inventory;
    }
}
