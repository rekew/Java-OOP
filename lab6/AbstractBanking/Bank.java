package lab6.AbstractBanking;

import java.util.ArrayList;
import java.util.List;

public class Bank {
    private final List<Customer> customers;

    public Bank() {
        customers = new ArrayList<>();
    }

    public void addCustomer(String firstName, String lastName) {
        customers.add(new Customer(firstName, lastName));
    }

    public Customer getCustomer(int index) {
        if (index >= 0 && index < customers.size()) {
            return customers.get(index);
        }
        return null;
    }

    public int getNumberOfCustomers() {
        return customers.size();
    }
}
