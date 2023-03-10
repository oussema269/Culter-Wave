/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package workshop3a24.Services;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import workshop3a24.Entities.produit;
import workshop3a24.Utils.MyDB;
 
public class CRUDproduit implements ProduitService{
    Statement ste;
    Connection conn = MyDB.getInstance().getCnx();

    @Override
    public void ajouterproduit(produit p) {
    try {
        ste = conn.createStatement();
         String req = "INSERT INTO `produit` (`lib`,`stock`, `prix`,`id_cat`, `id-owner`) VALUES('" + p.getLib() + "', '" + p.getStock() + "', '" + p.getPrix() + "','" + p.getId_cat()+ "','" + p.getId_owner() + "')";
        ste.executeUpdate(req);
        System.out.println("produit ajouté");
    } catch (SQLException ex) {
            System.out.println("produit non ajouté!!!!");    }
    }

 

  @Override
public void modifierproduit(produit p) {
    try {
        String req = "UPDATE produit SET lib='" + p.getLib() + "', stock='" + p.getStock() + "', prix='" + p.getPrix() + "' WHERE id=" + p.getId();
        Statement st = conn.createStatement();
        st.executeUpdate(req);
        System.out.println("produit updated !");
    } catch (SQLException ex) {
        System.out.println(ex.getMessage());
    }
}


    @Override
public void supprimerproduit(int id) {
    try {
        String req = "DELETE FROM produit WHERE id=" + id;
        Statement st = conn.createStatement();
        st.executeUpdate(req);
        System.out.println("Produit supprimé !");
    } catch (SQLException ex) {
        System.out.println(ex.getMessage());
    }
}


    @Override
public List<produit> afficherproduits() {
    List<produit> produits = new ArrayList<produit>();
    try {
        String req = "SELECT * FROM produit";
        Statement st = conn.createStatement();
        ResultSet result = st.executeQuery(req);
        
        while (result.next()) {
            int id = result.getInt("id");
            int id_cat = result.getInt("id_cat");
            String lib = result.getString("lib");
            int stock = result.getInt("stock");
            float prix = result.getFloat("prix");
            produit p = new produit(id, lib, stock, prix,id_cat);
            produits.add(p);
        }
        //System.out.println(produits);
      
    } catch (SQLException ex) {
        System.out.println(ex.getMessage());   
    }
    return produits;
}
@Override
public List<produit> afficherProduitsParCategorie(int id_cat) {
    List<produit> produits = new ArrayList<>();
    String req = "SELECT * FROM produit WHERE id_cat=?";
    try {
        PreparedStatement ps = conn.prepareStatement(req);
        ps.setInt(1, id_cat);
        ResultSet resultat = ps.executeQuery();
        while (resultat.next()) {
            produit prod = new produit(resultat.getInt("id"), resultat.getString("nom"), resultat.getInt("quantite"), resultat.getFloat("prix"), resultat.getInt("id_cat"));
            produits.add(prod);
        }
    } catch (SQLException ex) {
        System.out.println("Erreur lors de l'affichage des produits par catégorie: " + ex.getMessage());
    }
    return produits;
}

  




    
}
