package lab6.AbstractBanking;

public class CheckingAccount extends Account{
    private final double overDraftLimit;

    public CheckingAccount(double balance, double overDraftLimit){
        super(balance);
        this.overDraftLimit = overDraftLimit;
    }

    public CheckingAccount(double balance){
        this(balance, 0);
    }

    @Override
    public String getDescription() {
        return "Checking Account";
    }

    @Override
    public boolean withdraw(double amount) {
        if (amount <= balance + overDraftLimit) {
            balance -= amount;
            return true;
        }
        return false;
    }
}