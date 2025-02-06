package Generics_Practice03;

public class Shirt {
    private String id;
    private String description;
    private String color;
    private String size;
    private int inventoryCount;

    public Shirt(String id, String description, String color, String size, int inventoryCount){
        this.id = id;
        this.description = description;
        this.color = color;
        this.size = size;
        this.inventoryCount = inventoryCount;
    }

    public String getId(){
        return id;
    }

    public String getDescription(){
        return description;
    }

    public String getColor(){
        return color;
    }

    public String getSize(){
        return size;
    }

    public int getCount(){
        return inventoryCount;
    }

    public void addItems(int count){
        this.inventoryCount += count;
    }

    public void removeItems(int count){
        this.inventoryCount -= count;
    }

    public String toString(){
        return "Shirt ID:" + id + "\nDescription: " + description + 
        "\nColor: " + color + "\nSize: " + size + 
        "\nInventory: " + inventoryCount + "\n";
    }
}
