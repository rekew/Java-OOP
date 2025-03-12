package lab6.SingletonBanking;

public class CustomerReport {
    private Bank bank;

    public void setBank(Bank bank) {
        this.bank = bank;
    }

    public void generateReport() {
        System.out.println("CUSTOMERS REPORT");
        System.out.println("====================");

        for (int i = 0; i < bank.getNumberOfCustomers(); i++) {
            Customer customer = bank.getCustomer(i);
            System.out.println("Customer: " + customer.getName());

            Account account = customer.getAccount();
            if (account instanceof TimeDepositAccount) {
                System.out.println("    " + account);
            } else {
                System.out.println("    Regular Account: balance is " + account.getBalance());
            }
        }
    }
}
