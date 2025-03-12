package lab6.SingletonBanking;

public class Bank {
    private static final Bank instance = new Bank();  
    //с помощью static мы можем сделать так, что значение instance меняется вместе с другими объектами
    /*
    Условно
     Example obj1 = new Example();
     Example obj2 = new Example();

     obj1.number = 20;
     System.out.println(obj2.number); -> 20 (потому что number – static)
     */
    
    private Customer[] customers;
    private int numberOfCustomers;

    private Bank() {
        customers = new Customer[10];
        numberOfCustomers = 0;
    }

    public static Bank getInstance() {
        return instance;
    }

    public void addCustomer(Customer customer) {
        if (numberOfCustomers < customers.length) {
            customers[numberOfCustomers] = customer;
            numberOfCustomers++;
        }
    }

    public Customer getCustomer(int index) {
        if (index >= 0 && index < numberOfCustomers) {
            return customers[index];
        }
        return null;
    }

    public int getNumberOfCustomers() {
        return numberOfCustomers;
    }
}
