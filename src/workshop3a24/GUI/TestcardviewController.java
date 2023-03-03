/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package workshop3a24.GUI;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.FlowPane;
import workshop3a24.Entities.Formation;
import workshop3a24.Services.Formationservice;

/**
 * FXML Controller class
 *
 * @author dell
 */
public class TestcardviewController implements Initializable {

    @FXML
    private ScrollPane scrollPane;
    @FXML
    private FlowPane flowPane;
    Formationservice sf = new Formationservice();

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        List<Formation> l = sf.afficher();
        // TODO
    }

    public void setFormations(List<Formation> formations) {
        flowPane.getChildren().clear();
        for (Formation formation : formations) {
            CardView cardView = new CardView(formation);
            flowPane.getChildren().add(cardView);

        }
    }

}
