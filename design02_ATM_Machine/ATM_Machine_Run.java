package src.design02_ATM_Machine;

import src.design02_ATM_Machine.ATMStates.ATMState;
import src.design02_ATM_Machine.ATMStates.IdealState;
import src.design02_ATM_Machine.ATMStates.MaintenanceState;
import src.design02_ATM_Machine.ATMStates.OperationType;

public class ATM_Machine_Run {

    public static void main(String[] args) {

        ATM atm=new ATM(10,10,10,10);
        //Dummy card
        Card card=new Card("Not expired",1134,"1234567812345678",888);
        System.out.println(" Put you card .....");
        atm.getAtmCurrentState().authenticatePin(atm,card,1134);
      //  atm.getAtmCurrentState().changePin(atm,card,1134,1234);
        atm.getAtmCurrentState().selectOperation(atm,card, OperationType.CHANGE_PIN);
        atm.getAtmCurrentState().changePin(atm,card,1134,1234);

       atm.getAtmCurrentState().selectOperation(atm,card, OperationType.DISPLAY_BALANCE);
        atm.getAtmCurrentState().displayBalance(atm,card);

   //     atm.getAtmCurrentState().cashWithdraw(atm,card,23566);
        atm.getAtmCurrentState().selectOperation(atm,card, OperationType.CASH_WITHDRAW);
        atm.getAtmCurrentState().cashWithdraw(atm,card,2350);

        atm.getAtmCurrentState().selectOperation(atm,card, OperationType.DISPLAY_BALANCE);
        atm.getAtmCurrentState().displayBalance(atm,card);

        //Under
        //spec
      //  atm.setAtmCurrentState(new MaintenanceState());
        atm.getAtmCurrentState().isUnderMaintenance=true;
        //INSTANCE OF

        ATMState state =new MaintenanceState();
        System.out.println(" Main "+(state instanceof MaintenanceState));
        System.out.println(" ATMS "+(state instanceof ATMState));
        System.out.println(" ATMS "+(state instanceof IdealState));


        ATMState state2 =new ATMState();
        System.out.println(" Main "+(state2 instanceof MaintenanceState));
        System.out.println(" ATMS "+(state2 instanceof ATMState));

        MaintenanceState state3 =new MaintenanceState();
        System.out.println(" Main "+(state3 instanceof MaintenanceState));
        System.out.println(" ATMS "+(state3 instanceof ATMState));

        System.out.println(" Current "+(atm.getAtmCurrentState() instanceof MaintenanceState));
        System.out.println(" Current "+(atm.getAtmCurrentState().isUnderMaintenance));
        atm.getAtmCurrentState().selectOperation(atm,card, OperationType.CASH_WITHDRAW);

    }
}
