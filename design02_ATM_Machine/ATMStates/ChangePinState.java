package src.design02_ATM_Machine.ATMStates;

import src.design02_ATM_Machine.ATM;
import src.design02_ATM_Machine.Card;

public class ChangePinState extends ATMState{

    @Override
    public void ejectCard(ATM atm, Card atmCard) {
        super.ejectCard(atm, atmCard);
    }

    @Override
    public void exit(ATM atm) {
        super.exit(atm);
    }

    @Override
    public void changePin(ATM atm, Card atmCard, int pin, int newPin) {


        if(isUnderMaintenance){
            atm.setAtmCurrentState(new MaintenanceState());
            System.out.println(" iN select under ....");
            atm.getAtmCurrentState().underMaintenance(atm);
            return;
        }

        if(!atm.getBankSession().IsAuthenticated){
            System.out.println(" Session Expired ");
            ejectCard(atm,atmCard);
            exit(atm);
        }
        else if(pin!= atmCard.getPin()){
            System.out.println(" Old pin incorrect");
            ejectCard(atm,atmCard);
            exit(atm);
        }
        else{
            System.out.println(" Changing to new pin  "+newPin);

            //API set pin details
            atm.getBankSession().SetPin(newPin,atmCard);

            atm.setAtmCurrentState(new SelectOperationState());
        }
    }
}
