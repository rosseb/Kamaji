package fr.univ.amu;

public class Case {

    private final int valeur;
    private boolean utilise;
    private int nbUtilisation;

    public Case(int valeur) {
        this.valeur = valeur;
        this.utilise = false;
        this.nbUtilisation=0;
    }

    public int getValeur() {
        return valeur;
    }

    public boolean estUtilise() {
        return utilise;
    }

    public void utilisationCase() {
        if(this.nbUtilisation==0 && this.valeur==1){
            ++this.nbUtilisation;
        } else {
            this.utilise = true;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Case)) return false;
        Case caseo = (Case) o;
        return this.valeur==(caseo.getValeur()) &&
                this.utilise==caseo.estUtilise();
    }

    public void reinitialiser(){
        this.nbUtilisation=0;
        this.utilise=false;
    }

}