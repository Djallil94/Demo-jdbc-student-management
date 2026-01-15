package com.Djallil.dao;

import com.Djallil.exception.DaoException;
import com.Djallil.model.Etudiant;
import com.Djallil.db.DatabaseConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EtudiantDAO {
    public static void save(Etudiant etudiant) {
        String sql = "INSERT INTO etudiant (nom, note) VALUES (?, ?)";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, etudiant.getNom());
            ps.setDouble(2, etudiant.getNote());

            ps.executeUpdate();
        } catch (SQLException e) {
            throw new DaoException("Erreur lors de l'ajout de l'étudiant", e);
        }
    }

    public static void updateNote(String nom, double nouvelleNote) {
        String sql = "update etudiant set note = ? where nom = ?";

        try (Connection conn = DatabaseConnection.getConnection();
        PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setDouble(1, nouvelleNote);
            ps.setString(2, nom);

            ps.executeUpdate();
        } catch (SQLException e){
            throw new DaoException("Erreur lors de la mise à jour de la note", e);
        }
    }

    public static double averageEtudiant() {
        String sql = "select avg(note) as moyenne from etudiant";
        double moyenne = 0.0;
        try(Connection conn = DatabaseConnection.getConnection();
        PreparedStatement ps = conn.prepareStatement(sql);
        ResultSet rs = ps.executeQuery()) {
            if (rs.next()) {
                moyenne = rs.getDouble("moyenne");
            }
        } catch (SQLException e) {
            throw new DaoException("Erreur lors du calcul de la moyenne", e);
        }
        return moyenne;
    }
    public static void deleteByNom(String nom) {
        String sql = "delete from etudiant where nom = ?";

        try(Connection conn = DatabaseConnection.getConnection();
        PreparedStatement ps = conn.prepareStatement(sql);) {
            ps.setString(1, nom);
            ps.executeUpdate();
        } catch (SQLException e){
            throw new DaoException("Erreur lors de la suppression de l'étudiant par le nom", e);
        }
    }


    public static List<Etudiant> findAll() {
        List<Etudiant> etudiants = new ArrayList<>();
        String sql = "select nom, note from etudiant";

        try (Connection conn = DatabaseConnection.getConnection();
        PreparedStatement ps = conn.prepareStatement(sql);
        ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                String nom = rs.getString("nom");
                double note = rs.getDouble("note");

                etudiants.add(new Etudiant(nom, note));
            }
            } catch (SQLException e){
            throw new DaoException("Erreur lors de l'affichage des étudiants", e);
        }
        return etudiants;
    }
}
