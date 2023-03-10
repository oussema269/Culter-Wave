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
import workshop3a24.Entities.Panier;
import workshop3a24.Entities.Personne;
import workshop3a24.Utils.MyDB;

/**
 *
 * @author asus
 */
public class PanierService implements InterfaceService<Panier> {

    Connection connection = MyDB.getInstance().getCnx();

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

      public List<Panier> getPanier(int id_client) {

        List<Panier> pers = new ArrayList<Panier>();
        try {
            Statement st = connection.createStatement();

            String req = "SELECT p.id_client, p.id_product,p.quantite, c.Nom, pr.prix, pr.lib "
                    + "FROM panier p "
                    + "JOIN user c ON p.id_client = c.Id  "
                    + "JOIN produit pr ON p.id_product = pr.id "
                    + "WHERE p.id_client = '" + id_client + "' ";

            ResultSet result = st.executeQuery(req);

            while (result.next()) {
               Panier p=new Panier(result.getInt(1),result.getInt(2),result.getInt(3),result.getString(6),result.getDouble(5),result.getString(4));
                
               pers.add(p);
                
               // System.out.println(+result.getInt(1)+"\n"+ result.getInt(2)+"\n"+ result.getInt(3)+"\n"+result.getString(4)+"\n"+result.getInt(5)+"\n"+result.getString(6));
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

            String req = "SELECT  p.id_product,p.quantite, pr.prix, pr.lib "
                    + "FROM panier p "
                    + "JOIN user c ON p.id_client = c.Id  "
                    + "JOIN produit pr ON p.id_product = pr.id "
                    + "WHERE p.id_client = '" + id_client + "' ";
                        
            ResultSet result = st.executeQuery(req);
               
            while (result.next()) {

                somme += result.getInt(2) * result.getInt(3);
                //System.out.println(+result.getInt(1)+"\n"+ result.getInt(2)+"\n"+ result.getInt(3)+"\n"+result.getString(4)+"\n"+result.getInt(5)+"\n"+result.getString(6));

            }
            String qry="UPDATE panier SET totale = '"+somme+"' WHERE id_client = '" + id_client + "'";
            st.executeUpdate(qry);

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return somme;

    }

    @Override
    public void ajouter(Panier p) {
        try {
            int idp=0;
            int quantite=0;
            String req=" SELECT id_product , quantite FROM `panier` WHERE id_client='" +p.getId_client()+"'AND id_product= '"+p.getId_product()+"'  ";
              Statement ste = connection.createStatement();
            ste.executeQuery(req);
             ResultSet result = ste.executeQuery(req);

            while (result.next()) {
                idp=result.getInt(1);
                quantite=result.getInt(2);
            }
            if(idp!=p.getId_product())
            {
             String qry = "INSERT INTO panier ( id_product,id_client, quantite) VALUES ('" + p.getId_product() + "', '" + p.getId_client() + "', '" + p.getQuantite() + "')";
            Statement st = connection.createStatement();
            st.executeUpdate(qry);
            sommeProduit(p.getId_client());
            System.out.println("mnadhem heyy");
            }
            else{
               quantite=quantite+p.getQuantite();
             String updateReq = "UPDATE panier SET quantite = '"+quantite+"' WHERE id_client = '" + p.getId_client() + "' AND id_product= '"+p.getId_product()+"'" ;
              ste.executeUpdate(updateReq);
            System.out.println("mrigel ye lhob ");
                sommeProduit(p.getId_client());
                
            }

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

       public List<Personne> getuser(int id_client) {

        List<Personne> pers = new ArrayList<Personne>();
        try {
            Statement st = connection.createStatement();

            String req = "SELECT p.id_client, c.Nom ,c.Prenom,c.Email "
                    + "FROM panier p "
                    + "JOIN user c ON p.id_client = c.Id  "
                    + "JOIN produit pr ON p.id_product = pr.id "
                    + "WHERE p.id_client = '" + id_client + "' ";

            ResultSet result = st.executeQuery(req);

            while (result.next()) {
                Personne p=new Personne(result.getInt(1),result.getString(2),result.getString(3),result.getString(4));
                
               pers.add(p);
                
               // System.out.println(+result.getInt(1)+"\n"+ result.getInt(2)+"\n"+ result.getInt(3)+"\n"+result.getString(4)+"\n"+result.getInt(5)+"\n"+result.getString(6));

            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return pers;
    }

  
    public void supprimerP(int id_client,int id_product ) {
        Statement ste;
        try {
            ste = connection.createStatement();
            String qry = "DELETE FROM `panier` WHERE id_client='" + id_client + "' AND id_product = '"+id_product+"'";
            ste.executeUpdate(qry);
            System.out.println("mrigel ye lhob ");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
 
  public void decrementQuantite(int id_client , int id_product)
  {
      try {
        // Check if the product exists in the cart
        String selectReq = "SELECT quantite FROM panier WHERE id_client = ? AND id_product = ?";
        PreparedStatement selectPs = connection.prepareStatement(selectReq);
        selectPs.setInt(1, id_client);
        selectPs.setInt(2, id_product);
        ResultSet rs = selectPs.executeQuery();
 
        if (rs.next()) {
            int quantite = rs.getInt("quantite");
            if (quantite > 1) {
                // Product exists and quantity is more than 1, decrement the quantity
                String updateReq = "UPDATE panier SET quantite = ? WHERE id_client = ? AND id_product = ?";
                PreparedStatement updatePs = connection.prepareStatement(updateReq);
                updatePs.setInt(1, quantite - 1);
                updatePs.setInt(2, id_client);
                updatePs.setInt(3, id_product);
                updatePs.executeUpdate();
                System.out.println("Product quantity decremented in the cart!");
            } else {
                // Product exists but quantity is 1, remove the product from the cart
                String deleteReq = "DELETE FROM panier WHERE id_client = ? AND id_product = ?";
                PreparedStatement deletePs = connection.prepareStatement(deleteReq);
                deletePs.setInt(1, id_client);
                deletePs.setInt(2, id_product);
                deletePs.executeUpdate();
                System.out.println("Product removed from the cart!");
            }
        } else {
            // Product does not exist in the cart
            System.out.println("Product not found in the cart!");
        }
    } catch (SQLException ex) {
        System.out.println(ex.getMessage());
    }
}
 
   public void incrementQuantite(int id_client,int id_product)
  {
       try {
        // Check if the product exists in the cart
        String selectReq = "SELECT quantite FROM panier WHERE id_client = ? AND id_product = ?";
        PreparedStatement selectPs = connection.prepareStatement(selectReq);
        selectPs.setInt(1, id_client);
        selectPs.setInt(2, id_product);
        ResultSet rs = selectPs.executeQuery();
 
        if (rs.next()) {
            // Product exists in the cart, increment the quantity
            int quantite = rs.getInt("quantite");
            String updateReq = "UPDATE panier SET quantite = ? WHERE id_client = ? AND id_product = ?";
            PreparedStatement updatePs = connection.prepareStatement(updateReq);
            updatePs.setInt(1, quantite + 1);
            updatePs.setInt(2, id_client);
            updatePs.setInt(3, id_product);
            updatePs.executeUpdate();
            System.out.println("Product quantity incremented in the cart!");
        } else {
            // Product does not exist in the cart, add the product with quantity 1
            String insertReq = "INSERT INTO panier (id_client, id_product, quantite) VALUES (?, ?, 1)";
            PreparedStatement insertPs = connection.prepareStatement(insertReq);
            insertPs.setInt(1,id_client );
            insertPs.setInt(2, id_product);
            insertPs.executeUpdate();
            System.out.println("Product added to the cart!");
        }
    } catch (SQLException ex) {
        System.out.println(ex.getMessage());
    }
  }
 
    @Override
    public void supprimer(int i) {
        Statement ste;
        try {
            ste = connection.createStatement();
            String qry = "DELETE FROM `panier` WHERE id_client='" + i + "'";
            ste.executeUpdate(qry);
            System.out.println("mrigel ye lhob  ");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    private Object MyDB() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
   

}
