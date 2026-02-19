package src.design02_ATM_Machine.ATMStates;

import src.design02_ATM_Machine.ATM;
import src.design02_ATM_Machine.Card;

import java.math.BigDecimal;

public class CashWithdrawState extends ATMState{

    @Override
    public void cashWithdraw(ATM atm, Card atmCard, int amount) {

        if(isUnderMaintenance){
            atm.setAtmCurrentState(new MaintenanceState());
            System.out.println(" iN select under ....");
            atm.getAtmCurrentState().underMaintenance(atm);
            return;
        }

        if(!atm.getBankSession().IsAuthenticated){
            System.out.println(" Session expired");
            ejectCard(atm,atmCard);
            exit(atm);
        }

        if(!atm.getBankSession().CheckAllowed(atmCard.getAccount())){
            System.out.println("Operation not allowed");
        }
        else if(amount<0){
            System.out.println("Invalid amount");
        }
        else if(amount>=atm.getNetAmount()){
            System.out.println(" Can not serve request - No Balance");
        }
        else if(!atm.getBankSession().CheckLimit(atmCard.getAccount(),amount)){
            System.out.println(" Exceeding user limit . Connect with bank ");
        }
        else{
            System.out.println(" Please wait .....");
            atmCard.getAccount().setBalance(new BigDecimal(atmCard.getAccount().getBalance().intValue()-amount));
            atm.cashDispenser(amount);
        }
        atm.setAtmCurrentState(new SelectOperationState());

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
