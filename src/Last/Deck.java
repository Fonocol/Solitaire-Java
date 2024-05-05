import java.util.ArrayList;
import java.util.List;

public class Deck extends PileCartes {
    private List<Carte> deck;
    private int carteUsed;
    private static final int allcards = 52;

    public Deck(int x , int y) {
        super(x, y);
        this.deck = new ArrayList<Carte>();
        // Ajoute les cartes de Piques
        for (int valeur = 1; valeur <= 13; valeur++) {
            deck.add(new Carte(valeur, Carte.PIQUES));
        }
        // Ajoute les cartes de Coeurs
        for (int valeur = 1; valeur <= 13; valeur++) {
            deck.add(new Carte(valeur, Carte.COEURS));
        }
        // Ajoute les cartes de Carreaux
        for (int valeur = 1; valeur <= 13; valeur++) {
            deck.add(new Carte(valeur, Carte.CARREAUX));
        }
        // Ajoute les cartes de Trefles
        for (int valeur = 1; valeur <= 13; valeur++) {
            deck.add(new Carte(valeur, Carte.TREFLES));
        }
        this.carteUsed = 0;
    }

    public void shuffle(){
        for(int i = 0; i < allcards; i++){
            int random = (int)(Math.random() * 52);
            Carte temp = deck.get(i);
            deck.set(i, deck.get(random));
            deck.set(random, temp);
        }
    }

    public Carte draw(){
        Carte carte = deck.get(carteUsed);
        carteUsed++;
        return carte;
    }

    public int cartesRestant(){
        return allcards - carteUsed;
    }

    
    
    @Override
    public String toString(){
        String res ="Deck{"+"\n"+ "**il ya "+ deck.size() +" cartes dans le desk**"+"\n";
        for (Carte carte : deck) {
            res += carte.toString();
        }
        return res+ '}';
    }

}















/*
 * import java.util.ArrayList;
import java.util.List;

public class Deck extends PileCartes {
    private List<Carte> deck;
    private int carteUsed;
    private static final int allcards = 52;

    public Deck(int x , int y) {
        super(x, y);
        this.deck = new ArrayList<Carte>();
        // Ajoute les cartes de Piques
        for (int valeur = 1; valeur <= 13; valeur++) {
            deck.add(new Carte(valeur, Carte.PIQUES));
        }
        // Ajoute les cartes de Coeurs
        for (int valeur = 1; valeur <= 13; valeur++) {
            deck.add(new Carte(valeur, Carte.COEURS));
        }
        // Ajoute les cartes de Carreaux
        for (int valeur = 1; valeur <= 13; valeur++) {
            deck.add(new Carte(valeur, Carte.CARREAUX));
        }
        // Ajoute les cartes de Trefles
        for (int valeur = 1; valeur <= 13; valeur++) {
            deck.add(new Carte(valeur, Carte.TREFLES));
        }
        this.carteUsed = 0;
    }

    public void shuffle(){
        for(int i = 0; i < allcards; i++){
            int random = (int)(Math.random() * 52);
            Carte temp = deck.get(i);
            deck.set(i, deck.get(random));
            deck.set(random, temp);
        }
    }

    public Carte draw(){
        Carte carte = deck.get(carteUsed);
        carteUsed++;
        return carte;
    }

    public int cartesRestant(){
        return allcards - carteUsed;
    }

    
    
    @Override
    public String toString(){
        String res ="Deck{"+"\n"+ "**il ya "+ deck.size() +" cartes dans le desk**"+"\n";
        for (Carte carte : deck) {
            res += carte.toString();
        }
        return res+ '}';
    }

}


 */