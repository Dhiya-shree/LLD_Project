package src.design02_ATM_Machine.ATMStates;

import src.design02_ATM_Machine.ATM;
import src.design02_ATM_Machine.BankInterface.UserCheckPin;

public class IdealState extends ATMState{

    @Override
    public void insertCard(ATM atm) {
        if(isUnderMaintenance){
            atm.setAtmCurrentState(new MaintenanceState());
            System.out.println(" iN select under ....");
            atm.getAtmCurrentState().underMaintenance(atm);
            return;
        }

        System.out.println(" Card can be inserted !!! ");
        atm.setAtmCurrentState(new InsertCardState());
        atm.setBankSession(new UserCheckPin());
    }
}

