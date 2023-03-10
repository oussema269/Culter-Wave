/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package user.GUI;

import java.awt.event.ActionEvent;
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
import javafx.scene.control.ComboBox;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javax.swing.JOptionPane;
import user.Entities.personne;
import user.services.personneservice;

/**
 * FXML Controller class
 *
 * @author FIRAS
 */

public class InterfacesignupController implements Initializable {
    @FXML
    private TextField textnom;

    @FXML
    private TextField textprenom;

    @FXML
    private TextField textemail;

    @FXML
    private TextField textepassword;
    @FXML
    private ComboBox <String> combobox;
    @FXML
    private Hyperlink hyperlinkback;
    /**
     * Initializes the controller class.
     * 
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    combobox.getItems().addAll("user", "vendeur", "formateur");
    } 
    
      @FXML
  public void ajouter(MouseEvent event) {
      if (textnom.getText().isEmpty() || textprenom.getText().isEmpty()||!textemail.getText().contains("@")||!textemail.getText().contains(".")||textepassword.getText().isEmpty()|| textepassword.getText().length() < 8) {
            JOptionPane.showMessageDialog(null, "verfier vous donnéez");
            return;
      }
          String ss = combobox.getValue();
          personneservice ps = new personneservice();
          personne p = new personne(textnom.getText(),textprenom.getText(),textemail.getText(),textepassword.getText(),ss);
          ps.ajouter(p);
          JOptionPane.showMessageDialog(null, "compte céer ");

    }
  @FXML
    void back(MouseEvent event) {
        hyperlinkback.setOnAction(e ->{
            try {
                Parent root = FXMLLoader.load(getClass().getResource("interfacelogin.fxml"));
                Stage mainStage = new Stage();
                Scene scene = new Scene(root);
                mainStage.setScene(scene);
                mainStage.show();
            } catch (IOException ex) {
                Logger.getLogger(InterfaceloginController.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
    }

   
    
}
