/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package workshop3a24.GUI;

import com.mysql.jdbc.UpdatableResultSet;
import static com.sun.xml.internal.fastinfoset.alphabet.BuiltInRestrictedAlphabets.table;
import java.io.IOException;
import java.net.URL;
import java.util.Date;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.chart.PieChart.Data;
import javafx.scene.control.Button;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TreeTableColumn;
import javafx.scene.control.TreeTableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.layout.HBox;
import javafx.util.Callback;
import javafx.util.converter.IntegerStringConverter;
import javax.print.DocFlavor;
import workshop3a24.Entities.Formation;
import workshop3a24.Services.Formationservice;

/**
 * FXML Controller class
 *
 * @author dell
 */
public class HomeFormation implements Initializable {

    Formationservice sf = new Formationservice();

    @FXML
    private TableView<Formation> tableformation;
    @FXML
    private TableColumn<Formation, String> titre;
    @FXML
    private TableColumn<Formation, String> desc;
    @FXML
    private TableColumn<Formation, Integer> owner;
    @FXML
    private TableColumn<Formation, String> type;
    @FXML
    private TableColumn<Formation, String> pays;
    @FXML
    private TableColumn<Formation, Date> debuit;
    @FXML
    private TableColumn<Formation, Date> fin;
    @FXML
    private TableColumn<?, ?> action;
    @FXML
    private Button update;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

        tableformation.setItems(FXCollections.observableArrayList(sf.afficher()));
        titre.setCellValueFactory(new PropertyValueFactory<>("titre"));
        desc.setCellValueFactory(new PropertyValueFactory<>("description"));
        type.setCellValueFactory(new PropertyValueFactory<>("type"));
        pays.setCellValueFactory(new PropertyValueFactory<>("pays"));
        debuit.setCellValueFactory(new PropertyValueFactory<>("debut"));
        fin.setCellValueFactory(new PropertyValueFactory<>("fin"));
        owner.setCellValueFactory(new PropertyValueFactory<>("ownerid"));
        tableformation.setEditable(true);
        /*
 pays.setCellFactory(column -> new TableCell<Formation, String>() {
    @Override
    protected void updateItem(String item, boolean empty) {
        super.updateItem(item, empty);

        if (item == null || empty) {
            setText(null);
        } else {
            setText(item);
        }
    }
});*/
        // Formation selectedPerson = tableformation.getSelectionModel().getSelectedItem();

        //  if (selectedPerson != null) {
        // Update the properties of the selected person
        //  selectedPerson.setId(f.getId());
        //selectedPerson.setOwnerid(f.getId());
        // selectedPerson.set("New Last Name");
        // selectedPerson.setAge(50);
        // Refresh the TableView to reflect the changes
        //tableformation.refresh();
        //   }
        update.setOnAction((event) -> {
            try {
                int selectedIndex = tableformation.getSelectionModel().getSelectedIndex();
                Date d1 = new Date(2023 - 1900, 13 - 01, 13);
                if (selectedIndex >= 0) {
                    Formation selectedData = tableformation.getItems().get(selectedIndex);
                    Formation newData = new Formation();
                    newData.setTitre(selectedData.getTitre());
                    newData.setDescription("New value for column 2");
                    newData.setPays("New value for column ");
                    newData.setDebut(d1);
                    newData.setFin(d1);
                    System.out.println(newData);
                    System.out.println(selectedData);

                } else {
                    // No row selected
                }

            } catch (Exception ex) {
                System.out.print(ex.getMessage());
            }

        });

        action.setCellFactory(
                (param) -> {
                    TableCell t = new TableCell<Object, Object>() {
                HBox box;

                Button btn = new Button("action");
                Button bt = new Button("hibebe");

                @Override
                protected void updateItem(Object item, boolean empty) {
                    btn.setOnAction((event) -> {
                        Formation f = (Formation) getTableRow().getItem();
                        System.out.println(f + "hiii");

                    });
                    bt.setOnAction((event) -> {

                        try {
                            FXMLLoader loader = new FXMLLoader(getClass().getResource("AddFormation.fxml"));
                            Parent root = loader.load();
                            bt.getScene().setRoot(root);
                        } catch (IOException ex) {
                            System.out.print(ex.getMessage());
                        }

                    });

                    super.updateItem(item, empty); //To change body of generated methods, choose Tools | Templates.
                    box = new HBox(btn, bt);

                    if (!empty) {
                        setGraphic(box);
                    }
                }

            };

                    return t; //To change body of generated lambdas, choose Tools | Templates.
                }
        );

        // TODO
    }

}
       
