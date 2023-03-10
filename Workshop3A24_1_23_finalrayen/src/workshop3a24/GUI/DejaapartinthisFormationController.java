/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package workshop3a24.GUI;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.FlowPane;
import workshop3a24.Entities.Formation;
import workshop3a24.Entities.Personne;
import workshop3a24.Services.Formationservice;
import workshop3a24.Services.Personneservice;

/**
 * FXML Controller class
 *
 * @author dell
 */
public class DejaapartinthisFormationController implements Initializable {

   List<Formation> l;
    @FXML
    private ScrollPane scrollPane;
    @FXML
    private FlowPane flowPane;
    Formationservice sf = new Formationservice();
    @FXML
    private TextField search;
    @FXML
    private DatePicker filterbyDate;
    @FXML
    private Button btnroter;
    InterfaceloginController i = new InterfaceloginController();
    String emiii = InterfaceloginController.currentUserEmail;
    @FXML
    private Button dejapart;
    @FXML
    private Button allFormation;
  int x ;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
              Personneservice pssss = new Personneservice();
         x = pssss.GETIDuser(emiii);

        Personne p = pssss.GetUserById(x);

        l = sf.afficherAcceptByiduser(x);
        setFormations(l);
        // TODO
        filterbyDate.setOnAction(e -> {
            LocalDate localDate = filterbyDate.getValue();
            java.sql.Date datetocmpareith = java.sql.Date.valueOf(localDate);

            ObservableList<Formation> filteredPeople = FXCollections.observableArrayList(sf.afficherAcceptByiduser(x));


            ObservableList<Formation> newdata = filteredPeople.stream()
                    .filter(n -> n.getDebut().compareTo(datetocmpareith) == 0 || n.getFin().compareTo(datetocmpareith) == 0
                    )
                    .collect(Collectors.toCollection(FXCollections::observableArrayList));

            l = newdata;
            filterbyDate.setValue(null);
            setFormations(newdata);

      
        });
        
        
           allFormation.setOnAction((event) -> {
                       
                     

                        try {
                            Parent root;
                            FXMLLoader loader = new FXMLLoader(getClass().getResource("Testcardview.fxml"));
                            root = loader.load();
                         
                            allFormation.getScene().setRoot(root);
                        } catch (IOException ex) {
                            Logger.getLogger(FormationDachboardFormateuerController.class.getName()).log(Level.SEVERE, null, ex);
                        }

                    });
        
        
       
    }

    public void setFormations(List<Formation> formations) {
        flowPane.getChildren().clear();
        for (Formation formation : formations) {
            CardView1 cardView = new CardView1(formation);
            flowPane.getChildren().add(cardView);

        }

    }

    @FXML
    private void filter(KeyEvent event) {
        ObservableList<Formation> filteredPeople = FXCollections.observableArrayList(sf.afficherAcceptByiduser(x));
        //    ObservableList<Person> filteredPeople = people.filtered(p -> p.getAge() >= 30 && p.getAge() < 40);  

        ObservableList<Formation> newdata = filteredPeople.stream()
                .filter(n -> n.getEmail().toLowerCase().contains(search.getText().toLowerCase())
                || n.getEmail().toLowerCase().equals(search.getText())
                || n.getDescription().toLowerCase().contains(search.getText())
                || n.getNom().toLowerCase().contains(search.getText().toLowerCase())
                || n.getNom().toLowerCase().equals(search.getText())
                || n.getPays().toLowerCase().contains(search.getText().toLowerCase())
                || n.getPays().toLowerCase().equals(search.getText())
                || n.getTitre().toLowerCase().contains(search.getText().toLowerCase())
                || n.getTitre().toLowerCase().equals(search.getText())
                || n.getType().toLowerCase().contains(search.getText().toLowerCase())
                || n.getType().toLowerCase().equals(search.getText()))
                .collect(Collectors.toCollection(FXCollections::observableArrayList));
        l = newdata;
        setFormations(newdata);

    }

    @FXML
    private void router(ActionEvent event) {

        Personneservice pssss = new Personneservice();
        int x = pssss.GETIDuser(emiii);

        Personne p = pssss.GetUserById(x);
        if (p.getType() == "user") {
            try {
                Parent root;
                FXMLLoader loader = new FXMLLoader(getClass().getResource("Dashbord_user.fxml"));
                root = loader.load();
                btnroter.getScene().setRoot(root);
            } catch (IOException ex) {
                Logger.getLogger(FormationDachboardFormateuerController.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            try {
                Parent root;
                FXMLLoader loader = new FXMLLoader(getClass().getResource("Dashbord_client.fxml"));
                root = loader.load();
                btnroter.getScene().setRoot(root);
            } catch (IOException ex) {
                Logger.getLogger(FormationDachboardFormateuerController.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
    }

}
