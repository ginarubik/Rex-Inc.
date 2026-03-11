package hu.progmasters.rex.pets;

public class Cat extends Pet{

    private int iq;

    public Cat(String name, int age, int iq) {
        super(name, age);
        this.iq = iq;
    }

    public int getIq() {
        return iq;
    }
}
