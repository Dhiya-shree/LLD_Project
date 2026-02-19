package src.design02_ATM_Machine.ATMStates;

import src.design02_ATM_Machine.ATM;
import src.design02_ATM_Machine.Card;

public class CheckBalanceState extends ATMState{

    @Override
    public void displayBalance(ATM atm, Card atmCard) {

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
        else{
            System.out.println(" User Balance for" +atmCard.getAccount().getUser().getUserName()+" is : "+atmCard.getAccount().getBalance());
            atm.setAtmCurrentState(new SelectOperationState());
        }
    }

    @Override
    public void ejectCard(ATM atm, Card atmCard) {
        super.ejectCard(atm, atmCard);
    }

    @Override
    public void exit(ATM atm) {
        super.exit(atm);
    }
}

