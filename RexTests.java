import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class RexTests {

    @Test
    void testRegisterAdoptionCenter() {

        RexController controller = new RexController();

        controller.registerAdoptionCenter("Center1");

        assertEquals(1, controller.getAdoptionCentersCount());
    }

    @Test
    void testRegisterDog() {

        RexController controller = new RexController();

        controller.registerAdoptionCenter("Center1");
        controller.registerDog("Rex",2,5,"Center1");

        controller.sendForCleansing("Center1");

        assertEquals(1, controller.getAnimalsAwaitingCleansing());
    }

    @Test
    void testRegisterCat() {

        RexController controller = new RexController();

        controller.registerAdoptionCenter("Center1");
        controller.registerCat("Kitty",1,100,"Center1");

        controller.sendForCleansing("Center1");

        assertEquals(1, controller.getAnimalsAwaitingCleansing());
    }

    @Test
    void testSendForCleansing() {

        RexController controller = new RexController();

        controller.registerAdoptionCenter("Center1");
        controller.registerDog("Dog",1,3,"Center1");

        controller.sendForCleansing("Center1");

        assertEquals(1, controller.getAnimalsAwaitingCleansing());
    }

    @Test
    void testCleanseAnimals() {

        RexController controller = new RexController();

        controller.registerAdoptionCenter("Center1");
        controller.registerDog("Dog",1,3,"Center1");

        controller.sendForCleansing("Center1");
        controller.cleanse();

        assertEquals(1, controller.getAnimalsAwaitingAdoption());
    }

    @Test
    void testAdoption() {

        RexController controller = new RexController();

        controller.registerAdoptionCenter("Center1");
        controller.registerDog("Dog",1,3,"Center1");

        controller.sendForCleansing("Center1");
        controller.cleanse();
        controller.adopt("Center1");

        assertEquals(1, controller.getAdoptedAnimals());
    }

    @Test
    void testMultipleAnimals() {

        RexController controller = new RexController();

        controller.registerAdoptionCenter("Center1");

        controller.registerDog("Dog1",1,3,"Center1");
        controller.registerCat("Cat1",2,50,"Center1");

        controller.sendForCleansing("Center1");
        controller.cleanse();

        assertEquals(2, controller.getAnimalsAwaitingAdoption());
    }

    @Test
    void testAdoptRemovesAnimals() {

        RexController controller = new RexController();

        controller.registerAdoptionCenter("Center1");
        controller.registerDog("Dog1",1,3,"Center1");

        controller.sendForCleansing("Center1");
        controller.cleanse();
        controller.adopt("Center1");

        assertEquals(0, controller.getAnimalsAwaitingAdoption());
    }
}
