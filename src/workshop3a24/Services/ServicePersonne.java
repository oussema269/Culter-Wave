
package workshop3a24.Services;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import workshop3a24.Entities.Personne;
import workshop3a24.Utils.MyDB;

/**
 *
 * @author Mohamed
 */
public class ServicePersonne implements IService<Personne>{
    Connection cnx;
    @Override
    public void add(Personne t) {
         try {
        String qry ="INSERT INTO `personne`( `nom`, `prenom`, `age`) VALUES ('"+t.getNom()+"','"+t.getPrenom()+"','"+t.getAge()+"')";
      cnx = MyDB.getInstance().getCnx();
      
            Statement stm =cnx.createStatement();
            
            stm.executeUpdate(qry);
            
        } catch (SQLException ex) {
             System.out.println(ex.getMessage());
        }
    
    }

    @Override
    public List<Personne> afficher() {
        List<Personne> personnes = new ArrayList<>();
        try {
            String qry ="SELECT * FROM `personne` ";
            cnx = MyDB.getInstance().getCnx();
            Statement stm = cnx.createStatement();
            ResultSet rs = stm.executeQuery(qry);
            while(rs.next()){
                Personne p =new Personne();
                p.setId(rs.getInt(1));
                p.setNom(rs.getString("nom"));
                p.setPrenom(rs.getString(3));
                p.setAge(rs.getInt("age"));
                personnes.add(p);
            }
            return personnes;
            
            
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return personnes;
        
    }

    @Override
    public void modifier(Personne t) {
      }

    @Override
    public void supprimer(Personne t) {
         }
    
}
