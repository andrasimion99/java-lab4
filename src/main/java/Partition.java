import java.util.ArrayList;
import java.util.List;

/**
 * Partition va reprezenta o lista de obiecte de tip Element(ex: Resident/Hospital)
 */
public class Partition {
    List<Element> partitionList = new ArrayList<>();

    public Partition(List<Element> partitionList) {
        this.partitionList = partitionList;
    }

    public List<Element> getPartitionList() {
        return partitionList;
    }

    public void setPartitionList(List<Element> partitionList) {
        this.partitionList = partitionList;
    }
}
