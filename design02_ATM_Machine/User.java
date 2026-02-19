package src.design02_ATM_Machine;

import java.util.UUID;

public class User {

    private String userName;
    private UUID uuid;

    public String getUserName() {
        return userName;
    }


    public User(String userName) {
        this.userName = userName;
        this.uuid=UUID.randomUUID();
    }
}
