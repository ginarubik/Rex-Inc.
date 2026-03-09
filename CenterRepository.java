import java.util.*;

public class CenterRepository {

    private Map<String, AdoptionCenter> centers = new HashMap<>();

    public void addCenter(AdoptionCenter center) {
        centers.put(center.getName(), center);
    }

    public AdoptionCenter get(String name) {
        return centers.get(name);
    }

    public int count() {
        return centers.size();
    }

    public Collection<AdoptionCenter> getAll() {
        return centers.values();
    }
}
