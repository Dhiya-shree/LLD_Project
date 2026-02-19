package src.design06_CarRental_System.car_rental_app;

import src.design06_CarRental_System.reservation.Reservation;
import src.design06_CarRental_System.reservation.iReservation;
import src.design06_CarRental_System.search.iSearch;
import src.design06_CarRental_System.vehicle.AvailabilityClass.Status;
import src.design06_CarRental_System.vehicle.Vehicle;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class VehicleRentalService implements iSearch, iReservation {

    private List<RentalLot> rentalLotList;
    private List<Reservation> reservationList;

    public VehicleRentalService() {
        this.rentalLotList = new ArrayList<>();
        this.reservationList = new ArrayList<>();
    }

    public void addRentalLot(RentalLot rental){
        this.rentalLotList.add(rental);
    }

    public void addReservationList(Reservation reservation) {
        this.reservationList.add(reservation);
    }

    public List<Vehicle> getVehicle(Date startDate, Date endDate, Location pickUp, Location dropOff,
                                    int searchRadius){

        List<Vehicle> empty =new ArrayList<>();
        List<RentalLot> usableLots=new ArrayList<>();
        // list of lots nearer to pick up location
        // list of vehicles based on availability
        // Sort based on price
        for(RentalLot rl:rentalLotList){
            if(Math.abs(pickUp.getCoordinate().getLatitude()-
                    rl.getLocation().getCoordinate().getLatitude())<=searchRadius
                && Math.abs(pickUp.getCoordinate().getLongitude()-
                    rl.getLocation().getCoordinate().getLongitude())<=searchRadius)
            {
                usableLots.add(rl);
            }
        }

        if(usableLots.isEmpty()){
            System.out.println(" No nearby Cars !!!! Showing all the cars based on city. Kindly reset you searchRadius");
            for(RentalLot rl:rentalLotList){
                if(rl.getLocation().getCity().equalsIgnoreCase(pickUp.getCity())){
                    usableLots.add(rl);
                }
            }
        }

        if(usableLots.isEmpty()){
            System.out.println(" OOPS no cars ");
            return empty;
        }

        for(RentalLot rl:usableLots){
            empty.addAll(rl.getInventory().getVehicles(startDate,endDate));
        }
        return empty;
    }

    public boolean reserveVehicle(Vehicle vehicle,Date startDate,Date endDate,RentalLot pickUp,RentalLot dropOff){

       if( vehicle.getAvailabiliy().CheckAvailability(startDate,endDate)){
           vehicle.getAvailabiliy().addDateRange(startDate,endDate);
           vehicle.setStatus(Status.BOOKED);
           reservationList.add(new Reservation());
           pickUp.getInventory().removeVehicle(vehicle.getRegistrationNumber());
           dropOff.getInventory().addVehicle(vehicle);
           return true;
       }

        return false;
    }

    public boolean returnVehicle(Reservation reservation){
        return true;
    }
}
