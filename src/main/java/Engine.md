This Engine class acts as the command processor / controller of the program.

Essentially, this is a text-based command system for managing animals and adoption centers.

The public class Engine is responsible for: reading user input from the console, interprets commands, and calls methods in another class called RexInc.

Parsing the command: refers to the process of analyzing a command line input—such as a user's typed command in a terminal or shell—to break it down into meaningful components like the command name, options (flags), and arguments.

Calling the correct method in RexInc

Running until the user types "Quit"

So it acts like the main program loop.

Fields (Variables) private Scanner scanner = new Scanner(System.in);

Scanner reads input from the console (keyboard).

System.in = standard input.

Example input:

RegisterDog | Rex | 3 | Male | Center1 private RexInc rexInc = new RexInc();

This creates an object of the class RexInc.

RexInc likely contains the business logic, such as:

storing animals

managing adoption centers

cleansing animals

adoption process

So:

Engine = command interpreter RexInc = system logic The run() Method public void run() This method runs the main program loop.

1.Start Loop boolean running = true;

Controls whether the program keeps running.

while(running){

This means:

Keep running until Quit command appears 2.Read User Command command = scanner.nextLine();

Reads a full line typed by the user.

Example:

RegisterDog | Rex | 3 | Male | Center1

3.Split Command commandArray = splitCommand(command);

This converts the command string into an array of parts.

The method used:

private String[] splitCommand(String command) { return command.split(" \| "); }

The separator is:

|

Example result:

Input:

RegisterDog | Rex | 3 | Male | Center1

Array:

commandArray[0] = RegisterDog commandArray[1] = Rex commandArray[2] = 3 commandArray[3] = Male commandArray[4] = Center1

Switch Command switch(commandArray[0])
The program checks the first word of the command to decide what to do.

Supported Commands Register Adoption Center case "RegisterAdoptionCenter": rexInc.registerAdoptionCenter(commandArray[1]);

Example input:

RegisterAdoptionCenter | Center1 Register Dog case "RegisterDog": rexInc.registerDog(commandArray[1], commandArray[2], commandArray[3], commandArray[4]);

Example:

RegisterDog | Rex | 3 | Male | Center1

Parameters:

name age gender adoptionCenter Register Cat case "RegisterCat": rexInc.registerCat(commandArray[1], commandArray[2], commandArray[3], commandArray[4]);

Example:

RegisterCat | Kitty | 2 | Female | Center1 Send Animal for Cleansing case "SendForCleansing": rexInc.sendForCleansing(commandArray[1]);

Example:

SendForCleansing | Center1

Likely sends animals to a cleansing center.

Cleanse Animals case "Cleanse": rexInc.cleanse();

Example:

Cleanse

Probably marks animals as clean.

Adopt Animals case "Adopt": rexInc.adopt(commandArray[1]);

Example:

Adopt | Center1

Adopts animals from a center.

Quit Program case "Quit": running = false;

Stops the loop.

After the Loop Ends

When "Quit" is entered:

rexInc.status();

The system prints a final status report.

Example things it might show:

adopted animals

animals awaiting adoption

cleansing centers

adoption centers

Execution Flow Program starts ↓ Main creates Engine ↓ Engine.run() ↓ Loop starts ↓ User enters command ↓ Command is split ↓ Switch chooses action ↓ Method in RexInc is called ↓ Repeat until Quit ↓ Print final status Example Session

Input:

RegisterAdoptionCenter | Center1 RegisterDog | Rex | 3 | Male | Center1 RegisterCat | Kitty | 2 | Female | Center1 SendForCleansing | Center1 Cleanse Adopt | Center1 Quit

Output:

System status... (adoption and animal information)

This method runs the main program loop.

1️⃣ Start Loop boolean running = true;

Controls whether the program keeps running.

while(running){

This means:

Keep running until Quit command appears 2️⃣ Read User Command command = scanner.nextLine();

Reads a full line typed by the user.

Example:

RegisterDog | Rex | 3 | Male | Center1 3️⃣ Split Command commandArray = splitCommand(command);

This converts the command string into an array of parts.

The method used:

private String[] splitCommand(String command) { return command.split(" \| "); }

The separator is:

|

Example result:

Input:

RegisterDog | Rex | 3 | Male | Center1

Array:

commandArray[0] = RegisterDog commandArray[1] = Rex commandArray[2] = 3 commandArray[3] = Male commandArray[4] = Center1 4️⃣ Switch Command switch(commandArray[0])

The program checks the first word of the command to decide what to do.

Supported Commands Register Adoption Center case "RegisterAdoptionCenter": rexInc.registerAdoptionCenter(commandArray[1]);

Example input:

RegisterAdoptionCenter | Center1 Register Dog case "RegisterDog": rexInc.registerDog(commandArray[1], commandArray[2], commandArray[3], commandArray[4]);

Example:

RegisterDog | Rex | 3 | Male | Center1

Parameters:

name age gender adoptionCenter Register Cat case "RegisterCat": rexInc.registerCat(commandArray[1], commandArray[2], commandArray[3], commandArray[4]);

Example:

RegisterCat | Kitty | 2 | Female | Center1 Send Animal for Cleansing case "SendForCleansing": rexInc.sendForCleansing(commandArray[1]);

Example:

SendForCleansing | Center1

Likely sends animals to a cleansing center.

Cleanse Animals case "Cleanse": rexInc.cleanse();

Example:

Cleanse

Probably marks animals as clean.

Adopt Animals case "Adopt": rexInc.adopt(commandArray[1]);

Example:

Adopt | Center1

Adopts animals from a center.

Quit Program case "Quit": running = false;

Stops the loop.

After the Loop Ends

When "Quit" is entered:

rexInc.status();

The system prints a final status report.

Example things it might show:

adopted animals

animals awaiting adoption

cleansing centers

adoption centers

Execution Flow Program starts ↓ Main creates Engine ↓ Engine.run() ↓ Loop starts ↓ User enters command ↓ Command is split ↓ Switch chooses action ↓ Method in RexInc is called ↓ Repeat until Quit ↓ Print final status Example Session

Input:

RegisterAdoptionCenter | Center1 RegisterDog | Rex | 3 | Male | Center1 RegisterCat | Kitty | 2 | Female | Center1 SendForCleansing | Center1 Cleanse Adopt | Center1 Quit

Output:

System status... (adoption and animal information)

Summary

Engine is a command-driven console controller that:

reads input

parses commands

calls methods in RexInc

stops when "Quit" is typed

prints final system status.
