package people;

public abstract class Person {

    private String name;
    private String tc;

    public Person(String name, String tc) {

        if (tc == null || tc.length() != 11) {
            throw new IllegalArgumentException("National ID number must be 11 digits.");
        }

        this.name = name;
        this.tc = tc;
    }

    public String getName() {
        return name;
    }

    public String getTc() {
        return tc;
    }

    public boolean login(String tc) {
        return this.tc.equals(tc);
    }

    public abstract void showMenu();
}