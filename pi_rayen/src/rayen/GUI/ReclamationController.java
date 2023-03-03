/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rayen.GUI;

import connect_rayen.Connxion_rayen;
import entity.User;
import entity.Reclamation;
import entity.Reponse;
import service.UserService;
import service.ReclamationService;
import service.ReponseService;
import utils.DataSource;
import java.io.IOException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import java.net.URL;
import java.sql.ResultSet;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import java.sql.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Properties;
import javafx.application.Application;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellDataFeatures;
import javafx.scene.control.TableView;
import javafx.stage.Stage;
import javafx.util.Callback;
import utils.DataSource;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javax.mail.*;
import javax.mail.internet.*;
/**
 * FXML Controller class
 *
 * @author rayen
 */
public class ReclamationController implements Initializable {

    @FXML
    private TextField idd;

    @FXML
    private TextField id_reclamateur1;

    @FXML
    private TextField id_cible_reclamation1;

    @FXML
    private TextField type1;

    @FXML
    private TextField cont;

    @FXML
    private Button btn_ajout;

    @FXML
    private Button btn_modif;

    @FXML
    private Button btn_supp;

    @FXML
    private TableView<Reclamation> table;

    @FXML
    private TableColumn<Reclamation, Integer> idrec;

    @FXML
    private TableColumn<Reclamation, Integer> reclamateur;

    @FXML
    private TableColumn<Reclamation, Integer> cible;

    @FXML
    private TableColumn<Reclamation, String> type;

    @FXML
    private TableColumn<Reclamation, String> contenu2;
    @FXML
    private TextField searchField;
    @FXML
    private ComboBox<String> sortBox = new ComboBox<>();

    /**
     * Initializes the controller class.
     */
    Connection mc;
    PreparedStatement ste;
    ObservableList<Reclamation> reclist;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ObservableList<String> items = FXCollections.observableArrayList(
                "ID",
                "type"
                
        );
        sortBox.setItems(items);
        
        searchField.textProperty().addListener((observable, oldValue, newValue) -> search());
        sortBox.setOnAction(event -> sort());
        afficher();

    }
    @FXML
private void search() {
    String query = searchField.getText();
    ObservableList<Reclamation> filteredList = FXCollections.observableArrayList();
    for (Reclamation reclamation : reclist) {
        if (reclamation.gettype_reclamation().toLowerCase().contains(query.toLowerCase())) {
            filteredList.add(reclamation);
        }
    }
    table.setItems(filteredList);
}
@FXML
private void sort() {
    String selectedOption = sortBox.getValue();
    if (selectedOption == null) {
        return;
    }
    switch (selectedOption) {
        case "ID":
            reclist.sort((p1, p2) -> Integer.compare(p1.getid_reclamation(), p2.getid_reclamation()));
            break;
        case "type":
            reclist.sort((p1, p2) -> p1.gettype_reclamation().compareToIgnoreCase(p2.gettype_reclamation()));
            break;
        
        default:
            break;
    }
    table.setItems(reclist);
}
    





    @FXML
    private void afficher() {

        mc = DataSource.getInstance().getCnx();
        reclist = FXCollections.observableArrayList();

        try {
            String requete = "select * from reclamation e";
            Statement st;
            st = DataSource.getInstance().getCnx()
                    .createStatement();
            ResultSet rs = st.executeQuery(requete);
            while (rs.next()) {
                Reclamation e;
                e = new Reclamation();
                e.setid_reclamation(rs.getInt("id_reclamation"));

                e.setid_reclamateur(rs.getInt("id_reclamateur"));

                e.setid_cible_reclamation(rs.getInt("id_cible_reclamation"));

                e.settype_reclamation(rs.getString("type_reclamation"));

                e.setcontenu(rs.getString("contenu"));

                System.out.println("les reclamations ajoutees :" + e.toString());
                reclist.add(e);

            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        idrec.setCellValueFactory(data -> new SimpleObjectProperty(data.getValue().getid_reclamation()));
        reclamateur.setCellValueFactory(data -> new SimpleObjectProperty(data.getValue().getid_reclamateur()));
        cible.setCellValueFactory(data -> new SimpleObjectProperty(data.getValue().getid_cible_reclamation()));
        type.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().gettype_reclamation()));
        contenu2.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getcontenu()));

        table.setItems(reclist);
        refresh();

    }

    public void refresh() {
        reclist.clear();
        mc = DataSource.getInstance().getCnx();
        reclist = FXCollections.observableArrayList();

        try {
            String requete = "SELECT * FROM reclamation e  ";
            Statement st = DataSource.getInstance().getCnx()
                    .createStatement();
            ResultSet rs = st.executeQuery(requete);
            while (rs.next()) {
                Reclamation e = new Reclamation();
                e.setid_reclamation(rs.getInt("id_reclamation"));

                e.setid_reclamateur(rs.getInt("id_reclamateur"));

                e.setid_cible_reclamation(rs.getInt("id_cible_reclamation"));

                e.settype_reclamation(rs.getString("type_reclamation"));

                e.setcontenu(rs.getString("contenu"));
                System.out.println("les reclamations ajoutees :" + e.toString());
                reclist.add(e);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        table.setItems(reclist);

    }

    @FXML
    private void selected(MouseEvent event) {
        Reclamation clicked = table.getSelectionModel().getSelectedItem();
        idd.setText(String.valueOf(clicked.getid_reclamation()));
        id_reclamateur1.setText(String.valueOf(clicked.getid_reclamateur()));
        id_cible_reclamation1.setText(String.valueOf(clicked.getid_cible_reclamation()));
        type1.setText(String.valueOf(clicked.gettype_reclamation()));
        cont.setText(String.valueOf(clicked.getcontenu()));

    }
    @FXML
    private void checkadd() {

        String testidrec = idd.getText();
        String testidreclamateur = id_reclamateur1.getText();
        String testciblerec = id_cible_reclamation1.getText();
        String testtype = type1.getText();
        String testconenu = cont.getText();
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);

         if (testidrec.isEmpty()) {
            id_reclamateur1.setText("choisis une reclamation");
        } else if (testidreclamateur.isEmpty()) {
            id_reclamateur1.setText("ici");
        } else if (testciblerec.isEmpty()) {
            id_cible_reclamation1.setText("ici");
        } else if (testtype.isEmpty()) {
            type1.setText("ici");
        } else if (testconenu.isEmpty()) {
            cont.setText("ici");
        }else {
            Optional<ButtonType> result = alert.showAndWait();
            if (result.get() == ButtonType.OK) {
                try {

                    Reclamation r1 = new Reclamation( Integer.parseInt(id_reclamateur1.getText()), Integer.parseInt(id_cible_reclamation1.getText()), type1.getText(), cont.getText());
                    ReclamationService rs = new ReclamationService();
                    rs.insert(r1);
                    handle();
                } catch (NumberFormatException ex) {
                    Logger.getLogger(ReclamationController.class.getName()).log(Level.SEVERE, null, ex);
                }
                refresh();
            }

        }

    }
    public void handle() {
        // Recipient's email address
        String to = "rayen.khalfaoui@esprit.tn";
        // Sender's email address
        String from = "culturewave2a14@outlook.com";
        // Sender's email password
        String password = "aqwzsx@123456";

        // Setup mail server properties
        Properties props = new Properties();
        props.put("mail.smtp.host", "smtp.office365.com");
        props.put("mail.smtp.port", "587");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");

        // Create a new session with an authenticator
        Session session;
        session = Session.getInstance(props, new javax.mail.Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(from, password);
            }
        });
        try {
            // Create a new message
            Message message = new MimeMessage(session);
            // Set the sender, recipient, subject and body of the message
            message.setFrom(new InternetAddress(from));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to));
            message.setSubject("Creaction Reclamation");
            message.setText("Votre Reclamation a etait crée!");

            // Send the message
            Transport.send(message);
            System.out.println("Email sent successfully!");

        } catch (MessagingException e) {
            System.out.println("Failed to send email. Error message: " + e.getMessage());
        }
    }
    @FXML
    private void checkmod() {

        String testidrec = idd.getText();
        String testidreclamateur = id_reclamateur1.getText();
        String testciblerec = id_cible_reclamation1.getText();
        String testtype = type1.getText();
        String testconenu = cont.getText();
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);

         if (testidrec.isEmpty()) {
            id_reclamateur1.setText("choisis une reclamation");
        } else if (testidreclamateur.isEmpty()) {
            id_reclamateur1.setText("ici");
        } else if (testciblerec.isEmpty()) {
            id_cible_reclamation1.setText("ici");
        } else if (testtype.isEmpty()) {
            type1.setText("ici");
        } else if (testconenu.isEmpty()) {
            cont.setText("ici");
        }else {
            Optional<ButtonType> result = alert.showAndWait();
            if (result.get() == ButtonType.OK) {
                try {

                    Reclamation r1 = new Reclamation(Integer.parseInt(idd.getText()), Integer.parseInt(id_reclamateur1.getText()), Integer.parseInt(id_cible_reclamation1.getText()), type1.getText(), cont.getText());
                    ReclamationService rs = new ReclamationService();
                    rs.update(r1);
                } catch (NumberFormatException ex) {
                    Logger.getLogger(ReclamationController.class.getName()).log(Level.SEVERE, null, ex);
                }
                refresh();
            }

        }

    }
    @FXML
    private void checkdel() {

        String testidrec = idd.getText();
        
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);

         if (testidrec.isEmpty()) {
            id_reclamateur1.setText("choisis une reclamation");
        } else {
            Optional<ButtonType> result = alert.showAndWait();
            if (result.get() == ButtonType.OK) {
                try {

                    Reclamation r1 = new Reclamation( Integer.parseInt(idd.getText()),Integer.parseInt(id_reclamateur1.getText()), Integer.parseInt(id_cible_reclamation1.getText()), type1.getText(), cont.getText());
                    ReclamationService rs = new ReclamationService();
                    
                    rs.delete(r1);
                } catch (NumberFormatException ex) {
                    Logger.getLogger(ReclamationController.class.getName()).log(Level.SEVERE, null, ex);
                }
                refresh();
            }

        }

    }

}
