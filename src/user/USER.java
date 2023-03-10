/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package user;

import user.Entities.personne;
import user.services.personneservice;

/**
 *
 * @author FIRAS
 */
public class USER {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        //personne p = new personne(40,"nnn","nnnn","jjjjjj","hhhhhh","ggggg",1);
        //personne p2 = new personne(27,"11111","kdai","ki@gmail.com","1111","for",0);
        personneservice ps = new personneservice();
        //
        
        
        //ps.ajouter(p);
        //ps.ajouter(p2);
        //ps.modifier(p);
        //ps.modifier(p2);
        //ps.supprimer(p2);
        System.out.println(ps.afficher());
    }
    
    
}
