import java.io.IOException;
import java.util.Scanner;
import java.util.ArrayList;
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
                        Carte carte = Solitaire.pileCartes.get(i).pop();
                        Solitaire.defausse.push(carte);
                        
                    }
                    }
                }

            }
        });
        run();
    }
    
    
    public static void run(){
        
    
        Solitaire solitaire = new Solitaire();
        solitaire.initialisation();
        solitaire.screne(gc);
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