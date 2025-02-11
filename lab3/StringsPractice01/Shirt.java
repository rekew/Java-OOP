package StringsPractice01;

public class Shirt {
    public String id;
    public String description;
    public String color;
    public String size;

    public Shirt(String id, String description, String color, String size){
        this.id = id;
        this.description = description;
        this.color = color;
        this.size = size;
    }

    @Override
    public String toString(){
        return "Shirt ID: " + id + "\n"
        + "Description: " + description + "\n"
        + "Color: " + color + "\n"
        + "Size: " + size + "\n"; 
    }
}
