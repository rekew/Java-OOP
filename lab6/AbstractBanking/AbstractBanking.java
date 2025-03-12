package lab6.AbstractBanking;

import java.util.Date;

public class AbstractBanking {
    public static void main(String[] args) {
        Bank bank = new Bank();

        bank.addCustomer("Jane", "Simms");
        Customer customer = bank.getCustomer(0);
        Date maturityDate = new Date(System.currentTimeMillis() + (100L * 24 * 60 * 60 * 1000)); 
        customer.addAccount(new TimeDepositAccount(500.00, maturityDate));
        customer.addAccount(new CheckingAccount(200.00, 400.00));

        bank.addCustomer("Owen", "Bryant");
        customer = bank.getCustomer(1);
        customer.addAccount(new CheckingAccount(200.00));

        bank.addCustomer("Tim", "Soley");
        customer = bank.getCustomer(2);
        maturityDate = new Date(System.currentTimeMillis() + (100L * 24 * 60 * 60 * 1000));
        customer.addAccount(new TimeDepositAccount(1500.00, maturityDate));
        customer.addAccount(new CheckingAccount(200.00));

        bank.addCustomer("Maria", "Soley");
        customer = bank.getCustomer(3);
        customer.addAccount(bank.getCustomer(2).getAccount(1)); 
        maturityDate = new Date(System.currentTimeMillis() + (100L * 24 * 60 * 60 * 1000));
        customer.addAccount(new TimeDepositAccount(150.00, maturityDate));

        
        CustomerReport report = new CustomerReport();
        for (int i = 0; i < bank.getNumberOfCustomers(); i++) {
            report.generateReport(bank.getCustomer(i));
            System.out.println();
        }
    }
}
