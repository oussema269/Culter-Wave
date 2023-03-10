/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package workshop3a24.GUI;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;

import workshop3a24.Utils.MyDB;
import java.net.URL;
import java.sql.Connection;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import workshop3a24.Entities.Panier;
import workshop3a24.Entities.produit;
import workshop3a24.Services.CRUDproduit;
import workshop3a24.Services.PanierService;
import workshop3a24.Services.Personneservice;
import workshop3a24.Services.ProduitService;

/**
 * FXML Controller class
 *
 * @author azizt
 */
public class StoreController implements Initializable {
    @FXML
    private TextField searchField;
    @FXML
    private HBox ecran_id;
    @FXML
    private VBox left_box;
    @FXML
    private TextField txt_produit;
    @FXML
    private TextField text_prix;
    @FXML
    private TextField text_stock;
    @FXML
    private VBox vbox;
    @FXML
    private WebView chat_id;
    @FXML
    private Button precedant;
    @FXML
    private Button suivant;
    @FXML
    private TextField textId;
    @FXML
    private Button btncommander;
    @FXML
    private Button id_retour;
    
    int id_commander=0;
    
    Connection cnx = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        
    Statement ste;
    Connection conn = MyDB.getInstance().getCnx();
        static Panier panier;
        int l = 0;
        int id_client;
    InterfaceloginController i = new InterfaceloginController();
    String emiii = InterfaceloginController.currentUserEmail;

/*
    @FXML
    private VBox left_box;
    @FXML
    private HBox ecran_id;
    @FXML
    private WebView chat_id;
    @FXML
    private TextField searchField;
    static int id_client;
    
    static Panier panier;
int l = 0;
    InterfaceloginController i = new InterfaceloginController();
    String emiii = InterfaceloginController.currentUserEmail;

    /**
     * Initializes the controller class.
     */
    /*
    @Override
    public void initialize(URL url, ResourceBundle rb) {

        searchField.textProperty().addListener((observable, oldValue, newValue) -> {
            rechercher(newValue);
        });
        Personneservice pssss = new Personneservice();
        int id_client = pssss.GETIDuser(emiii);

        // TODO
        affichernotadmin();
    }

    /*  private void affichernotadmin()
    {
         ProduitService ps = new CRUDproduit();
        List<produit> listProduit = ps.afficherproduits();
        for (int i=0; i< listProduit.size(); i++) {
            ListView<String> items= new ListView<>();
            Image image = new Image("/edu/workshop/img/tabulé");
             ImageView img=new ImageView(image);
            ObservableList<String>item;
            item=FXCollections.observableArrayList(listProduit.get(i).getLib(),Float.toString(listProduit.get(i).getPrix()),Integer.toString(listProduit.get(i).getStock()) );
            items.setItems(item);
            ecran_id.getChildren().add(img);
            ecran_id.getChildren().add(items);
                
        }


         
    }*/
    /*
    private void affichernotadmin() {
        ProduitService ps = new CRUDproduit();
        List<produit> listProduit = ps.afficherproduits();
        for (l=0; l < listProduit.size(); l++) {
           
            System.out.println(listProduit.get(l));
            VBox vbox = new VBox(); // Créer une boîte verticale pour chaque élément de la liste
            vbox.setPrefHeight(200);
            // Charger l'image
            Image image = null;
            String imagePath = "/workshop3a24/img/" + listProduit.get(l).getLib() + ".jpg";
            try {
                image = new Image(imagePath);
            } catch (Exception e) {
                System.out.println("L'image " + imagePath + " n'existe pas.");
                // Charger une image par défaut si l'image n'existe pas
                image = new Image("/workshop3a24/img/default.PNG");
            }
            ImageView img = new ImageView(image);
            img.setFitHeight(100); // Ajuster la hauteur de l'image
            img.setPreserveRatio(true); // Conserver le ratio de l'image

            // Ajouter la liste dans la boîte verticale
            ObservableList<String> item = FXCollections.observableArrayList(
                    listProduit.get(l).getLib(),
                    Float.toString(listProduit.get(l).getPrix()),
                    Integer.toString(listProduit.get(l).getStock())
            );
            ListView<String> items = new ListView<>(item); // Créer la liste avec les éléments

            // Ajouter le bouton "Commander"
            Button button = new Button("Commander");
            button.setStyle("-fx-background-color: green; -fx-text-fill: white; -fx-font-size: 12;");
            button.setPrefSize(120, 50);
            VBox.setMargin(button, new Insets(5, 0, 0, 10));
               Button add = new Button("add");
add.setLayoutX(400);
add.setLayoutY(40);
/*
add.setOnAction(event -> {
    

                    Personneservice pssss = new Personneservice();
              
                    InterfaceloginController i = new InterfaceloginController();
                    String emiii = InterfaceloginController.currentUserEmail;
                    id_client = pssss.GETIDuser(emiii);
                    PanierService s = new PanierService();
                     panier = new Panier(id_client,listProduit.get(l).getId(), 1);
                    s.ajouter(panier);

});
  */  
    /*
vbox.getChildren().addAll(img, items, add); // Ajouter l'image, la liste et le bouton dans la boîte verticale

            ecran_id.getChildren().add(vbox); // Ajouter la boîte verticale à l'écran
            //handle button 

         
 
                
                    // Ajouter l'action à effectuer lors du clic sur le bouton Commander ici
                    // Ajouter l'action à effectuer lors du clic sur le bouton Commander ici
              

                
            

        }

        // ajouter tdio api 
        try {
            WebEngine webEngine = chat_id.getEngine();
            webEngine.load("http://localhost/chat/");

        } catch (Exception e) {
            System.out.println("fichier php introuvable");
        }
    }

    private void rechercher(String searchText) {
        ProduitService ps = new CRUDproduit();
        List<produit> listProduit = ps.afficherproduits();

        ecran_id.getChildren().clear(); // Effacer les produits affichés précédemment

        for (int i = 0; i < listProduit.size(); i++) {
            if (listProduit.get(i).getLib().toLowerCase().contains(searchText.toLowerCase())) {
                VBox vbox = new VBox(); // Créer une boîte verticale pour chaque élément de la liste
                vbox.setPrefHeight(200);

                // Charger l'image
                Image image = null;
                String imagePath = "/workshop3a24/img/" + listProduit.get(i).getLib() + ".jpg";
                try {
                    image = new Image(imagePath);
                } catch (Exception e) {
                    System.out.println("L'image " + imagePath + " n'existe pas.");
                    // Charger une image par défaut si l'image n'existe pas
                    image = new Image("/workshop3a24/img/default.PNG");
                }
                ImageView img = new ImageView(image);
                img.setFitHeight(100); // Ajuster la hauteur de l'image
                img.setPreserveRatio(true); // Conserver le ratio de l'image

                // Ajouter la liste dans la boîte verticale
                ObservableList<String> item = FXCollections.observableArrayList(
                        listProduit.get(i).getLib(),
                        Float.toString(listProduit.get(i).getPrix()),
                        Integer.toString(listProduit.get(i).getStock())
                );
                ListView<String> items = new ListView<>(item); // Créer la liste avec les éléments
                vbox.getChildren().addAll(img, items); // Ajouter l'image et la liste dans la boîte verticale
                ecran_id.getChildren().add(vbox); // Ajouter la boîte verticale à l'écran
            }
        }
    }

    @FXML
    private void gotopanier(ActionEvent event) {
  try {
                            Parent root;
                            FXMLLoader loader = new FXMLLoader(getClass().getResource("Panier.fxml"));
                            root = loader.load();
                            
                            ecran_id.getScene().setRoot(root);
                        } catch (IOException ex) {
                            Logger.getLogger(FormationDachboardFormateuerController.class.getName()).log(Level.SEVERE, null, ex);
                        }

        
        
    }*/
    
    
    // le code du contrleur commance 
    @FXML
    private Button btnpanier;
    
    
    
    
        /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        
       Personneservice pssss = new Personneservice();
          id_client= pssss.GETIDuser(emiii);

        
        
        searchField.textProperty().addListener((observable, oldValue, newValue) -> {
            // rechercher(newValue);
            });
        afficherFirstTime();
        
       // ajouter tdio api 
   
        try {
        WebEngine webEngine = chat_id.getEngine();
        webEngine.load("http://localhost/chat/");
            
        } catch (Exception e) {
            System.out.println("fichier php introuvable");
        }
        
        
        searchField.textProperty().addListener((observable, oldValue, newValue) -> {
        rechercher(newValue);
    });
    }    
  

private void rechercher(String searchText) {
    ProduitService ps = new CRUDproduit();
    List<produit> listProduit = ps.afficherproduits();
    
    //ecran_id.getChildren().clear(); // Effacer les produits affichés précédemment
    
    for (int i=0; i< listProduit.size(); i++) {
        if (listProduit.get(i).getLib().toLowerCase().contains(searchText.toLowerCase())) {           
            // Charger l'image
            Image image = null;
            String imagePath = "/workshop3a24/img/" + listProduit.get(i).getLib() + ".jpg";
            try {
                image = new Image(imagePath);
            } catch (Exception e) {
                System.out.println("L'image " + imagePath + " n'existe pas.");
                // Charger une image par défaut si l'image n'existe pas
                image = new Image("/workshop3a24/img/default.PNG");
            }
            ImageView img = new ImageView(image); 
            img.setFitHeight(200); // Ajuster la hauteur de l'image
            img.setPreserveRatio(true); // Conserver le ratio de l'image
                         
           

            if (vbox.getChildren().isEmpty() || vbox.getChildren().get(0)== null ) {
               
                vbox.setPrefHeight(200);
                vbox.setPadding(new Insets(70, 0, 0, 40));
                vbox.getChildren().add(img);
                
               
            } else {
                
                vbox.getChildren().clear();
                vbox.setPrefHeight(200);
                vbox.setPadding(new Insets(70, 0, 0, 40));
                vbox.getChildren().add(img);
                
            }

            // Ajouter la liste dans la boîte verticale
          
                     String produit = listProduit.get(i).getLib();
                    txt_produit.setText(produit);
                    String stock = Integer.toString(listProduit.get(i).getStock());
                     text_stock.setText(stock);
        String prix = Float.toString(listProduit.get(i).getPrix());
        }
        
    }
}

    @FXML
    private void showPrecedant(MouseEvent event) {
                
  cnx = MyDB.getInstance().getCnx(); // Utilisation de la méthode getConnection() pour récupérer une instance de Connection
    int id = Integer.valueOf(textId.getText());
    
    String qry = "SELECT `lib`, `stock`, `prix`,`id` FROM `produit` WHERE `id` < ? ORDER BY `id` ASC LIMIT 1";

    try {
        pst = cnx.prepareStatement(qry);
        pst.setInt(1, id); // utiliser la valeur de l'ID de l'utilisateur actuellement affiché
        rs = pst.executeQuery();
        if (rs.next()) {
            String produit = rs.getString("lib");
            txt_produit.setText(produit);
            String stock = rs.getString("stock");
            text_stock.setText(stock);
            String prix = rs.getString("prix");
            text_prix.setText(prix);
            int newId = rs.getInt("id");
            id_commander=newId;
            textId.setText(Integer.toString(newId));
            

            // Charger l'image
            Image image = null;
            String imagePath = "/workshop3a24/img/" + produit + ".jpg";

            try {
                image = new Image(imagePath);
            } catch (Exception e) {
                System.out.println("L'image" + imagePath + " n'existe pas.");
                // Charger une image par défaut si l'image n'existe pas
                image = new Image("/workshop3a24/img/default.PNG");
                
            }

            ImageView img = new ImageView(image);
            img.setFitHeight(200); // Ajuster la hauteur de l'image
            img.setPreserveRatio(true); // Conserver le ratio de l'image
                       
           

            if (vbox.getChildren().isEmpty() || vbox.getChildren().get(0)== null ) {
               
                vbox.setPrefHeight(200);
                vbox.setPadding(new Insets(70, 0, 0, 40));
                vbox.getChildren().add(img);
                
               
            } else {
               
                vbox.getChildren().clear();
                vbox.setPrefHeight(200);
                vbox.setPadding(new Insets(70, 0, 0, 40));
                vbox.getChildren().add(img);
                
            }
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
        
        
    }

@FXML
private void showSuivant(MouseEvent event) {
      cnx = MyDB.getInstance().getCnx(); // Utilisation de la méthode getConnection() pour récupérer une instance de Connection
    int id = Integer.valueOf(textId.getText());
    String qry = "SELECT `lib`, `stock`, `prix`,`id` FROM `produit` WHERE `id` > ? ORDER BY `id` ASC LIMIT 1";

    try {
        pst = cnx.prepareStatement(qry);
        pst.setInt(1, id); // utiliser la valeur de l'ID de la commande actuellement affiché
        rs = pst.executeQuery();
        if (rs.next()) {
            String produit = rs.getString("lib");
            txt_produit.setText(produit);
            String stock = rs.getString("stock");
            text_stock.setText(stock);
            String prix = rs.getString("prix");
            text_prix.setText(prix);
            int newId = rs.getInt("id");
            id_commander=newId;
            
            
            textId.setText(Integer.toString(newId));
           

            // Charger l'image
            Image image = null;
            String imagePath = "/workshop3a24/img/" + produit + ".jpg";

            try {
                image = new Image(imagePath);
            } catch (Exception e) {
                System.out.println("L'image" + imagePath + " n'existe pas.");
                // Charger une image par défaut si l'image n'existe pas
                image = new Image("/workshop3a24/img/default.PNG");
                
            }

            ImageView img = new ImageView(image);
            img.setFitHeight(200); // Ajuster la hauteur de l'image
            img.setPreserveRatio(true); // Conserver le ratio de l'image
                       
           

            if (vbox.getChildren().isEmpty() || vbox.getChildren().get(0)== null ) {
              
                vbox.setPrefHeight(200);
                vbox.setPadding(new Insets(70, 0, 0, 40));
                vbox.getChildren().add(img);
                
               
            } else {
               
                vbox.getChildren().clear();
                vbox.setPrefHeight(200);
                vbox.setPadding(new Insets(70, 0, 0, 40));
                vbox.getChildren().add(img);
                
            }
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
}



private void afficherFirstTime(){
        cnx = MyDB.getInstance().getCnx(); // Utilisation de la méthode getConnection() pour récupérer une instance de Connection
String qry = "SELECT id, lib, prix, stock FROM produit WHERE id = 39";

try {
    pst = cnx.prepareStatement(qry);
    rs = pst.executeQuery();
    
    if (rs.next()) {
        String produit = rs.getString("lib");
        txt_produit.setText(produit);
        String stock = rs.getString("stock");
        text_stock.setText(stock);
        String prix = rs.getString("prix");
        text_prix.setText(prix);
        int id = rs.getInt("id");
        textId.setText(Integer.toString(id));
        id_commander=39;
                    // Charger l'image
            Image image = null;
            String imagePath = "/workshop3a24/img/" + produit + ".jpg";

            try {
                image = new Image(imagePath);
            } catch (Exception e) {
                
                // Charger une image par défaut si l'image n'existe pas
                image = new Image("/workshop3a24/img/default.PNG");
                
            }

            ImageView img = new ImageView(image);
            img.setFitHeight(200); // Ajuster la hauteur de l'image
            img.setPreserveRatio(true); // Conserver le ratio de l'image
                       
           

            if (vbox.getChildren().isEmpty() || vbox.getChildren().get(0)== null ) {
               
                vbox.setPrefHeight(200);
                vbox.setPadding(new Insets(70, 0, 0, 40));
                vbox.getChildren().add(img);
                
               
            } else {
                
                vbox.getChildren().clear();
                vbox.setPrefHeight(200);
                vbox.setPadding(new Insets(70, 0, 0, 40));
                vbox.getChildren().add(img);
                
            }
        
       
    } else {
        // TODO : Gérer le cas où il n'y a pas de produit avec l'id 1
    }
} catch (SQLException e) {
    // TODO : Gérer l'exception SQLException
}}


    @FXML
    private void commander(MouseEvent event) {
     
                         Personneservice pssss = new Personneservice();
              
                    InterfaceloginController i = new InterfaceloginController();
                    String emiii = InterfaceloginController.currentUserEmail;
                    id_client = pssss.GETIDuser(emiii);
                    PanierService s = new PanierService();
                     System.out.println(id_commander);
                    panier = new Panier(id_client,id_commander, 1);
                    s.ajouter(panier);
    }

    @FXML
    private void commnder(MouseEvent event) {
    }

    @FXML
    private void retrour(MouseEvent event) {
        try {
                            Parent root;
                            FXMLLoader loader = new FXMLLoader(getClass().getResource("Dashbord_client.fxml"));
                            root = loader.load();
                            
                            ecran_id.getScene().setRoot(root);
                        } catch (IOException ex) {
                            Logger.getLogger(FormationDachboardFormateuerController.class.getName()).log(Level.SEVERE, null, ex);
                        }
        
    }

    @FXML
    private void gotopanier(MouseEvent event) {
        
          
  try {
                            Parent root;
                            FXMLLoader loader = new FXMLLoader(getClass().getResource("Panier.fxml"));
                            root = loader.load();
                            
                            ecran_id.getScene().setRoot(root);
                        } catch (IOException ex) {
                            Logger.getLogger(FormationDachboardFormateuerController.class.getName()).log(Level.SEVERE, null, ex);
                        }

        
        
    
        
    }



}
