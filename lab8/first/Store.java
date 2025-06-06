package lab8.first;

import java.util.Deque;
import java.util.LinkedList;

public class Store {

    private Deque<Shirt> shirts = new LinkedList<>();
    //singleton
    private sta tic Store instance = new Store();
    //singleton

    private Store() {
    }
    //singleton

    public static Store getInstance() {
        return instance;
    }

    public void addShirt(Shirt shirt) {
        System.out.println("Adding a shirt to the store.");
        shirts.push(shirt);
        System.out.println("Total shirts in stock: " + shirts.size());
    }

    public Shirt takeShirt() {
        return shirts.pop();
    }

    public int getShirtCount() {
        return shirts.size();
    }

    public boolean authorizeCreditCard(String accountNumber, double amount) {
        int seconds = (int) (Math.random() * 3 + 1);
        System.out.println("Sleeping for " + seconds + " seconds");
        try{
            Thread.sleep(seconds * 1000);
        }
        catch(InterruptedException e){
            System.out.println("Interrupted");
        }
        
        return true;
    }
}