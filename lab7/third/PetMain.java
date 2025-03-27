public class PetMain {
    public static void main(String[] args) {
        Spider s = new Spider();
        s.eat();
        s.walk();

        Cat c = new Cat("Tom");
        c.eat();
        c.walk();
        c.play();

        c.setName("Mr. Whiskers");
        System.out.println("Cat's name: " + c.getName());

        Fish f = new Fish();
        f.setName("Guppy");
        f.eat();
        f.play();
        System.out.println("Fish name: " + f.getName());

        System.out.println("\n--- Testing walk with references ---");
        Ambulatory a1 = new Spider();
        Ambulatory a2 = new Cat();
        a1.walk();
        a2.walk();
    }
}
