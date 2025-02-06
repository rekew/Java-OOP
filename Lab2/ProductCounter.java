import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;
import java.util.Collections;

public class ProductCounter {

    private Map<String, Long> count = new HashMap<>();
    private Map<String, String> description = new TreeMap<>(Collections.reverseOrder());

    public ProductCounter(Map<String, String> list) {
        this.description = list;
    }

    public void processList(String[] list) {
        //long curVal = 0;
        for (String itemNumber : list) {
            /*
                if (count.containsKey(itemNumber)) {
                    curVal = count.get(itemNumber);
                    curVal++;
                    count.put(itemNumber, new Long(curVal));
                }  
                else count.put(itemNumber, new Long(1));
            */ 
            count.put(itemNumber, count.getOrDefault(itemNumber, 0L) + 1);
        }
    }

    public void print() {
        System.out.println("=== Product Report ===");
        for (String key : description.keySet()) {
            String name = description.get(key);
            long cnt = count.getOrDefault(key, 0L);
            /*
                System.out.print("Name: " + name + "\t\t"); 
                System.out.println("Count: " + cnt);
             */
            System.out.printf("Name: %-20s Count: %d%n", name, cnt);
        }
    }

    public static void main(String[] args) {
        Map<String, String> list = new HashMap<>();
        list.put("1S01", "Blue Polo Shirt");
        list.put("1S02", "Black Polo Shirt");
        list.put("1H01", "Red Ball Cap");
        list.put("1M02", "Duke Mug");

        ProductCounter pc1 = new ProductCounter(list);

        String[] parts = {
            "1S02", "1S01", "1S02", "1S01", "1H01", "1S01", "1M02",
            "1S02", "1H01","1H01", "1M02", "1S02", "1H01", "1S02", "1H01",
            "1S02", "1S01", "1M02", "1S01", "1S01", "1S01"
        };
        pc1.processList(parts);
        pc1.print();
    }
}
