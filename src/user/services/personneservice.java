/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package user.services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import user.Entities.personne;
import user.Utils.MyDB;

/**
 *
 * @author FIRAS
 */
public class personneservice implements Iservice<personne>{
    Connection cnx;

    @Override
    public void ajouter(personne u) {
      
        try {
             String qry ="  INSERT INTO `user`( `Nom`, `Prenom`, `Email`,`password`, `Type`) VALUES ('"+u.getNom()+"','"+u.getPrenom()+"','"+u.getEmail()+"','"+u.getPassword()+"','"+u.getType()+"')";
       cnx = MyDB.getInsatnce().getCnx();
            Statement stm = cnx.createStatement();
            stm.executeUpdate(qry);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            
        }
       
    }

    @Override

     public List<personne> afficher() {
        List<personne> personnes = new ArrayList<>();
        try {
        String qry = "SELECT * FROM `user`";
        cnx = MyDB.getInsatnce().getCnx();
        Statement stm = cnx.createStatement();
        ResultSet rs = stm.executeQuery(qry);
        while (rs.next()) {
            personne p = new personne();
            p.setNom(rs.getString(2));
            p.setPrenom(rs.getString(3));
            p.setEmail(rs.getString(4));
            p.setType(rs.getString(5));
            p.setPassword(rs.getString(6));
            p.setIsActive(rs.getInt(7));
            personnes.add(p);
        }
        rs.close();
        stm.close();
    } catch (SQLException ex) {
        System.out.println(ex.getMessage());
    }
    return personnes;
}

    @Override
    public void modifier(personne u) {
        try {
        String qry = "UPDATE `user` SET `Nom`='" + u.getNom() + "', `Prenom`='" + u.getPrenom() + "', `Email`='" + u.getEmail() + "', `password`='" + u.getPassword() + "', `Type`='" + u.getType() + "'  WHERE `id`=" + u.getId();

            cnx = MyDB.getInsatnce().getCnx();

            Statement stm = cnx.createStatement();
            stm.executeUpdate(qry);

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
     
    }
      public void modifierByuser(personne u) {
        try {
        String qry = "UPDATE `user` SET `Nom`='" + u.getNom() + "', `Prenom`='" + u.getPrenom() + "', `Email`='" + u.getEmail() + "', `password`='" + u.getPassword() + "'  WHERE `id`=" + u.getId();

            cnx = MyDB.getInsatnce().getCnx();

            Statement stm = cnx.createStatement();
            stm.executeUpdate(qry);

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
     
    }
    public void modifierisactive(String u) {
        try {
        String qry = "UPDATE `user` SET  `isActive`= '1'   WHERE `Nom`='"+u+"'" ;

            cnx = MyDB.getInsatnce().getCnx();

            Statement stm = cnx.createStatement();
            stm.executeUpdate(qry);

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
     
    }
    public void modifierisactive1(String u) {
        try {
        String qry = "UPDATE `user` SET  `isActive`= '0'   WHERE `Nom`='"+u+"'" ;

            cnx = MyDB.getInsatnce().getCnx();

            Statement stm = cnx.createStatement();
            stm.executeUpdate(qry);

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
    /*public void modifier2(String u) {
        try {
        String qry = "UPDATE `user` SET  `password`= ?   WHERE `Email`='"+u+"'" ;

            cnx = MyDB.getInsatnce().getCnx();

            Statement stm = cnx.createStatement();
            stm.executeUpdate(qry);

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }*/


    @Override
    public void supprimer(personne u) {
        /* try {
            String qry = "DELETE FROM `user` WHERE id='" + u.getId() + "'";
            cnx = MyDB.getInsatnce().getCnx();

            Statement stm = cnx.createStatement();

            stm.executeUpdate(qry);

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }*/
       
    }
      public void supprimerid(String u) {
         try {
            String qry = "DELETE FROM `user` WHERE Nom='" + u + "'";
            cnx = MyDB.getInsatnce().getCnx();

            Statement stm = cnx.createStatement();

            stm.executeUpdate(qry);

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
       
    }
      public personne getUserByEmail(String email) {
        personne user = null;
    try {
          PreparedStatement preparedStatement = cnx.prepareStatement("SELECT * FROM user WHERE Email = ?");
        preparedStatement.setString(1, email);
        ResultSet rs = preparedStatement.executeQuery();
        Statement stm = cnx.createStatement();
        
        if (rs.next()) {
            user = new personne();
            user.setId(rs.getInt(1));
            user.setNom(rs.getString(2));
            user.setPrenom(rs.getString(3));
            user.setEmail(rs.getString(4));
            user.setPassword(rs.getString(5));
            user.setType(rs.getString(6));
            user.setIsActive(rs.getInt(7));
            
        }
        
    } catch (SQLException ex) {
        System.out.println(ex.getMessage());
    }
    return user;
}
      
    

   

     public static String generateVerificationCode() {
         StringBuilder sb = new StringBuilder();
        int codeLength = 6;
        Random random = new Random();
        
        for (int i = 0; i < codeLength; i++) {
            sb.append(random.nextInt(10));
        }
        return sb.toString();
    }
     
     public String check(String email, String password) {
    String type = null;
    try {
        Connection connection = MyDB.getInsatnce().getCnx();
        String query = "SELECT Type FROM user WHERE Email = ? AND password = ?";
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setString(1, email);
        statement.setString(2, password);
        ResultSet result = statement.executeQuery();
        if (result.next()) {
            type = result.getString("Type");
        }
    } catch (SQLException ex) {
    }
    return type;
}
     
    /* public String check2(String code, String email) {
    String emaill = null;
    try {
        Connection connection = MyDB.getInsatnce().getCnx();
        String query = "SELECT Type FROM code WHERE codeEmail = ? AND email = ?";
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setString(1, code);
        statement.setString(2, email);
        ResultSet result = statement.executeQuery();
        if (result.next()) {
            emaill = result.getString("email");
        }
    } catch (SQLException ex) {
    }
    return emaill;
}*/
    


          
           
}   