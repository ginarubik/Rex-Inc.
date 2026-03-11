package hu.progmasters.rex;

import hu.progmasters.rex.centers.AdoptionCenter;
import hu.progmasters.rex.centers.CleansingCenter;
import hu.progmasters.rex.pets.Cat;
import hu.progmasters.rex.pets.Dog;
import hu.progmasters.rex.pets.Pet;

import java.util.ArrayList;
import java.util.List;

public class RexInc {

    List<AdoptionCenter> adoptionCenterList;
    CleansingCenter cleansingCenter;
    private int adoptedAnimalsCount = 0;

    public RexInc(){
        this.adoptionCenterList = new ArrayList<>();
        this.cleansingCenter = new CleansingCenter();
    }

    public void registerAdoptionCenter(String adoptionCenterName){
        AdoptionCenter adoptionCenter = new AdoptionCenter(adoptionCenterName);
        adoptionCenterList.add(adoptionCenter);
    }

    private AdoptionCenter getAdoptionCenterByName(String adoptionCenterName){
        for(AdoptionCenter adoptionCenter : adoptionCenterList){
            if(adoptionCenterName.equals(adoptionCenter.getName())){
                return adoptionCenter;
            }
        }
        return null;
    }

    public void registerDog(String name, String age, String amountsOfCommand, String adoptionCenterName) {
        Dog dog = new Dog(name, Integer.parseInt(age), Integer.parseInt(amountsOfCommand));
        AdoptionCenter adoptionCenter = getAdoptionCenterByName(adoptionCenterName);
        if(adoptionCenter != null){
            adoptionCenter.getPets().add(dog);
        }
    }

    public void registerCat(String name, String age, String iq, String adoptionCenterName) {
        Cat cat = new Cat(name, Integer.parseInt(age), Integer.parseInt(iq));
        AdoptionCenter adoptionCenter = getAdoptionCenterByName(adoptionCenterName);
        if(adoptionCenter != null){
            adoptionCenter.getPets().add(cat);
        }
    }

    public void sendForCleansing(String adoptionCenterName) {
        AdoptionCenter adoptionCenter = getAdoptionCenterByName(adoptionCenterName);
        if(adoptionCenter != null){
//            List<Pet> unCleansedPets = new ArrayList<>();
//            for(Pet pet : adoptionCenter.getPets()){
//                if(!pet.isCleansed()){
//                    unCleansedPets.add(pet);
//                }
//            }
//            cleansingCenter.awaitingCleansing(unCleansedPets, adoptionCenter);
//            adoptionCenter.getPets().removeAll(unCleansedPets);
            cleansingCenter.awaitingCleansing(adoptionCenter.getUnCleansedPets(), adoptionCenter);
        }
    }

    public void cleanse() {
        cleansingCenter.cleanse();
    }

    public void adopt(String adoptionCenterName) {
        AdoptionCenter adoptionCenter = getAdoptionCenterByName(adoptionCenterName);
        if(adoptionCenter != null){
            adoptedAnimalsCount += adoptionCenter.adopt();
        }
    }

    public void status(){
        System.out.println("Rex Incorporated Regular Statistics");
        System.out.println("Adoption Centers: " + adoptionCenterList.size());
        System.out.println("Adopted Animals: " + adoptedAnimalsCount);
        System.out.println("Animals Awaiting Adoption: " + getCleansedPetsCountFromAllAdoptionCenter());
        System.out.println("Animals Awaiting Cleansing: " + cleansingCenter.getPetAdoptionCenterMap().size());
    }

    private int getCleansedPetsCountFromAllAdoptionCenter() {
        int count = 0;
        for(AdoptionCenter adoptionCenter : adoptionCenterList){
            count += adoptionCenter.getCleansedPetsCount();
        }
        return count;
    }

    public List<AdoptionCenter> getAdoptionCenterList() {
        return adoptionCenterList;
    }
}
