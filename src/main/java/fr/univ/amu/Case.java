package fr.univ.amu;

public class Case {

    private final int valeur;
    private int raye;

    public Case(int valeur) {
        this.valeur = valeur;
        this.raye = 0;
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