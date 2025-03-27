public class Cat implements Pet, Ambulatory{
    private Nameable nameable = new NameableImpl();
    private Ambulatory ambulatory;

    public Cat(String name) {
        ambulatory = new AmbulatoryImpl(4);
        nameable.setName(name);
    }

    public Cat() {
        this("Fluffy");
    }

    public void setName(String name) {
        nameable.setName(name);
    }

    public String getName() {
        return nameable.getName();
    }

    public void play() {
        System.out.println(getName() + " likes to play with string.");
    }

    public void eat() {
        System.out.println("Cats like to eat spiders and fish.");
    }

    public void walk() {
        ambulatory.walk();
    }
}