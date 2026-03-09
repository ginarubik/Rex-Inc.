public class PetFactory {

    public Pet createDog(String name, int age, int commands) {
        return new Dog(name, age, commands);
    }

    public Pet createCat(String name, int age, int intelligence) {
        return new Cat(name, age, intelligence);
    }
}
