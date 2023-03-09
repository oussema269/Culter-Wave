/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;
import entity.Reclamation;
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
public  class ReclamationService implements IService<Reclamation>{
    
    private Connection conn;

    public ReclamationService() {
        conn=DataSource.getInstance().getCnx();
    }
    
    @Override
    public void insert(Reclamation p){
        String requete="insert into reclamation (id_reclamateur, id_cible_reclamation , type_reclamation , contenu , datepro ) values"
                + "('"+p.getid_reclamateur()+"','"+p.getid_cible_reclamation()+"','" +p.gettype_reclamation()+ "','" +p.getcontenu()+"','" + p.getDatecr() +"')";
        try {
            Statement ste=conn.createStatement();
            ste.executeUpdate(requete);
        } catch (SQLException ex) {
            Logger.getLogger(ReclamationService.class.getName()).
                    log(Level.SEVERE, null, ex);
        }    
    }
    public void insertPst(Reclamation p){
        String requete="insert into reclamation (id_reclamation,id_reclamateur, id_cible_reclamation , type_reclamation , contenu) values (?,?,?)";
        try {
            PreparedStatement pst=conn.prepareStatement(requete);
           pst.setInt(1, p.getid_reclamation());
           pst.setInt(2, p.getid_reclamateur());
           pst.setInt(3, p.getid_cible_reclamation());
           pst.setString(3, p.gettype_reclamation()) ;
           pst.setString(3, p.getcontenu()) ;
            pst.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ReclamationService.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    @Override
    public void delete(Reclamation t) {
            String requete="DELETE from reclamation where id_reclamation  = "+t.getid_reclamation()+";" ;
        try {
            Statement st=conn.createStatement();
            st.executeUpdate(requete);
        } catch (SQLException ex) {
            Logger.getLogger(ReclamationService.class.getName()).log(Level.SEVERE, null, ex);
        }
            
    }

    @Override
    public void update(Reclamation t) {
        String requete="UPDATE `reclamation` SET `id_reclamateur`='"+ t.getid_reclamateur() +" ' ,`id_cible_reclamation`= '"+ t.getid_cible_reclamation()+ "' ,`type_reclamation`='  "+ t.gettype_reclamation()   + "' ,`contenu`='  " + t.getcontenu() +"' ,`datepro`='  " + t.getDatecr() +  "' where id_reclamation = '" + t.getid_reclamation() + "'" ;
        try {
            Statement st=conn.createStatement();
            st.executeUpdate(requete);
        } catch (SQLException ex) {
            Logger.getLogger(ReclamationService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public List<Reclamation> readAll() {
        String requete ="select * from reclamation";
        List<Reclamation> list=new ArrayList<>();
        try {
            Statement st=conn.createStatement();
           ResultSet rs= st.executeQuery(requete);
           while(rs.next()){
               Reclamation p;
                p = new Reclamation
                (rs.getInt("id_reclamation"),rs.getInt("id_reclamateur"), rs.getInt("id_cible_reclamation") ,rs.getString("type_reclamation"), rs.getString("contenu"));
               list.add(p);
                       
           }
        } catch (SQLException ex) {
            Logger.getLogger(ReclamationService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
    
    

    @Override
    public Reclamation readById(int id_reclamation) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    

    
    
    
}
