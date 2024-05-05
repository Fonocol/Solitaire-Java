public class PileOrdonner extends PileCartes{

    public PileOrdonner(int x, int y) {
        super(x, y);
    }

    public boolean pushPosible(Carte carte){
        if(is_Empty()){
            if (carte.getValue() == Carte.AS) {
                push(carte);
                return true;
            }else{
                return false;
            }
        }else{
            Carte last = top();
            if ((last.getValue()+1 == carte.getValue()) && (last.getColor() == carte.getColor()) ) {
                push(carte);
                return true;
            }else{
                return false;
            }
        }
    }
    
}
