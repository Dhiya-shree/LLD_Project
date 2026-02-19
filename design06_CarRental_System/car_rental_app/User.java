package src.design06_CarRental_System.car_rental_app;

import java.util.UUID;

public class User {

    private UUID uuid;
    private String name;
    private String email;
    private String number;

    public User(String name, String email, String number) {
        this.name = name;
        this.email = email;
        this.number = number;
        this.uuid=UUID.randomUUID();
    }
}
