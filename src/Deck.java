public class Deck extends PileCartes {
    private int carteUsed;
    private static final int allcards = 52;

    public Deck(int x , int y) {
        super(x, y);
        // Ajoute les cartes de Piques
        for (int valeur = 1; valeur <= 13; valeur++) {
            push(new Carte(valeur, Carte.PIQUES));
        }
        // Ajoute les cartes de Coeurs
        for (int valeur = 1; valeur <= 13; valeur++) {
            push(new Carte(valeur, Carte.COEURS));
        }
        // Ajoute les cartes de Carreaux
        for (int valeur = 1; valeur <= 13; valeur++) {
            push(new Carte(valeur, Carte.CARREAUX));
        }
        // Ajoute les cartes de Trefles
        for (int valeur = 1; valeur <= 13; valeur++) {
            push(new Carte(valeur, Carte.TREFLES));
        }
        
        this.carteUsed = 0;
    }

    public void shuffle(){
        for(int i = 0; i < allcards; i++){
            int random = (int)(Math.random() * 52);
            Carte temp = carteLinkedList.get(i);
            carteLinkedList.set(i, carteLinkedList.get(random));
            carteLinkedList.set(random, temp);
        }
    }

    public Carte draw_Carte(){
        Carte carte = carteLinkedList.get(carteUsed);
        carteUsed++;
        return carte;
    }

    public int cartesRestant(){
        return allcards - carteUsed;
    }

    
    
    @Override
    public String toString(){
        String res ="Deck{"+"\n"+ "**il ya "+ carteLinkedList.size() +" cartes dans le desk**"+"\n";
        for (Carte carte : carteLinkedList) {
            res += carte.toString();
        }
        return res+ '}';
    }

}
