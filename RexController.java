import java.util.*;

public class RexController {

    private Map<String, AdoptionCenter> adoptionCenters;
    private CleansingCenter cleansingCenter;

    private int adoptedAnimals;

    public RexController() {
        adoptionCenters = new HashMap<>();
        cleansingCenter = new CleansingCenter();
        adoptedAnimals = 0;
    }

    public void registerAdoptionCenter(String name) {
        adoptionCenters.put(name, new AdoptionCenter(name));
    }

    public void registerDog(String name, int age, int commands, String centerName) {
        Dog dog = new Dog(name, age, commands);
        adoptionCenters.get(centerName).addAnimal(dog);
    }

    public void registerCat(String name, int age, int intelligence, String centerName) {
        Cat cat = new Cat(name, age, intelligence);
        adoptionCenters.get(centerName).addAnimal(cat);
    }

    public void sendForCleansing(String centerName) {

        AdoptionCenter center = adoptionCenters.get(centerName);

        List<Animal> animals = center.sendForCleansing();

        for (Animal animal : animals) {
            cleansingCenter.addAnimal(animal, center);
        }
    }

    public void cleanse() {
        cleansingCenter.cleanse();
    }

    public void adopt(String centerName) {
        adoptedAnimals += adoptionCenters.get(centerName).adopt();
    }

    public int getAdoptionCentersCount() {
        return adoptionCenters.size();
    }

    public int getAdoptedAnimals() {
        return adoptedAnimals;
    }

    public int getAnimalsAwaitingAdoption() {

        return adoptionCenters.values()
                .stream()
                .mapToInt(AdoptionCenter::getCleansedAnimalsCount)
                .sum();
    }

    public int getAnimalsAwaitingCleansing() {
        return cleansingCenter.getAnimalsCount();
    }
}
