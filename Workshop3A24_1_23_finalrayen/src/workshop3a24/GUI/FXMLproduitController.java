/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package workshop3a24.GUI;

import com.twilio.twiml.voice.Sms;
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
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import workshop3a24.Entities.produit;
import workshop3a24.Services.CRUDproduit;
import workshop3a24.Services.ProduitService;



/**
 * FXML Controller class
 *
 * @author azizt
 */
public class FXMLproduitController implements Initializable {

    @FXML
    private TextField tflabel;
    @FXML
    private TextField tfstock;
    @FXML
    private TextField tfprix;
    @FXML
    private TextField tfcategorie;
    @FXML
    private TableView<produit> tvProduit;
    @FXML
    private TableColumn<produit, Integer> colId;
    @FXML
    private TableColumn<produit, String> colLabel;
    @FXML
    private TableColumn<produit, Integer> colStock;
    @FXML
    private TableColumn<produit, Float> colPrix;
    @FXML
    private TableColumn<produit, Integer> colId_cat;
    @FXML
    private Button btnajouter;
    @FXML
    private Button btnmodifier;
    @FXML
    private Button btnsupprimer;
    @FXML
    private Button btnCategorie;
    @FXML
    private TextField tfvendeur;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        afficherProduits();
        // TODO
    }    

   @FXML
private void handleButtonAction(ActionEvent event) throws IOException {
    if(event.getSource() == btnajouter) {
      ajouterProduit();
    }
    if(event.getSource() == btnmodifier){
        modifierProduit();
    }
      if(event.getSource() == btnsupprimer){
        supprimerProduit();
    }
      if (event.getSource() == btnCategorie) {
    // charger la scène catégorie
    FXMLLoader loader = new FXMLLoader(getClass().getResource("FXMLcategorie.fxml"));
    Parent root = loader.load();
    Scene scene = new Scene(root);
    Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
    stage.setScene(scene);
    stage.show();
}

}
private void modifierProduit() {
    // Récupérer le produit sélectionné
    produit p = tvProduit.getSelectionModel().getSelectedItem();
    if(p != null) {
        // Récupérer les nouvelles informations du produit
        String label = tflabel.getText().trim();
        int stock = 0;
        if (!tfstock.getText().trim().isEmpty()) {
            stock = Integer.parseInt(tfstock.getText().trim());
        }
        float prix = 0.0f;
        if (!tfprix.getText().trim().isEmpty()) {
            prix = Float.parseFloat(tfprix.getText().trim());
        }
        int categorie = 0;
        if (!tfcategorie.getText().trim().isEmpty()) {
            categorie = Integer.parseInt(tfcategorie.getText().trim());
        }
        
        // Modifier le produit avec les nouvelles informations
        if (!label.isEmpty()) {
            p.setLib(label);
        }
        if (stock > 0) {
            p.setStock(stock);
        }
        if (prix > 0.0f) {
            p.setPrix(prix);
        }
        if (categorie > 0) {
            p.setId_cat(categorie);
        }
        
        // Modifier le produit dans la base de données
        ProduitService ps = new CRUDproduit();
        ps.modifierproduit(p);
        
        // Actualiser la table des produits
        afficherProduits();
        
        // Effacer les champs de saisie
        tflabel.setText("");
        tfstock.setText("");
        tfprix.setText("");
        tfcategorie.setText("");
    }
}
private void supprimerProduit() {
    // Récupérer le produit sélectionné
    produit p = tvProduit.getSelectionModel().getSelectedItem();
    if(p != null) {
        // Supprimer le produit de la base de données
        ProduitService ps = new CRUDproduit();
        ps.supprimerproduit(p.getId());
        
        // Actualiser la table des produits
        afficherProduits();
    }
}




    private void initialize() {
        afficherProduits();
    }
   
private void afficherProduits() {
    ProduitService ps = new CRUDproduit();
    List<produit> listProduit = ps.afficherproduits();

    colId.setCellValueFactory(new PropertyValueFactory<>("id"));
    colLabel.setCellValueFactory(new PropertyValueFactory<>("lib"));
    colStock.setCellValueFactory(new PropertyValueFactory<>("stock"));
    colPrix.setCellValueFactory(new PropertyValueFactory<>("prix"));
    colId_cat.setCellValueFactory(new PropertyValueFactory<>("id_cat"));

    ObservableList<produit> observableList = FXCollections.observableList(listProduit);
    tvProduit.setItems(observableList);
}

private void ajouterProduit()
{
    
   

String label = tflabel.getText().trim();
String stockStr = tfstock.getText().trim();
String prixStr = tfprix.getText().trim();
String categorieStr = tfcategorie.getText().trim();
String vendeurStr = tfvendeur.getText().trim();

// Vérifier que tous les champs sont remplis
if (label.isEmpty() || stockStr.isEmpty() || prixStr.isEmpty() || categorieStr.isEmpty()) {
    Alert alert = new Alert(AlertType.ERROR);
    alert.setTitle("Erreur");
    alert.setHeaderText("Veuillez remplir tous les champs");
    alert.showAndWait();
    return;
}

// Vérifier que le stock est un nombre entier
int stock;
try {
    stock = Integer.parseInt(stockStr);
} catch (NumberFormatException e) {
    Alert alert = new Alert(AlertType.ERROR);
    alert.setTitle("Erreur");
    alert.setHeaderText("Le stock doit être un nombre entier");
    alert.showAndWait();
    return;
}

// Vérifier que le prix est un nombre décimal
float prix;
try {
    prix = Float.parseFloat(prixStr);
} catch (NumberFormatException e) {
    Alert alert = new Alert(AlertType.ERROR);
    alert.setTitle("Erreur");
    alert.setHeaderText("Le prix doit être un nombre décimal");
    alert.showAndWait();
    return;
}

// Vérifier que la catégorie est un nombre entier
int categorie;
try {
    categorie = Integer.parseInt(categorieStr);
} catch (NumberFormatException e) {
    Alert alert = new Alert(AlertType.ERROR);
    alert.setTitle("Erreur");
    alert.setHeaderText("La catégorie doit être un nombre entier");
    alert.showAndWait();
    return;
}
// Vérifier que la vendeur est un nombre entier
int vendeur;
try {
    vendeur = Integer.parseInt(vendeurStr);
} catch (NumberFormatException e) {
    Alert alert = new Alert(AlertType.ERROR);
    alert.setTitle("Erreur");
    alert.setHeaderText("L'id du vendeur  doit être un nombre entier");
    alert.showAndWait();
    return;
}
    try {
        // Créer un nouveau produit avec ces informations
produit p = new produit(label, stock, prix,categorie,vendeur);
// Ajouter le produit à la base de données
ProduitService ps = new CRUDproduit();
    ps.ajouterproduit(p);
       
        
    } catch (Exception e) {
        System.out.println("le produit n'est pas été ajouté ");
    }




// Actualiser la table des produits
afficherProduits();

//envoyer un sms 

//Sms msg=new Sms();




// Effacer les champs de saisie
tflabel.setText("");
tfstock.setText("");
tfprix.setText("");
tfcategorie.setText("");
tfvendeur.setText("");
}

    
}

