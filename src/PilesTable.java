import javafx.scene.canvas.GraphicsContext;

public class PilesTable extends PileCartes {
    private int nombreDeCartes;
    public static final int YDIST =25;
    //private Deck deck;

    public PilesTable(int x, int y,int n) {
        super(x, y);
        this.nombreDeCartes = n;

        for (int i = 0; i < nombreDeCartes; i++) {
            if(Solitaire.deck.taille() > 0){
                push(Solitaire.deck.pop());
            }
        }
        if (!is_Empty()) {
            carteLinkedList.getLast().retourne();
        }

    }

    public boolean pushPosible(Carte carte){
        if(is_Empty()){
            if (carte.getValue() == Carte.ROI) {
                push(carte);
                return true;
            }else{
                return false;
            }
        }else{
            Carte last = top();
            if (last.getValue() == carte.getValue() - 1) {
                if ((carte.getColor()==Carte.PIQUES || carte.getColor()==Carte.TREFLES) && (last.getColor()==Carte.CARREAUX || last.getColor()==Carte.COEURS)) {
                    push(carte);
                }else if((carte.getColor()==Carte.COEURS || carte.getColor()==Carte.CARREAUX) && (last.getColor()==Carte.TREFLES || last.getColor()==Carte.PIQUES)){
                    push(carte);
                }else{
                    return false;
                }
                return true;
            }else{
                return false;
            }
        }
    }
    
    public void selected(){
        //
    }

    public void main(){
        //
    }

    @Override
    public void draw(GraphicsContext gc){
        if (!is_Empty()) {
            for (int i = 0; i < nombreDeCartes; i++) {
                carteLinkedList.get(i).draw(gc,x,y+i*YDIST);
            }
        }else{
            gc.strokeRect(x, y, Carte.LARGEUR, Carte.HAUTEUR);
            gc.strokeText("?", x+25, y+35);
        }
    }

    @Override
    public boolean estInclus(int a, int b){
        if((x < a && a< x+Carte.LARGEUR) && (y < b && b< y+Carte.HAUTEUR+PilesTable.YDIST*(nombreDeCartes)) ){
            return true;
        }else{
            return false;
        }
    }
    
}










/*
 * version
 */

 /*
  * 1111111
  public PilesTable(int x, int y,int n) {
        super(x, y);
        this.nombreDeCartes = n;
        this.deck = new Deck(x,y);
        deck.shuffle();

        for (int i = 0; i < nombreDeCartes; i++) {
            carteLinkedList.add(deck.draw_Carte());
        }
        carteLinkedList.getFirst().retourne();

    }
  */
  /*
   * 2222222222
   *     private int nombreDeCartes;
    public static final int YDIST =25;
    private Deck deck;

    public PilesTable(int x, int y,int n) {
        super(x, y);
        this.nombreDeCartes = n;
        this.deck = new Deck(x,y);
        deck.shuffle();

        for (int i = 0; i < nombreDeCartes; i++) {
            push(deck.draw_Carte());
        }
        if (!is_Empty()) {
            carteLinkedList.getLast().retourne();
        }

    }
   */
