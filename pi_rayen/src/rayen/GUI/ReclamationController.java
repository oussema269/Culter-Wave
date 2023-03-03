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

    /**
     * Initializes the controller class.
     */
    Connection mc;
    PreparedStatement ste;
    ObservableList<Reclamation> reclist;

    @Override
    public void initialize(URL url, ResourceBundle rb) {

        afficher();

    }

    @FXML
    private void ajouter(ActionEvent event) {
        try {

            Reclamation r1 = new Reclamation(Integer.parseInt(id_reclamateur1.getText()), Integer.parseInt(id_cible_reclamation1.getText()), type1.getText(), cont.getText());
            ReclamationService rs = new ReclamationService();
            rs.insert(r1);
        } catch (NumberFormatException ex) {
            Logger.getLogger(ReclamationController.class.getName()).log(Level.SEVERE, null, ex);
        }
        refresh();
    }

    @FXML
    private void modifier(ActionEvent event) {
        try {
            Reclamation r1 = new Reclamation(Integer.parseInt(idd.getText()), Integer.parseInt(id_reclamateur1.getText()), Integer.parseInt(id_cible_reclamation1.getText()), type1.getText(), cont.getText());
            ReclamationService rs = new ReclamationService();
            rs.update(r1);
        } catch (NumberFormatException ex) {
            Logger.getLogger(ReclamationController.class.getName()).log(Level.SEVERE, null, ex);
        }
        refresh();
    }

    @FXML
    private void sup(ActionEvent event) {
        try {
            Reclamation r1 = new Reclamation(Integer.parseInt(idd.getText()), Integer.parseInt(id_reclamateur1.getText()), Integer.parseInt(id_cible_reclamation1.getText()), type1.getText(), cont.getText());
            ReclamationService rs = new ReclamationService();
            rs.delete(r1);
        } catch (NumberFormatException ex) {
            Logger.getLogger(ReclamationController.class.getName()).log(Level.SEVERE, null, ex);
        }

        refresh();

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

}
