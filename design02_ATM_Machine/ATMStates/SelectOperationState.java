package src.design02_ATM_Machine.ATMStates;

import src.design02_ATM_Machine.ATM;
import src.design02_ATM_Machine.BankInterface.UserCheckPin;
import src.design02_ATM_Machine.BankInterface.UserDetailAPI;
import src.design02_ATM_Machine.BankInterface.UserLimitAPI;
import src.design02_ATM_Machine.Card;

public class SelectOperationState extends ATMState{

    @Override
    public void selectOperation(ATM atm, Card atmCard, OperationType operationType) {

        if(isUnderMaintenance){
            atm.setAtmCurrentState(new MaintenanceState());
            System.out.println(" iN select under ....");
            atm.getAtmCurrentState().underMaintenance(atm);
            return;
        }

        switch(operationType){
            case CASH_WITHDRAW -> {
                atm.setBankSession(new UserLimitAPI());
                atm.getBankSession().IsAuthenticated=true;
                atm.setAtmCurrentState(new CashWithdrawState());
            }
            case DISPLAY_BALANCE -> {
                atm.setBankSession(new UserDetailAPI());
                atm.getBankSession().IsAuthenticated=true;
                atm.setAtmCurrentState(new CheckBalanceState());
            }
            case CHANGE_PIN-> {
                atm.setBankSession(new UserCheckPin());
                atm.getBankSession().IsAuthenticated=true;
                atm.setAtmCurrentState(new ChangePinState());
            }
            default -> {
                System.out.println(" Exit option ");
                ejectCard(atm,atmCard);
                exit(atm);
            }
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
