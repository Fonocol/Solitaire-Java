import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Player {
    private List<Carte> cartesList;
    private int nbCartes;

    public Player() {
        this.cartesList = new ArrayList<Carte>();
        this.nbCartes = 0;
    }

    public void clear(){
        cartesList.clear();
        nbCartes = 0;
    }

    public void addCart(Carte c){
        if (cartesList.size() < 6){
            cartesList.add(c);
            nbCartes++;   
        } 
    }

    public void removeCart(int position){
        if(position <= 6 && cartesList.get(position) != null){
            cartesList.remove(position);
            nbCartes--;
        }
    }

    public Carte getCart(int position){
        return cartesList.get(position);
    }

    public void sortByValue(){
        //cartesList.sort(null);
        Collections.sort(cartesList, new ComparatorCartes());
    }

    public int getNbCartes() {
        return nbCartes;
    }

    @Override
    public String toString() {
        String res ="";
        res += "Player{" + "\n"+"****il y a "+ nbCartes +" Cartes****"+"\n";
        for (Carte carte : cartesList) {
            res += carte.toString();
        }
        return res+ '}';
    }

}
