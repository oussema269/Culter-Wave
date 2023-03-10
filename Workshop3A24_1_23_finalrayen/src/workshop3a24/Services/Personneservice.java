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
import java.util.Random;
import workshop3a24.Entities.Personne;
import workshop3a24.Utils.MyDB;

/**
 *
 * @author dell
 */
public class Personneservice implements IService<Personne>{

    Connection cnx;

   

    public void ajouter(Personne u) {
      
        try {
             String qry ="  INSERT INTO `user`( `Nom`, `Prenom`, `Email`,`password`, `Type`) VALUES ('"+u.getNom()+"','"+u.getPrenom()+"','"+u.getEmail()+"','"+u.getPassword()+"','"+u.getType()+"')";
       cnx = MyDB.getInstance().getCnx();
            Statement stm = cnx.createStatement();
            stm.executeUpdate(qry);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            
        }
       
    }

    @Override

     public List<Personne> afficher() {
        List<Personne> Personnes = new ArrayList<>();
        try {
        String qry = "SELECT * FROM `user`";
        cnx = MyDB.getInstance().getCnx();
        Statement stm = cnx.createStatement();
        ResultSet rs = stm.executeQuery(qry);
        while (rs.next()) {
            Personne p = new Personne();
            p.setNom(rs.getString(2));
            p.setPrenom(rs.getString(3));
            p.setEmail(rs.getString(4));
            p.setType(rs.getString(5));
            p.setPassword(rs.getString(6));
            p.setIsActive(rs.getInt(7));
            Personnes.add(p);
        }
        rs.close();
        stm.close();
    } catch (SQLException ex) {
        System.out.println(ex.getMessage());
    }
    return Personnes;
}

     
     
     
        public int GETIDuser(String email) {
        List<Personne> Personnes = new ArrayList<>();
        int x = 0;
        try {
            
        String qry = "SELECT `ID`  FROM `user` WHERE `Email` = '"+email+"' ";
        cnx = MyDB.getInstance().getCnx();
        Statement stm = cnx.createStatement();
        ResultSet rs = stm.executeQuery(qry);
        while (rs.next()) {
            Personne p = new Personne();
           p.setId(rs.getInt(1));
           x=p.getId();
            Personnes.add(p);
        }
        rs.close();
        stm.close();
    } catch (SQLException ex) {
        System.out.println(ex.getMessage());
    }
    return x;
}
        public Personne GetUserById(int id) {
        List<Personne> Personnes = new ArrayList<>();
           Personne p = new Personne();
        
        try {
            
        String qry = "SELECT `*  FROM `user` WHERE `ID` = '"+id+"' ";
        cnx = MyDB.getInstance().getCnx();
        Statement stm = cnx.createStatement();
        ResultSet rs = stm.executeQuery(qry);
        while (rs.next()) {
            p.setNom(rs.getString(2));
            p.setPrenom(rs.getString(3));
            p.setEmail(rs.getString(4));
            p.setType(rs.getString(5));
            p.setPassword(rs.getString(6));
            p.setIsActive(rs.getInt(7));
            Personnes.add(p);
        }
        rs.close();
        stm.close();
    } catch (SQLException ex) {
        System.out.println(ex.getMessage());
    }
    return p;
}
     
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
      public void modifierByuser(Personne u) {
        try {
        String qry = "UPDATE `user` SET `Nom`='" + u.getNom() + "', `Prenom`='" + u.getPrenom() + "', `Email`='" + u.getEmail() + "', `password`='" + u.getPassword() + "'  WHERE `id`=" + u.getId();

            cnx = MyDB.getInstance().getCnx();

            Statement stm = cnx.createStatement();
            stm.executeUpdate(qry);

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
     
    }
    public void modifierisactive(String u) {
        try {
        String qry = "UPDATE `user` SET  `isActive`= '1'   WHERE `Nom`='"+u+"'" ;

            cnx = MyDB.getInstance().getCnx();

            Statement stm = cnx.createStatement();
            stm.executeUpdate(qry);

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
     
    }
    public void modifierisactive1(String u) {
        try {
        String qry = "UPDATE `user` SET  `isActive`= '0'   WHERE `Nom`='"+u+"'" ;

            cnx = MyDB.getInstance().getCnx();

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


   
    public void supprimer(Personne u) {
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
            cnx = MyDB.getInstance().getCnx();

            Statement stm = cnx.createStatement();

            stm.executeUpdate(qry);

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
       
    }
      public Personne getUserByEmail(String email) {
        Personne user = null;
    try {
          PreparedStatement preparedStatement = cnx.prepareStatement("SELECT * FROM user WHERE Email = ?");
        preparedStatement.setString(1, email);
        ResultSet rs = preparedStatement.executeQuery();
        Statement stm = cnx.createStatement();
        
        if (rs.next()) {
            user = new Personne();
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
        Connection connection = MyDB.getInstance().getCnx();
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

    @Override
    public void add(Personne t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    



          
  
   
}
