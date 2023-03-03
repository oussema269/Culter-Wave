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
import workshop3a24.Entities.Personne;
import workshop3a24.Utils.MyDB;

/**
 *
 * @author dell
 */
public class Personneservice implements IService<Personne>{

    Connection cnx;

   

    @Override

     public List<Personne> afficher() {
        List<Personne> personnes = new ArrayList<>();
        try {
        String qry = "SELECT * FROM `user`";
        cnx = MyDB.getInstance().getCnx();
        Statement stm = cnx.createStatement();
        ResultSet rs = stm.executeQuery(qry);
        while (rs.next()) {
            Personne p = new Personne();
            p.setId(rs.getInt(1));
            p.setNom(rs.getString(2));
            p.setPrenom(rs.getString(3));
            p.setEmail(rs.getString(4));
            p.setType(rs.getString(5));
            p.setPassword(rs.getString(6));
            personnes.add(p);
        }
        rs.close();
        stm.close();
    } catch (SQLException ex) {
        System.out.println(ex.getMessage());
    }
    return personnes;
}
     public Personne  afficherByiduser(int t) {
        List<Personne> personnes = new ArrayList<>();
         Personne p = new Personne();
        try {
        String qry = "SELECT * FROM `user` WHERE `id`='"+t+ "' ";
         cnx = MyDB.getInstance().getCnx();
        Statement stm = cnx.createStatement();
        ResultSet rs = stm.executeQuery(qry);
        while (rs.next()) {
           
            p.setId(rs.getInt(1));
            p.setNom(rs.getString(2));
            p.setPrenom(rs.getString(3));
            p.setEmail(rs.getString(4));
            p.setType(rs.getString(5));
            p.setPassword(rs.getString(6));
           
        }
        rs.close();
        stm.close();
    } catch (SQLException ex) {
        System.out.println(ex.getMessage());
    }
    return p;}

    @Override
    public void modifier(Personne u) {
        try {
        String qry = "UPDATE `user` SET `Nom`='" + u.getNom() + "', `Prenom`='" + u.getPrenom() + "', `Email`='" + u.getEmail() + "', `password`='" + u.getPassword() + "', `Type`='" + u.getType() + "'  WHERE `id`=" + u.getId();

            cnx = MyDB.getInstance().getCnx();

            Statement stm = cnx.createStatement();
            stm.executeUpdate(qry);

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
     
    }

    @Override
    public void supprimer(Personne u) {
         try {
            String qry = "DELETE FROM `user` WHERE id='" + u.getId() + "'";
            cnx = MyDB.getInstance().getCnx();

            Statement stm = cnx.createStatement();

            stm.executeUpdate(qry);

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    
}

    @Override
    public void add(Personne u) {
          try {
             String qry ="  INSERT INTO `user`( `Nom`, `Prenom`, `Email`,`password`, `Type`) VALUES ('"+u.getNom()+"','"+u.getPrenom()+"','"+u.getEmail()+"','"+u.getPassword()+"','"+u.getType()+"')";
       cnx = MyDB.getInstance().getCnx();
            Statement stm = cnx.createStatement();
            stm.executeUpdate(qry);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            
        }
       
    }
}
