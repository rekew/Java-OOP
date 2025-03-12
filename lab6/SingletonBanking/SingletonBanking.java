package lab6.SingletonBanking;

public class SingletonBanking {
    public static void main(String[] args) {
        Bank bank = Bank.getInstance();
        bank.addCustomer(new Customer("Alice"));
        bank.addCustomer(new Customer("Bob"));
        Bank bank2 = Bank.getInstance();

        if (bank == bank2) {
            System.out.println("bank и bank2 - это один и тот же объект");
        }
        initializeCustomers(bank2);
        CustomerReport report = new CustomerReport();
        report.setBank(bank);
        report.generateReport();
    }

    public static void initializeCustomers(Bank bank) {
        Customer customer1 = new Customer("Charlie");
        customer1.getAccount().deposit(500.0);
        bank.addCustomer(customer1);

        Customer customer2 = new Customer("Diana");
        customer2.getAccount().deposit(1000.0);
        bank.addCustomer(customer2);
    }
}
