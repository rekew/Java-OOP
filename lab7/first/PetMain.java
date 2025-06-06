

public class PetMain {
    public static void main(String[] args) {
        Animal a;

        // Spider with spider reference
        Spider s = new Spider();
        s.eat();
        s.walk();

        // Spider with animal reference
        a = new Spider();
        a.eat();
        a.walk();

        Pet p;

        // Cat
        Cat c = new Cat("Tom");
        c.eat();
        c.walk();
        c.play();

        a = new Cat();
        a.eat();
        a.walk();

        p = new Cat();
        p.setName("Mr. Whiskers");
        p.play();

        // Fish
        Fish f = new Fish();
        f.setName("Guppy");
        f.eat();
        f.walk();
        f.play();

        a = new Fish();
        a.eat();
        a.walk();

        //dog
        Dog d = new Dog();
        d.setName("Barsik");
        d.eat();
        d.walk();
        d.play();

        a = new Dog();
        a.eat();
        a.walk();

        // Test playWithAnimal method
        playWithAnimal(s);
        playWithAnimal(c);
        playWithAnimal(f);
    }

    public static void playWithAnimal(Animal a) {
        if (a instanceof Pet) {
            Pet p = (Pet) a;
            p.play();
        } else {
            System.out.println("Danger! Wild Animal");
        }
    }
}