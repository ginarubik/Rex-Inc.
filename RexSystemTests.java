import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

public class RexSystemTests {

    // -----------------------
    // PET / DOG / CAT TESTS
    // -----------------------

    @Test
    void dogShouldBeUncleansedInitially() {

        Dog dog = new Dog("Rex", 3, 5);

        assertFalse(dog.isCleansed());
    }

    @Test
    void cleanseShouldMarkPetAsCleansed() {

        Dog dog = new Dog("Rex", 3, 5);

        dog.cleanse();

        assertTrue(dog.isCleansed());
    }

    @Test
    void catShouldStoreIntelligenceCoefficient() {

        Cat cat = new Cat("Kitty", 2, 120);

        assertEquals(120, cat.getIntelligenceCoefficient());
    }

    // -----------------------
    // FACTORY TESTS
    // -----------------------

    @Test
    void factoryShouldCreateDog() {

        PetFactory factory = new PetFactory();

        Pet dog = factory.createDog("Rex", 4, 10);

        assertTrue(dog instanceof Dog);
    }

    @Test
    void factoryShouldCreateCat() {

        PetFactory factory = new PetFactory();

        Pet cat = factory.createCat("Mittens", 2, 80);

        assertTrue(cat instanceof Cat);
    }

    // -----------------------
    // ADOPTION CENTER TESTS
    // -----------------------

    @Test
    void adoptionCenterShouldSendOnlyUncleansedPets() {

        AdoptionCenter center = new AdoptionCenter("Center1");

        Dog dog = new Dog("Dog1", 2, 5);
        Cat cat = new Cat("Cat1", 1, 90);

        cat.cleanse();

        center.addPet(dog);
        center.addPet(cat);

        List<Pet> result = center.sendForCleansing();

        assertEquals(1, result.size());
        assertEquals("Dog1", result.get(0).getName());
    }

    @Test
    void adoptionCenterShouldAdoptOnlyCleansedPets() {

        AdoptionCenter center = new AdoptionCenter("Center1");

        Dog dog = new Dog("Dog1", 2, 5);
        dog.cleanse();

        center.addPet(dog);

        int adopted = center.adopt();

        assertEquals(1, adopted);
    }

    // -----------------------
    // CLEANSING CENTER TESTS
    // -----------------------

    @Test
    void cleansingCenterShouldCleanPets() {

        CleansingCenter cleansingCenter = new CleansingCenter();
        AdoptionCenter center = new AdoptionCenter("Center1");

        Dog dog = new Dog("Dog1", 1, 3);

        cleansingCenter.addPet(dog, center);

        cleansingCenter.cleanse();

        assertTrue(dog.isCleansed());
    }

    // -----------------------
    // REPOSITORY TESTS
    // -----------------------

    @Test
    void repositoryShouldStoreCenters() {

        CenterRepository repo = new CenterRepository();

        AdoptionCenter center = new AdoptionCenter("Center1");

        repo.addCenter(center);

        assertEquals(1, repo.count());
    }

    // -----------------------
    // SERVICE TESTS
    // -----------------------

    @Test
    void serviceShouldRegisterAdoptionCenter() {

        RexService service = new RexService();

        service.registerAdoptionCenter("Center1");

        assertEquals(1, service.centersCount());
    }

    @Test
    void serviceShouldSendPetsForCleansing() {

        RexService service = new RexService();

        service.registerAdoptionCenter("Center1");

        service.registerDog("Dog1", 2, 5, "Center1");

        service.sendForCleansing("Center1");

        assertEquals(1, service.awaitingCleansing());
    }

    @Test
    void serviceShouldCleansePets() {

        RexService service = new RexService();

        service.registerAdoptionCenter("Center1");

        service.registerDog("Dog1", 2, 5, "Center1");

        service.sendForCleansing("Center1");
        service.cleanse();

        assertEquals(1, service.awaitingAdoption());
    }

    @Test
    void serviceShouldAdoptPets() {

        RexService service = new RexService();

        service.registerAdoptionCenter("Center1");

        service.registerDog("Dog1", 2, 5, "Center1");

        service.sendForCleansing("Center1");
        service.cleanse();
        service.adopt("Center1");

        assertEquals(1, service.adoptedPets());
    }

}
   
