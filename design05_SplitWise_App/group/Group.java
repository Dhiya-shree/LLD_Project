package src.design05_SplitWise_App.group;

import src.design05_SplitWise_App.expense.Expense;
import src.design05_SplitWise_App.expense.ExpenseController;
import src.design05_SplitWise_App.User.User;
import src.design05_SplitWise_App.split.Split;

import java.util.ArrayList;
import java.util.List;

public class Group {
    String id;
    String description;
    List<User> members;
    List<Expense> expenses;
    ExpenseController expenseController;

    public void createExpense(String id,String description,User paidBy,List<Split> split,double amount){
        Expense expense=expenseController.createExpense(id,description,paidBy,split,amount);
        expenses.add(expense);
    }

    public Group(String id, String description) {
        this.id = id;
        this.description = description;
        this.members=new ArrayList<>();
        this.expenses=new ArrayList<>();
        expenseController=new ExpenseController();
    }

    public void addMember(User user){
        members.add(user);
    }

    public String getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public List<User> getMembers() {
        return members;
    }

    public List<Expense> getExpenses() {
        return expenses;
    }

    public ExpenseController getExpenseController() {
        return expenseController;
    }
}
