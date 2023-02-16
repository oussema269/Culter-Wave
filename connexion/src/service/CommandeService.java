/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import utils.MyConnection;
import service.InterfaceService;
import entite.Commande;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author asus
 */
public class CommandeService implements InterfaceService<Commande> {

    Connection conn = MyConnection.getInstance().getConnection();
      public List<Commande> afficher() {
           List<Commande> pers = new ArrayList<Commande>();
        try {
            Statement st = conn.createStatement();

            String req = "SELECT * FROM commande";
                    
                    

            ResultSet result = st.executeQuery(req);

            while (result.next()) {
                Commande resultc = new Commande(result.getInt(1),result.getInt(2), result.getDate(3));
                pers.add(resultc);
            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return pers;
         }
    public List<Commande> afficher(int id_client) {
        List<Commande> pers = new ArrayList<Commande>();
        try {
            Statement st = conn.createStatement();

            String req = "SELECT c.idc ,c.id_client ,c.date ,u.nom "+
                    "FROM commande c " +
                     "JOIN user u ON c.id_client = u.id_user "+
                    " WHERE id_client='"+id_client+"'";
                    

            ResultSet result = st.executeQuery(req);

            while (result.next()) {
                Commande resultc = new Commande(result.getInt(1),result.getInt(2), result.getDate(3));
                pers.add(resultc);
            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return pers;
    }

    @Override
    public void ajouter(Commande c) {
        try {
            
            Statement st=conn.createStatement();
            String qry= " INSERT INTO `commande` ( `id_client`, `date`) VALUES ('"+c.getId_client()+"', NOW()) ";
            st.executeUpdate(qry);
            System.out.println("mrigel ye brooo ");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
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
    public void modifierEtat(int etat , int id_client)
    {
         Statement ste;
        try {
            ste = conn.createStatement();
             String qry="UPDATE `commande` SET `etat`=1 WHERE id_client= '" + id_client + "' ";
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
            String qry = "DELETE FROM `commande` WHERE id_client='" + i + "'";
            ste.executeUpdate(qry);
            System.out.println("mrigel ye lhob ");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

}
