/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;
import entity.User;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import utils.DataSource;
/**
 *
 * @author rayen
 */
public class UserService implements IService<User>{
    
    private Connection conn;

    public UserService() {
        conn=DataSource.getInstance().getCnx();
    }
    
    @Override
    public void insert(User p){
        String requete="insert into user (nom,type) values"
                + "('"+p.getNom()+"','"+p.getType()+"')";
        try {
            Statement ste=conn.createStatement();
            ste.executeUpdate(requete);
        } catch (SQLException ex) {
            Logger.getLogger(UserService.class.getName()).
                    log(Level.SEVERE, null, ex);
        }    
    }
    public void insertPst(User p){
        String requete="insert into user (nom,type) values (?,?,?)";
        try {
            PreparedStatement pst=conn.prepareStatement(requete);
            pst.setString(2, p.getNom());
            
            pst.setInt(3, p.getType());
            pst.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(UserService.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    @Override
    public void delete(User t) {
            String requete="DELETE from user where id = '"+t.getId()+"'";
        try {
            Statement st=conn.createStatement();
            st.executeUpdate(requete);
        } catch (SQLException ex) {
            Logger.getLogger(UserService.class.getName()).log(Level.SEVERE, null, ex);
        }
            
    }

    @Override
    public void update(User t) {
        String requete="UPDATE `user` SET `nom`='" +t.getNom()+"',`type`='"+ t.getType() +"' where id = '" + t.getId() + "'" ;
        try {
            Statement st=conn.createStatement();
            st.executeUpdate(requete);
        } catch (SQLException ex) {
            Logger.getLogger(UserService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public List<User> readAll() {
        String requete ="select * from user";
        List<User> list=new ArrayList<>();
        try {
            Statement st=conn.createStatement();
           ResultSet rs= st.executeQuery(requete);
           while(rs.next()){
               User p=new User
        (rs.getInt("id"), rs.getString(2), rs.getInt("type"));
               list.add(p);
                       
           }
        } catch (SQLException ex) {
            Logger.getLogger(UserService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    @Override
    public User readById(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
    
    
}
