package src.design05_SplitWise_App.balance;

import src.design05_SplitWise_App.User.User;

import java.util.HashMap;
import java.util.Map;

public class BalanceSheet {
    double totalPayment;
    double totalExpense;

    double lendMoney;
    double ownMoney;

    Map<User,Balance> userBalanceMap;

    public BalanceSheet() {
        totalPayment=0;totalExpense=0;
        lendMoney=0;ownMoney=0;
        this.userBalanceMap=new HashMap<User, Balance>();
    }

    public double getTotalPayment() {
        return totalPayment;
    }

    public double getTotalExpense() {
        return totalExpense;
    }

    public double getLendMoney() {
        return lendMoney;
    }

    public double getOwnMoney() {
        return ownMoney;
    }

    public Map<User, Balance> getUserBalanceMap() {
        return userBalanceMap;
    }


}
