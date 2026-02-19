package src.design02_ATM_Machine;

import java.math.BigDecimal;
import java.util.UUID;

public class BankAccount {
    private User user;

    public BankAccount(User user, BigDecimal balance) {
        this.user = user;
        this.balance = balance;
        this.uuid = UUID.randomUUID();
    }

    private UUID uuid;

    public User getUser() {
        return user;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    private BigDecimal balance;

}
