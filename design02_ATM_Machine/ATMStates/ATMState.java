package src.design02_ATM_Machine.ATMStates;

import src.design02_ATM_Machine.ATM;
import src.design02_ATM_Machine.Card;

/**
 *
 * STATE DESIGN PATTERN
 * <p>
 * Object whose state being changed needs to be passed in every state .
 * MUST !!!!!!!
 *
 *
 */
public class ATMState {

    public  boolean isUnderMaintenance;
    public void insertCard(ATM atm){
        System.out.println(" Idea state --> insert card ");
    }

    public void authenticatePin(ATM atm, Card atmCard, int pin){
         System.out.println(" Not allowed auth ");
     }

    public void changePin(ATM atm , Card atmCard,int pin,int newPin){
        System.out.println(" Not allowed pin");
    }

     public void selectOperation(ATM atm , Card atmCard,OperationType operationType){
         System.out.println(" Not allowed op");
     }

     public  void cashWithdraw(ATM atm , Card atmCard ,int amount){
         System.out.println(" Not allowed ca");
     }

     public void displayBalance(ATM atm , Card atmCard){
         System.out.println(" Not allowed disp");
     }

    public void ejectCard(ATM atm , Card atmCard){
        System.out.println(" Please collect card ");
    }

    public void exit(ATM atm){
        System.out.println(" Session Expired ");
        atm.setAtmCurrentState(new IdealState());
    }

    public void underMaintenance(ATM atm){

        System.out.println("Under Maintenance in atm state ");
    }


}
