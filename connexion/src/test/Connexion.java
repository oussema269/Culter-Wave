/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import entite.Commande;
import entite.Panier;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import service.CommandeService;
import service.PanierService;

/**
 *
 * @author asus
 */
public class Connexion {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        List<Panier> pan = new ArrayList<Panier>();
        CommandeService c =new CommandeService();
        Commande co =new Commande(22,0,20);        
        Commande co1 =new Commande(23); 
        Panier p =new Panier(22,33,8);
        Panier p1 =new Panier(23,33,4);
        Panier p2 =new Panier(24,34,3);
        Panier p3 =new Panier(24,33,2);
        PanierService ps=new PanierService();
        ps.ajouter(p1);   
        //ps.decrementQuantite(24,34);
         //ps.modifier(p1,p2);
       //ps.supprimer(24);
       //System.out.println( "p1 = "+ps.getPanier(p1.getId_client()));
       // System.out.println(ps.sommeProduit(p1.getId_client()));
        //ps.trierParPrix();
        //ps.trierParQuantite();
    //c.ajouter(co);
        //c.modifier(co1);
       // System.out.println(c.afficher());
        //System.out.println( ps.afficher());
       //c.ajouterC(co);
        //System.out.println(c.afficher(co.getId_client()));
        //c.modifierEtat(0, 42);
      //  c.payer(co.getId_client());
      
       // System.out.println( c.getCommannde());
   
       // System.out.println(ps.afficher(p.getId_client()));
       // System.out.println(c.trierC());
        System.out.println(c.chercherCommande(22));
        
    }
}

