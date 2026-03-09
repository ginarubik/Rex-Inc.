Test Coverage Summary
Class	Tested Behavior
Dog	initial state, cleansing
Cat	intelligence storage
PetFactory	object creation
AdoptionCenter	cleansing filter, adoption
CleansingCenter	pet cleansing
CenterRepository	storing centers
RexService	registration, cleansing flow, adoption

Total tests:

13 unit tests

(Above the required 9 minimum)

How to Run the Tests
Maven dependency (JUnit 5)
<dependency>
 <groupId>org.junit.jupiter</groupId>
 <artifactId>junit-jupiter</artifactId>
 <version>5.9.3</version>
 <scope>test</scope>
</dependency>

Run:

mvn test

or in IntelliJ:

Right click → Run Tests
