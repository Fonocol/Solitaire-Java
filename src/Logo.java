import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Logo {
    private double x;
    private double y;
    
    public Logo(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void draw(GraphicsContext gc){
        for(int i=0; i<=10;i++){
            gc.setStroke(Color.BLACK);
            gc.strokeLine(x, y+i*(Carte.HAUTEUR+2*Solitaire.MARGE_GAUCHE),Carte.LARGEUR*(11) , y+i*(Carte.HAUTEUR+2*Solitaire.MARGE_GAUCHE));
            gc.strokeLine(x+i*(Carte.LARGEUR +(3/2)*Solitaire.MARGE_GAUCHE), y,x+i*(Carte.LARGEUR +(3/2)*Solitaire.MARGE_GAUCHE) , Carte.HAUTEUR*(9));
            //gc.strokeLine(x+i*(Carte.LARGEUR +(3/2)*Solitaire.MARGE_GAUCHE), y+i*(Carte.HAUTEUR+2*Solitaire.MARGE_GAUCHE), Carte.LARGEUR*(11-i), Carte.HAUTEUR*(8-i));
        }
    }

}
