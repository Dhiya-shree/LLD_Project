package src.design05_SplitWise_App.User;

import java.util.ArrayList;
import java.util.List;

public class UserController {

    List<User> users;

    public UserController() {
        this.users = new ArrayList<>();
    }

    public void addUser(User user){
        users.add(user);
    }
    public List<User> getUsers(){
        return users;
    }

    public User getUserByID(int id){
        for(User u:users){
            if(u.getId()==id){
                return u;
            }
        }
        return null;
    }
}
