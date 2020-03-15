import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Clasa matching va avea un atribut in care se va retine o mapa cu maching-ul final intre cdoua obiecte de tip Partition
 * De asemenea, are implementata si o metoda pentru algoritmul de matching
 */
public class Matching {
    Map<Element, Element> matches = new HashMap<>();

    public Map<Element, Element> getMatches() {
        return matches;
    }

    public void setMatches(Map<Element, Element> matches) {
        this.matches = matches;
    }

    /**
     *
     * @param p1 reprezinta prima partitie de obiecte de tip Element
     * @param p2 reprezinta a doua partitie de obiecte de tip Element
     *           metoda va calcula matching-ul final astfel:
     *           circula prin prima partitie si pentru fiecare Element se uita la lista lui de preferinte de Elemente de celalalt tip
     *           daca in lista de preferinte gaseste un element care sa aiba capacitate nenula si in lista acestuia de preferinta se afla si elementul din prima partitie
     *           atunci se adaga n map-ul final.
     */
    public void matchingAlg(Partition p1, Partition p2) {
        List<Element> lista1 = p1.getPartitionList();
//        List<Element> lista2 = p2.getPartitionList();
        for (Element e1 : lista1) {
            for (Element e2 : e1.getPrefList()) {
                if (e2.getCapacity() > 0 && e2.getPrefList().contains(e1)) {
                    matches.put(e1, e2);
                    e2.setCapacity(e2.getCapacity() - 1);
                    break;
                }
            }
        }
    }
}
