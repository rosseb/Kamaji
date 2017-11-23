package fr.univ.amu;

public class Case {

    private final int valeur;
    private boolean utilise;

    public Case(int valeur) {
        this.valeur = valeur;
        this.utilise = false;
    }

    public int getValeur() {
        return valeur;
    }

    public boolean estUtilise() {
        return utilise;
    }

    public void changeUtilise() {
        this.utilise = true;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Case)) return false;
        Case caseo = (Case) o;
        return this.valeur==(caseo.getValeur()) &&
                this.utilise==caseo.estUtilise();
    }

}