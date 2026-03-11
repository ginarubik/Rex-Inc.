package hu.progmasters.rex.centers;

import hu.progmasters.rex.pets.Pet;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CleansingCenter {

    private Map<Pet, AdoptionCenter> petAdoptionCenterMap;

    public CleansingCenter(){
        this.petAdoptionCenterMap = new HashMap<>();
    }

    public Map<Pet, AdoptionCenter> getPetAdoptionCenterMap() {
        return petAdoptionCenterMap;
    }

    public void awaitingCleansing(List<Pet> unCleansedPets, AdoptionCenter adoptionCenter) {
        for(Pet pet : unCleansedPets){
            petAdoptionCenterMap.put(pet, adoptionCenter);
        }
    }

    public void cleanse() {
        for(Pet pet : petAdoptionCenterMap.keySet()){
            pet.setCleansed(true);
            AdoptionCenter adoptionCenter = petAdoptionCenterMap.get(pet);
            adoptionCenter.getPets().add(pet);
        }
        petAdoptionCenterMap.clear();
    }
}
