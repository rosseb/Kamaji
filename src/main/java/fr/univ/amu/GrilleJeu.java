package fr.univ.amu;
import java.util.ArrayList;

public class GrilleJeu
{
    private Case[][] matrice;
    private final int valeurSomme;

    public GrilleJeu(int valeurSomme, int largeurGrille) {
        this.valeurSomme = valeurSomme;
        this.matrice = this.constituerGrilleAleatoire(largeurGrille);
    }

    private Case[][] constituerGrilleAleatoire(int largeurGrille) {
        // Constituer une grille résolvable


        // PROVISOIRE : Grille trouvée sur internet, il faudra remplacer par un algo qui créé une grille pour laquelle il existe au moins une solution

        // Créer tous les objets cases (la grille : http://prntscr.com/ht2bjl)
        Case c1 = new Case(3);
        Case c2 = new Case(3);
        Case c3 = new Case(2);
        Case c4 = new Case(2);
        Case c5 = new Case(4);
        Case c6 = new Case(3);
        Case c7 = new Case(2);
        Case c8 = new Case(1);
        Case c9 = new Case(1);
        Case c10 = new Case(3);
        Case c11 = new Case(3);
        Case c12 = new Case(2);
        Case c13 = new Case(5);
        Case c14 = new Case(2);
        Case c15 = new Case(4);
        Case c16 = new Case(3);
        Case c17 = new Case(2);
        Case c18 = new Case(2);
        Case c19 = new Case(4);
        Case c20 = new Case(2);
        Case c21 = new Case(2);
        Case c22 = new Case(4);
        Case c23 = new Case(1);
        Case c24 = new Case(3);
        Case c25 = new Case(3);


        Case[][] aRetourner =   {   {c1, c2, c3, c4, c5},
                                    {c6, c7, c8, c9, c10},
                                    {c11, c12, c13, c14, c15},
                                    {c16, c17, c18, c19, c20},
                                    {c21, c22, c23, c24, c25}    };

        return aRetourner;
    }

    /**
     * Raye une liste de case dans la matrice
     * @param lesCasesArayer la liste des cases à rayer
     * @return Renvoie vrai si la somme des cases correspond au pivot faux dans le cas contraire
     */
    public boolean rayerCases(ArrayList<Case> lesCasesArayer) {
        // Retourner true si les cases ont bien été reliées entre elles
        // Retourner false si impossible de les reliers (une des cases déjà utilisée)

        int valeurTotale = 0;
        for (Case c : lesCasesArayer) {
            valeurTotale++;
            if (c.estUtilisee())
                return false;
        }

        // Si aucune des cases n'est déjà utilisée (rappel : la fonction estUtilisee() gère seule le fait que 1 peut être rayé 2 fois)

        // On vérifie que la somme des cases est égale à la valeur à trouver (this.valeurSomme)
        if (valeurTotale != this.valeurSomme)
            return false;

        // Tout est bon on peut relier les cases ensembles
        for (Case c : lesCasesArayer) {
            c.rayer();
        }

        return true;
    }

    /**
     * Reinitialise la grille en dé-rayant toutes les cases
     */
    public void reinitialiserGrille(){
        for (Case[] c: matrice) {
            for (Case elem: c) {
                elem.reinitialiser();
            }
        }
    }

    /**
     * Vérifie si la grille est complétement validée est donc que le jeu est fini
     * @return true si la grille est validé, faux sinon
     */
    public boolean verifierGrilleFinie(){
        boolean etat = true;
        for (Case [] c : matrice){
            for (Case elem : c){
                if (!elem.estUtilisee())
                    etat = false;
            }
        }
        return etat;
    }
}
