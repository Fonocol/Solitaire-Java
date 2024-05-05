import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;


public class Carte {
    public final static int PIQUES =0,
                            COEURS =1,
                            CARREAUX =2,
                            TREFLES =3;
    public final static int AS =1,
                            VALET =11,
                            DAME =12,
                            ROI =13;
    private int value;
    private int color;
    private boolean visible;
    public final static int LARGEUR = 50;
    public final static int HAUTEUR = 70;

    public Carte(int value, int color) {
        this.value = value;
        this.color = color;
        this.visible = false;
    }

    public int getValue() {
        return value;
    }
    public int getColor() {
        return color;
    }

    public String getColorAsString(){
        switch (color){
            case PIQUES:
                return "PIQUES";
            case COEURS:
                return "COEURS";
            case CARREAUX:
                return "CARREAUX";
            case TREFLES:
                return "TREFLES";
        }
        return "??";
    }

    public String getValueAsString(){
        if(value == AS){
            return "AS";
        }else if(value == VALET){
            return "VALET";
        }else if(value == DAME){
            return "DAME";
        }else if(value == ROI){
            return "ROI";
        }else if(value>1 && value<11){
            return ""+ value ;
        }else{
            return "??";
        }
        
    }

    public void retourne(){
        visible = !visible;
    }
    public boolean getOrientation(){
        return this.visible;
    }

    private void drawCircle(GraphicsContext gc, int centerX, int centerY, int radius) {
        gc.strokeOval(centerX - radius, centerY - radius, 2 * radius, 2 * radius);
    }
    
    public void draw(GraphicsContext gc,int x , int y){
        // Dessine les lignes du carré
        /*
        gc.strokeLine(x, y, x + LARGEUR, y);
        gc.strokeLine(x + LARGEUR, y, x + LARGEUR, y + HAUTEUR);
        gc.strokeLine(x + LARGEUR, y + HAUTEUR, x, y + HAUTEUR);
        gc.strokeLine(x, y + HAUTEUR, x, y);*/
        gc.setStroke(Color.BLACK);
        gc.setFill(Color.BLACK);
        gc.fillRect(x, y, LARGEUR, HAUTEUR);

        if(visible){
            // Remplit le carré
            gc.setFill(Color.WHITE);
            gc.fillRect(x+1, y+1, LARGEUR-2, HAUTEUR-2);
            if (color == COEURS) {
                gc.setStroke(Color.RED);
                gc.strokeText(getValueAsString(), x+5, y+15);
                gc.strokeLine(x + 4, y + 22, x + 6, y + 20);
                gc.strokeLine(x + 6, y + 20, x + 8, y + 22);
                gc.strokeLine(x + 8, y + 22, x + 10, y + 20);
                gc.strokeLine(x + 10, y + 20, x + 12, y + 22);
                gc.strokeLine(x + 12, y + 22, x + 8, y + 30);
                gc.strokeLine(x + 8, y + 30, x + 4, y + 22);

                gc.strokeLine(x + 4+34, y + 22+35, x + 6+34, y + 20+35);
                gc.strokeLine(x + 6+34, y + 20+35, x + 8+34, y + 22+35);
                gc.strokeLine(x + 8+34, y + 22+35, x + 10+34, y + 20+35);
                gc.strokeLine(x + 10+34, y + 20+35, x + 12+34, y + 22+35);
                gc.strokeLine(x + 12+34, y + 22+35, x + 8+34, y + 30+35);
                gc.strokeLine(x + 8+34, y + 30+35, x + 4+34, y + 22+35);

                gc.strokeLine(x + 15, y + 40, x + 20, y + 30);
                gc.strokeLine(x + 20, y + 30, x + 25, y + 40);
                gc.strokeLine(x + 25, y + 40, x + 30, y + 30);
                gc.strokeLine(x + 30, y + 30, x + 35, y + 40);
                gc.strokeLine(x + 35, y + 40, x + 25, y + 60);
                gc.strokeLine(x + 25, y + 60, x + 15, y + 40);
            }else if(color ==PIQUES ){
                gc.strokeText(getValueAsString(), x+5, y+15);
                gc.strokeLine(x + 8, y + 20, x + 4, y + 27);
                gc.strokeLine(x + 4, y + 27, x + 12, y + 27);
                gc.strokeLine(x + 12, y + 27, x + 8, y + 20);
                gc.strokeLine(x + 8, y + 25, x + 6, y + 30);
                gc.strokeLine(x + 6, y + 30, x + 10, y + 30);
                gc.strokeLine(x + 10, y + 30, x + 8, y + 25);

                gc.strokeLine(x + 8+34, y + 20+35, x + 4+34, y + 27+35);
                gc.strokeLine(x + 4+34, y + 27+35, x + 12+34, y + 27+35);
                gc.strokeLine(x + 12+34, y + 27+35, x + 8+34, y + 20+35);
                gc.strokeLine(x + 8+34, y + 25+35, x + 6+34, y + 30+35);
                gc.strokeLine(x + 6+34, y + 30+35, x + 10+34, y + 30+35);
                gc.strokeLine(x + 10+34, y + 30+35, x + 8+34, y + 25+35);

                gc.strokeLine(x + 15, y + 50, x + 35, y + 50);
                gc.strokeLine(x + 35, y + 50, x + 25, y + 30);
                gc.strokeLine(x + 25, y + 30,x + 15, y + 50);
                gc.strokeLine(x + 25, y + 45, x + 15, y + 60);
                gc.strokeLine(x + 15, y + 60, x + 35, y + 60);
                gc.strokeLine(x + 35, y + 60, x + 25, y + 45);
            }else if(color ==CARREAUX ){
                gc.setStroke(Color.RED);
                gc.strokeText(getValueAsString(), x+5, y+15);
                gc.strokeLine(x + 8, y + 20, x + 4, y + 25);
                gc.strokeLine(x + 4, y + 25, x + 8, y + 30);
                gc.strokeLine(x + 8, y + 30, x + 12, y + 25);
                gc.strokeLine(x + 12, y + 25, x + 8, y + 20);

                gc.strokeLine(x + 42, y + 55, x + 38, y + 60);
                gc.strokeLine(x + 38, y + 60, x + 42, y + 65);
                gc.strokeLine(x + 42, y + 65, x + 46, y + 60);
                gc.strokeLine(x + 46, y + 60, x + 42, y + 55);


                gc.strokeLine(x + 25, y + 30, x + 15, y + 45);
                gc.strokeLine(x + 15, y + 45, x + 25, y + 60);
                gc.strokeLine(x + 25, y + 60, x + 35, y + 45);
                gc.strokeLine(x + 35, y + 45,x + 25, y + 30);
            }else if(color ==TREFLES ){
                gc.strokeText(getValueAsString(), x+5, y+15);
                drawCircle(gc,x+10,y+25,2);
                drawCircle(gc,x+6,y+25,2);
                drawCircle(gc,x+8,y+22,2);
                gc.strokeLine(x + 8, y + 25, x + 6, y + 30);
                gc.strokeLine(x + 6, y + 30, x + 10, y + 30);
                gc.strokeLine(x + 10, y + 30, x + 8, y + 25);

                drawCircle(gc,x+10+34,y+25+35,2);
                drawCircle(gc,x+6+34,y+25+35,2);
                drawCircle(gc,x+8+34,y+22+35,2);
                gc.strokeLine(x + 8+34, y + 25+35, x + 6+34, y + 30+35);
                gc.strokeLine(x + 6+34, y + 30+35, x + 10+34, y + 30+35);
                gc.strokeLine(x + 10+34, y + 30+35, x + 8+34, y + 25+35);

                drawCircle(gc,x+30,y+45,5);
                drawCircle(gc,x+20,y+45,5);
                drawCircle(gc,x+25,y+35,5);
                gc.strokeLine(x + 25, y + 45, x + 15, y + 60);
                gc.strokeLine(x + 15, y + 60, x + 35, y + 60);
                gc.strokeLine(x + 35, y + 60, x + 25, y + 45);
                
            }
        }else{
            gc.setFill(Color.GRAY);
            gc.fillRect(x+1, y+1, LARGEUR-2, HAUTEUR-2);
            gc.setStroke(Color.BLUE);
            gc.strokeLine(x + 12, y + 5, x + 12, y + 65);
            gc.strokeLine(x + 38, y + 5, x + 38, y + 65);
            gc.strokeLine(x + 5, y + 5, x + 45, y + 5);
            gc.strokeLine(x + 5, y + 35, x + 45, y + 35);
            gc.strokeLine(x + 5, y + 65, x + 45, y + 65);
        }
    }



    @Override
    public String toString() {
        return getValueAsString() + " de " + getColorAsString()+"\n";
    }

}
