package hu.progmasters.rex.pets;

public class Dog extends Pet{

    private int amountsOfCommand;

    public Dog(String name, int age, int amountsOfCommand) {
        super(name, age);
        this.amountsOfCommand = amountsOfCommand;
    }

    public int getAmountsOfCommand() {
        return amountsOfCommand;
    }
}
