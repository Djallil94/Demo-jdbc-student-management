package com.Djallil.model;

public class Etudiant {
    private String nom;
    private double note;

    public Etudiant(String nom, double note) {
        this.nom = nom;
        this.note = note;
    }

    public String getNom() {
        return nom;
    }

    public double getNote() {
        return note;
    }
}
