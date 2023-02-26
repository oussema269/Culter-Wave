/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package workshop3a24.GUI;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import workshop3a24.Entities.Personne;
import workshop3a24.Services.ServicePersonne;

/**
 * FXML Controller class
 *
 * @author Mohamed
 */
public class HomePersonneFXMLController implements Initializable {

    @FXML
    private TextField tfnom;
    @FXML
    private TextField tfprenom;
    @FXML
    private TextField tfage;
    @FXML
    private Label lresultat;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void ajouter(ActionEvent event) {
        ServicePersonne sp= new ServicePersonne();
        Personne p = new Personne(Integer.parseInt(tfage.getText()), tfnom.getText(), tfprenom.getText());
        sp.add(p);
    }

    @FXML
    private void afficher(ActionEvent event) {
        
        ServicePersonne s= new ServicePersonne();
        lresultat.setText(s.afficher().toString());
       
    }
    
}
