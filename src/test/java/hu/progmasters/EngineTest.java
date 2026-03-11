package hu.progmasters.rex;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

class EngineTest {

    Engine engine;
    InputStream inputStream;

    @BeforeEach
    void init(){
        inputStream = System.in;
        engine = new Engine();
    }

    @Test
    void createAdoptionCenterFromCommand(){
        System.setIn(new ByteArrayInputStream("RegisterAdoptionCenter | Beam of Hope\nQuit\n".getBytes()));
        engine.scanner = new Scanner(System.in);
        engine.run();

        assertEquals(1, engine.rexInc.getAdoptionCenterList().size());
    }

    @Test
    void registerDogFromCommand(){
        System.setIn(new ByteArrayInputStream(("RegisterAdoptionCenter | Beam of Hope\n" +
                "RegisterDog | Beethoven | 3 | 18 | Beam of Hope\n" +
                "Quit\n").getBytes()));
        engine.scanner = new Scanner(System.in);
        engine.run();

        assertEquals(1, engine.rexInc.getAdoptionCenterList().size());
        assertEquals(1, engine.rexInc.getAdoptionCenterList().get(0).getPets().size());
        assertEquals("Beethoven",  engine.rexInc.getAdoptionCenterList().get(0).getPets().get(0).getName());
    }

}
