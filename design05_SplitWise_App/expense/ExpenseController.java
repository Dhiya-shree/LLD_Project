package src.design05_SplitWise_App.expense;

import src.design05_SplitWise_App.User.User;
import src.design05_SplitWise_App.balance.BalanceSheetController;
import src.design05_SplitWise_App.split.Split;

import java.util.List;

public class ExpenseController {
    BalanceSheetController balanceSheetController;

    public ExpenseController() {
        this.balanceSheetController = new BalanceSheetController();
    }

    public Expense createExpense(String id, String desc, User paidBy, List<Split> splits, double amount){
        Expense expense=new Expense(id,desc,splits,paidBy,amount);
        balanceSheetController.updateBalanceSheet(expense);
        return expense;
    }
}
