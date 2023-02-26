/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package workshop3a24.Services;

import workshop3a24.Entities.Formation;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import workshop3a24.Utils.MyDB;

/**
 *
 * @author dell
 */
public class Formationservice implements IService<Formation> {

    Connection cnx;

    @Override
    public void add(Formation t) {
        try {
            String qry = "INSERT INTO `formation`( `titre`, `description`, `ownerID`, `type`, `pays`, `debut`, `fin`, `confirmation`) VALUES  ('" + t.getTitre() + "','" + t.getDescription() + "','" + t.getOwnerid() + "','" + t.getType() + "','" + t.getPays() + "','" + t.getDebut() + "','" + t.getFin() + "','" + false + "')";
            cnx = MyDB.getInstance().getCnx();

            Statement stm = cnx.createStatement();
            System.out.println(qry);
            stm.executeUpdate(qry);

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public List<Formation> afficher() {
        List<Formation> formations = new ArrayList<>();
        try {
            String qry = "SELECT f.idformation, f.titre, f.description, f.ownerID, f.type, f.pays, f.debut, f.fin, f.confirmation, u.Email, CONCAT(u.Nom, ' ', u.Prenom) AS nom\n" +
"FROM formation f\n" +
"INNER JOIN user u ON u.Iduser = f.ownerID AND u.Iduser = 35 AND f.confirmation IS NOT NULL";
            cnx = MyDB.getInstance().getCnx();
            Statement stm = cnx.createStatement();
            ResultSet rs = stm.executeQuery(qry);
            while (rs.next()) {
                Formation p = new Formation();
                p.setId(rs.getInt(1));
                p.setTitre(rs.getString("titre"));
                p.setDescription(rs.getString(3));
                p.setOwnerid(rs.getInt(4));
                p.setType(rs.getString(5));
                p.setPays(rs.getString(6));
                p.setDebut(rs.getDate(7));
                p.setFin(rs.getDate(8));
                p.setConfirmation(rs.getBoolean(9));
                p.setEmail(rs.getString(10));
                p.setNom(rs.getString(11));
                

                formations.add(p);
            }
            return formations;

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return formations;
    }

    public List<Formation> afficherAccept() {
        List<Formation> formations = new ArrayList<>();
        try {
            String qry = "SELECT * FROM `formation` WHERE `confirmation`='true'";
            cnx = MyDB.getInstance().getCnx();
            Statement stm = cnx.createStatement();
            ResultSet rs = stm.executeQuery(qry);
            while (rs.next()) {
                Formation p = new Formation();
                p.setId(rs.getInt(1));
                p.setTitre(rs.getString("titre"));
                p.setDescription(rs.getString(3));
                p.setOwnerid(rs.getInt(4));
                p.setType(rs.getString(5));
                p.setPays(rs.getString(6));
                p.setDebut(rs.getDate(7));
                p.setFin(rs.getDate(8));
                p.setConfirmation(rs.getBoolean(9));

                formations.add(p);
            }
            return formations;

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return formations;
    }

    public List<Formation> afficherAcceptPartypeForUser(String str) {
        List<Formation> formations = new ArrayList<>();
        try {
            String qry = "SELECT * FROM `formation` WHERE `type`='" + str + "' AND `confirmation`='true'";
            cnx = MyDB.getInstance().getCnx();
            Statement stm = cnx.createStatement();
            ResultSet rs = stm.executeQuery(qry);
            while (rs.next()) {
                Formation p = new Formation();
                p.setId(rs.getInt(1));
                p.setTitre(rs.getString("titre"));
                p.setDescription(rs.getString(3));
                p.setOwnerid(rs.getInt(4));
                p.setType(rs.getString(5));
                p.setPays(rs.getString(6));
                p.setDebut(rs.getDate(7));
                p.setFin(rs.getDate(8));
                p.setConfirmation(rs.getBoolean(9));

                formations.add(p);
            }
            return formations;

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return formations;
    }

    public List<Formation> afficherAllParType(String str) {
        List<Formation> formations = new ArrayList<>();
        try {
            String qry = "SELECT * FROM `formation` WHERE `type`='" + str + "'";
            cnx = MyDB.getInstance().getCnx();
            Statement stm = cnx.createStatement();
            ResultSet rs = stm.executeQuery(qry);
            while (rs.next()) {
                Formation p = new Formation();
                p.setId(rs.getInt(1));
                p.setTitre(rs.getString("titre"));
                p.setDescription(rs.getString(3));
                p.setOwnerid(rs.getInt(4));
                p.setType(rs.getString(5));
                p.setPays(rs.getString(6));
                p.setDebut(rs.getDate(7));
                p.setFin(rs.getDate(8));
                p.setConfirmation(rs.getBoolean(9));

                formations.add(p);
            }
            return formations;

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return formations;
    }

    public List<Formation> afficherAcceptParPaysForUser(String str) {
        List<Formation> formations = new ArrayList<>();
        try {
            String qry = "SELECT * FROM `formation` WHERE `type`='" + str + "' AND `pays`='true'";
            cnx = MyDB.getInstance().getCnx();
            Statement stm = cnx.createStatement();
            ResultSet rs = stm.executeQuery(qry);
            while (rs.next()) {
                Formation p = new Formation();
                p.setId(rs.getInt(1));
                p.setTitre(rs.getString("titre"));
                p.setDescription(rs.getString(3));
                p.setOwnerid(rs.getInt(4));
                p.setType(rs.getString(5));
                p.setPays(rs.getString(6));
                p.setDebut(rs.getDate(7));
                p.setFin(rs.getDate(8));
                p.setConfirmation(rs.getBoolean(9));

                formations.add(p);
            }
            return formations;

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return formations;
    }

    public List<Formation> afficherAllParPays(String str) {
        List<Formation> formations = new ArrayList<>();
        try {
            String qry = "SELECT * FROM `formation` WHERE `pays`='" + str + "'";
            cnx = MyDB.getInstance().getCnx();
            Statement stm = cnx.createStatement();
            ResultSet rs = stm.executeQuery(qry);
            while (rs.next()) {
                Formation p = new Formation();
                p.setId(rs.getInt(1));
                p.setTitre(rs.getString("titre"));
                p.setDescription(rs.getString(3));
                p.setOwnerid(rs.getInt(4));
                p.setType(rs.getString(5));
                p.setPays(rs.getString(6));
                p.setDebut(rs.getDate(7));
                p.setFin(rs.getDate(8));
                p.setConfirmation(rs.getBoolean(9));

                formations.add(p);
            }
            return formations;

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return formations;
    }

    public List<Formation> afficherAllBYOwnerId(int id) {
        List<Formation> formations = new ArrayList<>();
        try {
            String qry = "SELECT * FROM `formation` WHERE `ownerID`='" + id + "'";
            cnx = MyDB.getInstance().getCnx();
            Statement stm = cnx.createStatement();
            ResultSet rs = stm.executeQuery(qry);
            while (rs.next()) {
                Formation p = new Formation();
                p.setId(rs.getInt(1));
                p.setTitre(rs.getString("titre"));
                p.setDescription(rs.getString(3));
                p.setOwnerid(rs.getInt(4));
                p.setType(rs.getString(5));
                p.setPays(rs.getString(6));
                p.setDebut(rs.getDate(7));
                p.setFin(rs.getDate(8));
                p.setConfirmation(rs.getBoolean(9));

                formations.add(p);
            }
            return formations;

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return formations;
    }

    public List<Formation> afficherAllBYOwnerIdFromFormation(Formation t) {
        List<Formation> formations = new ArrayList<>();
        try {
            String qry = "SELECT * FROM `formation` WHERE `ownerID`='" + t.getOwnerid() + "'";
            cnx = MyDB.getInstance().getCnx();
            Statement stm = cnx.createStatement();
            ResultSet rs = stm.executeQuery(qry);
            while (rs.next()) {
                Formation p = new Formation();
                p.setId(rs.getInt(1));
                p.setTitre(rs.getString("titre"));
                p.setDescription(rs.getString(3));
                p.setOwnerid(rs.getInt(4));
                p.setType(rs.getString(5));
                p.setPays(rs.getString(6));
                p.setDebut(rs.getDate(7));
                p.setFin(rs.getDate(8));
                p.setConfirmation(rs.getBoolean(9));

                formations.add(p);
            }
            return formations;

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return formations;
    }
    public List<Formation> afficherAllBYDate(Date t) {
        List<Formation> formations = new ArrayList<>();
        try {
            String qry = "SELECT * FROM `formation` WHERE `debut`<'" + t + "'";
            cnx = MyDB.getInstance().getCnx();
            Statement stm = cnx.createStatement();
            ResultSet rs = stm.executeQuery(qry);
            while (rs.next()) {
                Formation p = new Formation();
                p.setId(rs.getInt(1));
                p.setTitre(rs.getString("titre"));
                p.setDescription(rs.getString(3));
                p.setOwnerid(rs.getInt(4));
                p.setType(rs.getString(5));
                p.setPays(rs.getString(6));
                p.setDebut(rs.getDate(7));
                p.setFin(rs.getDate(8));
                p.setConfirmation(rs.getBoolean(9));

                formations.add(p);
            }
            return formations;

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return formations;
    }

    @Override
    public void modifier(Formation t) {
        try {
            String qry = "UPDATE `formation` SET `titre`='" + t.getTitre() + "',`description`='" + t.getDescription() + "',`type`='" + t.getType() + "',`pays`='" + t.getPays() + "',`debut`='" + t.getDebut() + "',`fin`='" + t.getFin() + "'  WHERE idformation ='" + t.getId() + "'";
            cnx = MyDB.getInstance().getCnx();

            Statement stm = cnx.createStatement();

            stm.executeUpdate(qry);

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
    public void accept(int t) {
        try {
            String qry = "UPDATE `formation` SET `confirmation`='true'  WHERE `idformation`='" + t+ "'";
            cnx = MyDB.getInstance().getCnx();

            Statement stm = cnx.createStatement();

            stm.executeUpdate(qry);

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
     public void refusr(int t) {
        try {
            String qry = "UPDATE `formation` SET `confirmation`='null'  WHERE `idformation`='" + t+ "'";
            cnx = MyDB.getInstance().getCnx();

            Statement stm = cnx.createStatement();

            stm.executeUpdate(qry);

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    
    
    
    
    @Override
    public void supprimer(Formation t) {
        try {
            String qry = "DELETE FROM `formation` WHERE idformation ='" + t.getId() + "'";
            cnx = MyDB.getInstance().getCnx();

            Statement stm = cnx.createStatement();

            stm.executeUpdate(qry);

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

    }

    public void supprimerAllFormtionByOwnerId(int x) {
        try {
            String qry = "DELETE FROM `formation` WHERE ownerID='" + x + "'";
            cnx = MyDB.getInstance().getCnx();

            Statement stm = cnx.createStatement();

            stm.executeUpdate(qry);

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

    }/*
 public Formation afficherBYIdFormation(int t) {
        
        try {
            String qry = "SELECT * FROM `formation` WHERE `id`='" + t + "'";
            cnx = MyDB.getInstance().getCnx();
            Statement stm = cnx.createStatement();
            ResultSet rs = stm.executeQuery(qry);
            Formation p=new Formation();
              
                p.setId(rs.getInt(1));
                p.setTitre(rs.getString("titre"));
                p.setDescription(rs.getString(3));
                p.setOwnerid(rs.getInt(4));
                p.setType(rs.getString(5));
                p.setPays(rs.getString(6));
                p.setDebut(rs.getDate(7));
                p.setFin(rs.getDate(8));
                p.setConfirmation(rs.getBoolean(9));

             return p;
            }
            

        } catch (Exception ex) {
            System.out.println(ex.getMessage());

        }*/
     public void supprimerbyid(int t) {
        try {
            String qry = "DELETE FROM `formation` WHERE id='" + t + "'";
            cnx = MyDB.getInstance().getCnx();

            Statement stm = cnx.createStatement();

            stm.executeUpdate(qry);

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

    }

    }

