import java.util.*;
import java.util.stream.Collectors;

public class AdoptionCenter {

    private String name;
    private List<Pet> pets;

    public AdoptionCenter(String name) {
        this.name = name;
        this.pets = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void addPet(Pet pet) {
        pets.add(pet);
    }

    public List<Pet> sendForCleansing() {

        List<Pet> toSend = pets.stream()
                .filter(p -> !p.isCleansed())
                .collect(Collectors.toList());

        pets.removeAll(toSend);

        return toSend;
    }

    public int adopt() {

        List<Pet> adopted = pets.stream()
                .filter(Pet::isCleansed)
                .collect(Collectors.toList());

        pets.removeAll(adopted);

        return adopted.size();
    }

    public int awaitingAdoption() {

        return (int) pets.stream()
                .filter(Pet::isCleansed)
                .count();
    }
}
