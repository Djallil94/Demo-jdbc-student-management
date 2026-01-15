package com.Djallil.ui;

import com.Djallil.service.EtudiantService;
import java.util.Scanner;

public class Menu {

    private final Scanner scanner = new Scanner(System.in);
    private final EtudiantService service = new EtudiantService();

    public void start() {
        int choix;
        do {
            afficherMenu();
            choix = scanner.nextInt();
            scanner.nextLine();

            switch (choix) {
                case 1 -> ajouter();
                case 2 -> afficher();
                case 3 -> modifier();
                case 4 -> supprimer();
                case 0 -> System.out.println("Au revoir");
            }
        } while (choix != 0);
    }

    private void afficherMenu() {
        System.out.println("""
            1. Ajouter un étudiant
            2. Afficher les étudiants
            3. Modifier une note
            4. Supprimer un étudiant
            0. Quitter
        """);
    }

    private void ajouter() {
        System.out.print("Nom : ");
        String nom = scanner.nextLine();
        System.out.print("Note : ");
        double note = scanner.nextDouble();
        scanner.nextLine();

        service.ajouterEtudiant(nom, note);
    }

    private void afficher() {
        service.afficherEtudiants();
    }

    private void modifier() {
        System.out.print("Nom : ");
        String nom = scanner.nextLine();
        double note;
        while (true) {
            try {
                System.out.print("Nouvelle note : ");
                note = Double.parseDouble(scanner.nextLine());
                break;
            } catch (NumberFormatException e) {
                System.out.println("Veuillez entrer un nombre valide (ex: 12.5)");
            }
        }

        service.modifierNote(nom, note);
    }

    private void supprimer() {
        System.out.print("Nom : ");
        String nom = scanner.nextLine();
        scanner.nextLine();

        service.supprimer(nom);
    }
}
