package src.design02_ATM_Machine.ATMStates;

import src.design02_ATM_Machine.ATM;

public class MaintenanceState extends ATMState {

    @Override
    public void underMaintenance(ATM atm) {
        isUnderMaintenance=true;
   //     atm.setAtmCurrentState(new MaintenanceState());
       System.out.println("Under Maintenance in main ");
    }
}
