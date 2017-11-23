package fr.univ.amu;

public class Pair {

    private final int valeur;
    private boolean utilise;

    public Pair(int valeur) {
        this.valeur = valeur;
        this.utilise = false;
    }

    public int getValeur() {
        return valeur;
    }

    public boolean isUtilise() {
        return utilise;
    }

    public void setUtilise(boolean utilise) {
        this.utilise = utilise;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Pair)) return false;
        Pair pairo = (Pair) o;
        return this.valeur==(pairo.getValeur()) &&
                this.utilise==pairo.isUtilise();
    }

}