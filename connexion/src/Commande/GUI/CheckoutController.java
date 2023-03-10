/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Commande.GUI;

import com.stripe.Stripe;
import com.stripe.exception.StripeException;
import com.stripe.model.Charge;
import com.stripe.param.ChargeCreateParams;
import entite.Commande;
import entite.Panier;
import entite.User;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import service.CommandeService;
import service.PanierService;

/**
 * FXML Controller class
 *
 * @author asus
 */
public class CheckoutController implements Initializable {

    @FXML
    private Button btnOverview;
    @FXML
    private Button btnOrders;
    @FXML
    private Button btnCustomers;
    @FXML
    private Button btnMenus;
    @FXML
    private Button btnPackages;
    @FXML
    private Button btnSignout;
    @FXML
    private Pane pnlCustomer;
    @FXML
    private Pane pnlOrders;
    @FXML
    private Pane pnlMenus;
    private TextField idC;
    @FXML
    private TextField nomC;
    private TextField nomP;
    @FXML
    private Label nomClient;
    @FXML
Pane bord = new AnchorPane();
    @FXML
    private Button Checkout;
    @FXML
    private VBox tot;
    private TextField idC1;
    @FXML
    private TextField adrsse;
    @FXML
    private TextField email;
    @FXML
    private Label total;
    @FXML
    private Button stripe;
    @FXML
    private TextField search;
    int id_client;

    public int getId_client() {
        return id_client;
    }

    public void setId_client(int id_client) {
        this.id_client = id_client;
    }
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
          PanierService s = new PanierService();
        List<User> pers = new ArrayList<User>();
        pers = s.getUser(3);//23 remplacer par client_id
        
     
       
        // Ajoute des donn??es ?? afficher dans le Pane
        for (User p : pers) {
           
            email.setText(p.getEmail());
            adrsse.setText(p.getAdresse());
            nomC.setText(p.getNom());
            total.setText(String.valueOf(s.sommeProduit(p.getId_client())));
        }

    }    

    @FXML
    private void handleClicks(ActionEvent event) {
    }

    private void Checkout(ActionEvent event) {
         FXMLLoader loader = new FXMLLoader(getClass().getResource("panier.fxml"));
        try{
            Parent root = loader.load();
            bord.getChildren().setAll(root);
           
           }
        catch(IOException ex){
            System.out.println(ex);
        }
   
}

    @FXML
    private void payer(ActionEvent event) {
     

    }



    @FXML
    private void payer1(ActionEvent event) {
       boolean check=false;
       
       while(check==false)
       {
 Commande co =new Commande(3,1,Double.parseDouble(total.getText()));        
      CommandeService c =new CommandeService();
    String email1 = email.getText(); // R??cup??rer la saisie de l'utilisateur dans le champ de texte

// V??rifier si l'email est valide en utilisant une expression r??guli??re
Pattern pattern = Pattern.compile("^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$");
Matcher matcher = pattern.matcher(email1);
if(email.getText().isEmpty()||adrsse.getText().isEmpty()||nomC.getText().isEmpty())
{
   System.out.println("erreur");
   
Alert alert = new Alert(AlertType.WARNING);
alert.setTitle("Attention");
alert.setHeaderText("champ vide!!");
alert.setContentText("veuillez remplir tout champs");

alert.showAndWait();
break;
}
else
{
if (matcher.matches()) {
c.ajouterC(co);
check=true;
} else {
    System.out.println("erreur");
Alert alert = new Alert(AlertType.WARNING);
alert.setTitle("Attention");
alert.setHeaderText("email invalid");
alert.setContentText("veuillez remplir le champ email convenablement");
alert.showAndWait();
       break;
}
    }

       }
// FXMLController m=new FXMLController(Double.parseDouble(total.getText()));
if(check==true)
{ 
    
    FXMLLoader loader = new FXMLLoader(getClass().getResource("FXML.fxml"));

        
        try{
            Parent root = loader.load();
            bord.getChildren().setAll(root);
            


        FXMLController controller = loader.getController();
        controller.setMontant(Double.parseDouble(total.getText()));


        total.getScene().setRoot(root);
        }
        catch(IOException ex){
            System.out.println(ex);                                                                     
        }


        
    }
    }
    @FXML
    private void Panier(ActionEvent event) {
    }
}
