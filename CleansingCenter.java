import java.util.*;

public class CleansingCenter {

    private Map<Pet, AdoptionCenter> pets;

    public CleansingCenter() {
        pets = new HashMap<>();
    }

    public void addPet(Pet pet, AdoptionCenter center) {
        pets.put(pet, center);
    }

    public void cleanse() {

        for (Map.Entry<Pet, AdoptionCenter> entry : pets.entrySet()) {

            Pet pet = entry.getKey();
            pet.cleanse();

            entry.getValue().addPet(pet);
        }

        pets.clear();
    }

    public int awaitingCleansing() {
        return pets.size();
    }
}
