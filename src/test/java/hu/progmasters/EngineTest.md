1. Package and Imports
package hu.progmasters.rex;

This means the class belongs to the hu.progmasters.rex package.

Imports:

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

These come from JUnit 5 and are used for writing tests.

Other imports:

ByteArrayInputStream → simulate console input

InputStream → general input stream

Scanner → read input

Assertions → check if results are correct

2. Class Definition
class EngineTest {

This class contains tests for the Engine class.

3. Fields
Engine engine;
InputStream inputStream;

Two variables:

engine → the system we are testing

inputStream → stores the original System.in

4. @BeforeEach Method
@BeforeEach
void init(){
    inputStream = System.in;
    engine = new Engine();
}

@BeforeEach means this method runs before every test.

It:

Saves the original console input

Creates a new Engine object

So every test starts clean.

5. First Test: Create Adoption Center
@Test
void createAdoptionCenterFromCommand(){

This test checks if the command RegisterAdoptionCenter works.

Fake input
System.setIn(new ByteArrayInputStream(
"RegisterAdoptionCenter | Beam of Hope\nQuit\n".getBytes()));

Instead of typing in the console, we simulate this input:

RegisterAdoptionCenter | Beam of Hope
Quit

Meaning:

Create adoption center named Beam of Hope

Stop program

Connect scanner
engine.scanner = new Scanner(System.in);

Now the engine reads the simulated input.

Run engine
engine.run();

This executes the command system.

Assertion
assertEquals(1, engine.rexInc.getAdoptionCenterList().size());

We check that:

Number of adoption centers == 1

If not → test fails.

6. Second Test: Register Dog
@Test
void registerDogFromCommand(){

This test checks dog registration.

Simulated commands
RegisterAdoptionCenter | Beam of Hope
RegisterDog | Beethoven | 3 | 18 | Beam of Hope
Quit

Meaning:

1️⃣ Create adoption center
2️⃣ Register dog named Beethoven

Dog properties:

Property	Value
Name	Beethoven
Age	3
Weight	18
Center	Beam of Hope
Run engine
engine.scanner = new Scanner(System.in);
engine.run();
Assertions
Check adoption center exists
assertEquals(1, engine.rexInc.getAdoptionCenterList().size());
Check pet was added
assertEquals(1, engine.rexInc.getAdoptionCenterList().get(0).getPets().size());

Meaning:

The center has 1 pet
Check dog name
assertEquals("Beethoven",
engine.rexInc.getAdoptionCenterList().get(0).getPets().get(0).getName());

This verifies the dog created is Beethoven.

7. What This Test Class Verifies

The Engine must correctly process commands:

Command	Expected result
RegisterAdoptionCenter	create center
RegisterDog	add dog to center
Quit	stop engine
8. Key Testing Technique Used

The important trick here is:

System.setIn(new ByteArrayInputStream(...))

This simulates console input, allowing automated tests for programs that normally read from the terminal.

✅ Summary

This test class ensures that:

1️⃣ The engine can create adoption centers
2️⃣ The engine can register dogs to centers
3️⃣ The system stores data correctly

