package fr.univ.amu;

public class Case {

    public static final String[] tableauCouleur ={"\u001B[0m","\u001B[30m","\u001B[31m","\u001B[32m","\u001B[33m",
            "\u001B[34m","\u001B[35m","\u001B[36m}", "\u001B[37m"};

    private final int valeur;
    private int raye;
    private String couleur;

    public Case(int valeur) {
        this.valeur = valeur;
        this.raye = 0;
        this.couleur=tableauCouleur[0];
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
        if (this.valeur!=1 && this.raye<2)
            this.couleur=tableauCouleur[2];
    }


    public void afficherCase() {
        //Affiche la case avec sa couleur puis reconfigure la sortie en blanc

        System.out.print(this.couleur+this.valeur+tableauCouleur[0]+ "  "); //Affiche la case avec sa couleur puis reconfigure la sortie en blanc
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
    }


}