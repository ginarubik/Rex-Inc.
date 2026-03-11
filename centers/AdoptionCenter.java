package hu.progmasters.rex.centers;

import hu.progmasters.rex.pets.Pet;

import java.util.ArrayList;
import java.util.List;

public class AdoptionCenter {

    private String name;
    List<Pet> pets;

    public AdoptionCenter(String name) {
        this.name = name;
        pets = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public List<Pet> getPets() {
        return pets;
    }

    public void setPets(List<Pet> pets) {
        this.pets = pets;
    }

    public List<Pet> getUnCleansedPets(){
        List<Pet> unCleansedPets = new ArrayList<>();
        for(Pet pet : pets){
            if(!pet.isCleansed()){
                unCleansedPets.add(pet);
            }
        }
        pets.removeAll(unCleansedPets);
        return unCleansedPets;
    }

    public int adopt() {
        int adoptedAnimalsCount = 0;
        List<Pet> cleansedPets = new ArrayList<>();
        for(Pet pet : pets){
            if(pet.isCleansed()){
                cleansedPets.add(pet);
            }
        }
        adoptedAnimalsCount = cleansedPets.size();
        pets.removeAll(cleansedPets);
        return adoptedAnimalsCount;
    }

    public int getCleansedPetsCount(){
        int cleansedPetsCount = 0;
        for(Pet pet : pets) {
            if (pet.isCleansed()) {
                cleansedPetsCount++;
            }
        }
        return cleansedPetsCount;
    }
}
