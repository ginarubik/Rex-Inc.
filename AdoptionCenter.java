import java.util.*;
import java.util.stream.Collectors;

public class AdoptionCenter {

    private String name;
    private List<Animal> animals;

    public AdoptionCenter(String name) {
        this.name = name;
        this.animals = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void addAnimal(Animal animal) {
        animals.add(animal);
    }

    public List<Animal> sendForCleansing() {

        List<Animal> result = animals.stream()
                .filter(a -> !a.isCleansed())
                .collect(Collectors.toList());

        animals.removeAll(result);

        return result;
    }

    public int adopt() {

        List<Animal> adopted = animals.stream()
                .filter(Animal::isCleansed)
                .collect(Collectors.toList());

        animals.removeAll(adopted);

        return adopted.size();
    }

    public int getCleansedAnimalsCount() {
        return (int) animals.stream().filter(Animal::isCleansed).count();
    }
}
