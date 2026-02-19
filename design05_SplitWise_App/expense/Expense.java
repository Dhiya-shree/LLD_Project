package src.design05_SplitWise_App.expense;
import src.design05_SplitWise_App.User.User;
import src.design05_SplitWise_App.split.Split;

import java.util.List;

public class Expense {

    String id;
    String description;
    User paidBy;
    List<Split> splits;
    double amount;

    public Expense(String id, String description, List<Split> splits, User paidBy,double amount) {
        this.id = id;
        this.description = description;
        this.splits = splits;
        this.paidBy = paidBy;
        this.amount=amount;
    }

    public String getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public User getPaidBy() {
        return paidBy;
    }

    public List<Split> getSplits() {
        return splits;
    }

    public double getAmount() {
        return amount;
    }
}
