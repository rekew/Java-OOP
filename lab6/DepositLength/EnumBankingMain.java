package lab6.DepositLength;

import java.util.ArrayList;
import java.util.List;

public class EnumBankingMain {
    public static void main(String[] args) {
        List<BankCustomer> customers = initializeCustomers();
        for (BankCustomer customer : customers) {
            System.out.println(customer);
        }
    }

    public static List<BankCustomer> initializeCustomers() {
        List<BankCustomer> customers = new ArrayList<>();

        BankCustomer customer1 = new BankCustomer("Alice");
        customer1.addAccount(new TimeDepositAccount(500.00, DepositLength.SIX_MONTHS));

        BankCustomer customer2 = new BankCustomer("Bob");
        customer2.addAccount(new TimeDepositAccount(300.00, DepositLength.THREE_MONTHS));

        customers.add(customer1);
        customers.add(customer2);

        return customers;
    }
}
