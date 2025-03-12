package lab6.SingletonBanking;

public class Customer {
    private String name;
    private Account account;

    public Customer(String name) {
        this.name = name;
        this.account = new TimeDepositAccount(0);
    }

    public String getName() {
        return name;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }
}
