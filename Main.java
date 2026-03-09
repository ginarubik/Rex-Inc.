import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        RexController controller = new RexController();

        while (true) {

            String line = scanner.nextLine();

            if (line.equals("Quit")) break;

            String[] tokens = line.split("\\s*\\|\\s*");

            String command = tokens[0];

            switch (command) {

                case "RegisterAdoptionCenter":
                    controller.registerAdoptionCenter(tokens[1]);
                    break;

                case "RegisterDog":
                    controller.registerDog(
                            tokens[1],
                            Integer.parseInt(tokens[2]),
                            Integer.parseInt(tokens[3]),
                            tokens[4]);
                    break;

                case "RegisterCat":
                    controller.registerCat(
                            tokens[1],
                            Integer.parseInt(tokens[2]),
                            Integer.parseInt(tokens[3]),
                            tokens[4]);
                    break;

                case "SendForCleansing":
                    controller.sendForCleansing(tokens[1]);
                    break;

                case "Cleanse":
                    controller.cleanse();
                    break;

                case "Adopt":
                    controller.adopt(tokens[1]);
                    break;
            }
        }

        System.out.println("Rex Incorporated Regular Statistics");
        System.out.println("Adoption Centers: " + controller.getAdoptionCentersCount());
        System.out.println("Adopted Animals: " + controller.getAdoptedAnimals());
        System.out.println("Animals Awaiting Adoption: " + controller.getAnimalsAwaitingAdoption());
        System.out.println("Animals Awaiting Cleansing: " + controller.getAnimalsAwaitingCleansing());
    }
}
