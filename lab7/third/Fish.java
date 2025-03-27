public class Fish {
    private Nameable nameable = new NameableImpl();

    public Fish() {}

    public void setName(String name) {
        nameable.setName(name);
    }

    public String getName() {
        return nameable.getName();
    }

    public void play() {
        System.out.println("Just keep swimming.");
    }

    public void eat() {
        System.out.println("Fish eat pond scum.");
    }

    // Удалили метод walk() — потому что рыбы не ходят
}