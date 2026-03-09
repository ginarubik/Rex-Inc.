public abstract class Pet {

    private String name;
    private int age;
    private boolean cleansed;

    protected Pet(String name, int age) {
        this.name = name;
        this.age = age;
        this.cleansed = false;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public boolean isCleansed() {
        return cleansed;
    }

    public void cleanse() {
        this.cleansed = true;
    }
}
