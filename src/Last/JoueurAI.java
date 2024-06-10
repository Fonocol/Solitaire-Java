import java.util.List;
import java.util.Random;

public class JoueurAI extends Joueur {
    private Random random;

    public JoueurAI(Deck deck) {
        super(deck);
        this.random = new Random();
    }

    public boolean joue(Joueur autreJoueur) {
        // Vérifie si la main du joueur est vide et tire une nouvelle carte si nécessaire
        if (mainJoueur.getMainjoueur().size() == 0) {
            mainJoueur.ajouterCarte(deck.distribuerCarte());
        }

        // Sélectionne une carte aléatoire dans la main de l'IA
        int indexAleatoire = random.nextInt(mainJoueur.getMainjoueur().size());
        int valeurDemandee = mainJoueur.getMainjoueur().get(indexAleatoire).getValue();

        // Affiche la carte demandée
        System.out.println("L'IA demande la valeur : " + valeurDemandee);

        // Récupère les cartes de l'autre joueur
        List<Carte> cartesRecuperees = autreJoueur.donneTous(valeurDemandee);

        // Affiche le nombre de cartes récupérées
        System.out.println("L'IA a récupéré " + cartesRecuperees.size() + " carte(s) de l'autre joueur.");

        // Retourne vrai si au moins une carte a été récupérée, sinon faux
        return cartesRecuperees.size() > 0;
    }
}
