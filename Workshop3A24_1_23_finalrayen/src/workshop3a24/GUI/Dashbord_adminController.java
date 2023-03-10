/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package workshop3a24.GUI;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javax.swing.JOptionPane;
import workshop3a24.Utils.MyDB;

/**
 * FXML Controller class
 *
 * @author FIRAS
 */
public class Dashbord_adminController implements Initializable {

    /**
     * Initializes the controller class.
     */
        Connection cnx = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        InterfaceloginController i = new InterfaceloginController();
        String email = i.currentUserEmail;
    @FXML
    private Button btnuser;



    @FXML
    private Button btnlogout;
    @FXML
    private Button btnevent;
    @FXML
    private Button btn3;
    @FXML
    private Button btnproduit;
    @FXML
    private Button btn1;
    @FXML
    private Button btn5;
    @FXML
    private Button btn6;
    @FXML
    private TextField textId;
    @FXML
    private TextField text1;
    @FXML
    private TextField text2;
    @FXML
    private TextField text3;
    @FXML
    private Button btn51;
    
    
 
    @FXML
     void logout(MouseEvent event) throws IOException {
       btnlogout.getScene().getWindow().hide();
       int confirmation = JOptionPane.showConfirmDialog(null, "Voulez-vous vraiment quitter la page ?", "Confirmation de sortie", JOptionPane.YES_NO_OPTION);
       if (confirmation == JOptionPane.YES_OPTION) {
   

                   Parent root = FXMLLoader.load(getClass().getResource("interfacelogin.fxml"));
                   
                   Stage mainStage = new Stage();
                   Scene scene = new Scene(root);
                   mainStage.setScene(scene);
                   mainStage.show();  
    }else {
            Parent root = FXMLLoader.load(getClass().getResource("dashbord_admin.fxml"));
                   
                   Stage mainStage = new Stage();
                   Scene scene = new Scene(root);
                   mainStage.setScene(scene);
                   mainStage.show();
        
    }
    }
    @FXML
     void Guser(MouseEvent event) throws IOException {
        
        btnuser.getScene().getWindow().hide();
                   Parent root = FXMLLoader.load(getClass().getResource("Gestionuser.fxml"));
                   Stage mainStage = new Stage();
                   Scene scene = new Scene(root);
                   mainStage.setScene(scene);
                   mainStage.show();     
  
    }
    @FXML
    void gevent(MouseEvent event) {
           try {
                            Parent root;
                            FXMLLoader loader = new FXMLLoader(getClass().getResource("listevent_1.fxml"));
                            root = loader.load();
                            
                            btn3.getScene().setRoot(root);
                        } catch (IOException ex) {
                            Logger.getLogger(FormationDachboardFormateuerController.class.getName()).log(Level.SEVERE, null, ex);
                        }
        

    }



    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
         try {
          cnx = (Connection) MyDB.getInstance().getCnx();
          String qry = "SELECT `Id`, `Nom`, `Prenom`, `Email` FROM `user` WHERE `Email` = '"+email+"'  ";

       pst = cnx.prepareStatement(qry);
             rs = pst.executeQuery();
        if (rs.next()) {
             
            String nom = rs.getString("Nom");
            text1.setText(nom);
            String prenom = rs.getString("Prenom");
            text2.setText(prenom);
            String email = rs.getString("Email");
            text3.setText(email);
            int id = rs.getInt("Id");
            textId.setText(Integer.toString(id));
           
        } else {
            
        }
    } catch (SQLException e) {
    }
    }    

    @FXML
    private void FormationDachboardAdmin(MouseEvent event) {
          try {
                            Parent root;
                            FXMLLoader loader = new FXMLLoader(getClass().getResource("Finaladmin.fxml"));
                            root = loader.load();
                            
                            btn3.getScene().setRoot(root);
                        } catch (IOException ex) {
                            Logger.getLogger(FormationDachboardFormateuerController.class.getName()).log(Level.SEVERE, null, ex);
                        }
    }
        @FXML
    private void gotoproduit(MouseEvent event) {
        
                try {
                            Parent root;
                            FXMLLoader loader = new FXMLLoader(getClass().getResource("FXMLproduit.fxml"));
                            root = loader.load();
                            
                            btn3.getScene().setRoot(root);
                        } catch (IOException ex) {
                            Logger.getLogger(FormationDachboardFormateuerController.class.getName()).log(Level.SEVERE, null, ex);
                        }
    }

    @FXML
    private void GoToerc(MouseEvent event) {
        
        
            try {
                            Parent root;
                            FXMLLoader loader = new FXMLLoader(getClass().getResource("Reclamation.fxml"));
                            root = loader.load();
                            
                            btn3.getScene().setRoot(root);
                        } catch (IOException ex) {
                            Logger.getLogger(FormationDachboardFormateuerController.class.getName()).log(Level.SEVERE, null, ex);
                        }
    }

    @FXML
    private void GoTorep(MouseEvent event) {
          try {
                            Parent root;
                            FXMLLoader loader = new FXMLLoader(getClass().getResource("Reponse.fxml"));
                            root = loader.load();
                            
                            btn3.getScene().setRoot(root);
                        } catch (IOException ex) {
                            Logger.getLogger(FormationDachboardFormateuerController.class.getName()).log(Level.SEVERE, null, ex);
                        }
    }
    
}
