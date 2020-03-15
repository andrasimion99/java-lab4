import java.util.Map;

/**
 * Clasa Problem va returna solutia apeland metoda din clasa Metching intre doua partitii
 */
public class Problem {
    private Partition p1;
    private Partition p2;

    public Problem(Partition p1, Partition p2) {
        this.p1 = p1;
        this.p2 = p2;
    }

    public Partition getP1() {
        return p1;
    }

    public void setP1(Partition p1) {
        this.p1 = p1;
    }

    public Partition getP2() {
        return p2;
    }

    public void setP2(Partition p2) {
        this.p2 = p2;
    }

    /**
     *
     * @return map-ul final cu matching intre cele doua partitii date ca atribute ale problemei
     */
    public Map<Element, Element> getSolution() {
        Matching matching = new Matching();
        matching.matchingAlg(p1, p2);
        return matching.getMatches();
    }
}
