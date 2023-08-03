package com.cirilgroup.feuforet.model;

import com.cirilgroup.feuforet.enumForet.EtatArbre;

import java.util.Arrays;
import java.util.StringJoiner;

public class Foret {
    private Arbre[][] grille;
    private int hauteur;
    private int largeur;

    public Foret(int hauteur, int largeur) {
        this.hauteur = hauteur;
        this.largeur = largeur;
        this.grille = new Arbre[hauteur][largeur];
    }

    public void initialisationForet() {
        for (int i = 0; i < hauteur; i++) {
            for (int j = 0; j < largeur; j++) {
                grille[i][j] = new Arbre();
            }
        }
    }


    public int getHauteur() {
        return hauteur;
    }

    public int getLargeur() {
        return largeur;
    }

    public Arbre getGrilleA(int x, int y) {
        if (x >= 0 && x < hauteur && y >= 0 && y < largeur) {
            return grille[x][y];
        } else {
            return null;
        }
    }

    public int simulationFeuForet(double possibilitePropagation) {
        int tours = 0;
        boolean feuExiste = true;
        grille[0][0].setEtat(EtatArbre.EN_FEU);
        grille[hauteur - 1][largeur - 1].setEtat(EtatArbre.EN_FEU);

        while (feuExiste) {
            feuExiste = false;
            int[][] nouvelleGrille = new int[hauteur][largeur];

            for (int i = 0; i < hauteur; i++) {
                for (int j = 0; j < largeur; j++) {
                    Arbre arbre = grille[i][j];

                    if (arbre.getEtat() == EtatArbre.EN_FEU) {
                        arbre.setEtat(EtatArbre.ETEINT);

                        // propagation du feu vers les cases adjascentes
                        propagationFeu(i - 1, j, possibilitePropagation); // haut
                        propagationFeu(i + 1, j, possibilitePropagation); // bas
                        propagationFeu(i, j - 1, possibilitePropagation); // gauche
                        propagationFeu(i, j + 1, possibilitePropagation); // droite

                        feuExiste = true;
                    }
                }
            }
            tours++;
        }
        return tours;
    }

    private void propagationFeu(int x, int y, double possibilitePropagation) {
        Arbre arbre = getGrilleA(x, y);
        if (arbre != null && arbre.getEtat() == EtatArbre.DEBOUT){
            arbre.propagation(possibilitePropagation);
        }
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Foret.class.getSimpleName() + "[", "]")
                .add("grille=" + Arrays.toString(grille))
                .add("hauteur=" + hauteur)
                .add("largeur=" + largeur)
                .toString();
    }
}
