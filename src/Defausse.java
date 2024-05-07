public class Defausse extends PileCartes{

    public Defausse(int x, int y){
        super(x, y);
    }
    @Override
    public void push(Carte carte){
        if (!carte.getOrientation()) {
            carte.retourne();
        }
        carteLinkedList.addFirst(carte);
    }
    
}
