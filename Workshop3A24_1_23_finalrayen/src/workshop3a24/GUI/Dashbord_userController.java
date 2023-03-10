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
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import static javafx.scene.input.KeyCode.I;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javax.swing.JOptionPane;
import workshop3a24.Utils.MyDB;

public class Dashbord_userController implements Initializable {

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
   
        private Label labelnom;
    
     Connection cnx = null;
     PreparedStatement pst = null;
     ResultSet rs = null;
     
    @FXML
    private Button btn4;
    @FXML
    private TextField textId;
    @FXML
    private Button btn5;
   
   
    private ImageView btnlogout;

    
    InterfaceloginController i = new InterfaceloginController();
    String email = InterfaceloginController.currentUserEmail;
    @FXML
    private Button btn7;
    @FXML
    private Button btn6;
    
  
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            cnx = (Connection) MyDB.getInstance().getCnx();
            String qry1 = "SELECT  `Nom`,  FROM `user` WHERE `Email` = '"+email+"'";

                pst = cnx.prepareStatement(qry1);
                rs = pst.executeQuery();
                if (rs.next()){
                    String nom = rs.getString("Nom");
                labelnom.setText(nom);
                }
        } catch (SQLException e) {
        }
        }
        
    void afficherUtilisateurs(MouseEvent event) {
      
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
//    void afficherSuivent(MouseEvent event) {
//        int id =Integer.valueOf(textId.getText());
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
//}
////    void afficherPrecedent(MouseEvent event) {
////        int id =Integer.valueOf(textId.getText());
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
//}
    

 void deconnect(MouseEvent event) throws IOException {
    btnlogout.getScene().getWindow().hide();
       int confirmation = JOptionPane.showConfirmDialog(null, "Voulez-vous vraiment quitter la page ?", "Confirmation de sortie", JOptionPane.YES_NO_OPTION);
       if (confirmation == JOptionPane.YES_OPTION) {
   

                   Parent root = FXMLLoader.load(getClass().getResource("interfacelogin.fxml"));
                   
                   Stage mainStage = new Stage();
                   Scene scene = new Scene(root);
                   mainStage.setScene(scene);
                   mainStage.show();  
    }else {
            Parent root = FXMLLoader.load(getClass().getResource("Dashbord_user.fxml"));
                   
                   Stage mainStage = new Stage();
                   Scene scene = new Scene(root);
                   mainStage.setScene(scene);
                   mainStage.show();
        
    }
    }

    private void settings(MouseEvent event) throws IOException {
         btn2.getScene().getWindow().hide();
                            Parent root = FXMLLoader.load(getClass().getResource("settings.fxml"));
                            Stage mainStage = new Stage();
                            Scene scene = new Scene(root);
                            mainStage.setScene(scene);
                            mainStage.show();
        cnx = (Connection) MyDB.getInstance().getCnx();
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

    @FXML
    private void gotoformationtoclient(MouseEvent event) {
         try {
                            Parent root;
                            FXMLLoader loader = new FXMLLoader(getClass().getResource("Testcardview.fxml"));
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
                            FXMLLoader loader = new FXMLLoader(getClass().getResource("Store.fxml"));
                            root = loader.load();
                            
                            btn3.getScene().setRoot(root);
                        } catch (IOException ex) {
                            Logger.getLogger(FormationDachboardFormateuerController.class.getName()).log(Level.SEVERE, null, ex);
                        }
    }

    @FXML
    private void gotoeventvenderur(MouseEvent event) {
           try {
                            Parent root;
                            FXMLLoader loader = new FXMLLoader(getClass().getResource("listevent.fxml"));
                            root = loader.load();
                            
                            btn3.getScene().setRoot(root);
                        } catch (IOException ex) {
                            Logger.getLogger(FormationDachboardFormateuerController.class.getName()).log(Level.SEVERE, null, ex);
                        }
    }

    private void gotoeventvendeur(MouseEvent event) {
          try {
                            Parent root;
                            FXMLLoader loader = new FXMLLoader(getClass().getResource("listevent.fxml"));
                            root = loader.load();
                            
                            btn3.getScene().setRoot(root);
                        } catch (IOException ex) {
                            Logger.getLogger(FormationDachboardFormateuerController.class.getName()).log(Level.SEVERE, null, ex);
                        }
    }

    private void goToFormateurDashbord(MouseEvent event) {
         try {
                            Parent root;
                            FXMLLoader loader = new FXMLLoader(getClass().getResource("Testcardview.fxml"));
                            root = loader.load();
                            
                            btn3.getScene().setRoot(root);
                        } catch (IOException ex) {
                            Logger.getLogger(FormationDachboardFormateuerController.class.getName()).log(Level.SEVERE, null, ex);
                        }
    }

    @FXML
    private void GoToRec(MouseEvent event) {
        try {
                            Parent root;
                            FXMLLoader loader = new FXMLLoader(getClass().getResource("Reclamationuser.fxml"));
                            root = loader.load();
                            
                            btn3.getScene().setRoot(root);
                        } catch (IOException ex) {
                            Logger.getLogger(FormationDachboardFormateuerController.class.getName()).log(Level.SEVERE, null, ex);
                        }
    }

    @FXML
    private void logout(MouseEvent event) throws IOException {
          btn7.getScene().getWindow().hide();
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
    
    }
