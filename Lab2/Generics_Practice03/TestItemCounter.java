package Generics_Practice03;

import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.Arrays;
import java.util.Comparator;
import java.util.ArrayList;
import java.util.Collections;

public class TestItemCounter {
    public static void main(String[] args){
        Map<String, Shirt> polos = new HashMap<>();

        polos.put("P001", new Shirt("P001", "Blue Polo Shirt", "Blue", "L", 24));
        polos.put("P002", new Shirt("P002", "Black Polo Shirt", "Black", "M", 15));
        polos.put("P003", new Shirt("P003", "Maroon Polo Shirt", "Maroon", "XL", 20));
        polos.put("P004", new Shirt("P004", "Tan Polo Shirt", "Tan", "S", 19));

        List<DukeTransaction> transactions = Arrays.asList(
                new DukeTransaction("P001", "Sale", 5),
                new DukeTransaction("P002", "Purchase", 10),
                new DukeTransaction("P003", "Sale", 3),
                new DukeTransaction("P004", "Purchase", 6)
        );

        for(DukeTransaction transaction : transactions){
            if(polos.containsKey(transaction.getProductID())){
                Shirt currentShirt = polos.get(transaction.getProductID());
                switch (transaction.getTransactionType()){
                    case "Purchase":
                        currentShirt.addItems(transaction.getCount());
                        break;
                    case "Sale":
                        currentShirt.removeItems(transaction.getCount());
                        break;
                    default:
                        System.out.println("Wrong type of transaction");
                }
            }
            else System.out.println("Wrong product id");
        }

        List<Shirt> poloList = new ArrayList<>(polos.values());

        Comparator<Shirt> sortDescription = new SortShirtByDesc();
        Comparator<Shirt> sortCount = new SortShirtByCount();

        Collections.sort(poloList, sortDescription);
        System.out.println("=== Inventory Report - Description ===");
        for(Shirt shirt : poloList){
            System.out.println(shirt);
        }

        Collections.sort(poloList, sortCount);
        System.out.println("=== Inventory Report - Count ===");
        for(Shirt shirt : poloList){
            System.out.println(shirt);
        }
    }
}
