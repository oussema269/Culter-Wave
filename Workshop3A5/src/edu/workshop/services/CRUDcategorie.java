package edu.workshop.services;

import edu.workshop.entites.categorie;
import edu.workshop.utils.MyConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CRUDcategorie implements CategorieService{
    private Connection conn;
    private Statement ste;

    public CRUDcategorie() {
        conn = MyConnection.getConnection();
        try {
            ste = conn.createStatement();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }



    public void ajoutercategorie(categorie c) {
        try {
            String insertCategorie = "INSERT INTO categorie (categorie) VALUES ('" + c.getCategorie() + "')";
            ste.executeUpdate(insertCategorie);
            System.out.println("Catégorie ajoutée !");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void modifiercategorie(categorie c) {
        try {
            String req = "UPDATE categorie SET categorie = '" + c.getCategorie() + "' WHERE id_cat = " + c.getId_cat();
            ste.executeUpdate(req);
            System.out.println("categorie modifiée !");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void supprimercategorie(int id) {
        try {
            String req = "DELETE FROM categorie WHERE id_cat = " + id;
            ste.executeUpdate(req);
            System.out.println("categorie supprimée !");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public List<categorie> affichercategories() {
        List<categorie> categories = new ArrayList<categorie>();
        try {
            String req = "SELECT * FROM categorie";
            ResultSet result = ste.executeQuery(req);

            while (result.next()) {
                categorie c = new categorie(result.getInt("id_cat"), result.getString("categorie"));
                categories.add(c);
            }
            System.out.println(categories);
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return categories;
    }
}
