package lab6.SingletonBanking;

import java.util.Date;

public class TimeDepositAccount extends Account{
    private Date openingDate;
    private double interestRate;

    public TimeDepositAccount(double initialBalance) {
        super();
        deposit(initialBalance); 
        this.openingDate = new Date(); 
    }

    public Date getOpeningDate() {
        return openingDate;
    }

    public double getInterestRate() {
        return interestRate;
    }

    @Override
    public String toString() {
        return "Time Deposit Account " + openingDate + ": current balance is " + getBalance();
    }
}
