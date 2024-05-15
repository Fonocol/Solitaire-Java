import java.util.ArrayList;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Solitaire {
    public final static int NOMBRE_DE_PILES =13;
    public final static int NOMBRE_PILES_ORDONNES =4;
    public final static int NOMBRE_PILES_TABLES =7;
    public final static int SHUFFLE = 5;
    /*graphisme */
    public final static int MARGE_SOMMET =40;
    public final static int MARGE_GAUCHE =5;
    public final static int DISTANCE_TABLE =5;
    public final static int DISTANCE_ORDO = 5;
    
    /*
     * Les piles de cartes
     */
    public static Deck deck;
    public static Defausse defausse;
    public static ArrayList<PilesTable> pilesTables;
    public static ArrayList<PileOrdonner> pileOrdonnees;
    public static ArrayList<PileCartes> pileCartes;

    public Solitaire(){
        pilesTables = new ArrayList<>();
        pileOrdonnees = new ArrayList<>();
        pileCartes = new ArrayList<>();
    }


    public void initialisation(){
        deck = new Deck((MARGE_GAUCHE+Carte.LARGEUR)*8 , MARGE_SOMMET);
        //shuffle
        for(int shuffle=0; shuffle<SHUFFLE;shuffle++){
            deck.shuffle();
        }

        defausse= new Defausse((MARGE_GAUCHE+Carte.LARGEUR)*9 , MARGE_SOMMET);
        /*
         * 0
         * 1
         */
        pileCartes.add(deck);
        pileCartes.add(defausse);
        /*
         * creation des piles ordonnee et ajout a la liste des pile de carte
         */
        for(int pile=0; pile<NOMBRE_PILES_ORDONNES;pile++){
            pileOrdonnees.add(new PileOrdonner(MARGE_GAUCHE*(pile+1) +Carte.LARGEUR*pile,MARGE_SOMMET));
        }
        /*
         * 2-3-4-5
         */
        for(PileOrdonner pile:pileOrdonnees){
            pileCartes.add(pile);
        }

        /*
         * creation des piles tables et ajout a la liste des pile de carte
         */
        for(int i=0; i<NOMBRE_PILES_TABLES; i++){
            pilesTables.add(
                new PilesTable(MARGE_GAUCHE+(Carte.LARGEUR+5)*i,Carte.HAUTEUR*2+MARGE_SOMMET,i+1)
            );
        }
        /*
         * 6 a 12
         */
        for(PilesTable pile:pilesTables){
            pileCartes.add(pile);
        }
            
    }

    public static void  screne(GraphicsContext gc){
        Logo logo = new Logo(0, MARGE_SOMMET-MARGE_GAUCHE);
        

        gc.setFill(Color.PINK);
        gc.fillRect(0, 0, 600, 600);

        logo.draw(gc);

        gc.strokeText("@ SOLITAIRE", 250,MARGE_SOMMET- 2*MARGE_GAUCHE);
        gc.setFill(Color.GREEN);
        gc.fillRect(164, 515, 4*(Carte.LARGEUR +MARGE_GAUCHE), Carte.HAUTEUR+MARGE_GAUCHE*2);
        gc.strokeText("@ PROJET SOLITAIRE AVEC JAVA", 190, 530+Carte.HAUTEUR/2);

        //deck.draw(gc);
        //defausse.draw(gc);

        for(int i=0; i<NOMBRE_DE_PILES; i++){
            pileCartes.get(i).draw(gc);
        }
        
    }

    
    
}
