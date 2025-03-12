package lab6.AbstractBanking;

import java.util.ArrayList;
import java.util.List;

public class Customer {
    private final String firstName;
    private final String lastName;
    private final List<Account> accounts;

    public Customer(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.accounts = new ArrayList<>();
    }

    public void addAccount(Account account) {
        accounts.add(account);
    }

    public Account getAccount(int index) {
        if (index >= 0 && index < accounts.size()) {
            return accounts.get(index);
        }
        return null;
    }

    public int getNumberOfAccounts() {
        return accounts.size();
    }

    public String getFullName() {
        return firstName + " " + lastName;
    }

    public List<Account> getAccounts() {
        return accounts;
    }
}
