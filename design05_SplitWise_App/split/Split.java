package src.design05_SplitWise_App.split;

import src.design05_SplitWise_App.User.User;

public class Split {
    User user;
    int amount;
    public Split(User user, int i) {
        this.user=user;
        this.amount=i;
    }

    public User getUser() {
        return user;
    }

    public int getAmount() {
        return amount;
    }
}
