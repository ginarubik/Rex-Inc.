package hu.progmasters.rex.pets;

public abstract class Pet {

    private String name;
    private int age;
    private boolean cleansed;

    public Pet(String name, int age){
        this.name = name;
        this.age = age;
        this.cleansed = false;
    }

    public boolean isCleansed() {
        return cleansed;
    }

    public void setCleansed(boolean cleansed) {
        this.cleansed = cleansed;
    }
}
