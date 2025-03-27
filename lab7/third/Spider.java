public class Spider implements Ambulatory{
    private Ambulatory ambulatory;

    public Spider() {
        ambulatory = new AmbulatoryImpl(8);
    }

    public void walk() {
        ambulatory.walk();
    }

    public void eat() {
        System.out.println("Spiders eat insects.");
    }
}