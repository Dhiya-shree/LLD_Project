package src.design02_ATM_Machine.BankInterface;

import src.design02_ATM_Machine.BankAccount;

public class UserLimitAPI extends Bank{

    @Override
    public boolean CheckLimit(BankAccount account, Integer amount) {
        boolean isAllowed=false;
        System.out.println(" User balance ......"+account.getBalance().intValue());
        if(amount<(account.getBalance().intValue() )&& amount>0){
            isAllowed=true;
        }
       return isAllowed;
    }
}
