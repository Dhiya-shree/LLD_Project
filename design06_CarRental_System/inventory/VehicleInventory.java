package src.design06_CarRental_System.inventory;

import src.design06_CarRental_System.car_rental_app.Location;
import src.design06_CarRental_System.vehicle.Vehicle;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
public class VehicleInventory implements Inventory{

    private List<Vehicle> vehicleList;
   // private Map<VehicleType,List<Vehicle>> indexedData;
    // Query in Vehicle list based on type

    public void VehicleInventory(){
        this.vehicleList=new ArrayList<>();
    }

    public List<Vehicle> getVehicles(Date startDate, Date endDate){
        // Consider only dates
        List<Vehicle> vehi=new ArrayList<>();
        for(Vehicle v:vehicleList){
            if(v.getAvailabiliy().CheckAvailability(startDate,endDate)){
                vehi.add(v);
            }
        }
        return vehi;
    }

    public void addVehicle(Vehicle vehicle){
        vehicleList.add(vehicle);
    }

    public void removeVehicle(String regNo){
        for(Vehicle v: vehicleList){
           if(v.getRegistrationNumber().equalsIgnoreCase(regNo)){
              vehicleList.remove(v); break;
           }

        }
    }

}
