package src.design02_ATM_Machine;

import src.design02_ATM_Machine.ATMStates.ATMState;
import src.design02_ATM_Machine.ATMStates.IdealState;
import src.design02_ATM_Machine.BankInterface.Bank;

public class ATM {
    private int netAmount;
    private ATMState atmCurrentState;
    private int TENS;
    private int HUNDRED;
    private int THOUSAND;
    private int FIVEHUNDRED;
    private Bank bankSession;

    public ATM(int THOUSAND, int TENS, int HUNDRED, int FIVEHUNDRED) {
        this.THOUSAND = THOUSAND;
        this.TENS = TENS;
        this.HUNDRED = HUNDRED;
        this.FIVEHUNDRED = FIVEHUNDRED;
        netAmount=10*TENS+100*HUNDRED+500*FIVEHUNDRED+1000*THOUSAND;

        //null for now
        atmCurrentState=new IdealState();
        atmCurrentState.insertCard(this);
    }

    public void setBankSession(Bank bank) {
        // Bank will be used as API
        this.bankSession = bank;
    }

    public Bank getBankSession() {
        // Bank will be used as API
        return this.bankSession;
    }


    public int getNetAmount() {
        return netAmount;
    }

    public void setNetAmount(int netAmount) {
        this.netAmount = netAmount;
    }

    public ATMState getAtmCurrentState() {
        return atmCurrentState;
    }

    public void setAtmCurrentState(ATMState atmCurrentState) {
        this.atmCurrentState = atmCurrentState;
    }

   

    public void cashDispenser(int amount) {

        int netDebit=amount;
        int thousand=amount/1000;amount=amount%1000;
        int fiveHundred=amount/500;amount=amount%500;
        int hundred=amount/100;amount=amount%100;
        int tens=amount/10;amount=amount%10;
        if(amount>0){
            System.out.println(" Try again with Enter amount without ones ");
            return;
        }
        if(thousand>THOUSAND||FIVEHUNDRED<fiveHundred||hundred>HUNDRED||tens>TENS){
            System.out.println(" Not enough amount ");
            return ;
        }

        System.out.println(" Please withdraw ......");
        setNetAmount(netAmount-netDebit);
        THOUSAND=-thousand;FIVEHUNDRED=-fiveHundred;HUNDRED=-hundred;TENS=-tens;

        if(thousand>0){
            System.out.println(" Thousand withdraw "+thousand);
        }
        if(fiveHundred>0){
            System.out.println(" fiveHundred withdraw "+fiveHundred);
        }
        if(hundred>0){
            System.out.println(" hundred withdraw "+hundred);
        }
        if(tens>0){
            System.out.println(" tens withdraw "+tens);
        }

        System.out.println(" Net sum withdrawn "+netDebit);

    }
}
