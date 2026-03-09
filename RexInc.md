OOP Exercise – Rex Inc.
Rex Incorporated is a large corporation that has the grand mission to rescue all street dogs 
and cats, shelter them, and possibly find a family to adopt them. You have been tasked to 
create a software program that oversees the operations of Rex Inc.
Overview
Rex Inc. has several Adoption centers and one Cleansing center.
The Adoption centers’ main function is to provide the functionality of finding new home for an
already cleansed animal.
The main function of the Cleansing center is to cleanse the animals of all types of dirt, 
diseases or any parasites on them, so that they can be suitable for adoption. The Cleansing 
center can take over and cleanse animals from any Adoption center.
The animals are first registered in the Adoption centers. However, they can ONLY be adopted 
after they are cleansed. 
Upon receiving the command, a particular Adoption center sends all of its stored animals to 
the Cleansing center.
Upon receiving the command, a particular Cleansing center cleanses all of its stored 
animals, and returns each stored animal to the Adoption center it received it from.
Rex Inc. works with two types of pets – dogs and cats. 
Dogs are not quite smart, but they are loyal, so they have a particular amount of commands 
they have learned.
Cats are quite intelligent, so they have an estimated intelligence coefficient.
Task 1: Implementing the class structure & hierarchy
You need to implement the needed class structure for the components of Rex Inc.
The Centers:
 Adoption Center – has a name and one list of the stored animals (both 
uncleansed and cleansed). Provides functionality for sending animals for cleansing and 
f
inding new homes for them.
o The name will be a string, which could consist of any ASCII character.
o The stored animals can be many and can be both dogs and cats.
o Upon receiving the send for cleanse command, it sends all of its stored 
uncleansed animals to the  Cleansing center, so that they can be cleansed.
Follow 
us:
Page 1 of 4
o Upon receiving the adoption command, all of the cleansed animals, 
currently in the adoption center, get adopted and removed from the stored 
animals.
 Cleansing Center – has one list of the stored animals (hint:.store them in 
Map<Animal, AdoptionCenter>) Provides functionality for cleansing animals.
o The stored animals can be many and can be both dogs and cats.
o Upon receiving the cleansing command, it cleanses all of the stored animals 
it has, and returns each to the Adoption center it received it from.
The Animals:
 Dog – has a name, age, cleansing status and amount of commands it has 
learned.
o The name of the dog is a string, which can consist of any ASCII character.
o The age of the dog is an integer.
o The amount of commands of the dog is an integer.
 Cat – has a name, age, cleansing status and intelligence coefficient.
o The name of the cat is a string, which can consist of any ASCII character.
o The age of the cat is an integer.
o The intelligence coefficient of the cat is an integer.
By default, all animals are UNCLEANSED upon registration.
Task 2: Implementing the main functionality and
application logic
The functionality of Rex Inc. is interpreted through commands. There are several commands 
you need to have in mind.
Commands
 RegisterAdoptionCenter | {name}
o Registers an Adoption center with the given name.
 RegisterDog | {name} | {age} | {learnedCommands} | 
{adoptionCenterName}
o Registers a dog with the given name, age and amount of learned 
commands in the given Adoption center.
 RegisterCat | {name} | {age| | {intelligenceCoefficient} | 
{adoptionCenterName}
o Registers a cat with the given name, age and intelligence coefficient in the 
given Adoption center.
 SendForCleansing | {adoptionCenterName} 
o Sends all UNCLEANSED animals from the given Adoption center to the 
Cleansing center.
 Cleanse 
o Cleanses all animals in the Cleansing center and returns them to their 
corresponding Adoption centers.
 Adopt | {adoptionCenterName}
Follow 
us:
Page 2 of 4
o All CLEANSED animals from the given Adoption center get adopted, and 
removed from the stored animals.
 Quit
o This command terminates the input sequence.
You can safely assume that there will be NO invalid input commands. There will be NO 
duplicate names for the Cleansing and Adoption centers. There will be NO nonexistent 
centers in the commands. 
Task 3: Encapsulating the data
Make sure no data is revealed completely, unless it is absolutely needed for it to be. Make 
sure you hide all data and also make sure that the input data follows the rules, specified in 
Task 1.
Task 4: Presenting the Output 
No output should be printed as the result of executing commands.
The only output you should print is when you receive the input sequence terminating 
command. Then you should print the following:
“Rex Incorporated Regular Statistics
Adoption Centers: {amountOfAdoptionCenters}
Adopted Animals: {amountOfAdoptedAnimals}  
Animals Awaiting Adoption: {amountOfAnimalsWaitingForAdoption}
Animals Awaiting Cleansing: {amountOfAnimalsWaitingForCleansing}”
You need to present the count of all registered Adoption centers.
You need to show the amount of all ADOPTED animals.
You need to show the amount of all CLEANSED animals in the Adoption centers, waiting to 
be adopted.
You need to show the amount of all UNCLEANSED animals in the Cleansing centers, 
waiting to be cleansed.
Input
 The input will come in the form of commands, in the format specified above.
 The input sequence ends when the command “Quit” is received.
Output
 The only output you need to print is the final one, when the input sequence ends. 
Constraints
 The names of the centers and the animals can consist of any ASCII characters.
 The input age of the animals will be a valid integer in range [0, 231 – 1].
 The input amount of learned commands for the dogs will be a valid integer in range [0, 
231 – 1].
 The input intelligence coefficient for the cats will be a valid integer in range [0, 231 – 1].
Follow 
us:
Page 3 of 4
 You can safely assume that all commands will follow the format specified above.
 You can safely assume there will be NO duplicate names for the centers or the 
animals.
Example
Input
Output
RegisterAdoptionCenter | Beam of Hope
RegisterDog | Beethoven | 3 | 18 | Beam of Hope
RegisterCat | Safranek | 14 | 200 | Beam of Hope
SendForCleansing | Beam of Hope
RegisterAdoptionCenter | Find Your Soulmate
RegisterDog | Toto | 1 | 2 | Find Your Soulmate
RegisterDog | Snoopy | 3 | 7 | Find Your Soulmate
SendForCleansing | Find Your Soulmate
Cleanse
RegisterCat | Schrödinger | 0 | 99 | Find Your 
Soulmate
SendForCleansing | Find Your Soulmate
Adopt | Beam of Hope
Quit
Rex Incorporated Regular Statistics
Adoption Centers: 2
Adopted Animals: 2
Animals Awaiting Adoption: 2
Animals Awaiting Cleansing: 
