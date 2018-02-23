package fr.univ.amu;

public class Case {

    private final int valeur;
    private int raye;
    private String couleur;

    public Case(int valeur) {
        this.valeur = valeur;
        this.raye = 0;
        this.couleur=getCouleur(0);
    }


    public String getCouleur(int indice){


        if (indice==1)
            return "\u001B[30m";
        else if (indice==2)
            return "\u001B[31m";
        else if (indice==3)
            return "\u001B[32m";
        else if (indice==4)
            return "\u001B[33m";
        else if (indice==5)
            return "\u001B[34m";
        else if (indice==6)
            return "\u001B[35m";
        else if (indice==7)
            return "\u001B[36m";
        else if (indice==8)
            return "\u001B[37m";
        else if (indice==9)
            return "\033[1;30m";

        return "\u001B[0m";
    }
    public int getValeur() {
        return valeur;
    }

    public boolean estUtilisee() {
        if (this.valeur == 1) {
            if (this.raye >= 2)
                return true;
            else
                return false;
        }
        else {
            if (this.raye >= 1)
                return true;
            else
                return false;
        }
    }

    public void rayer() {
        this.raye++;
    }

    public void changerCouleur(int indice){
        this.couleur=getCouleur(indice);
        if (this.raye == 2)
            this.couleur = getCouleur(9);
    }

    public void afficherCase() {
        //Affiche la case avec sa couleur puis reconfigure la sortie en blanc

        System.out.print(this.couleur+this.valeur+getCouleur(0)+ "  "); //Affiche la case avec sa couleur puis reconfigure la sortie en blanc
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Case)) return false;
        Case caseo = (Case) o;
        return this.valeur==(caseo.getValeur()) &&
                this.estUtilisee()==caseo.estUtilisee();
    }

    public void reinitialiser(){
        this.raye=0;
        this.couleur=getCouleur(0);
    }


}