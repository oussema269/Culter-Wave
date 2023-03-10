/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package workshop3a24.GUI;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfDocument;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;


import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.FileChooser;
import workshop3a24.Entities.Commande;
import workshop3a24.Services.CommandeService;


/**
 * FXML Controller class
 *
 * @author asus
 */
public class CommandeController implements Initializable {

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
    private Button btnSettings;
    @FXML
    private Button btnSignout;
    @FXML
    private Pane pnlCustomer;
    @FXML
    private Pane pnlOrders;
    @FXML
    private Pane pnlMenus;
    @FXML
    private Pane pnlOverview;
    @FXML
    private VBox VboxCommande;
    private TextField fichier;
    @FXML
    private Button chercher;
    @FXML
    private TextField search;
    @FXML
    private Button trier;
    @FXML
    private VBox Vboxchercher;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        List<Commande> pers = new ArrayList<Commande>();

        CommandeService c = new CommandeService();
        pers = c.getCommannde();
        afficher(pers, VboxCommande);
    }

    @FXML
    private void handleClicks(ActionEvent event) {

    }

    @FXML
    private void generer(ActionEvent event) throws DocumentException {

// Afficher la boîte de dialogue de sélection de fichiers
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Enregistrer les données");
        File selectedFile = fileChooser.showSaveDialog(trier.getScene().getWindow());

        if (selectedFile != null) {
            // Écrire des données dans le fichier sélectionné
            try {
                // Créer un fichier de sortie et un écrivain PDF
                OutputStream outputStream = new FileOutputStream(selectedFile);
                // Créer un document PDF
                Document document = new Document();
                PdfWriter.getInstance(document, new FileOutputStream(selectedFile));
                document.open();

                // Ajouter un contenu au document
                List<Commande> pers = new ArrayList<Commande>();
                CommandeService c = new CommandeService();
                pers = c.getCommannde();

                for (Commande p : pers) {
                    Paragraph para = new Paragraph();
                    para.add("la commande de l'id \n");
                    para.add("ID : " + p.getId() + "\n");
                    para.add("Date : " + p.getDateP() + "\n");
                    para.add("Etat : " + p.getEtat() + "\n");
                    para.add("Total : " + p.getTotale() + "\n");
                    document.add(para);
                }

                // Fermer le document PDF
                document.close();
            } catch (IOException ex) {
                System.err.println("Erreur lors de l'écriture dans le fichier: " + ex.getMessage());
            }
        } else {
            // L'utilisateur a annulé la sélection de fichier
            System.out.println("La sélection de fichier a été annulée");
        }

    }

    @FXML
    private void chercher(ActionEvent event) {
        Vboxchercher.getChildren().clear();
        List<Commande> pers = new ArrayList<Commande>();
        CommandeService c = new CommandeService();
        pers = c.chercherCommande(Integer.parseInt(search.getText()));
        afficher(pers, Vboxchercher);

    }

    public void afficher(List<Commande> pers, VBox VboxCommande) {
        CommandeService c = new CommandeService();

        for (Commande p : pers) {

            Pane pane = new Pane();
            pane.setPrefSize(500, 75);
            pane.setStyle("-fx-background-color: #e6e6e6;");
            Label ID = new Label("ID: " + p.getId());
            ID.setLayoutX(10);
            ID.setLayoutY(10);
            ID.setFont(Font.font("Verdana", FontWeight.BOLD, 14));

            Label Id_Client = new Label("Id_Client: " + p.getId_client());
            Id_Client.setLayoutX(120);
            Id_Client.setLayoutY(10);
            Id_Client.setFont(Font.font("Verdana", FontWeight.NORMAL, 12));

            Label Etat = new Label("Etat: " + p.getEtat());
            Etat.setLayoutX(240);
            Etat.setLayoutY(10);
            Etat.setFont(Font.font("Verdana", FontWeight.NORMAL, 12));

            Label Date = new Label("Date: " + p.getDateP());// remplace 1 par client.id
            Date.setLayoutX(360);
            Date.setLayoutY(10);
            Date.setFont(Font.font("Verdana", FontWeight.NORMAL, 12));
            Label total = new Label("Totale: " + p.getTotale());// remplace 1 par client.id
            total.setLayoutX(480);
            total.setLayoutY(10);
            total.setFont(Font.font("Verdana", FontWeight.NORMAL, 12));

            Button supprimer = new Button("Supprimer");// remplace 1 par client.id
            supprimer.setLayoutX(580);
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
                    c.supprimer(p.getId());
                    parent.getChildren().remove(pane);

                }

            });

            Button modifier = new Button("modifier");// remplace 1 par client.id
            modifier.setLayoutX(660);
            modifier.setLayoutY(10);
            modifier.setFont(Font.font("Verdana", FontWeight.NORMAL, 12));

            modifier.setOnMouseClicked(event1 -> {
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setTitle("Confirmation de modification");
                alert.setHeaderText("Voulez-vous vraiment modifier cette commande?");
                alert.setContentText("Cliquez sur OK pour confirmer.");

                Optional<ButtonType> result = alert.showAndWait();
                if (result.isPresent() && result.get() == ButtonType.OK) {
                    Pane parent = (Pane) pane.getParent();
                    c.modifierEtat(1, p.getId());
                    afficher(pers, VboxCommande);

                }

            });

            pane.getChildren().addAll(ID, Id_Client, Etat, Date, total, supprimer, modifier);
            VboxCommande.getChildren().add(pane);

        }

        VboxCommande.setSpacing(100);

    }

    @FXML
    private void trier(ActionEvent event) {
        CommandeService c = new CommandeService();
        List<Commande> pers = new ArrayList<Commande>();
        VboxCommande.getChildren().clear();
        pers = c.trierC();
        afficher(pers, VboxCommande);

    }
}
