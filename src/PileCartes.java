import java.util.LinkedList;

import javafx.scene.canvas.GraphicsContext;

public class PileCartes {
    protected int x;
    protected int y;
    protected LinkedList<Carte> carteLinkedList;

    public PileCartes(int x, int y) {
        this.x = x;
        this.y = y;
        this.carteLinkedList = new LinkedList<>();
    }

    public Carte top(){
        return carteLinkedList.getLast();
    }

    public Carte pop(){
        return carteLinkedList.removeFirst();
    }

    public void push(Carte carte){
        carteLinkedList.addLast(carte);
    }

    public int taille(){
        return carteLinkedList.size();
    }

    public boolean is_Empty(){
        return carteLinkedList.isEmpty();
    }


    public void draw(GraphicsContext gc){
        if(!is_Empty()){
            top().draw(gc, x, y);
        }else{
            gc.strokeRect(x, y, Carte.LARGEUR, Carte.HAUTEUR);
            gc.strokeText("?", x+25, y+35);
        }
    }

    public boolean estInclus(int a, int b){
        if((x < a && a< x+Carte.LARGEUR) && (y < b && b< y+Carte.HAUTEUR) ){
            return true;
        }else{
            return false;
        }
    }

    @Override
    public String toString(){
        String res = "Pile: " +"\n";
        for (Carte carte : carteLinkedList) {
            res += carte.toString();
        }
        return res +"}";
    }
}
