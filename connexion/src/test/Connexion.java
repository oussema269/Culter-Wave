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
        Commande co =new Commande(22);        
        Commande co1 =new Commande(23); 
        Panier p =new Panier(22,33,66);
        Panier p1 =new Panier(23,33,1);
        Panier p2 =new Panier(24,34,88);
        Panier p3 =new Panier(22,34,2);
        PanierService ps=new PanierService();
       //ps.ajouter(p);       
         //ps.modifier(p1,p2);
       // ps.supprimer(p3.getId_client());
        //System.out.println( "p2 = "+ps.afficher(p2.getId_client())+"\n p=" +ps.afficher(p.getId_client())+"\n p1="+ps.afficher(p1.getId_client())+ "\n p3="+ps.afficher(p3.getId_client()));
        System.out.println(ps.sommeProduit(p1.getId_client()));
        //ps.trierParPrix();
        //ps.trierParQuantite();
    //c.ajouter(co);
        //c.modifier(co1);
       // System.out.println(c.afficher());
        //System.out.println( ps.afficher());
       //c.ajouter(co);
       /* System.out.println(c.afficher(co.getId_client()));
        c.modifierEtat(1, co.getId_client());
        c.payer(co.getId_client());
      
    */
       // System.out.println(ps.afficher(p.getId_client()));
    }
}

