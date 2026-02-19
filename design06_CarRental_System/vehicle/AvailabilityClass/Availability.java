package src.design06_CarRental_System.vehicle.AvailabilityClass;

import java.util.*;

public class Availability {
    List<DateRange> dateRangeList;

    public Availability() {
        this.dateRangeList = new ArrayList<>();
    }

    public void addDateRange(Date a,Date b){
        DateRange dr=new DateRange(a,b);
        dateRangeList.add(dr);
        Collections.sort(this.dateRangeList);
    }

    public void removeDateRange(DateRange dr){
        dateRangeList.remove(dr);
    }

    public boolean CheckAvailability(Date pickUp, Date dropOff){
        if(dateRangeList.isEmpty()){
            dateRangeList.add(new DateRange(pickUp,dropOff));
            return true;
        }

        DateRange prev= dateRangeList.get(0);

            if(dropOff.compareTo(prev.getStartDate())<0){
           //     dateRangeList.add(new DateRange(pickUp,dropOff));
                return true;
            }
            if(pickUp.compareTo(dateRangeList.get(dateRangeList.size()-1).getEndDate())>0){
            //    dateRangeList.add(new DateRange(pickUp,dropOff));
                return true;
            }

        for(DateRange dr:dateRangeList) {
              if(pickUp.after(prev.getEndDate()) && dropOff.before(dr.getStartDate())){
                //  dateRangeList.add(new DateRange(pickUp,dropOff));
                  return true;
        }
              prev=dr;
        }
            return false;

    }
}
