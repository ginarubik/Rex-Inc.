import java.util.*;

public class CleansingCenter {

    private Map<Animal, AdoptionCenter> animals;

    public CleansingCenter() {
        animals = new HashMap<>();
    }

    public void addAnimal(Animal animal, AdoptionCenter center) {
        animals.put(animal, center);
    }

    public int getAnimalsCount() {
        return animals.size();
    }

    public void cleanse() {

        for (Map.Entry<Animal, AdoptionCenter> entry : animals.entrySet()) {

            Animal animal = entry.getKey();
            AdoptionCenter center = entry.getValue();

            animal.cleanse();
            center.addAnimal(animal);
        }

        animals.clear();
    }
}
