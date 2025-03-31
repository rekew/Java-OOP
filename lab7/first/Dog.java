public class Dog extends Animal implements Pet{
    private String name;

    public Dog(){
        super(4);
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public void play() {
        System.out.println("Dog is playing with ball");
    }

    public void eat() {
        System.out.println("Dog eats beef");
    }
}