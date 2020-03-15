import java.util.ArrayList;
import java.util.List;

/**
 * Hospital va fi de tipul element
 *  nu are metode speciale, decat cele din interfata
 */
public class Hospital implements Comparable<Hospital>, Element {
    String name;
    int capacity;
    List<Element> prefList = new ArrayList<>();

    public Hospital(String name) {
        this.name = name;
    }

    public Hospital(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
    }

    public Hospital(String name, int capacity, List<Element> prefList) {
        this.name = name;
        this.capacity = capacity;
        this.prefList = prefList;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    @Override
    public List<Element> getPrefList() {
        return prefList;
    }

    public void setPrefList(List<Element> prefList) {
        this.prefList = prefList;
    }

    public int compareTo(Hospital h) {
        return this.getName().compareTo(h.getName());
    }

    @Override
    public String toString() {
        return "Hospital{" +
                "name='" + name + '\'' +
                ", capacity=" + capacity +
                '}';
    }
}
