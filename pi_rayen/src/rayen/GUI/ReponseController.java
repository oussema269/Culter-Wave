/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rayen.GUI;

import entity.Reclamation;
import entity.Reponse;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import service.ReclamationService;
import service.ReponseService;
import utils.DataSource;

/**
 * FXML Controller class
 *
 * @author rayen
 */
public class ReponseController implements Initializable {

    @FXML
    private TextField idreponse;
    @FXML
    private Button btn_ajout;
    @FXML
    private Button btn_modif;
    @FXML
    private Button btn_supp;
    @FXML
    private TextField idreclam;
    @FXML
    private TextField idreclam1;
    @FXML
    private TextArea rep;
    @FXML
    private TableView<Reponse> tabrep;
    @FXML
    private TableColumn<Reponse, Integer> idreponse1;
    @FXML
    private TableColumn<Reponse, Integer> idreclam3;
    @FXML
    private TableColumn<Reponse, String> reponse2;
    @FXML
    private TableView<Reclamation> tabrec;
    @FXML
    private TableColumn<Reclamation, Integer> idreclam2;
    @FXML
    private TableColumn<Reclamation, String> contenureclam;

    /**
     * Initializes the controller class.
     */
    Connection mc;
    PreparedStatement ste;
    ObservableList<Reponse> replist;
    ObservableList<Reclamation> reclist;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        afficher();
        afficher2();
    }

    

    @FXML
    private void afficher() {

        mc = DataSource.getInstance().getCnx();
        replist = FXCollections.observableArrayList();

        try {
            String requete = "select * from reponse e";
            Statement st;
            st = DataSource.getInstance().getCnx()
                    .createStatement();
            ResultSet rs = st.executeQuery(requete);

            while (rs.next()) {
                Reponse e;
                e = new Reponse();
                e.setId_reponse(rs.getInt("id_reponse"));

                e.setId_reclamation(rs.getInt("id_reclamation"));

                e.setRepo(rs.getString("repo"));

                System.out.println("les reponses ajoutees :" + e.toString());
                replist.add(e);

            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        idreponse1.setCellValueFactory(data -> new SimpleObjectProperty(data.getValue().getId_reponse()));
        idreclam3.setCellValueFactory(data -> new SimpleObjectProperty(data.getValue().getId_reclamation()));
        reponse2.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getRepo()));

        tabrep.setItems(replist);
        refresh();
    }

    @FXML
    private void afficher2() {
        mc = DataSource.getInstance().getCnx();
        reclist = FXCollections.observableArrayList();
        try {
            String requetereponse = "select * from reclamation e";

            Statement dt;
            dt = DataSource.getInstance().getCnx().createStatement();
            ResultSet rs1 = dt.executeQuery(requetereponse);
            while (rs1.next()) {
                Reclamation es;
                es = new Reclamation();
                es.setid_reclamation(rs1.getInt("id_reclamation"));

                es.setcontenu(rs1.getString("contenu"));

                System.out.println("les reclamations ajoutees :" + es.toString());

                reclist.add(es);

            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        idreclam2.setCellValueFactory(data -> new SimpleObjectProperty(data.getValue().getid_reclamation()));
        contenureclam.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getcontenu()));

        tabrec.setItems(reclist);
        refresh2();

    }

    public void refresh() {
        replist.clear();
        mc = DataSource.getInstance().getCnx();
        replist = FXCollections.observableArrayList();

        try {
            String requete = "select * from reponse e";
            Statement st = DataSource.getInstance().getCnx()
                    .createStatement();
            ResultSet rs = st.executeQuery(requete);
            while (rs.next()) {
                Reponse e = new Reponse();
                e.setId_reponse(rs.getInt("id_reponse"));

                e.setId_reclamation(rs.getInt("id_reclamation"));

                e.setRepo(rs.getString("repo"));

                System.out.println("les reponses ajoutees :" + e.toString());
                replist.add(e);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        tabrep.setItems(replist);

    }

    public void refresh2() {
        reclist.clear();
        mc = DataSource.getInstance().getCnx();
        reclist = FXCollections.observableArrayList();
        try {
            String requetereponse = "select * from reclamation e";

            Statement dt;
            dt = DataSource.getInstance().getCnx()
                    .createStatement();
            ResultSet rs1 = dt.executeQuery(requetereponse);
            while (rs1.next()) {
                Reclamation es;
                es = new Reclamation();
                es.setid_reclamation(rs1.getInt("id_reclamation"));

                es.setcontenu(rs1.getString("contenu"));

                System.out.println("les reclamations ajoutees :" + es.toString());

                reclist.add(es);

            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        tabrec.setItems(reclist);
    }

    @FXML
    private void selected(MouseEvent event) {
        Reponse clicked = tabrep.getSelectionModel().getSelectedItem();
        idreponse.setText(String.valueOf(clicked.getId_reponse()));
        idreclam1.setText(String.valueOf(clicked.getId_reclamation()));
        rep.setText(String.valueOf(clicked.getRepo()));

    }

    @FXML
    private void selectedrec(MouseEvent event) {

        Reclamation clicked2 = tabrec.getSelectionModel().getSelectedItem();

        idreclam.setText(String.valueOf(clicked2.getid_reclamation()));
        idreclam1.setText(String.valueOf(clicked2.getid_reclamation()));

    }

    @FXML
    private void checkadd() {

        String testidrep = idreponse.getText();
        String testidrec = idreclam1.getText();
        String testrep = rep.getText();
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);

         if (testidrec.isEmpty()) {
            idreclam1.setText("choisis une reclamation");
        } else if (testrep.isEmpty()) {
            rep.setText("ici");
        } else {
            Optional<ButtonType> result = alert.showAndWait();
            if (result.get() == ButtonType.OK) {
                try {

                    Reponse r1 = new Reponse( Integer.parseInt(idreclam1.getText()), rep.getText());
                    ReponseService rs = new ReponseService();
                    rs.insert(r1);
                } catch (NumberFormatException ex) {
                    Logger.getLogger(ReponseController.class.getName()).log(Level.SEVERE, null, ex);
                }
                refresh();
            }

        }

    }

    @FXML
    private void checkmod() {

        String testidrep = idreponse.getText();
        String testidrec = idreclam1.getText();
        String testrep = rep.getText();
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);

        if (testidrep.isEmpty()) {
            idreponse.setText("ici");
        }else if (testidrec.isEmpty()) {
            idreclam1.setText("choisis une reclamation");
        } else if (testrep.isEmpty()) {
            rep.setText("donnez une reponse");
        } else {
            Optional<ButtonType> result = alert.showAndWait();
            if (result.get() == ButtonType.OK) {
                try {
                    Reponse r1 = new Reponse(Integer.parseInt(idreponse.getText()), Integer.parseInt(idreclam1.getText()), rep.getText());
                    ReponseService rs = new ReponseService();
                    rs.update(r1);
                } catch (NumberFormatException ex) {
                    Logger.getLogger(ReponseController.class.getName()).log(Level.SEVERE, null, ex);
                }
                refresh();
            }

        }

    }

    @FXML
    private void checkdel() {

        String testidrep = idreponse.getText();
        String testidrec = idreclam1.getText();
        String testrep = rep.getText();
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);

        if (testidrep.isEmpty()) {
            idreponse.setText("Une reponse svp");
        }  else {
            Optional<ButtonType> result = alert.showAndWait();
            if (result.get() == ButtonType.OK) {
                try {
                    Reponse r1 = new Reponse(Integer.parseInt(idreponse.getText()), Integer.parseInt(idreclam1.getText()), rep.getText());
                    ReponseService rs = new ReponseService();
                    rs.delete(r1);
                } catch (NumberFormatException ex) {
                    Logger.getLogger(ReponseController.class.getName()).log(Level.SEVERE, null, ex);
                }

                refresh();
            }

        }

    }
}
