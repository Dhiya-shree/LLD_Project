package src.design02_ATM_Machine.BankInterface;

import src.design02_ATM_Machine.BankAccount;
import src.design02_ATM_Machine.Card;

public abstract class Bank {
    public boolean IsAuthenticated = false;

    public void GetUserDetails(Card atmCard){
        System.out.println(" Get user details from CARD .....");
    }

    public void SetPin(int pin, Card atmCard){
        System.out.println(" Set pin ");
    }

    public void CheckPin(int pin){
        System.out.println(" Check pin ");
    }
    public boolean CheckLimit(BankAccount account, Integer amount) {
        return false;
    }

    public boolean CheckAllowed(BankAccount account){
        return account != null;
    }

}
