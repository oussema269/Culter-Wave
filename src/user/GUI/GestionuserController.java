/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package user.GUI;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import javax.swing.Icon;
import javax.swing.JOptionPane;
import user.Entities.personne;
import user.services.personneservice;

/**
 * FXML Controller class
 *
 * @author FIRAS
 */
public class GestionuserController implements Initializable {

    /**
     * Initializes the controller class.
     */
   @FXML
    private HBox hbox1;
   @FXML
    private TableView<personne> tablepersonne;
   
   ObservableList<personne> personnelist = FXCollections.observableArrayList();

    @FXML
    private Button btnaffiche;

    @FXML
    private Button btnmodifier;

    @FXML
    private Button btndelete;
      @FXML
    private Button retour;


    //@FXML
   // private TableColumn<personne, Integer> id;

    @FXML
    private TableColumn<personne, String> nom;

    @FXML
    private TableColumn<personne, String> prenom;

    @FXML
    private TableColumn<personne, String> email;

    @FXML
    private TableColumn<personne, String> password;

    @FXML
    private TableColumn<personne, String> type;

    @FXML
    private TableColumn<personne, Integer> isactive;

    Connection cnx;
    personneservice ps = new personneservice();
    ObservableList<String> ss = FXCollections.observableArrayList();
    @FXML
    private Button btnmodifier1;
    
    
    @FXML
    void affiche(MouseEvent event) {
      tablepersonne.setItems(FXCollections.observableArrayList(ps.afficher()));
       //id.setCellValueFactory(new PropertyValueFactory<>("id"));
        nom.setCellValueFactory(new PropertyValueFactory<>("Nom"));
        prenom.setCellValueFactory(new PropertyValueFactory<>("Prenom"));
        email.setCellValueFactory(new PropertyValueFactory<>("Email"));
        password.setCellValueFactory(new PropertyValueFactory<>("password"));
        type.setCellValueFactory(new PropertyValueFactory<>("Type"));
        isactive.setCellValueFactory(new PropertyValueFactory<>("isActive"));
 

        tablepersonne.setEditable(true);
         

    }
    @FXML
    void modifier(MouseEvent event) {
        int myIndex = tablepersonne.getSelectionModel().getSelectedIndex();
        String nom = tablepersonne.getSelectionModel().getSelectedItem().getNom();
        ps.modifierisactive(nom);
          JOptionPane.showMessageDialog(null, "utilisateur debloquer ");
    }

    
    
    
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {
       
    }

    @FXML
    private void modifier1(MouseEvent event) {
         int myIndex = tablepersonne.getSelectionModel().getSelectedIndex();
       String nom = tablepersonne.getSelectionModel().getSelectedItem().getNom();
        ps.modifierisactive1(nom);
        JOptionPane.showMessageDialog(null, "utilisateur Bolquer ");  
        affiche(event);
    }

    @FXML
    private void delete(MouseEvent event) {
        int myIndex = tablepersonne.getSelectionModel().getSelectedIndex();
        String nom = tablepersonne.getSelectionModel().getSelectedItem().getNom();
        ps.supprimerid(nom);
         int confirmation = JOptionPane.showConfirmDialog(null, "Voulez-vous vraiment supprimer l'utilisateur " + nom + " ?", "Confirmation de suppression", JOptionPane.YES_NO_OPTION);
    if (confirmation == JOptionPane.YES_OPTION) {
        ps.supprimerid(nom);
        JOptionPane.showMessageDialog(null, "Utilisateur supprimé avec succès.");
        affiche(event);
        affiche(event);  
    }
    }
     @FXML
    void retour(MouseEvent event) throws IOException {
         retour.getScene().getWindow().hide();
                   Parent root = FXMLLoader.load(getClass().getResource("Dashbord_admin.fxml"));
                   
                   Stage mainStage = new Stage();
                   Scene scene = new Scene(root);
                   mainStage.setScene(scene);
                   mainStage.show();  

    }


}

       
    

