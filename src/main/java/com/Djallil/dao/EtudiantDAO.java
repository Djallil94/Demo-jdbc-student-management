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

    public static void deleteByNom(String nom) {
        String sql = "delete from etudiant where nom = ?";

        try(Connection conn = DatabaseConnection.getConnection();
        PreparedStatement ps = conn.prepareStatement(sql);) {
            ps.setString(1, nom);
            ps.executeUpdate();
        } catch (SQLException e){
            e.printStackTrace();
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
            e.printStackTrace();
        }
        return etudiants;
    }

    public Etudiant findByName(String nom) {
        String sql = "select * from etudiant where nom = ?";

        try( Connection conn = DatabaseConnection.getConnection();
        PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, nom);
            ResultSet rs = ps.executeQuery();

            if (rs.next()){
                String nomEtudiant = rs.getString("nom");
                double note = rs.getDouble("note");

                return new Etudiant(nomEtudiant, note);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
