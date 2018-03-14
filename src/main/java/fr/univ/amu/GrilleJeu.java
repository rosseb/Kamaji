package fr.univ.amu;
import java.lang.reflect.Array;
import java.util.ArrayList;


public class GrilleJeu
{


    private Case[][] matrice;
    private static int nbCasesRaye;
    private final int valeurSomme;

    // Pour algo :
    private ArrayList<Case> lesCases;
    private int largeurGrille;

    public GrilleJeu(int valeurSomme, int largeurGrille) {
        this.valeurSomme = valeurSomme;
        nbCasesRaye=0;
        this.matrice = this.constituerGrilleAleatoire(largeurGrille);
    }

    private Case[][] constituerGrilleAleatoire(int largeurGrille) {
        this.largeurGrille = largeurGrille;
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

        this.lesCases = new ArrayList<Case>();
        Case c0 = new Case(0);
        this.lesCases.add(c0);
        this.lesCases.add(c1);
        this.lesCases.add(c2);
        this.lesCases.add(c3);
        this.lesCases.add(c4);
        this.lesCases.add(c5);
        this.lesCases.add(c6);
        this.lesCases.add(c7);
        this.lesCases.add(c8);
        this.lesCases.add(c9);
        this.lesCases.add(c10);
        this.lesCases.add(c11);
        this.lesCases.add(c12);
        this.lesCases.add(c13);
        this.lesCases.add(c14);
        this.lesCases.add(c15);
        this.lesCases.add(c16);
        this.lesCases.add(c17);
        this.lesCases.add(c18);
        this.lesCases.add(c19);
        this.lesCases.add(c20);
        this.lesCases.add(c21);
        this.lesCases.add(c22);
        this.lesCases.add(c23);
        this.lesCases.add(c24);
        this.lesCases.add(c25);

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
            valeurTotale += c.getValeur();
            if (c.estUtilisee())
                return false;
        }

        // Si aucune des cases n'est déjà utilisée (rappel : la fonction estUtilisee() gère seule le fait que 1 peut être rayé 2 fois)

        // On vérifie que la somme des cases est égale à la valeur à trouver (this.valeurSomme)
        if (valeurTotale != this.valeurSomme)
            return false;
        if (nbCasesRaye>=8)
            nbCasesRaye=0;

        nbCasesRaye++;

        // Tout est bon on peut relier les cases ensembles
        for (Case c : lesCasesArayer) {
            c.rayer();
            c.changerCouleur(nbCasesRaye);
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

    public void afficherLaGrille() {
        System.out.println();
        int cpt=0;
        for (Case[] cTableau : matrice){
            for (Case c : cTableau){
                ++cpt;
                if (cpt == 5){
                    cpt =0;
                    c.afficherCase();
                    System.out.println();
                }else
                    c.afficherCase();
            }
        }
        System.out.println();
    }

    public void afficher(){
        this.afficherLaGrille();


        // Debug :
        System.out.println();
        while(trouverCasObligatoires())
            this.trouverCasObligatoires();

        // Afficher grille :
        this.afficherLaGrille();


        /*
        System.out.println("Resoudre grille : ");
        this.resoudreGrille();

                this.afficherLaGrille();
        */

        // Debug :
        System.out.println();
        System.out.println("Fin");
    }

    // Par exemple un 4 avec un seul 1 autour de lui => Il est forcémment rayé avec ce 1 là
    // On retourne true si on a rayer des cases pour savoir si cela sert à quelque chose de rappeler la fonction ou pas
    public boolean trouverCasObligatoires() {
        boolean modifs = false;
        int indexDeLaCase;

        // Pour les nombres reliés par deux
        for (int i = 1; i < this.valeurSomme / 2 + 1; i++) {
            indexDeLaCase = -1;
            for (Case c : this.lesCases) {
                indexDeLaCase++;
                if (!c.estUtilisee()) {
                    if (c.getValeur() == this.valeurSomme - i) {
                        ArrayList<Case> aRayer = new ArrayList<Case>();
                        aRayer.add(c);
                        aRayer.add(this.trierCasesAutour(this.lesCasesAutour(indexDeLaCase, "T"), i));

                        // Si trierCasesAutour n'a pas retourné null on raye
                        if (!aRayer.contains(null)) {
                            this.rayerCases(aRayer);
                            modifs = true;
                        }
                    }
                }
            }
        }

        // Pour les nombres reliés par 3 ou plus
        // Si on ne vient pas de modifier quelque chose, sinon ça attendra le tour d'après
        if (!modifs) {
            // Sens possibles :
            // Ligne : à gauche OU à droite de la case ---- en bas OU au dessus de la case
            // Tests : Juste à gauche (1), juste à droite (2), juste en bas (3), juste en haut (4), a gauche puis à droite (5), en haut puis en bas (6)

            // Diagonale : avant ou après en diagonale gauche ou droite
            // tests : Diagonale droite juste en bas (7), diagonale droite juste en haut (8), diagonale gauche juste en bas (9), diagonale gauche juste en haut (10), diagonale avant après x2 (12)

            // On test toutes les solutions possible, si il y en a plus que une on ne fait rien
            int solutionsTrouvees = 0;
            Case caseTestee = new Case(0);
            indexDeLaCase = -1;
            ArrayList<Case> aRayer = new ArrayList<Case>();

            // On parcours toutes les cases
            for (Case c : this.lesCases) {
                indexDeLaCase++;

                if (!c.estUtilisee()) {

                    int sommeAtrouver = this.valeurSomme - c.getValeur();
                    int sommeEnCours = 0;

                    // On test nos 12 cas (note : la fonction lesCasesAutour retourne soit une case soit rien du tout si elle est déjà utilisée)
                    for (int i = 1; i < 13 && solutionsTrouvees < 2; i++) {
                        switch (i) {
                            case 1:
                                // Tant que la sommeAtrouver est inférieur à la somme qu'on a déjà réussi à "construire" avec les cases, on cherche plus loin
                                int indexCaseTestee = indexDeLaCase;
                                while (sommeAtrouver > sommeEnCours && indexCaseTestee > 0) {
                                    if (this.lesCasesAutour(indexCaseTestee, "G").size() != 0)
                                        caseTestee = this.lesCasesAutour(indexCaseTestee, "G").get(0);
                                    else
                                        caseTestee = null;

                                    if (caseTestee != null) {
                                        if (caseTestee.getValeur() <= sommeAtrouver - sommeEnCours) {
                                            // On se prépare pour tester plus loin (si la caleur de la case était égale à SommeAtrouver - sommeEnCours la boucle s'arrêtera donc ce n'est pas grave de laisser
                                            // indexCaseTestee = ...
                                            indexCaseTestee = this.lesCases.indexOf(caseTestee);
                                            sommeEnCours += caseTestee.getValeur();

                                            aRayer.add(c);
                                            aRayer.add(caseTestee);

                                            solutionsTrouvees++;
                                        }
                                        else
                                            aRayer = new ArrayList<Case>();
                                    }
                                    else
                                        indexCaseTestee = -1;
                                }
                                break;
                            case 2:
                                break;
                            case 3:
                                break;
                            case 4:
                                break;
                            case 5:
                                break;
                            case 6:
                                break;
                            case 7:
                                break;
                            case 8:
                                break;
                            case 9:
                                break;
                            case 10:
                                break;
                            case 11:
                                break;
                            case 12:
                                break;
                            default:
                                break;
                        }

                    }
                }
            }

            // Si on a trouvé qu'une solution
            if (solutionsTrouvees == 1) {
                this.rayerCases(aRayer);
            }
        }



        return modifs;
    }

    // Passer une liste de cases, si parmis ces cases il n'y a qu'une fois le chiffre que l'on cherche (exemple : 1) on renvoi la case en question
    // Retourne null si la valeur n'y est pas
    public Case trierCasesAutour(ArrayList<Case> lesCases, int valeurCherchee) {
        int compteur = 0;
        Case aRetourner = new Case(0);
        for (Case c : lesCases) {
            if (c.getValeur() == valeurCherchee) {
                compteur++;
                aRetourner = c;
            }
        }
        if (compteur == 1)
            return aRetourner;
        else
            return null;
    }

    // Algorithme pour résoudre la grille
    public void resoudreGrille() {
        // Commencer par les nombres forcément reliés entre eux : (nombre à trouver -1) et le chiffre 1
        //      Parcourir la grille et chercher valeurSomme -1, si il existe le relier au 1 qui est autour de lui (par défaut on prend le premier)
        for (Case c : this.lesCases) {
            if (!c.estUtilisee()) {
                if (c.getValeur() == this.valeurSomme - 1) {
                    for (Case cTrouve : this.lesCasesAutour(this.lesCases.indexOf(c), "T")) {
                        if (cTrouve != null) {
                            if (cTrouve.getValeur() == 1) {
                                ArrayList<Case> aRayer = new ArrayList<Case>();
                                aRayer.add(c);
                                aRayer.add(cTrouve);
                                this.rayerCases(aRayer);
                                break;
                            }
                        }
                    }
                }
            }
        }

        // Nombre reliés par 2 (ex 3 et 2 pour 5, 4 et 1 pour 5)
        for (Case c : this.lesCases) {
            if (!c.estUtilisee()) {
                for (int i = this.valeurSomme - 2; i > 1; i--) {
                    if (c.getValeur() == i) {
                        for (Case cTrouve : this.lesCasesAutour(this.lesCases.indexOf(c), "T")) {
                            if (cTrouve != null) {
                                if (cTrouve.getValeur() == this.valeurSomme - i) {
                                    ArrayList<Case> aRayer = new ArrayList<Case>();
                                    aRayer.add(c);
                                    aRayer.add(cTrouve);
                                    this.rayerCases(aRayer);
                                    break;
                                }
                            }
                        }
                    }
                }
            }
        }






        // Ensuite : Trouver nombre à trouver - 2 et regarder si il y a soit en caseAutour 2 soit un 1 qui a pour caseAutour un 1 aussi
        // (en rayant dans le même sens, donc ajouter une variable pour le sens et éventuellement refaire une fonction)
    }

    public void relierCases(){

        // Les cases avec relier directement
        for(Case c : this.lesCases){
            if(!c.estUtilisee()) {
                for (Case ct : lesCasesAutour(this.lesCases.indexOf(c), "T")) {
                    if (c.getValeur() + ct.getValeur() == this.valeurSomme) {
                        ArrayList<Case> aRayer = new ArrayList<Case>();
                        aRayer.add(c);
                        aRayer.add(ct);
                        this.rayerCases(aRayer);
                        break;
                    }
                }
            }
        }

        //Case à relier séparé par une case
        for(Case c : this.lesCases){
            if(!c.estUtilisee()) {
                for (Case ct : lesCasesAutour(this.lesCases.indexOf(c), "T")){
                    for (Case ct2 : lesCasesAutour(this.lesCases.indexOf(ct), "T")){
                        if ( !ct2.estUtilisee() && !ct.estUtilisee()&& c.getValeur()+ct.getValeur()+ct2.getValeur()==this.valeurSomme){
                            ArrayList<Case> aRayer = new ArrayList<Case>();
                            aRayer.add(c);
                            aRayer.add(ct);
                            aRayer.add(ct2);
                            this.rayerCases(aRayer);
                            break;
                        }
                    }
                }
            }
        }

        //Case à relier séparé par deux cases
        for(Case c : this.lesCases){
            if(!c.estUtilisee()) {
                for (Case ct : lesCasesAutour(this.lesCases.indexOf(c), "T")){
                    for (Case ct2 : lesCasesAutour(this.lesCases.indexOf(ct), "T")){
                        for (Case ct3 : lesCasesAutour(this.lesCases.indexOf(ct2), "T")){
                            if ( !ct3.estUtilisee() && !ct2.estUtilisee() && !ct.estUtilisee()&& ct3.getValeur()+c.getValeur()+ct.getValeur()+ct2.getValeur()==this.valeurSomme){
                                ArrayList<Case> aRayer = new ArrayList<Case>();
                                aRayer.add(c);
                                aRayer.add(ct);
                                aRayer.add(ct2);
                                aRayer.add(ct3);
                                this.rayerCases(aRayer);
                                break;
                            }
                        }

                    }
                }
            }
        }


    }


    // Retourne les cases autour de la case passée en paramètre = permet de connaitre les nombres autour d'elle
    public ArrayList<Case> lesCasesAutour(int numeroCaseEnCours, String sens) {
        ArrayList<Case> aRetourner = new ArrayList<Case>();
        /* Les cases à retourner sont les suivantes :
              - Gauche = Case -1
              - Droite = Case +1
              - Haut = Case - largeurGrille
              - Bas = Case + largeurGrille
              - Diagonale haut gauche = Case - largeurGrille -1
              - Diagonale haut droit = Case - largeurGrille +1
              - Diagonale bas gauche = Case + largeurGrille -1
              - Diagonale bas droite = Case + largeurGrille +1

              Cas particulier = Case au bord de la grille
                - Bord gauche : pas de case à gauche, pas de diagonale gauche
                - Bord droit : pas de case à droite, pas de diagonale droit
                - Bord haut : pas de case au dessus (valeur inférieur à 1 donc erreur détectée)
                - Bord bas : pas de case en dessous (valeur supérieur à nbCasestotal donc erreur détectée)


             Pour détecter case bord : valeurCaseEnCours / largeurTotale
                - Gauche :  = reste division euclidienne = 1
                - Droit : reste division euclidienne nul
                - Haut : Largeur totale <= caseEnCours
                - Bas : Nombre total de cases - largeur totale <= caseEnCours

             Les différents sens possible :
                - T : pas de préférence
                - G : gauche
                - D : droite
                - H : haut
                - B : bas
                - HG : diagonale gauche
                - HD : diagonale droite
                - BG & BD : diagonale gauche et diagonale droite

        */

        // Valeurs des cases autour
        int caseGauche = numeroCaseEnCours - 1;
        int caseDroite = numeroCaseEnCours +1;
        int caseHaut = numeroCaseEnCours - this.largeurGrille;
        int caseBas = numeroCaseEnCours + this.largeurGrille;
        int caseDiagonaleHautGauche = numeroCaseEnCours - this.largeurGrille -1;
        int caseDiagonaleHautDroit = numeroCaseEnCours - this.largeurGrille +1;
        int caseDiagonaleBasGauche = numeroCaseEnCours + this.largeurGrille -1;
        int caseDiagonaleBasDroite = numeroCaseEnCours + this.largeurGrille +1;

        // Emplacement case
        boolean bordGauche = numeroCaseEnCours % this.largeurGrille == 1;
        boolean bordDroit = numeroCaseEnCours % this.largeurGrille == 0;
        boolean bordHaut = this.largeurGrille >= numeroCaseEnCours;
        boolean bordBas = this.lesCases.size() - this.largeurGrille <= numeroCaseEnCours;



            // Détecter bord gauche
            if (bordGauche) {
                if (((sens.equals("T") || sens.equals("D"))) && caseDroite <= this.lesCases.size() && caseDroite > 0)
                    aRetourner.add(this.lesCases.get(caseDroite));

                if (((sens.equals("T") || sens.equals("H"))) && caseHaut <= this.lesCases.size() && caseHaut > 0)
                    aRetourner.add(this.lesCases.get(caseHaut));

                if (((sens.equals("T") || sens.equals("B"))) && caseBas <= this.lesCases.size() && caseBas > 0)
                    aRetourner.add(this.lesCases.get(caseBas));

                if (((sens.equals("T") || sens.equals("HD"))) && caseDiagonaleHautDroit <= this.lesCases.size() && caseDiagonaleHautDroit > 0)
                    aRetourner.add(this.lesCases.get(caseDiagonaleHautDroit));

                if (((sens.equals("T") || sens.equals("BD"))) && caseDiagonaleBasDroite <= this.lesCases.size() && caseDiagonaleBasDroite > 0)
                    aRetourner.add(this.lesCases.get(caseDiagonaleBasDroite));
            }
            // Détecter le bord droit
            else if (bordDroit) {
                if (((sens.equals("T") || sens.equals("G"))) && caseGauche <= this.lesCases.size() && caseGauche > 0)
                    aRetourner.add(this.lesCases.get(caseGauche));

                if (((sens.equals("T") || sens.equals("H"))) && caseHaut <= this.lesCases.size() && caseHaut > 0)
                    aRetourner.add(this.lesCases.get(caseHaut));

                if (((sens.equals("T") || sens.equals("B"))) && caseBas <= this.lesCases.size() && caseBas > 0)
                    aRetourner.add(this.lesCases.get(caseBas));

                if (((sens.equals("T") || sens.equals("HG"))) && caseDiagonaleHautGauche <= this.lesCases.size() && caseDiagonaleHautGauche > 0)
                    aRetourner.add(this.lesCases.get(caseDiagonaleHautGauche));

                if (((sens.equals("T") || sens.equals("BG"))) && caseDiagonaleBasGauche <= this.lesCases.size() && caseDiagonaleBasGauche > 0)
                    aRetourner.add(this.lesCases.get(caseDiagonaleBasGauche));

            }

            // Détecter bord haut
            else if (bordHaut) {
                if (((sens.equals("T") || sens.equals("G"))) && caseGauche <= this.lesCases.size() && caseGauche > 0)
                    aRetourner.add(this.lesCases.get(caseGauche));

                if (((sens.equals("T") || sens.equals("D"))) && caseDroite <= this.lesCases.size() && caseDroite > 0)
                    aRetourner.add(this.lesCases.get(caseDroite));

                if (((sens.equals("T") || sens.equals("B"))) && caseBas <= this.lesCases.size() && caseBas > 0)
                    aRetourner.add(this.lesCases.get(caseBas));

                if (((sens.equals("T") || sens.equals("BG"))) && caseDiagonaleBasGauche <= this.lesCases.size() && caseDiagonaleBasGauche > 0)
                    aRetourner.add(this.lesCases.get(caseDiagonaleBasGauche));

                if (((sens.equals("T") || sens.equals("BD"))) && caseDiagonaleBasDroite <= this.lesCases.size() && caseDiagonaleBasDroite > 0)
                    aRetourner.add(this.lesCases.get(caseDiagonaleBasDroite));
            }

            // Détecter bord bas
            else if (bordBas) {
                if (((sens.equals("T") || sens.equals("G"))) && caseGauche <= this.lesCases.size() && caseGauche > 0)
                    aRetourner.add(this.lesCases.get(caseGauche));

                if (((sens.equals("T") || sens.equals("D"))) && caseDroite <= this.lesCases.size() && caseDroite > 0)
                    aRetourner.add(this.lesCases.get(caseDroite));

                if (((sens.equals("T") || sens.equals("H"))) && caseHaut <= this.lesCases.size() && caseHaut > 0)
                    aRetourner.add(this.lesCases.get(caseHaut));

                if (((sens.equals("T") || sens.equals("HG"))) && caseDiagonaleHautGauche <= this.lesCases.size() && caseDiagonaleHautGauche > 0)
                    aRetourner.add(this.lesCases.get(caseDiagonaleHautGauche));

                if (((sens.equals("T") || sens.equals("HD"))) && caseDiagonaleHautDroit <= this.lesCases.size() && caseDiagonaleHautDroit > 0)
                    aRetourner.add(this.lesCases.get(caseDiagonaleHautDroit));
            } else {
                // Signifie que ce n'est pas un cas particulier

                if (((sens.equals("T") || sens.equals("G"))) && caseGauche <= this.lesCases.size() && caseGauche > 0)
                    aRetourner.add(this.lesCases.get(caseGauche));

                if (((sens.equals("T") || sens.equals("D"))) && caseDroite <= this.lesCases.size() && caseDroite > 0)
                    aRetourner.add(this.lesCases.get(caseDroite));

                if (((sens.equals("T") || sens.equals("H"))) && caseHaut <= this.lesCases.size() && caseHaut > 0)
                    aRetourner.add(this.lesCases.get(caseHaut));

                if (((sens.equals("T") || sens.equals("B"))) && caseBas <= this.lesCases.size() && caseBas > 0)
                    aRetourner.add(this.lesCases.get(caseBas));

                if (((sens.equals("T") || sens.equals("HG"))) && caseDiagonaleHautGauche <= this.lesCases.size() && caseDiagonaleHautGauche > 0)
                    aRetourner.add(this.lesCases.get(caseDiagonaleHautGauche));

                if (((sens.equals("T") || sens.equals("HD"))) && caseDiagonaleHautDroit <= this.lesCases.size() && caseDiagonaleHautDroit > 0)
                    aRetourner.add(this.lesCases.get(caseDiagonaleHautDroit));

                if (((sens.equals("T") || sens.equals("BG"))) && caseDiagonaleBasGauche <= this.lesCases.size() && caseDiagonaleBasGauche > 0)
                    aRetourner.add(this.lesCases.get(caseDiagonaleBasGauche));

                if (((sens.equals("T") || sens.equals("BD"))) && caseDiagonaleBasDroite <= this.lesCases.size() && caseDiagonaleBasDroite > 0)
                    aRetourner.add(this.lesCases.get(caseDiagonaleBasDroite));
            }



        // Supprimer les cases déjà rayées
        for (int i = 0; i < aRetourner.size(); i++) {
            if (aRetourner.get(i).estUtilisee()) {
                aRetourner.remove(aRetourner.get(i));
                i--;
            }
        }

        return aRetourner;
    }

}
