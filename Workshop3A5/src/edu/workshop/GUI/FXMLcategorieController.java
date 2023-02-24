package edu.workshop.GUI;

import edu.workshop.entites.categorie;
import edu.workshop.services.CRUDcategorie;
import edu.workshop.services.CategorieService;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

public class FXMLcategorieController implements Initializable {

    @FXML
    private TableView<categorie> tvCategorie;
    @FXML
    private TableColumn<categorie, Integer> colId_cat;
    @FXML
    private TableColumn<categorie, String> colCategorie;
    @FXML
    private Button btnAjouter;
    @FXML
    private Button btnModifier;
    @FXML
    private Button btnSupprimer;
    @FXML
    private TextField tfCategorie;
    @FXML
    private Button produitBtn;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        afficherCategories();
    }

    @FXML
    private void handleButtonAction(ActionEvent event) throws IOException {
        if (event.getSource() == btnAjouter) {
            ajouterCategorie();
        }
        if (event.getSource() == btnModifier) {
            modifierCategorie();
        }
        if (event.getSource() == btnSupprimer) {
            supprimerCategorie();
        }
           if (event.getSource() == btnAjouter) {
            ajouterCategorie();
        }
           if (event.getSource() == produitBtn) {
    // charger la scène produit
    FXMLLoader loader = new FXMLLoader(getClass().getResource("FXMLproduit.fxml"));
    Parent root = loader.load();
    Scene scene = new Scene(root);
    Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
    stage.setScene(scene);
    stage.show();
}
    }

private void modifierCategorie() {
    categorie c = tvCategorie.getSelectionModel().getSelectedItem();
    if (c != null) {
        String nom = tfCategorie.getText().trim();
        if (!nom.isEmpty()) {
            c.setCategorie(nom);
            CategorieService cs = new CRUDcategorie();
            cs.modifiercategorie(c);
            afficherCategories();
            tfCategorie.setText("");
        }
    }
}


    private void supprimerCategorie() {
        categorie c = tvCategorie.getSelectionModel().getSelectedItem();
        if (c != null) {
            CategorieService cs = new CRUDcategorie();
            cs.supprimercategorie(c.getId_cat());
            afficherCategories();
        }
    }


        
public void afficherCategories() {
    CRUDcategorie ca=new CRUDcategorie();
    List<categorie> categories = ca.affichercategories();
      colId_cat.setCellValueFactory(new PropertyValueFactory<>("id_cat"));
       colCategorie.setCellValueFactory(new PropertyValueFactory<>("categorie"));
       ObservableList<categorie> categorieObservableList = FXCollections.observableArrayList(categories);
    tvCategorie.setItems(categorieObservableList);
}
private void ajouterCategorie() {
    String nom = tfCategorie.getText().trim();
    boolean valid = true;

    // Vérifier si l'utilisateur a entré une catégorie valide
    if (nom.isEmpty()) {
        valid = false;
        System.out.println("La catégorie ne peut pas être vide");
    }

    // Ajouter la catégorie si toutes les saisies sont valides
    if (valid) {
        categorie c = new categorie(nom);
        CategorieService cs = new CRUDcategorie();
        cs.ajoutercategorie(c);
        afficherCategories();
        tfCategorie.setText("");
    }
}


       
   
    
}
