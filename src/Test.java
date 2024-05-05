public class Test {
    public static void main(String [] args){
        Carte c1 = new Carte(10,2);
        Carte c2 = new Carte(Carte.ROI,Carte.TREFLES);
        Carte c3 = new Carte(Carte.DAME, Carte.CARREAUX);
        Carte c4 = new Carte(8, Carte.PIQUES);
        Carte c5 = new Carte(Carte.AS, Carte.PIQUES);
        Carte c6 = new Carte(7, Carte.TREFLES);
        Player m = new Player();
        m.addCart(c1);
        m.addCart(c2);
        m.addCart(c3);
        m.addCart(c4);
        m.addCart(c5);
        m.addCart(c6);
        System.out.println(m);
        m.sortByValue();
        System.out.println(m);
        m.removeCart(2); // on enlève le 8 de Piques
        System.out.println(m);

        Deck d = new Deck();
        System.out.println(d);
        d.shuffle();
        System.out.println(d);
    }
}

