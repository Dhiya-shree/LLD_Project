package src.design05_SplitWise_App;

import src.design05_SplitWise_App.User.User;
import src.design05_SplitWise_App.User.UserController;
import src.design05_SplitWise_App.balance.BalanceSheetController;
import src.design05_SplitWise_App.group.Group;
import src.design05_SplitWise_App.group.GroupController;
import src.design05_SplitWise_App.split.Split;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SplitWise_App {
    UserController userController;
    GroupController groupController;
    BalanceSheetController balanceSheetController;

    public SplitWise_App() {
        this.userController = new UserController();
        this.groupController = new GroupController();
        this.balanceSheetController = new BalanceSheetController();
    }

    public void run(){
        addUsers();
        initializeGroup();
        addExpenses();
        showBalanceSheet();
    }

    private void addExpenses() {
        // user 1 paid for group 1 500 for everyone food
        User user=userController.getUserByID(1);
        Group group=groupController.getGroupByID("1");
        List<Split> splits=new ArrayList<>(Arrays.asList(
           new Split(userController.getUserByID(1),100),
                new Split(userController.getUserByID(2),100),
                new Split(userController.getUserByID(3),100),
                new Split(userController.getUserByID(4),100),
                new Split(userController.getUserByID(5),100)
        ));
        group.createExpense(group.getId(),group.getDescription(),user,splits,500);

        //User 2 paid 1200 for some in group 1
         user=userController.getUserByID(2);
       //  group=groupController.getGroupByID("2");  no need for group id
        splits=new ArrayList<>(Arrays.asList(
                new Split(userController.getUserByID(1),200),
                new Split(userController.getUserByID(2),200),
                new Split(userController.getUserByID(3),200),
                new Split(userController.getUserByID(4),300),
                new Split(userController.getUserByID(5),300)
        ));
        group.createExpense(group.getId(),group.getDescription(),user,splits,1200);



    }

    private void initializeGroup() {
        User user=userController.getUserByID(1);
        Group group=groupController.createGroup("1","Trip manali",user);
        group.addMember(userController.getUserByID(2));
        group.addMember(userController.getUserByID(3));
        group.addMember(userController.getUserByID(4));
        group.addMember(userController.getUserByID(5));
    }


    private void addUsers() {
        userController.addUser(new User(1,"A"));
        userController.addUser(new User(2,"B"));
        userController.addUser(new User(3,"C"));
        userController.addUser(new User(4,"D"));
        userController.addUser(new User(5,"E"));

    }

    private void showBalanceSheet() {
        List<User> users=userController.getUsers();
        for(User u:users){
            balanceSheetController.show(u);
        }
    }


}
