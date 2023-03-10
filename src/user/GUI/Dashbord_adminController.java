/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package user.GUI;

import java.io.IOException;
import java.net.URL;
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

/**
 * FXML Controller class
 *
 * @author FIRAS
 */
public class Dashbord_adminController implements Initializable {

    /**
     * Initializes the controller class.
     */
    
       @FXML
    private Button btnuser;



    private Button btnlogout;
    @FXML
    private Button btn1;
    @FXML
    private Button btn2;
    @FXML
    private Button btn3;
    @FXML
    private Button btn4;
    @FXML
    private Button btn5;
    @FXML
    private Button btn6;
    @FXML
    private Button btn7;
    @FXML
    private TextField textId;
    @FXML
    private TextField text1;
    @FXML
    private TextField text2;
    @FXML
    private TextField text3;
    
    
 
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
     void Guser(MouseEvent event) throws IOException {
        
        btnuser.getScene().getWindow().hide();
                   Parent root = FXMLLoader.load(getClass().getResource("Gestionuser.fxml"));
                   Stage mainStage = new Stage();
                   Scene scene = new Scene(root);
                   mainStage.setScene(scene);
                   mainStage.show();     
  
    }
    void gevent(MouseEvent event) {
        

    }



    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
