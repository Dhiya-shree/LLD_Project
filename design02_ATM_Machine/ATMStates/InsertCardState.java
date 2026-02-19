package src.design02_ATM_Machine.ATMStates;

import src.design02_ATM_Machine.ATM;
import src.design02_ATM_Machine.BankInterface.UserDetailAPI;
import src.design02_ATM_Machine.Card;

public class InsertCardState extends ATMState{

    static int retry;

    @Override
    public void authenticatePin(ATM atm, Card atmCard, int pin) {

        if(isUnderMaintenance){
            atm.setAtmCurrentState(new MaintenanceState());
            System.out.println(" iN select under ....");
            atm.getAtmCurrentState().underMaintenance(atm);
            return;
        }
        System.out.println(" User input pin .....: "+pin);
        atm.getBankSession().CheckPin(pin);

        if(!atm.getBankSession().IsAuthenticated && retry>5){
            ejectCard(atm,atmCard);
            exit(atm);
        }
        else if(!atm.getBankSession().IsAuthenticated ){
            System.out.println(" Wrong pin ... ReEnter");
            atm.getAtmCurrentState().authenticatePin(atm,atmCard,1234);
            retry++;
        }
        else{
            // API comes in
            atm.setBankSession(new UserDetailAPI());
            atm.getBankSession().IsAuthenticated=true;
            atm.getBankSession().GetUserDetails(atmCard);
            System.out.println(" LOGGED in ...."+atmCard.getAccount().getUser().getUserName()+" .. WELCOME");
            atm.setAtmCurrentState(new SelectOperationState());
        }

    }

    @Override
    public void ejectCard(ATM atm, Card atmCard) {
        super.ejectCard(atm,atmCard);
    }

    @Override
    public void exit(ATM atm) {
        super.exit(atm);
    }
}
