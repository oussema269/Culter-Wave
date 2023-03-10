/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package workshop3a24.GUI;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.PasswordField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import workshop3a24.Entities.Personne;
import workshop3a24.GUI.InterfaceloginController;
import workshop3a24.Services.Personneservice;
import workshop3a24.Utils.MyDB;


/**
 * FXML Controller class
 *
 * @author FIRAS
 */
public class SettingsController implements Initializable {

    /**
     * Initializes the controller class.
     */
   
     @FXML
    private JFXTextField text1;

    @FXML
    private JFXTextField text2;

    @FXML
    private JFXTextField text3;

    @FXML
    private PasswordField text4;

    @FXML
    private JFXTextField text5;

    @FXML
    private JFXTextField text6;
     @FXML
    private ImageView btnretour;
    
    InterfaceloginController i = new InterfaceloginController();
    
    
     Connection cnx = null;
     PreparedStatement pst = null;
     ResultSet rs = null;
     
     String email = i.currentUserEmail;
    @FXML
    private JFXTextField textId;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        i = new InterfaceloginController();
        cnx = MyDB.getInstance().getCnx();
         String qry = "SELECT `Id`, `Nom`, `Prenom`, `Email`, `Password`,`Type`, `isActive` FROM `user` WHERE `Email` = '"+email+"'";

        try {
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
                String Password = rs.getString("Password");
                text4.setText(Password);
                String type = rs.getString("Type");
                text5.setText(type);
                int isAc = rs.getInt("isActive");
                text6.setText(Integer.toString(isAc));
            } else {
                
            }
        } catch (SQLException e) {
          // Gérer l'exception

        } 
    }
    
    
        
       @FXML
    void getdonnee(MouseEvent event) {
          String nom= text1.getText();
           String prenom=text2.getText();
            String    email =text3.getText( );
              int id= Integer.valueOf(textId.getText()) ;
              String Password = text4.getText();
              Personne p=new Personne();
              p.setId(id);
              p.setEmail(email);
              p.setNom(nom);
              p.setPrenom(prenom);
              p.setPassword(Password);
              Personneservice ps=new Personneservice(); 
              System.out.println(p);
            ps.modifierByuser(p);
        
        
        
     
    }
    
  @FXML
    void retour(MouseEvent event) throws IOException {
          btnretour.getScene().getWindow().hide();
                   Parent root = FXMLLoader.load(getClass().getResource("Dashbord_user.fxml"));
                   
                   Stage mainStage = new Stage();
                   Scene scene = new Scene(root);
                   mainStage.setScene(scene);
                   mainStage.show();  


    }
    }    
    

