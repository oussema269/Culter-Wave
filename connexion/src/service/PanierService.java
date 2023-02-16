/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import entite.Commande;
import entite.Panier;
import entite.Product;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import utils.MyConnection;

/**
 *
 * @author asus
 */
public class PanierService implements InterfaceService<Panier> {

    Connection connection = MyConnection.getInstance().getConnection();

    public List<Panier> afficher() {
        List<Panier> pers = new ArrayList<Panier>();
        try {
            Statement st = connection.createStatement();

            String req = "SELECT * FROM `panier`";

            ResultSet result = st.executeQuery(req);

            while (result.next()) {
                Panier resultc = new Panier(result.getInt(1), result.getInt(2), result.getInt(3));
                pers.add(resultc);
            }

        } catch (SQLException ex) {
            System.out.println("leeeee");
        }
        return pers;
    }

    public List<Panier> afficher(int id_client) {

        List<Panier> pers = new ArrayList<Panier>();
        try {
            Statement st = connection.createStatement();

            String req = "SELECT p.id_client, p.id_product,p.quantite, c.nom, pr.prix, pr.nom "
                    + "FROM panier p "
                    + "JOIN user c ON p.id_client = c.id_user "
                    + "JOIN product pr ON p.id_product = pr.id_product "
                    + "WHERE p.id_client = '" + id_client + "' ";

            ResultSet result = st.executeQuery(req);

            while (result.next()) {
                Panier resultc = new Panier(result.getInt(1), result.getInt(2), result.getInt(3));
                pers.add(resultc);
                System.out.println(+result.getInt(1)+"\n"+ result.getInt(2)+"\n"+ result.getInt(3)+"\n"+result.getString(4)+"\n"+result.getInt(5)+"\n"+result.getString(6));

            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return pers;
    }

    public Double sommeProduit(int id_client) {
        Double somme = 0.0;
        List<Panier> pers = new ArrayList<Panier>();
        try {
            Statement st = connection.createStatement();

            String req = "SELECT  p.id_product,p.quantite, pr.prix, pr.nom "
                    + "FROM panier p "
                    + "JOIN user c ON p.id_client = c.id_user "
                    + "JOIN product pr ON p.id_product = pr.id_product "
                    + "WHERE p.id_client = '" + id_client + "' ";

            ResultSet result = st.executeQuery(req);

            while (result.next()) {

                somme += result.getInt(2) * result.getInt(3);
                //System.out.println(+result.getInt(1)+"\n"+ result.getInt(2)+"\n"+ result.getInt(3)+"\n"+result.getString(4)+"\n"+result.getInt(5)+"\n"+result.getString(6));

            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return somme;

    }

    @Override
    public void ajouter(Panier p) {
        try {
            String qry = "INSERT INTO panier ( id_product,id_client, quantite) VALUES ('" + p.getId_product() + "', '" + p.getId_client() + "', '" + p.getQuantite() + "')";
            Statement st = connection.createStatement();
            st.executeUpdate(qry);
            System.out.println("mnadhem heyy");

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public void modifier(Panier c, Panier c1) {
        Statement ste;
        try {
            ste = connection.createStatement();
            String qry = "UPDATE `panier` SET `quantite`='" + c.getQuantite() + "',`id_produit`='"+c.getId_product()+"' WHERE id_client= '" + c1.getId_client() + "' ";
            ste.executeUpdate(qry);
            System.out.println("mrigel ye lhob ");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

    }

    @Override
    public void supprimer(int id_client) {
        Statement ste;
        try {
            ste = connection.createStatement();
            String qry = "DELETE FROM `panier` WHERE id_client='" + id_client + "'";
            ste.executeUpdate(qry);
            System.out.println("mrigel ye lhob ");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void trierParQuantite() {
        try {
            Statement st = connection.createStatement();

            String req = "SELECT p.id_client, p.id_product,p.quantite, c.nom, pr.prix, pr.nom "
                    + "FROM panier p "
                    + "JOIN user c ON p.id_client = c.id_user "
                    + "JOIN product pr ON p.id_product = pr.id_product "
                    + " ORDER BY p.quantite ASC";

            ResultSet result = st.executeQuery(req);

            while (result.next()) {
                System.out.println(+result.getInt(1) + "\n" + result.getInt(2) + "\n" + result.getInt(3) + "\n" + result.getString(4) + "\n" + result.getInt(5) + "\n" + result.getString(6));

            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
  public void trierParPrix() {
        try {
            Statement st = connection.createStatement();

            String req = "SELECT p.id_client, p.id_product,p.quantite, c.nom, pr.prix, pr.nom "
                    + "FROM panier p "
                    + "JOIN user c ON p.id_client = c.id_user "
                    + "JOIN product pr ON p.id_product = pr.id_product "
                    + " ORDER BY pr.prix ASC";

            ResultSet result = st.executeQuery(req);

            while (result.next()) {
                System.out.println(+result.getInt(1) + "\n" + result.getInt(2) + "\n" + result.getInt(3) + "\n" + result.getString(4) + "\n" + result.getInt(5) + "\n" + result.getString(6));

            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

}
