public class NameableImpl implements Nameable {
    private String name;

    @Override
    public void setName(String name) {
        if (name.length() > 20) {
            System.out.println("Name too long");
        } else {
            this.name = name;
        }
    }

    @Override
    public String getName() {
        return name;
    }
}
