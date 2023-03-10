/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package user.GUI;

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
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javax.swing.JOptionPane;
import user.Utils.MyDB;

/**
 * FXML Controller class
 *
 * @author FIRAS
 */
public class Dashbord_formaController implements Initializable {

    @FXML
    private Button btn51;
  

    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
   


       
    @FXML
    private Button btn1;

    @FXML
    private Button btn2;

    @FXML
    private Button btn3;

    @FXML
    private TextField text1;

    @FXML
    private TextField text2;

    @FXML
    private TextField text3;

    @FXML
    private Button btn4;

    @FXML
    private Button btn5;

    @FXML
    private TextField textId;


    InterfaceloginController i = new InterfaceloginController();
    String email = i.currentUserEmail;

    
        Connection cnx = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
    @FXML
    private Label lab_nbr;

////    void afficherPrecedent(MouseEvent event) {
////    int id =Integer.valueOf(textId.getText());
////          cnx = (Connection) MyDB.getInsatnce().getCnx();
////         String qry = "SELECT `Nom`, `Prenom`, `Email`,`Id` FROM `user` WHERE `Id` < ? ORDER BY `Id` DESC LIMIT 1 ";
////
////
////    try {
////        pst = cnx.prepareStatement(qry);
////        pst.setInt(1, id); 
////        rs = pst.executeQuery();
////        if (rs.next()) {
////        String nom = rs.getString("Nom");
////        text1.setText(nom);
////        String prenom = rs.getString("Prenom");
////        text2.setText(prenom);
////        String email = rs.getString("Email");
////        text3.setText(email);
////        int newId = rs.getInt("Id");
////        textId.setText(Integer.toString(newId));
////        
////    }
////    } catch (SQLException e) {
////    } 
//    }

//    void afficherSuivent(MouseEvent event) {
//         int id =Integer.valueOf(textId.getText());
//          cnx = (Connection) MyDB.getInsatnce().getCnx();
//         String qry = "SELECT `Nom`, `Prenom`, `Email`,`Id` FROM `user` WHERE `Id` > ? ORDER BY `Id` ASC LIMIT 1";
//
//    try {
//        pst = cnx.prepareStatement(qry);
//    pst.setInt(1, id); // utiliser la valeur de l'ID de l'utilisateur actuellement affiché
//    rs = pst.executeQuery();
//    if (rs.next()) {
//        String nom = rs.getString("Nom");
//        text1.setText(nom);
//        String prenom = rs.getString("Prenom");
//        text2.setText(prenom);
//        String email = rs.getString("Email");
//        text3.setText(email);
//        int newId = rs.getInt("Id");
//        textId.setText(Integer.toString(newId));
//        
//    } else {
//       
//    }
//    } catch (SQLException e) {
//    } 
//    }

    @FXML
    void afficherUtilisateurs(MouseEvent event) {
     try {
          cnx = (Connection) MyDB.getInsatnce().getCnx();
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
    void settings(MouseEvent event) throws IOException {
 btn2.getScene().getWindow().hide();
                            Parent root = FXMLLoader.load(getClass().getResource("settings.fxml"));
                            Stage mainStage = new Stage();
                            Scene scene = new Scene(root);
                            mainStage.setScene(scene);
                            mainStage.show();
        cnx = (Connection) MyDB.getInsatnce().getCnx();
        String qry = "SELECT  `Nom`, `Prenom`, `Email` ,`password`, `Type`,`isActive` FROM `user` WHERE `Email` = '"+email+"' ";

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
           
        } 
        } catch (SQLException e) {
    }
    }
    

     @Override
public void initialize(URL url, ResourceBundle rb) {
       
    } 
    
}
