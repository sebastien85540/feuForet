package com.cirilgroup.feuforet.model;

import com.cirilgroup.feuforet.enumForet.EtatArbre;

import java.util.StringJoiner;

public class Arbre {

    private EtatArbre etat = EtatArbre.DEBOUT;

    public Arbre() {
        setEtat(etat);
    }

    public EtatArbre getEtat() {
        return etat;
    }

    public void setEtat(EtatArbre etat) {
        this.etat = etat;
    }

    void propagation(double possibilitePropagation){
        if (etat == EtatArbre.EN_FEU){
            if (Math.random() < possibilitePropagation){
                etat = EtatArbre.EN_FEU;
            }
        }
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Arbre.class.getSimpleName() + "[", "]")
                .add("etat=" + etat)
                .toString();
    }
}
