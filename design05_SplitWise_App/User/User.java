package src.design05_SplitWise_App.User;

import src.design05_SplitWise_App.balance.BalanceSheet;

public class User {
    private int id;
    private String name;
    private BalanceSheet balanceSheet;

    public User(int id, String name) {
        this.id = id;
        this.name = name;
        this.balanceSheet=new BalanceSheet();
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public BalanceSheet getBalanceSheet() {
        return balanceSheet;
    }
}
