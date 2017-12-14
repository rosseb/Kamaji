package fr.univ.amu;


public class GrilleJeu
{
    private Case[][] matrice ;

    public GrilleJeu(Case[][] matrice) {
        this.matrice = matrice;
    }

    public void reinitialiserGrille(){
        for (Case[] c: matrice) {
            for (Case elem: c) {
                elem.reinitialiser();
            }
        }
    }
}
