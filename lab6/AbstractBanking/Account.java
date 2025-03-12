package lab6.AbstractBanking;

public abstract class Account {
    protected double balance;

    public Account(double balance){
        this.balance = balance;
    }

    public double getBalance(){
        return balance;
    }

    public void deposit(double amount){
        balance += amount;
    }

    @Override
    public String toString(){
        return "Current balance is " + balance;
    }

    public abstract String getDescription();

    public abstract boolean withdraw(double amount);
}
