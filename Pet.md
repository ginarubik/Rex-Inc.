This class defines a base (parent) class for pets in the system. It represents the common properties and behavior that all pets share (for example dogs and cats).
1. Package
package hu.progmasters.rex.pets;

This class belongs to the package:

hu.progmasters.rex.pets

So the folder structure would look like:

hu
 └─ progmasters
     └─ rex
         └─ pets
             └─ Pet.java

The pets package likely contains:

Pet (base class)

Dog

Cat

2. Abstract Class
public abstract class Pet

abstract means:

You cannot create objects of Pet directly.

It is meant to be extended by other classes.

Example:

Dog extends Pet
Cat extends Pet

So instead of:

Pet pet = new Pet(...); // not allowed

You would use:

Dog dog = new Dog(...);
Cat cat = new Cat(...);
3. Fields (Attributes)
private String name;
private int age;
private boolean cleansed;

Each pet has:

Field	Type	Meaning
name	String	name of the pet
age	int	age of the pet
cleansed	boolean	whether the pet has been cleansed

Example object state:

name = "Rex"
age = 3
cleansed = false
4. Constructor
public Pet(String name, int age){
    this.name = name;
    this.age = age;
    this.cleansed = false;
}

The constructor initializes the object.

When a new pet is created:

the name is set

the age is set

the pet starts not cleansed

Example:

Dog dog = new Dog("Rex", 3);

After construction:

name = Rex
age = 3
cleansed = false
5. Getter Method
public boolean isCleansed() {
    return cleansed;
}

This method returns whether the pet is cleansed.

Example:

if(pet.isCleansed()){
    // pet is clean
}

The name isCleansed() follows Java convention for boolean getters.

6. Setter Method
public void setCleansed(boolean cleansed) {
    this.cleansed = cleansed;
}

This method changes the cleansed state.

Example:

pet.setCleansed(true);

After that:

cleansed = true

This would likely happen when the system executes the Cleanse command.

7. OOP Design

This class demonstrates inheritance.

Example structure:

        Pet (abstract)
        /        \
      Dog        Cat

Dog and Cat will inherit:

name

age

cleansed

isCleansed()

setCleansed()

So those classes don't need to rewrite that code.

Example child class:

public class Dog extends Pet {

    private String breed;

    public Dog(String name, int age, String breed) {
        super(name, age);
        this.breed = breed;
    }
}

super(name, age) calls the Pet constructor.

8. Why Use an Abstract Parent Class?

Because dogs and cats share common features.

Instead of duplicating code:

Dog -> name, age, cleansed
Cat -> name, age, cleansed

We store them once in Pet.

Benefits:

cleaner code

easier maintenance

better OOP design

Summary

Pet is an abstract base class that represents a generic animal in the system.

It stores:

pet name

pet age

whether the pet is cleansed

And it is meant to be extended by classes like:

Dog
Cat
