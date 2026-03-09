import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        RexService service = new RexService();

        while (true) {

            String input = scanner.nextLine();

            if (input.equals("Quit")) break;

            String[] tokens = input.split("\\s*\\|\\s*");

            switch (tokens[0]) {

                case "RegisterAdoptionCenter":
                    service.registerAdoptionCenter(tokens[1]);
                    break;

                case "RegisterDog":
                    service.registerDog(tokens[1],
                            Integer.parseInt(tokens[2]),
                            Integer.parseInt(tokens[3]),
                            tokens[4]);
                    break;

                case "RegisterCat":
                    service.registerCat(tokens[1],
                            Integer.parseInt(tokens[2]),
                            Integer.parseInt(tokens[3]),
                            tokens[4]);
                    break;

                case "SendForCleansing":
                    service.sendForCleansing(tokens[1]);
                    break;

                case "Cleanse":
                    service.cleanse();
                    break;

                case "Adopt":
                    service.adopt(tokens[1]);
                    break;
            }
        }

        System.out.println("Rex Incorporated Regular Statistics");
        System.out.println("Adoption Centers: " + service.centersCount());
        System.out.println("Adopted Animals: " + service.adoptedPets());
        System.out.println("Animals Awaiting Adoption: " + service.awaitingAdoption());
        System.out.println("Animals Awaiting Cleansing: " + service.awaitingCleansing());
    }
}
