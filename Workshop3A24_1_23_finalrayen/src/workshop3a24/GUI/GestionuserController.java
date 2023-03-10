/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package workshop3a24.GUI;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
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
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import javax.swing.Icon;
import javax.swing.JOptionPane;
import static jdk.nashorn.internal.objects.NativeString.search;
import workshop3a24.Entities.Personne;
import workshop3a24.Services.Personneservice;

/**
 * FXML Controller class
 *
 * @author FIRAS
 */
public class GestionuserController implements Initializable {

   @FXML
    private TableView<Personne> tablepersonne;
   
   ObservableList<Personne> personnelist = FXCollections.observableArrayList();


    private Button retour;


    //@FXML
   // private TableColumn<Personne, Integer> id;

    @FXML
    private TableColumn<Personne, String> nom;

    @FXML
    private TableColumn<Personne, String> prenom;

    @FXML
    private TableColumn<Personne, String> email;

    @FXML
    private TableColumn<Personne, String> password;

    @FXML
    private TableColumn<Personne, String> type;

    @FXML
    private TableColumn<Personne, Integer> isactive;

    Connection cnx;
   Personneservice  ps = new Personneservice();
    ObservableList<String> ss = FXCollections.observableArrayList();
    @FXML
    private ImageView btnretour;
    @FXML
    private TextField search;
    
    
    void affiche(MouseEvent event) {
        System.out.println(ps.afficher());
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
        
          System.out.println(ps.afficher());
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
    private void modifier1(MouseEvent event) {
         int myIndex = tablepersonne.getSelectionModel().getSelectedIndex();
       String nomm = tablepersonne.getSelectionModel().getSelectedItem().getNom();
        ps.modifierisactive1(nomm);
        JOptionPane.showMessageDialog(null, "utilisateur Bolquer ");  
        affiche(event);
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
     void retour(MouseEvent event) throws IOException {
         retour.getScene().getWindow().hide();
                   Parent root = FXMLLoader.load(getClass().getResource("Dashbord_admin.fxml"));
                   
                   Stage mainStage = new Stage();
                   Scene scene = new Scene(root);
                   mainStage.setScene(scene);
                   mainStage.show();  

    }

    @FXML
    private void filter(KeyEvent event) {
       
           ObservableList<Personne> filteredPeople = FXCollections.observableArrayList(ps.afficher());
        //    ObservableList<Person> filteredPeople = people.filtered(p -> p.getAge() >= 30 && p.getAge() < 40);  

        ObservableList< Personne> newdata = filteredPeople.stream().filter(
                n
                -> n.getNom().toLowerCase().contains(search.getText())
            || n.getNom().toLowerCase().contains(search.getText().toLowerCase())
            || n.getEmail().toLowerCase().contains(search.getText().toLowerCase())
                || n.getEmail().toLowerCase().equals(search.getText())
                || n.getPrenom().toLowerCase().contains(search.getText().toLowerCase())
               ).collect(Collectors.toCollection(FXCollections::observableArrayList));

       
        tablepersonne.setItems(newdata);

    }

    @FXML
    private void router(MouseEvent event) {
        try {
                            Parent root;
                            FXMLLoader loader = new FXMLLoader(getClass().getResource("dashbord_admin.fxml"));
                            root = loader.load();
                            
                             btnretour.getScene().setRoot(root);
                        } catch (IOException ex) {
                            Logger.getLogger(FormationDachboardFormateuerController.class.getName()).log(Level.SEVERE, null, ex);
                        }
    }


}

       
    

