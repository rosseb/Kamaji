package fr.univ.amu;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;


public class GrilleJeu
{
    private static int nbCasesRaye;
    private final int valeurSomme;
    private ArrayList<Case> lesCases;
    private int largeurGrille;

    public GrilleJeu(int largeurGrille) {
        nbCasesRaye=0;
        this.valeurSomme = this.constituerGrille(largeurGrille);
    }

    private int constituerGrille(int largeurGrille) {
        this.largeurGrille = largeurGrille;

        Case[] grille = {new Case(0),
                new Case(3),
                new Case(3),
                new Case(2),
                new Case(2),
                new Case(4),
                new Case(3),
                new Case(2),
                new Case(1),
                new Case(1),
                new Case(3),
                new Case(3),
                new Case(2),
                new Case(5),
                new Case(2),
                new Case(4),
                new Case(3),
                new Case(2),
                new Case(2),
                new Case(4),
                new Case(2),
                new Case(2),
                new Case(4),
                new Case(1),
                new Case(3),
                new Case(3)};


        this.lesCases = new ArrayList<Case>();
        this.lesCases.addAll(Arrays.asList(grille));

        // Rayer la case pivot pour dire qu'on ne peut pas l'utiliser
        this.lesCases.get(13).rayer();


        // On récupère la valeur somme (seule case rayée de la liste)
        for (Case c : lesCases)
            if (c.estUtilisee())
                return c.getValeur();

        return 0;
    }


    // Raye une liste de case dans la matrice
    // Retourner true si les cases ont bien été reliées entre elles
    // Retourner false si impossible de les reliers (une des cases déjà utilisée)
    public boolean rayerCases(ArrayList<Case> lesCasesArayer) {
        int valeurTotale = 0;

        // On vérifie si une des cases à rayer n'est pas déjà rayée (sauf si c'est un 1 là on peut la rayer autant que souhaité)
        for (Case c : lesCasesArayer) {
            valeurTotale += c.getValeur();
            if (c.estUtilisee())
                return false;
        }

        // Si aucune des cases n'est déjà utilisée, on vérifie que la somme des cases est égale à la valeur à trouver (this.valeurSomme)
        if (valeurTotale != this.valeurSomme)
            return false;

        // Pour la gestion de la couleur (avoir une couleur qui change à chaque nouveau groupe de cases reliées)
        if (nbCasesRaye>=8)
            nbCasesRaye=0;

        nbCasesRaye++;

        // Tout est bon on peut relier les cases ensembles
        for (Case c : lesCasesArayer) {
            c.rayer();
            c.changerCouleur(nbCasesRaye);
        }

        // Si on en est là c'est qu'il n'y avait aucune raison de retourner false, on peut donc retourner true
        return true;
    }


    // Remet toutes les cases à 0
    public void reinitialiserGrille(){
        for (Case c : this.lesCases) {
            c.reinitialiser();
        }
    }


    // Vérifie si la grille est complètement résolue (true) ou si il reste des cases non rayées (false)
    public boolean verifierGrilleFinie(){
        boolean etat = true;
        for (Case c : this.lesCases) {
            if ((c.estUtilisee()) && c.getValeur() <= 1)
                etat = false;
        }
        return etat;
    }


    // Afficher la grille dans son état en cours
    public void afficherLaGrille() {
        ecrireDansConsole("");
        int compteur=0;

        // for et pas foreach car on ne veut pas afficher le premier element (une case 0)
        for (int i = 1; i < this.lesCases.size(); i++) {
            compteur++;
            if (compteur == this.largeurGrille) {
                compteur = 0;
                this.lesCases.get(i).afficherCase();
                ecrireDansConsole("");
            }
            else
                this.lesCases.get(i).afficherCase();
        }

        ecrireDansConsole("");
    }


    // Ecrit le texte passé en paramètre dans la console
    public void ecrireDansConsole(String texte) {
        System.out.println(texte);
    }


    // Afficher la résolution de grille
    public void afficher(){
        // On affiche la grille non résolue
        this.afficherLaGrille();

        ecrireDansConsole("\nLancement de l'algorithme de résolution :");
        while(trouverCasObligatoires())
            this.trouverCasObligatoires();

        // Afficher grille :
        this.afficherLaGrille();

        // On vérifie si elle est finie :
        if (verifierGrilleFinie())
            ecrireDansConsole("\nGrille résolue !");
        else
            ecrireDansConsole("\nAucune solution n'a été trouvée.");


        ecrireDansConsole("");
        ecrireDansConsole("Fin");
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
            // Tests : Juste à gauche (1), juste à droite (1), juste en bas (2), juste en haut (2)

            // Diagonale : avant ou après en diagonale gauche ou droite
            // tests : Diagonale droite juste en bas (3), diagonale droite juste en haut (4), diagonale gauche juste en bas (4), diagonale gauche juste en haut (3)

            // Si ça trouve une ligne à droite d'une case, ça trouvera aussi la ligne mais vers la gauche quand on sera sur la case la plus à droite
            // Donc inutile de tester une ligne vers la droite ET une ligne vers la gauche...

            // On test toutes les solutions possible, si il y en a plus que une on ne fait rien
            int solutionsTrouvees = 0;
            Case caseTestee = new Case(0);
            indexDeLaCase = -1;
            ArrayList<Case> aRayer = new ArrayList<Case>();
            ArrayList<Case> premiereSolution = new ArrayList<Case>();
            int indexCaseTestee = 0;


            // On parcours toutes les cases
            for (Case c : this.lesCases) {
                indexDeLaCase++;
                solutionsTrouvees = 0;
                if (!c.estUtilisee()) {

                    int sommeAtrouver = this.valeurSomme - c.getValeur();
                    int sommeEnCours = 0;


                    // On test nos 12 cas (note : la fonction lesCasesAutour retourne soit une case soit rien du tout si elle est déjà utilisée)
                    for (int i = 1; i < this.valeurSomme; i++) {
                        switch (i) {
                            case 1:
                                // Tant que la sommeAtrouver est inférieur à la somme qu'on a déjà réussi à "construire" avec les cases, on cherche plus loin
                                indexCaseTestee = indexDeLaCase;
                                aRayer = new ArrayList<Case>();
                                aRayer.add(c);
                                while (sommeAtrouver > sommeEnCours && indexCaseTestee > 0) {
                                    if (this.lesCasesAutour(indexCaseTestee, "D").size() != 0)
                                        caseTestee = this.lesCasesAutour(indexCaseTestee, "D").get(0);
                                    else
                                        caseTestee = null;

                                    if (caseTestee != null) {
                                        if (caseTestee.getValeur() <= sommeAtrouver - sommeEnCours) {
                                            // On se prépare pour tester plus loin (si la caleur de la case était égale à SommeAtrouver - sommeEnCours la boucle s'arrêtera donc ce n'est pas grave de laisser
                                            // indexCaseTestee = ...
                                            indexCaseTestee++;
                                            sommeEnCours += caseTestee.getValeur();

                                            aRayer.add(caseTestee);
                                        }
                                        if (sommeAtrouver == sommeEnCours) {
                                            solutionsTrouvees++;
                                            premiereSolution = new ArrayList<>(aRayer);
                                        }
                                    }
                                    else
                                        indexCaseTestee = -1;
                                }
                                break;
                            case 2:
                                // Tant que la sommeAtrouver est inférieur à la somme qu'on a déjà réussi à "construire" avec les cases, on cherche plus loin
                                indexCaseTestee = indexDeLaCase;
                                aRayer = new ArrayList<Case>();
                                aRayer.add(c);
                                while (sommeAtrouver > sommeEnCours && indexCaseTestee > 0) {
                                    if (this.lesCasesAutour(indexCaseTestee, "B").size() != 0)
                                        caseTestee = this.lesCasesAutour(indexCaseTestee, "B").get(0);
                                    else
                                        caseTestee = null;

                                    if (caseTestee != null) {
                                        if (caseTestee.getValeur() <= sommeAtrouver - sommeEnCours) {
                                            // On se prépare pour tester plus loin (si la caleur de la case était égale à SommeAtrouver - sommeEnCours la boucle s'arrêtera donc ce n'est pas grave de laisser
                                            // indexCaseTestee = ...
                                            indexCaseTestee += this.largeurGrille;
                                            sommeEnCours += caseTestee.getValeur();

                                            aRayer.add(caseTestee);
                                        }
                                        if (sommeAtrouver == sommeEnCours) {
                                            solutionsTrouvees++;
                                            premiereSolution = new ArrayList<>(aRayer);
                                        }
                                    }
                                    else
                                        indexCaseTestee = -1;
                                }
                                break;
                            case 3:
                                // Tant que la sommeAtrouver est inférieur à la somme qu'on a déjà réussi à "construire" avec les cases, on cherche plus loin
                                indexCaseTestee = indexDeLaCase;
                                aRayer = new ArrayList<Case>();
                                aRayer.add(c);
                                while (sommeAtrouver > sommeEnCours && indexCaseTestee > 0) {
                                    if (this.lesCasesAutour(indexCaseTestee, "BD").size() != 0)
                                        caseTestee = this.lesCasesAutour(indexCaseTestee, "BD").get(0);
                                    else
                                        caseTestee = null;

                                    if (caseTestee != null) {
                                        if (caseTestee.getValeur() <= sommeAtrouver - sommeEnCours) {
                                            // On se prépare pour tester plus loin (si la caleur de la case était égale à SommeAtrouver - sommeEnCours la boucle s'arrêtera donc ce n'est pas grave de laisser
                                            // indexCaseTestee = ...
                                            indexCaseTestee += this.largeurGrille +1;
                                            sommeEnCours += caseTestee.getValeur();

                                            aRayer.add(caseTestee);
                                        }
                                        if (sommeAtrouver == sommeEnCours) {
                                            solutionsTrouvees++;
                                            premiereSolution = new ArrayList<>(aRayer);
                                        }
                                    }
                                    else
                                        indexCaseTestee = -1;
                                }
                                break;
                            case 4:
                                // Tant que la sommeAtrouver est inférieur à la somme qu'on a déjà réussi à "construire" avec les cases, on cherche plus loin
                                indexCaseTestee = indexDeLaCase;
                                aRayer = new ArrayList<Case>();
                                aRayer.add(c);
                                while (sommeAtrouver > sommeEnCours && indexCaseTestee > 0) {
                                    if (this.lesCasesAutour(indexCaseTestee, "BG").size() != 0)
                                        caseTestee = this.lesCasesAutour(indexCaseTestee, "BG").get(0);
                                    else
                                        caseTestee = null;

                                    if (caseTestee != null) {
                                        if (caseTestee.getValeur() <= sommeAtrouver - sommeEnCours) {
                                            // On se prépare pour tester plus loin (si la caleur de la case était égale à SommeAtrouver - sommeEnCours la boucle s'arrêtera donc ce n'est pas grave de laisser
                                            // indexCaseTestee = ...
                                            indexCaseTestee += this.largeurGrille -1;
                                            sommeEnCours += caseTestee.getValeur();

                                            aRayer.add(caseTestee);
                                        }
                                        if (sommeAtrouver == sommeEnCours) {
                                            solutionsTrouvees++;
                                            premiereSolution = new ArrayList<>(aRayer);
                                        }
                                    }
                                    else
                                        indexCaseTestee = -1;
                                }
                                break;
                            default:
                                break;
                        }

                    }
                }
                // Si on a trouvé qu'une solution
                if (solutionsTrouvees == 1) {
                    // On élimine les doublons
                    this.rayerCases(premiereSolution);
                    modifs = true;
                }
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
