package src.design02_ATM_Machine.BankInterface;

import src.design02_ATM_Machine.Card;

public class UserCheckPin extends Bank{

    public void CheckPin(int pin){
        if(pin>0){
            IsAuthenticated=true;
        }
    }

    public void SetPin(int pin, Card atmCard){
        atmCard.setPin(5678);
    }
}
