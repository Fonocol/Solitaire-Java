public class Main {
    public static void main(String [] args){
        Carte c1 = new Carte(10,2);
        Carte c2 = new Carte(Carte.ROI,Carte.TREFLES);
        System.out.println(c1);
        System.out.println(c2.getColor());
        System.out.println(c2);
    }
}