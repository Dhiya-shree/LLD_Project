package src.design02_ATM_Machine.BankInterface;

import src.design02_ATM_Machine.BankAccount;
import src.design02_ATM_Machine.Card;
import src.design02_ATM_Machine.User;

import java.math.BigDecimal;

public class UserDetailAPI extends Bank{
    @Override
    public void GetUserDetails(Card atmCard) {

        BankAccount bankAccount;
        if(BankValidator.ValidateATMCard(atmCard)){
            //Dummy Bank Account
            bankAccount= new BankAccount(new User("Shree"), new BigDecimal(5000));
            atmCard.setAccount(bankAccount);
        }
        else{
            System.out.println("Not authenticate");
        }
    }


}
