/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package workshop3a24.GUI;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

/**
 * FXML Controller class
 *
 * @author dell
 */
public class ParticipationformationController implements Initializable {

    @FXML
    private TableView<?> tableformation;
    @FXML
    private TableColumn<?, ?> titre;
    @FXML
    private TableColumn<?, ?> desc;
    @FXML
    private TableColumn<?, ?> owner;
    @FXML
    private TableColumn<?, ?> type;
    @FXML
    private TableColumn<?, ?> pays;
    @FXML
    private TableColumn<?, ?> debuit;
    @FXML
    private TableColumn<?, ?> fin;
    @FXML
    private TableColumn<?, ?> action;
    @FXML
    private TableColumn<?, ?> fin1;
    @FXML
    private TableColumn<?, ?> fin2;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
