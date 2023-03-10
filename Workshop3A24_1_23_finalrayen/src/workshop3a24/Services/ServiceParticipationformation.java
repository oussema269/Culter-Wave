
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
import workshop3a24.Entities.Participationformation;
import workshop3a24.Utils.MyDB;

/**
 *
 * @author dell
 */
public class ServiceParticipationformation implements IService<Participationformation> {

    Connection cnx;

    @Override
    public void add(Participationformation t) {
        try {
            String qry = "INSERT INTO `participationformation`( `idFormation`, `idUser`, `confirmation`) VALUES ('" + t.getIdFormation() + "','" + t.getIdUser() + "','" + false + "')";
            cnx = MyDB.getInstance().getCnx();

            Statement stm = cnx.createStatement();

            stm.executeUpdate(qry);

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

    }

    @Override
    public List<Participationformation> afficher() {
        List<Participationformation> personnes = new ArrayList<>();
        try {
                String qry = "SELECT\n"
                        + "    s.idParticipationFormation,s.idFormation,s.Id,s.confirmation,\n"
                        + "    fo.titre,\n"
                        + "    us.Email,CONCAT(us.Nom, ' ', us.Prenom) AS nom\n"
                        + "FROM participationformation s\n"
                        + "INNER JOIN formation AS fo\n"
                        + "ON fo.idformation = s.idFormation\n"
                        + "INNER JOIN user us  \n"
                        + "ON us.Id = s.idUser;";
            cnx = MyDB.getInstance().getCnx();
            Statement stm = cnx.createStatement();
            ResultSet rs = stm.executeQuery(qry);
            while (rs.next()) {
                Participationformation p = new Participationformation();

                p.setIdParticipationFormation(rs.getInt(1));
                p.setIdFormation(rs.getInt(2));
                p.setIdUser(rs.getInt(3));
                p.setConfirmation(rs.getBoolean(4));
                p.setTitre(rs.getNString(5));
                p.setEmail(rs.getNString(6));
                p.setNom(rs.getNString(7));

                personnes.add(p);
            }
            return personnes;

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return personnes;

    }
    
    
    
        public int GetNumAcceptedByID(int y) {
            int x = 0;
        List<Participationformation> personnes = new ArrayList<>();
        try {
                String qry = "SELECT COUNT(pf.idParticipationFormation) \n" +
"FROM participationformation pf \n" +
"INNER JOIN formation f ON f.idformation = pf.idFormation \n" +
"WHERE pf.confirmation = 'true' AND f.idformation = "+y+"";
            cnx = MyDB.getInstance().getCnx();
            Statement stm = cnx.createStatement();
            ResultSet rs = stm.executeQuery(qry);
            while (rs.next()) {
                Participationformation p = new Participationformation();

                p.setIdParticipationFormation(rs.getInt(1));
               x=p.getIdParticipationFormation();

                personnes.add(p);
            }
            return x;

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return x;

    }

        public int GetNumAlledByID(int y) {
            int x = 0;
        List<Participationformation> personnes = new ArrayList<>();
        try {
                String qry = "SELECT COUNT(pf.idParticipationFormation) \n" +
"FROM participationformation pf \n" +
"INNER JOIN formation f ON f.idformation = pf.idFormation \n" +
"WHERE pf.confirmation IS NOT NULL AND f.idformation = "+y+"";
            cnx = MyDB.getInstance().getCnx();
            Statement stm = cnx.createStatement();
            ResultSet rs = stm.executeQuery(qry);
            while (rs.next()) {
                Participationformation p = new Participationformation();

                p.setIdParticipationFormation(rs.getInt(1));
               x=p.getIdParticipationFormation();

                personnes.add(p);
            }
            return x;

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return x;

    }
    @Override
    public void modifier(Participationformation t) {
        try {
            String qry = "UPDATE `participationformation` SET `idParticipationFormation`='" + t.getIdParticipationFormation() + "',`idFormation`='" + t.getIdFormation() + "',`idUser`='" + t.getIdUser() + "',`confirmation`='" + t.getConfirmation() + "' WHERE idParticipationFormation='" + t.getIdParticipationFormation() + "' ";
            cnx = MyDB.getInstance().getCnx();

            Statement stm = cnx.createStatement();

            stm.executeUpdate(qry);

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

    }

    public void accept(int t) {
        try {
            String qry = "UPDATE `participationformation` SET `confirmation`='true' WHERE idParticipationFormation='" + t + "' ";
            cnx = MyDB.getInstance().getCnx();

            Statement stm = cnx.createStatement();

            stm.executeUpdate(qry);

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

    }

    public void refuser(int t) {
        try {
            String qry = "UPDATE `participationformation` SET `confirmation`='null' WHERE idParticipationFormation='" + t + "' ";
            cnx = MyDB.getInstance().getCnx();

            Statement stm = cnx.createStatement();

            stm.executeUpdate(qry);

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
    

    @Override
    public void supprimer(Participationformation t) {
        try {
            String qry = "DELETE FROM `participationformation`WHERE idParticipationFormation='" + t.getIdParticipationFormation() + "' ";
            cnx = MyDB.getInstance().getCnx();

            Statement stm = cnx.createStatement();

            stm.executeUpdate(qry);

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

    }

    public List<Participationformation> afficherbyidformation(int id) {
        List<Participationformation> personnes = new ArrayList<>();
        try {
            String qry = "SELECT s.idParticipationFormation, s.idFormation, s.Id, s.confirmation, fo.titre, us.Email, CONCAT(us.Nom, ' ', us.Prenom) AS nom FROM participationformation s INNER JOIN formation AS fo ON fo.idformation = s.idFormation INNER JOIN user us ON us.Id = s.idUser WHERE fo.idformation =" + id + " ;";
            cnx = MyDB.getInstance().getCnx();
            Statement stm = cnx.createStatement();
            ResultSet rs = stm.executeQuery(qry);
            while (rs.next()) {
                Participationformation p = new Participationformation();

                p.setIdParticipationFormation(rs.getInt(1));
                p.setIdFormation(rs.getInt(2));
                p.setIdUser(rs.getInt(3));
                p.setConfirmation(rs.getBoolean(4));
                p.setTitre(rs.getNString(5));
                p.setEmail(rs.getNString(6));
                p.setNom(rs.getNString(7));

                personnes.add(p);
            }
            return personnes;

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return personnes;

    }
}
