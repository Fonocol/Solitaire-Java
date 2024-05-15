import java.io.IOException;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.LinkedList;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
//https://www.youtube.com/watch?v=AubJaosfI-0
public class App extends Application {

    private static GraphicsContext gc;
    // les constantes et variables globales
    public final static int CARTES_PAR_COULEUR = 13;
    public final static int NOMBRE_COULEURS = 4;
    public final static int NOMBRE_PILES = 7;
    public final static int MARGE_HAUTE = 40;
    public final static int MARGE_GAUCHE = 5;

    @Override
    public void start(Stage stage) throws Exception {
        initUI(stage);
    }
    

    private void initUI(Stage stage) {
        Pane root = new Pane();
        Canvas canvas = new Canvas(600, 600);
        gc = canvas.getGraphicsContext2D();
        root.getChildren().add(canvas);
        
        var scene = new Scene(root, 600, 600, Color.WHITESMOKE);
        stage.setTitle("Solitaire");
        stage.setScene(scene);
        stage.show();

        root.addEventHandler(MouseEvent.MOUSE_CLICKED, event -> {
            if (event.getButton() == MouseButton.PRIMARY) {
                System.out.println("Clic gauche détecté à la position (" + event.getX() + ", " + event.getY() + ")");

                int x, y;
                x = (int) event.getX();
                y = (int) event.getY();
                for (int i = 0; i < Solitaire.NOMBRE_DE_PILES; i++){
                    if (Solitaire.pileCartes.get(i).estInclus(x, y)){
                        System.out.println("la pile " + i + " a été cliqué");
                        if (i==0) {
                            if(Solitaire.deck.is_Empty()){
                                int end =Solitaire.defausse.taille();
                                System.out.println(end);
                                for(int n = 0; n < end; n++){
                                    
                                    Carte carte = Solitaire.defausse.pop();
                                    carte.retourne();
                                    Solitaire.deck.push(carte);
                                }
                            }else{
                                System.out.println("no");
                                Carte carte = Solitaire.deck.pop();
                                Solitaire.defausse.push(carte);
                            }
    
                        }else if(i==1){
                            if (!Solitaire.defausse.is_Empty()) {
                                
                            
                                Carte carte = Solitaire.defausse.top();
                                boolean inOrdonnee= false;
                                for (PileOrdonner pile : Solitaire.pileOrdonnees){
                                    System.out.println(inOrdonnee);
                                    if (!inOrdonnee) {
                                        inOrdonnee = pile.pushPosible(carte);
                                    }
                                }
                                if (!inOrdonnee) {
                                    for (PilesTable pile : Solitaire.pilesTables){
                                        if (pile.pushPosible(carte)) {
                                            Solitaire.defausse.pop();
                                            break;
                                        }
                                    }
                                }else{
                                    Solitaire.defausse.pop();
                                }
                            }

                        }else if(i>5){
                            if(!Solitaire.pileCartes.get(i).is_Empty()){
                                if(!Solitaire.pileCartes.get(i).top().getOrientation()){
                                    Solitaire.pileCartes.get(i).top().retourne();
                                }else{
                                    Carte carte = Solitaire.pileCartes.get(i).top();
                                    boolean inOrdonnee= false;
                                    for (PileOrdonner pile : Solitaire.pileOrdonnees){
                                        System.out.println(inOrdonnee);
                                        if (!inOrdonnee) {
                                            inOrdonnee = pile.pushPosible(carte);
                                        }
                                    }
                                    if (!inOrdonnee) {
                                        PileCartes newPileCarte = new PileCartes(0, 0);
                                        PilesTable currentPileCarte = (PilesTable) Solitaire.pileCartes.get(i);
                                        
                                        /*LinkedList<Carte> listecarts = new LinkedList<>();
                                        for(Carte ele:currentPileCarte.getPileCarte()){
                                            listecarts.push(ele);
                                        }*/
                                        LinkedList<Carte> listecarts = currentPileCarte.getPileCarte();
                                        
                                        //liste des carte face true et les suprimer dans les tables
                                        for (Carte c: listecarts){
                                            if (c.getOrientation()) {
                                                newPileCarte.push(c);
                                                Solitaire.pileCartes.get(i).pop();  //supression dans les tables
                                                
                                            }
                                        }
                                        
                                        if (newPileCarte.taille()==1) {
                                            boolean inTable = false;
                                            for(int index=0;index<Solitaire.NOMBRE_DE_PILES-6;index++){

                                                if (!inTable && index!= i-6 && Solitaire.pilesTables.get(index).top().getOrientation()) {//verifier que la carte du dessu est retourner
                                                    inTable = Solitaire.pilesTables.get(index).pushPosible(newPileCarte.top());
                                                }
                                            }
                                            if (!inTable) {
                                                Solitaire.pileCartes.get(i).push(newPileCarte.top());
                                            }
                                        }else{
                                            System.out.println("taille plus de  1");   
                                        }
                                        
                                    }else{
                                        Solitaire.pileCartes.get(i).pop();
                                    }

                                }
                            }
                        }
                        Platform.runLater(() -> {
                            Solitaire.screne(gc);
                        });
                    }
                }

            }
        });
        
        run();
    }
    
    
    public static void run(){
        Solitaire solitaire = new Solitaire();
        solitaire.initialisation();
        Solitaire.screne(gc);
    }


    public static void main(String[] args) {
        launch(args);
    }
}




/*
 * run 4  
 * 
        public static void run(){
        Carte test = new Carte(2,Carte.COEURS);
        ArrayList<PilesTable> toulesPiles= new ArrayList<PilesTable>();
        for(int i=0; i<NOMBRE_PILES; i++){
            toulesPiles.add(
                new PilesTable(MARGE_GAUCHE+(Carte.LARGEUR+5)*i,Carte.HAUTEUR+5+MARGE_HAUTE,i)
            );
        }

        for(int i=0; i<NOMBRE_PILES; i++){
            toulesPiles.get(i).draw(gc);
        }
        System.out.println(toulesPiles.get(0).pushPosible(test));
        System.out.println(toulesPiles.get(1).pushPosible(test));
        
        PileOrdonner ord = new PileOrdonner(0, 0);
        ord.draw(gc);
        System.out.println("*****text pile ordonner******");
        System.out.println(ord.pushPosible(test));
 

    }

 */


/*
 * run3
 * 
 * public static void run(){
        // Création du Deck et de la défausse
        Deck monDeck = new Deck(20, 20);
        Defausse defausse = new Defausse(80, 80);
        // Mélange et affichage initial du Deck et de la défausse
        monDeck.shuffle();
        monDeck.top().retourne();
        monDeck.draw(gc);
        
        // Création d'un thread pour gérer les entrées de la console
        Thread consoleThread = new Thread(() -> {
            try (Scanner scanner = new Scanner(System.in)) {
                
                System.out.println("Entrez une commande (par exemple 'deplacer'):");
                String input = scanner.nextLine();
                System.out.println(input);
                
                Platform.runLater(() -> { // Mise à jour de l'interface graphique après l'action
                    Carte carte = monDeck.pop();
                    defausse.push(carte);
                    monDeck.top().retourne();
                    defausse.draw(gc);
                    monDeck.draw(gc);
                });
                input = scanner.nextLine();
                System.out.println(input);
            }
            Platform.runLater(() -> { // Mise à jour de l'interface graphique après l'action
                Carte carte = monDeck.pop();
                defausse.push(carte);
                monDeck.top().retourne();
                defausse.draw(gc);
                monDeck.draw(gc);
            });
        });
        consoleThread.setDaemon(true);
        consoleThread.start();

    }
 */





/*
 * public static void run(){
        PileCartes pileCartes = new PileCartes(100,100);
        pileCartes.push(new Carte(Carte.DAME, Carte.COEURS));
        pileCartes.push(new Carte(10, Carte.CARREAUX));
        pileCartes.push(new Carte(9, Carte.TREFLES));
        pileCartes.top().retourne();
        pileCartes.draw(gc);
        
        Deck monDeck = new Deck(200,200);
        monDeck.shuffle();
        monDeck.top().retourne();
        monDeck.draw(gc);

    }
 */


/*Carte c1 = new Carte(10, Carte.COEURS);
        Carte c2 = new Carte(11, Carte.CARREAUX);
        Carte c3 = new Carte(1, Carte.TREFLES);
        Carte c4 = new Carte(7, Carte.PIQUES);
        Carte c5 = new Carte(11, Carte.COEURS);
        c5.retourne();
        
        c1.draw(gc, 0,0);
        c2.draw(gc, 52,0);
        c3.draw(gc, 102,0);
        c4.draw(gc, 152,0);
        c5.draw(gc, 77,77);
        Deck main = new Deck();
        main.shuffle();
        int posx=0;
        int posy=0;
        for(int i =0;i <52; i++){
            main.draw().draw(gc, posx*50, posy*70);
            posx++;
            if(posx==10){
                posx=0;
                posy++;
            }
        }*/



/*
 * @Override
    public void start(Stage stage) {
        initUI(stage);
    }

    private void initUI(Stage stage) {
        var root = new Pane();
        var canvas = new Canvas(300, 300);
        var gc = canvas.getGraphicsContext2D();
        drawLines(gc);
        root.getChildren().add(canvas);
        var scene = new Scene(root, 300, 250, Color.WHITESMOKE);
        stage.setTitle("Lines");
        stage.setScene(scene);
        stage.show();
    }
    private void drawLines(GraphicsContext gc) {
        gc.beginPath();
        gc.moveTo(30.5, 30.5);
        gc.lineTo(150.5, 30.5);
        gc.lineTo(150.5, 150.5);
        gc.lineTo(30.5, 30.5);
        gc.stroke();
    }
 */




/*@Override
    public void start(Stage primaryStage) {
        
        Parent root;
        try {
            root = FXMLLoader.load(getClass().getResource("MainScene.fxml"));
            Scene scene = new Scene(root);
            primaryStage.setTitle("Hello World!");
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException e) {
        }
        
    }

    public static void main(String[] args) {
        launch(args);
    }*/