package com.Djallil.service;

import com.Djallil.dao.EtudiantDAO;
import com.Djallil.model.Etudiant;

public class EtudiantService {

    public void ajouterEtudiant(String nom, double note) {
        EtudiantDAO.save(new Etudiant(nom, note));
        System.out.println("Étudiant ajouté");
    }

    public void afficherEtudiants() {
        EtudiantDAO.findAll()
                .forEach(e ->
                        System.out.println(
                                        "Nom: " + e.getNom() +
                                        " | Note: " + e.getNote()
                        )
                );
    }

    public void modifierNote(String nom, double note) {
        EtudiantDAO.updateNote(nom, note);
        System.out.println("Note modifiée");
    }

    public void supprimer(String nom) {
        EtudiantDAO.deleteByNom(nom);
        System.out.println("Étudiant supprimé");
    }
}
