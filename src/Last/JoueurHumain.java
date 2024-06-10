import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class JoueurHumain extends Joueur {
    private Scanner scanner;

    public JoueurHumain(Deck deck) {
        super(deck);
        this.scanner = new Scanner(System.in);
    }

    public boolean joue(Joueur autreJoueur) {
        // Vérifie si la main du joueur est vide et tire une nouvelle carte si nécessaire
        if (mainJoueur.getMainjoueur().size() == 0) {
            mainJoueur.ajouterCarte(deck.distribuerCarte());
        }

        // Affiche la main du joueur et le nombre de carrés
        System.out.println("Votre main : " + mainJoueur.toString());
        System.out.println("Vous avez " + nombreCarres + " carré(s)");

        // Demande à l'utilisateur une valeur de carte
        int valeurDemandee;
        while (true) {
            System.out.print("Entrez une valeur de carte (entre 1 et 13) présente dans votre main : ");
            valeurDemandee = scanner.nextInt();
            if (mainJoueur.estPresent(valeurDemandee)){
                break;
            } else {
                System.out.println("Vous n'avez pas cette carte dans votre main. Veuillez réessayer.");
            }
        }
        
        // Récupère les cartes de l'autre joueur
        List<Carte> cartesRecuperees = autreJoueur.donneTous(valeurDemandee);

        // Affiche le nombre de cartes récupérées
        System.out.println("Vous avez récupéré " + cartesRecuperees.size() + " carte(s) de l'autre joueur.");

        // Retourne vrai si au moins une carte a été récupérée, sinon faux
        return cartesRecuperees.size() > 0;
    }

    
}
