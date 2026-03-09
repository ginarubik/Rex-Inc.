public class RexService {

    private CenterRepository repository;
    private CleansingCenter cleansingCenter;
    private PetFactory factory;

    private int adoptedPets;

    public RexService() {
        repository = new CenterRepository();
        cleansingCenter = new CleansingCenter();
        factory = new PetFactory();
    }

    public void registerAdoptionCenter(String name) {
        repository.addCenter(new AdoptionCenter(name));
    }

    public void registerDog(String name, int age, int commands, String centerName) {

        Pet dog = factory.createDog(name, age, commands);
        repository.get(centerName).addPet(dog);
    }

    public void registerCat(String name, int age, int iq, String centerName) {

        Pet cat = factory.createCat(name, age, iq);
        repository.get(centerName).addPet(cat);
    }

    public void sendForCleansing(String centerName) {

        AdoptionCenter center = repository.get(centerName);

        for (Pet pet : center.sendForCleansing()) {
            cleansingCenter.addPet(pet, center);
        }
    }

    public void cleanse() {
        cleansingCenter.cleanse();
    }

    public void adopt(String centerName) {
        adoptedPets += repository.get(centerName).adopt();
    }

    public int centersCount() {
        return repository.count();
    }

    public int adoptedPets() {
        return adoptedPets;
    }

    public int awaitingAdoption() {

        return repository.getAll()
                .stream()
                .mapToInt(AdoptionCenter::awaitingAdoption)
                .sum();
    }

    public int awaitingCleansing() {
        return cleansingCenter.awaitingCleansing();
    }
}
