package lab6.DepositLength;

import java.util.ArrayList;
import java.util.List;

public class BankCustomer {
    private String name;
    private List<BankAccount> accounts;

    public BankCustomer(String name) {
        this.name = name;
        this.accounts = new ArrayList<>();
    }

    public void addAccount(BankAccount account) {
        accounts.add(account);
    }

    @Override
    public String toString() {
        return "BankCustomer{name='" + name + "', accounts=" + accounts + "}";
    }
}
