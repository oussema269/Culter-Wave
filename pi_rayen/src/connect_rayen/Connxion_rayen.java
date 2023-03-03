/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package connect_rayen;


import entity.User;
import entity.Reclamation;
import entity.Reponse;
import service.UserService;
import service.ReclamationService;
import service.ReponseService;
import utils.DataSource;
import java.util.Scanner;
/**
 *
 * @author rayen
 */
public class Connxion_rayen {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        

        

     
            Reclamation r1;
        r1 = new Reclamation(7,1,2,"type rec","contenu");
        ReclamationService rs = new ReclamationService() {};
        
        User u1;
        u1 = new User(8,"hama",0);
        UserService us = new UserService() ;
        
        Reponse rep;
        rep = new Reponse (1,3,"dejas fait");
        ReponseService reps = new ReponseService();
          
         
        //User u1= new User(1,"dorra",0 );
        
        //UserService us= new UserService()  ;
        
        
       us.insert(u1);
       //us.delete(u1);
       //us.update(u1);
        
       //rs.update(r1);
       //rs.insert(r1);
       //rs.delete(r1);
       
       //reps.insert(rep);
       //reps.update(rep);
       //reps.delete(rep);
       
       
       us.readAll().forEach(System.out::println);
       
      rs.readAll().forEach(System.out::println);
       
       reps.readAll().forEach(System.out::println);
       
       
       
       
    }

}
