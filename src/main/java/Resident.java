import java.util.ArrayList;
import java.util.List;

/**
 * Rezidentul va fi de tipul Element
 * nu are metode speciale, decat cele din interfata
 */
public class Resident implements Element {
    String name;
    int capacity;
    List<Element> prefList = new ArrayList<>();

    public Resident(String name) {
        this.name = name;
    }

    public Resident(String name, List<Element> prefList) {
        this.name = name;
        this.prefList = prefList;
    }

    @Override
    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public List<Element> getPrefList() {
        return prefList;
    }

    public void setPrefList(List<Element> prefList) {
        this.prefList = prefList;
    }

    @Override
    public String toString() {
        return "Resident{" +
                "name='" + name + '\'' +
                '}';
    }
}
