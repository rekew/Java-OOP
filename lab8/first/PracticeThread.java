package lab8.first;

public class PracticeThread extends Thread {
    
    @Override
    public void run() {
        PurchasingAgent agent = new PurchasingAgent();
        agent.purchase();
    }
    
}