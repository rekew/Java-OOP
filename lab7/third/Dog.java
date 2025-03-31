public class Dog implements Pet, Ambulatory{
    private Nameable nameable = new NameableImpl();
    private Ambulatory ambulatory;

    public Dog(String name) {
        ambulatory = new AmbulatoryImpl(4);
        nameable.setName(name);
    }

    public Dog() {
        this("Fluffy");
    }

    public void setName(String name) {
        nameable.setName(name);
    }

    public String getName() {
        return nameable.getName();
    }

    public void play() {
        System.out.println(getName() + " likes to play with ball.");
    }

    public void eat() {
        System.out.println("Dog eats beef");
    }

    public void walk() {
        ambulatory.walk();
    }
}