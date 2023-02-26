/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package workshop3a24.GUI;

import java.net.URL;
import java.sql.Date;
import java.time.LocalDate;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javax.swing.text.StyledEditorKit;
import workshop3a24.Entities.Formation;
import workshop3a24.Entities.Participationformation;
import workshop3a24.Services.ServiceParticipationformation;

/**
 * FXML Controller class
 *
 * @author dell
 */
public class ParticpationformationformateuerController implements Initializable {
    ServiceParticipationformation sp=new ServiceParticipationformation();


    @FXML
    private TableView<Participationformation> table;
    private TableColumn<Participationformation, Integer> id;
    @FXML
    private TableColumn<Participationformation, String> TITREcol;
    @FXML
    private TableColumn<Participationformation, Integer> formation;
    private TableColumn<Participationformation, Integer> user;
    @FXML
    private TableColumn<Participationformation, Boolean> Conf;
    @FXML
    private Button btnaceppter;
    @FXML
    private Button btnrefuser;
    @FXML
    private TableColumn<Participationformation, String> nom;
    @FXML
    private TableColumn<Participationformation, String> email;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        Table0();
        // TODO
    }    


    @FXML
    private void refuser(ActionEvent event) {
         int myIndex = table.getSelectionModel().getSelectedIndex();
        int id = Integer.parseInt(String.valueOf(table.getItems().get(myIndex).getIdParticipationFormation()));
        sp.refuser(id);
          Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("User refused");

        alert.setHeaderText("modifaction Registation");
        alert.setContentText("Updateddd!");

        alert.showAndWait();
        Table0();
    }

    @FXML
    private void aceepter(ActionEvent event) {
         int myIndex = table.getSelectionModel().getSelectedIndex();
        int id = Integer.parseInt(String.valueOf(table.getItems().get(myIndex).getIdParticipationFormation()));
        sp.accept(id);
         Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("User acceted");

        alert.setHeaderText("modifaction Registation");
        alert.setContentText("Updateddd!");

        alert.showAndWait();
        Table0();
    }
   
    
     

  

  public void Table0() {
Participationformation p=new Participationformation();
        table.setItems(FXCollections.observableArrayList(sp.afficher()));
        nom.setCellValueFactory(new PropertyValueFactory<>("nom"));
        Conf.setCellValueFactory(new PropertyValueFactory<>("confirmation"));
       email.setCellValueFactory(new PropertyValueFactory<>("email"));
          formation.setCellValueFactory(new PropertyValueFactory<>("titre"));
        table.setEditable(true);
}
}