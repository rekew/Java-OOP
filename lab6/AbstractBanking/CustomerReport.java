package lab6.AbstractBanking;

public class CustomerReport {
    public void generateReport(Customer customer) {
        System.out.println("Customer: " + customer.getFullName());

        for (Account account : customer.getAccounts()) {
            System.out.println(" " + account.getDescription() + ": " + account);
        }
    }
}
