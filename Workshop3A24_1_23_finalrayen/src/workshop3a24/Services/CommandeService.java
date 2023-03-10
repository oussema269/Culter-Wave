/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package workshop3a24.Services;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import workshop3a24.Entities.Commande;
import workshop3a24.Utils.MyDB;

/**
 *
 * @author asus
 */
public class CommandeService implements InterfaceService<Commande> {

    Connection conn = MyDB.getInstance().getCnx();
      public List<Commande> afficher() {
List<Commande> pers = new ArrayList<Commande>();
return pers;
      }
       public List<Commande> getCommannde() {
           List<Commande> pers = new ArrayList<Commande>();
        try {
            Statement st = conn.createStatement();

            String req = "SELECT * FROM commande";
                    
                    

            ResultSet result = st.executeQuery(req);

            while (result.next()) {
                Commande resultc = new Commande(result.getInt(1),result.getInt(2),result.getInt(4), result.getDate(3),result.getDouble(5));
                pers.add(resultc);
            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return pers;
         }
    /*public List<Panier> getProduct(int id_client) {
        List<Panier> pers = new ArrayList<Panier>();
        try {
            Statement st = conn.createStatement();

            String req = "SELECT p.id_client, p.id_product,p.quantite, c.nom, pr.prix, pr.nom "
                    + "FROM panier p "
                    + "JOIN user c ON p.id_client = c.id_user "
                    + "JOIN product pr ON p.id_product = pr.id_product "
                    + "WHERE p.id_client = '" + id_client + "' ";

            ResultSet result = st.executeQuery(req);

            while (result.next()) {
                Panier p=new Panier(result.getInt(2),result.getInt(3),result.getString(6),result.getInt(5),result.getString(4));
                
               pers.add(p);
                
               // System.out.println(+result.getInt(1)+"\n"+ result.getInt(2)+"\n"+ result.getInt(3)+"\n"+result.getString(4)+"\n"+result.getInt(5)+"\n"+result.getString(6));

            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return pers;
    }
*/
    @Override
    public void ajouter(Commande c) {
    }
    
    
         public List<Commande> ajouterC(Commande c) {
          List<Commande> commande = new ArrayList<Commande>();
        try {
            Statement st=conn.createStatement();
          
            
                  String qry= " INSERT INTO `commande` ( `id_client`, `date` , etat,totale) VALUES ('"+c.getId_client()+"', NOW(),'"+c.getEtat()+"' ,'"+c.getTotale()+"') ";
            st.executeUpdate(qry);
            System.out.println("mrigel ye brooo ");
                          ResultSet result = st.executeQuery(qry);
                           while (result.next()) {
               Commande c1 =new Commande(result.getInt(1),result.getInt(3),result.getDate(2),result.getDouble(4));
               commande.add(c1);
            }

             
           

            //String req = "SELECT etat from commande WHERE id_client='"+c.getId_client()+"'";
            //System.out.println("payer lhamdouleh");
           
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
       
        return commande;
    }

    @Override
    public void modifier(Commande  c , Commande c1) {
       Statement ste;
        try {
            ste = conn.createStatement();
             String qry="UPDATE `commande` SET `prenom`=aa WHERE idc= 1 ";
        ste.executeUpdate(qry);
          System.out.println("mrigel ye lhob ");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        
      
    }
    public void modifierEtat(int etat , int idc)
    {
         Statement ste;
        try {    
            ste = conn.createStatement();
String qry="UPDATE `commande` SET `etat`='"+etat+"' WHERE idc= '" + idc + "' ";
        ste.executeUpdate(qry);
          System.out.println("modifieretat");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        
    }
        public void payer(int id_client)
    {
         try {
            Statement st = conn.createStatement();

            String req = "SELECT etat from commande WHERE id_client='"+id_client+"'";
              ResultSet result = st.executeQuery(req);
            System.out.println("payer lhamdouleh");
            while (result.next()) {
                if(result.getInt(1)==1)
                {
                 PanierService ps=new PanierService();
                 ps.supprimer(id_client);
                }
            }
             
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
            
    }
    

    @Override
    public void supprimer(int i) {
          Statement ste;
        try {
            ste = conn.createStatement();
            String qry = "DELETE FROM `commande` WHERE idc='" + i + "'";
            ste.executeUpdate(qry);
            System.out.println("mrigel ye lhob ");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
    public List<Commande> chercherCommande(int idC)
    {    List<Commande> commande = new ArrayList<Commande>();
         Statement ste;
        try {
            ste = conn.createStatement();
            String qry = "SELECT * FROM `commande` WHERE idc='" + idC+ "'";
            ste.executeQuery(qry);
            System.out.println("mrigel ye lhob ");
              ResultSet result = ste.executeQuery(qry);
            //System.out.println("payer lhamdouleh");
            while (result.next()) {
               Commande c1 =new Commande(result.getInt(1),result.getInt(2),result.getInt(4),result.getDate(3),result.getDouble(5));
               commande.add(c1);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return commande;
    }
    public  List<Commande>  trierC()
    {
      List<Commande> commande = new ArrayList<Commande>();
      
          try {
            Statement st = conn.createStatement();

            String req = "SELECT * FROM commande "
                    + " ORDER BY date ASC";

            ResultSet result = st.executeQuery(req);
              System.out.println("cbon");
            while (result.next()) {
               Commande c1 =new Commande(result.getInt(1),result.getInt(2),result.getInt(4),result.getDate(3),result.getDouble(5));
               commande.add(c1);
                System.out.println(c1);
            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
                  return commande;
    }



  
    
}
