/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package workshop3a24.GUI;


import java.awt.Insets;
import java.io.File;
import java.io.IOException;
import javafx.scene.control.cell.PropertyValueFactory;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.InputMethodEvent;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import workshop3a24.Entities.Panier;
import workshop3a24.Services.PanierService;
import workshop3a24.Services.Personneservice;

/**
 * FXML Controller class
 *
 * @author asus
 */
public class PanierController implements Initializable {

    public ObservableList<Object> data = FXCollections.observableArrayList();
    @FXML
    private VBox vboxPanier;
    @FXML
    private Pane pnlCustomer;
    @FXML
    private Pane pnlOrders;
    @FXML
    private Pane pnlMenus;
    @FXML
    private Label total;
    @FXML
    private VBox pnItems;
    @FXML
    private TextField chercherP;
    @FXML
    private Button Checkout;
    @FXML
    private Pane bord;
    @FXML
    private VBox totale;
    @FXML
    private Pane panierPane;
    @FXML
    private Label idc;
  

InterfaceloginController i = new InterfaceloginController();
    String emiii = InterfaceloginController.currentUserEmail;
    @FXML
    private Button Checkout1;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
          Personneservice pssss= new Personneservice();
            int id_client=pssss.GETIDuser(emiii);
        // TODO
        PanierService s = new PanierService();
        List<Panier> pers = new ArrayList<Panier>();
        pers = s.getPanier(id_client);//23 remplacer par client_id
         System.out.println(id_client);
            

     
       
        // Ajoute des données à afficher dans le Pane
        for (Panier p : pers) {
    idc.setText(String.valueOf(p.getId_client()));
         Pane pane = new Pane();
        pane.setPrefSize(500, 75);
        pane.setStyle("-fx-background-color: #e6e6e6;");   
    
 
    Label productDimensionLabel = new Label("Nom: " + p.getNomp());
    productDimensionLabel.setLayoutX(120);
    productDimensionLabel.setLayoutY(10);
    productDimensionLabel.setFont(Font.font("Verdana", FontWeight.NORMAL, 12));
 
    Label productPrixLabel = new Label("Prix: " + p.getPrix());
    productPrixLabel.setLayoutX(240);
    productPrixLabel.setLayoutY(10);
    productPrixLabel.setFont(Font.font("Verdana", FontWeight.NORMAL, 12));
 
    Label productQuantiteLabel = new Label("Quantité: " + p.getQuantite());// remplace 1 par client.id
    productQuantiteLabel.setLayoutX(360);
    productQuantiteLabel.setLayoutY(10);
    productQuantiteLabel.setFont(Font.font("Verdana", FontWeight.NORMAL, 12));
    

     Button supprimer = new Button("Supprimer");// remplace 1 par client.id
    supprimer.setLayoutX(480);
    supprimer.setLayoutY(10);
    supprimer.setFont(Font.font("Verdana", FontWeight.NORMAL, 12));
   
        supprimer.setOnMouseClicked(event1 -> {
Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
alert.setTitle("Confirmation de suppression");
alert.setHeaderText("Voulez-vous vraiment supprimer ce produit du panier ?");
alert.setContentText("Cliquez sur OK pour confirmer.");

Optional<ButtonType> result = alert.showAndWait();
if (result.isPresent() && result.get() == ButtonType.OK) {
    Pane parent = (Pane) pane.getParent();
    s.supprimerP(p.getId_client(),p.getId_product());
    parent.getChildren().remove(pane);
       double resultat = s.sommeProduit(p.getId_client());
total.setText(String.valueOf(resultat));
}    
    
    
});
 
    

    
    Button incrementButton = new Button("+");
incrementButton.setLayoutX(400);
incrementButton.setLayoutY(40);

incrementButton.setOnAction(event -> {
    int oldQuantite = p.getQuantite()+1;
    p.setQuantite(oldQuantite);
productQuantiteLabel.setText("Quantité: " + oldQuantite);
    
     s.incrementQuantite(p.getId_client(),p.getId_product());
   double resultat = s.sommeProduit(p.getId_client());
total.setText(String.valueOf(resultat));
});

Button decrementButton = new Button("-");
decrementButton.setLayoutX(350);
decrementButton.setLayoutY(40);
decrementButton.setOnAction(event -> {
    int oldQuantity = p.getQuantite();
    if (oldQuantity > 1) {
        
 int quantite = p.getQuantite()-1;
    p.setQuantite(quantite);
productQuantiteLabel.setText("Quantité: " + quantite);
  
     s.decrementQuantite(p.getId_client(),p.getId_product());       
     int newQuantity = p.getQuantite();
        if (newQuantity < oldQuantity) {
            System.out.println("aaa");
            productQuantiteLabel.setText("Quantité: " + newQuantity);
        }
         double resultat = s.sommeProduit(p.getId_client());
total.setText(String.valueOf(resultat));
    }
});
    
    
    
 
    
        pane.getChildren().addAll( productDimensionLabel, productPrixLabel, productQuantiteLabel,incrementButton,decrementButton,supprimer);
        vboxPanier.getChildren().add(pane);
        }
          vboxPanier.setSpacing(100);

        
     
    }
  
    

    @FXML
    private void afficherPanier(MouseEvent event) {
    }


    private void ajouterP(ActionEvent event) {
          MouseEvent event1 = new MouseEvent(MouseEvent.MOUSE_CLICKED, 0, 0, 0, 0, MouseButton.PRIMARY, 1,
            false, false, false, false, true, false, false, true, false, false, null);
        Panier p1 =new Panier(35,33,4);
        Panier p2 =new Panier(24,34,3);
        PanierService ps=new PanierService();
        ps.ajouter(p2);
        afficherPanier(event1);
        
        
    }

    @FXML
    private void chercherP(InputMethodEvent event) {
         Panier p1 =new Panier(35,33,4);
        Panier p2 =new Panier(24,34,3);
        PanierService ps=new PanierService();
        //ps.chercher(chercherP.getText());
        
    }

    @FXML
    private void checkout(ActionEvent event) {
       
         
      FXMLLoader loader = new FXMLLoader(getClass().getResource("Checkout.fxml"));

        
        try{
            Parent root = loader.load();
            bord.getChildren().setAll(root);
            CheckoutController controller = loader.getController();
            System.out.println("ouuaatt");

        }
        catch(IOException ex){
            System.out.println(ex.getMessage());                                                                     
        }

    }

    @FXML
    private void panierRetour(ActionEvent event) {
        try {
                            Parent root;
                            FXMLLoader loader = new FXMLLoader(getClass().getResource("Store.fxml"));
                            root = loader.load();
                            
                             Checkout.getScene().setRoot(root);
                        } catch (IOException ex) {
                            Logger.getLogger(FormationDachboardFormateuerController.class.getName()).log(Level.SEVERE, null, ex);
                        }
    }

   

}
