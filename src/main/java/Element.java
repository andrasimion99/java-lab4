import java.util.List;

/**
 * Element este o interfata pentru Resident si Hospital
 * Fiecare element va avea un nume, o lista de preferinte tot de tipul Element si o capacitate
 * Daca Element va fi Resident, lista lui de preferinte se va compune din Obiecte de tip Hospital, si vice versa.
 */
public interface Element {

    String getName();

    void setPrefList(List<Element> prefList);

    List<Element> getPrefList();

    int getCapacity();

    void setCapacity(int capacity);

}
