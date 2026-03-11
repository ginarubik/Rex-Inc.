package hu.progmasters.rex;

import java.util.Scanner;

public class Engine {

    private Scanner scanner = new Scanner(System.in);
    private RexInc rexInc = new RexInc();

    public void run(){
        boolean running = true;
        String command = "";
        String[] commandArray;
        while(running){
            command = scanner.nextLine();
            commandArray = splitCommand(command);
            switch(commandArray[0]){
                case "RegisterAdoptionCenter":
                    rexInc.registerAdoptionCenter(commandArray[1]);
                    break;
                case "RegisterDog":
                    rexInc.registerDog(commandArray[1], commandArray[2], commandArray[3], commandArray[4]);
                    break;
                case "RegisterCat":
                    rexInc.registerCat(commandArray[1], commandArray[2], commandArray[3], commandArray[4]);
                    break;
                case "SendForCleansing":
                    rexInc.sendForCleansing(commandArray[1]);
                    break;
                case "Cleanse":
                    rexInc.cleanse();
                    break;
                case "Adopt":
                    rexInc.adopt(commandArray[1]);
                    break;
                case "Quit":
                    running = false;
            }
        }
        rexInc.status();
    }

    private String[] splitCommand(String command) {
        return command.split(" \\| ");
    }
}
