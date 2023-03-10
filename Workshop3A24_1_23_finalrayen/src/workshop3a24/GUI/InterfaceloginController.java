/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package workshop3a24.GUI;

import static com.sun.corba.se.spi.presentation.rmi.StubAdapter.request;
import java.awt.Button;
import java.awt.HeadlessException;
import java.awt.Image;
import java.awt.Label;
import java.awt.TextField;
import java.awt.event.ActionEvent;
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
import javafx.scene.control.Hyperlink;
import javafx.scene.control.PasswordField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javax.swing.JOptionPane;
import workshop3a24.Services.Personneservice;
import workshop3a24.Utils.MyDB;


/**
 * FXML Controller class
 *
 * @author FIRAS
 */
public class InterfaceloginController implements Initializable {
    @FXML
    private AnchorPane labelG;
    @FXML
    private ImageView img;
    @FXML
    private javafx.scene.control.Label label;

    @FXML
    private javafx.scene.control.TextField textfield;

    @FXML
    private PasswordField passwordfield;

    @FXML
    private javafx.scene.control.Button btnlogin;
    
     @FXML
    private Hyperlink hyperlink2;
    
       @FXML
    private Hyperlink hyperlink;
    

       
    
    Connection cnx = null;
    ResultSet rs = null;
    PreparedStatement pst = null ;
    
    Personneservice ps = new Personneservice();
     public static String currentUserEmail;
    @FXML
    private javafx.scene.control.Label label6;
    
    @Override
       public void initialize(URL url, ResourceBundle rb) {
     
       }

       

    @FXML
    private void login(MouseEvent event) throws IOException {
        cnx = (Connection) MyDB.getInstance().getCnx();
        String email = textfield.getText();
        String pswd = passwordfield.getText();
        String type = ps.check(email, pswd);
            
        try{
             

            if (textfield.getText().isEmpty() || passwordfield.getText().isEmpty()||!textfield.getText().contains("@")||!textfield.getText().contains(".")) {
            JOptionPane.showMessageDialog(null, "Veuillez verfier vous donneez");
            return;
            }
            //String userType = rs.getString("Type");
            String qry = "SELECT * FROM `user` WHERE `Email` = ? AND `password` = ? AND `Type` = ? AND `isActive` = ?";
            pst = cnx.prepareStatement(qry);
            pst.setString(1, textfield.getText());
            pst.setString(2, passwordfield.getText());
            pst.setString(3, ps.check(textfield.getText(), passwordfield.getText()));
            pst.setInt(4, 1);
            rs = pst.executeQuery();
            if(rs.next()) {
             String user_Type = rs.getString("Type");
              currentUserEmail = textfield.getText();
            int isActive = rs.getInt("isActive");
       
                switch (user_Type) {
                    case "user":
                        {
                            btnlogin.getScene().getWindow().hide();
                            Parent root = FXMLLoader.load(getClass().getResource("Dashbord_user.fxml"));
                            Stage mainStage = new Stage();
                            Scene scene = new Scene(root);
                            mainStage.setScene(scene);
                            mainStage.show();
                            break;
                        }
                    case "admin":
                        {
                            btnlogin.getScene().getWindow().hide();
                            Parent root = FXMLLoader.load(getClass().getResource("dashbord_admin.fxml"));
                            Stage mainStage = new Stage();
                            Scene scene = new Scene(root);
                            mainStage.setScene(scene);
                            mainStage.show();
                            break;
                        }
                    case "vendeur":
                        {
                            btnlogin.getScene().getWindow().hide();
                            Parent root = FXMLLoader.load(getClass().getResource("Dashbord_client.fxml"));
                            Stage mainStage = new Stage();
                            Scene scene = new Scene(root);
                            mainStage.setScene(scene);
                            mainStage.show();
                            break;
                        }
                    case "formateur":
                        {
                            btnlogin.getScene().getWindow().hide();
                            Parent root = FXMLLoader.load(getClass().getResource("dashbord_forma.fxml"));
                            Stage mainStage = new Stage();
                            Scene scene = new Scene(root);
                            mainStage.setScene(scene);
                            mainStage.show();
                            break;
                        }
                    default:
                        JOptionPane.showMessageDialog(null, "user inconnu");
                        break;
                }
                
            }else
                JOptionPane.showMessageDialog(null, "login failed");
                        
           
        }catch(HeadlessException | SQLException e){
            JOptionPane.showMessageDialog(null, e);
        }
        
    
    }
  @FXML
    void mtpoublier(MouseEvent event) {
        hyperlink.setOnAction(e ->{
            try {
                Parent root = FXMLLoader.load(getClass().getResource("modifier password.fxml"));
                Stage mainStage = new Stage();
                Scene scene = new Scene(root);
                mainStage.setScene(scene);
                mainStage.show();
                
            } catch (IOException ex) {
                Logger.getLogger(InterfaceloginController.class.getName()).log(Level.SEVERE, null, ex);
            }
        });

    }
      @FXML
    void signup(MouseEvent event) {
        hyperlink2.setOnAction(e ->{
            try {
                Parent root = FXMLLoader.load(getClass().getResource("interfacesignup.fxml"));
                Stage mainStage = new Stage();
                Scene scene = new Scene(root);
                mainStage.setScene(scene);
                mainStage.show();
            } catch (IOException ex) {
                Logger.getLogger(InterfaceloginController.class.getName()).log(Level.SEVERE, null, ex);
            }
        });

    }
      public static String getCurrentUserEmail;
          

  void deconnect(MouseEvent event) {

    }
   
   
    
}
    
    

