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
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author dell
 */
public class NewformationaddController implements Initializable {

    @FXML
    private TextField title;
    @FXML
    private TextField desc;
    @FXML
    private ChoiceBox<?> pays;
    @FXML
    private ChoiceBox<?> type;
    @FXML
    private DatePicker debut;
    @FXML
    private DatePicker fin;
    @FXML
    private Button add;
    @FXML
    private Button del;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
