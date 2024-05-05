import java.util.Comparator;

public class ComparatorCartes implements Comparator<Carte> {

    @Override
    public int compare(Carte c1, Carte c2) {
        return Integer.compare(c1.getValue(), c2.getValue());
    }
}