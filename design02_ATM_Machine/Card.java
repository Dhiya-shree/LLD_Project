package src.design02_ATM_Machine;

import java.util.UUID;

public class Card {
    private int cvv;
    private String cardNo;
    private int pin;
    private String expiryDate;
    private BankAccount account;
    private UUID uuid;


    public Card(String expiryDate, int pin, String cardNo, int cvv) {
        this.uuid = UUID.randomUUID();
        this.expiryDate = expiryDate;
        this.pin = pin;
        this.cardNo = cardNo;
        this.cvv = cvv;
    }

    public BankAccount getAccount() {
        return account;
    }

    public void setAccount(BankAccount account) {
        this.account = account;
    }

    public Card(int cvv,String expiryDate,String cardNo){
        this.cvv=cvv;
        this.expiryDate=expiryDate;
        this.cardNo=cardNo;
    }


    public String getCardNo() {
        return cardNo;
    }

    public String getExpiryDate() {
        return expiryDate;
    }


    public int getPin() {
        return pin;
    }

    public void setPin(int pin) {
        this.pin = pin;
    }
}
