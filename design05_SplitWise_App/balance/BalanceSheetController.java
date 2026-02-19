package src.design05_SplitWise_App.balance;

import src.design05_SplitWise_App.User.User;
import src.design05_SplitWise_App.expense.Expense;
import src.design05_SplitWise_App.split.Split;

import java.util.Map;


public class BalanceSheetController {

    public void updateBalanceSheet(Expense expense){
        // update balance sheet of the given user
        User expensePaidBy=expense.getPaidBy();
        //update total payment for the user
        expensePaidBy.getBalanceSheet().totalPayment=expensePaidBy.getBalanceSheet().getTotalPayment()+expense.getAmount();

        for(Split split:expense.getSplits()){
            User u=split.getUser();
            double amount=split.getAmount();
            BalanceSheet bs=u.getBalanceSheet();

            // update for user
            bs.totalExpense=bs.totalExpense+ split.getAmount();

            if(!isPaidByUser(split,expensePaidBy)){
                // Not paid by user
                expensePaidBy.getBalanceSheet().lendMoney=expensePaidBy.getBalanceSheet().lendMoney+amount;
                bs.ownMoney=bs.ownMoney+amount;

                // update paidBy balance map
                if(!expensePaidBy.getBalanceSheet().getUserBalanceMap().containsKey(u)){
                    expensePaidBy.getBalanceSheet().getUserBalanceMap().put(u,new Balance());
                }

                // update user balance map
                if(!u.getBalanceSheet().getUserBalanceMap().containsKey(expensePaidBy)){
                    u.getBalanceSheet().getUserBalanceMap().put(expensePaidBy,new Balance());
                }

                Balance b1=expensePaidBy.getBalanceSheet().getUserBalanceMap().get(u);
                b1.setOwe(b1.getOwe()+amount);
                // Not needed b1 change by ref
            //    expensePaidBy.getBalanceSheet().getUserBalanceMap().put(u,b1);

                Balance b2=u.getBalanceSheet().getUserBalanceMap().get(expensePaidBy);
                b2.setLend(b1.getLend()+amount);
                // Not needed passed as ref , change reflected
             //   u.getBalanceSheet().getUserBalanceMap().put(expensePaidBy,b2);

            }
        }
    }

    private boolean isPaidByUser(Split split, User expensePaidBy) {
        if(split.getUser().getId()!=expensePaidBy.getId()){
            return false;
        }
        return true;
    }


    public void show(User user){
        BalanceSheet bs= user.getBalanceSheet();
        System.out.println(" User "+user.getId()+" name : "+user.getName());
        System.out.println(" Total lend "+bs.lendMoney);
        System.out.println(" Total owe "+bs.ownMoney);
        System.out.println(" Total payment "+bs.totalPayment);
        System.out.println(" Total expense "+bs.totalExpense);

        for (Map.Entry<User,Balance> map:bs.getUserBalanceMap().entrySet()){
            System.out.println(map.getKey().getName()+" lends you "+map.getValue().getLend()+"" +
                    "owe you "+map.getValue().getOwe());
        }
    }
}
