package src.design02_ATM_Machine.BankInterface;

import src.design02_ATM_Machine.Card;

public class BankValidator {
    public static boolean ValidateATMCard(Card atmCard) {

        if(atmCard==null){
            System.out.println("No card ");
            return false;
        }

        return CardCheck(atmCard) && PinChecks(atmCard) && ExpiryChecks(atmCard);
    }

    public static boolean CardCheck(Card atmCard) {
        if (atmCard.getCardNo().length() != 16) {
            System.out.println("No number ");
            return false;
        }
     return true;
    }

    public static boolean PinChecks(Card atmCard){
        if(Integer.toString(atmCard.getPin()).length()!=4){
            System.out.println(" No pin ....");
            return false;
        }

        return true;
    }

    public static boolean ExpiryChecks(Card atmCard){
        if(atmCard.getExpiryDate()==null) {
            System.out.println(" No expiry date ");
            return false;
        }
        return true;
    }

}
