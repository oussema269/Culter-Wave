/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;
import entity.Reponse;
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
public  class ReponseService implements IService<Reponse>{
    
    private Connection conn;

    public ReponseService() {
        conn=DataSource.getInstance().getCnx();
    }
    
    @Override
    public void insert(Reponse p){
        String requete="insert into Reponse ( id_reclamation , repo ) values"
                + "('"+p.getId_reclamation()+ "','"+ p.getRepo() +"')";
        try {
            Statement ste=conn.createStatement();
            ste.executeUpdate(requete);
        } catch (SQLException ex) {
            Logger.getLogger(ReponseService.class.getName()).
                    log(Level.SEVERE, null, ex);
        }    
    }
    public void insertPst(Reponse p){
        String requete="insert into reponse (id_reponse,id_reclamation, repo ) values (?,?,?)";
        try {
            PreparedStatement pst=conn.prepareStatement(requete);
           pst.setInt(1, p.getId_reponse());
           pst.setInt(2, p.getId_reclamation());
           pst.setString(3, p.getRepo());
           
            pst.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ReponseService.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    @Override
    public void delete(Reponse t) {
            String requete="DELETE from reponse where id_reponse = "+t.getId_reponse() +";" ;
        try {
            Statement st=conn.createStatement();
            st.executeUpdate(requete);
        } catch (SQLException ex) {
            Logger.getLogger(ReponseService.class.getName()).log(Level.SEVERE, null, ex);
        }
            
    }

    @Override
    public void update(Reponse t) {
        String requete="UPDATE `reponse` SET `id_reclamation`='"+ t.getId_reclamation() +" ' ,`repo`= '"+ t.getRepo()+  "'" ;
        try {
            Statement st=conn.createStatement();
            st.executeUpdate(requete);
        } catch (SQLException ex) {
            Logger.getLogger(ReponseService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public List<Reponse> readAll() {
        String requete ="select * from reponse";
        List<Reponse> list=new ArrayList<>();
        try {
            Statement st=conn.createStatement();
           ResultSet rs= st.executeQuery(requete);
           while(rs.next()){
               Reponse p;
                p = new Reponse
                (rs.getInt("id_reponse"),rs.getInt("id_reclamation"), rs.getString("repo"));
               list.add(p);
                       
           }
        } catch (SQLException ex) {
            Logger.getLogger(ReponseService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    @Override
    public Reponse readById(int id_reponse) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    

    
    
    
}
