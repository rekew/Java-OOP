package Generics_Practice03;

public class DukeTransaction {
    private String productID;
    private String transactionType;
    private int count;

    public DukeTransaction(String productID, String transactionType, int count){
        this.productID = productID;
        this.transactionType = transactionType;
        this.count = count;
    }

    public String getProductID(){
        return productID;
    }

    public String getTransactionType(){
        return transactionType;
    }

    public int getCount(){
        return count;
    }
}
