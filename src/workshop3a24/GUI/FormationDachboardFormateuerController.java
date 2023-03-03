/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package workshop3a24.GUI;

import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.HBox;
import workshop3a24.Entities.Formation;
import workshop3a24.Services.Formationservice;

/**
 * FXML Controller class
 *
 * @author dell
 */
public class FormationDachboardFormateuerController implements Initializable {

    Formationservice sf = new Formationservice();
    ObservableList<String> options = FXCollections.observableArrayList("", "LANGUE", "musique", "littérature", "Cuisson");
    ObservableList<String> payss = FXCollections.observableArrayList("", "Afghanistan", "Albania", "Algeria", "Andorra", "Angola", "Antigua and Barbuda", "Argentina", "Armenia", "Australia", "Austria", "Azerbaijan", "Bahamas", "Bahrain", "Bangladesh", "Barbados", "Belarus", "Belgium", "Belize", "Benin", "Bhutan", "Bolivia", "Bosnia and Herzegovina", "Botswana", "Brazil", "Brunei", "Bulgaria", "Burkina Faso", "Burundi", "Cabo Verde", "Cambodia", "Cameroon", "Canada", "Central African Republic (CAR)", "Chad", "Chile", "China", "Colombia", "Comoros", "Costa Rica", "Cote d'Ivoire", "Croatia", "Cuba", "Cyprus", "Czech Republic", "Democratic Republic of the Congo", "Denmark", "Djibouti", "Dominica", "Dominican Republic", "Ecuador", "Egypt", "El Salvador", "Equatorial Guinea", "Eritrea", "Estonia", "Ethiopia", "Fiji", "Finland", "France", "Gabon", "Gambia", "Georgia", "Germany", "Ghana", "Greece", "Grenada", "Guatemala", "Guinea", "Guinea-Bissau", "Guyana", "Haiti", "Honduras", "Hungary", "Iceland", "India", "Indonesia", "Iran", "Iraq", "Ireland", "Italy", "Jamaica", "Japan", "Jordan", "Kazakhstan", "Kenya", "Kiribati", "Kosovo", "Kuwait", "Kyrgyzstan", "Laos", "Latvia", "Lebanon", "Lesotho", "Liberia", "Libya", "Liechtenstein", "Lithuania", "Luxembourg", "Macedonia", "Madagascar", "Malawi", "Malaysia", "Maldives", "Mali", "Malta", "Marshall Islands", "Mauritania", "Mauritius", "Mexico", "Micronesia", "Moldova", "Monaco", "Mongolia", "Montenegro", "Morocco", "Mozambique", "Myanmar (Burma)", "Namibia", "Nauru", "Nepal", "Netherlands", "New Zealand", "Nicaragua", "Niger", "Nigeria", "North Korea", "Norway", "Oman", "Pakistan", "Palau", "Palestine", "Panama", "Papua New Guinea", "Paraguay", "Peru", "Philippines", "Poland", "Portugal", "Qatar", "Republic of the Congo", "Romania", "Russia", "Rwanda", "Saint Kitts and Nevis", "Saint Lucia", "Saint Vincent and the Grenadines", "Samoa", "San Marino", "Sao Tome and Principe", "Saudi Arabia", "Senegal", "Serbia", "Seychelles", "Sierra Leone", "Singapore", "Slovakia", "Slovenia", "Solomon Islands", "Somalia", "South Africa", "South Korea", "South Sudan", "Spain", "Sri Lanka", "Syria", "Tunisia");

    @FXML
    private TextField titrefx;
    @FXML
    private TextField descriptionfx;
    @FXML
    private ChoiceBox<String> paysfx;
    @FXML
    private ChoiceBox<String> typefx;
    @FXML
    private DatePicker debutpicker;
    @FXML
    private DatePicker finpicker;
    @FXML
    private TableView<Formation> table;
    @FXML
    private TableColumn<Formation, Integer> IDcol;
    @FXML
    private TableColumn<Formation, String> TITREcol;
    @FXML
    private TableColumn<Formation, String> DESCRIPTIONcol;
    @FXML
    private TableColumn<Formation, Date> debut;
    @FXML
    private TableColumn<Formation, Date> fin;
    @FXML
    private TableColumn<Formation, String> Type;
    @FXML
    private TableColumn<Formation, String> Pays;
    @FXML
    private TableColumn<Formation, String> Conf;
    @FXML
    private Button btnajouter;
    @FXML
    private Button btnmodifier;
    @FXML
    private Button btnsupprimer;
    @FXML
    private TextField search;
    @FXML
    private DatePicker filterbyDate;
    @FXML
    private TableColumn<?, ?> action;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

        action.setCellFactory(
                (param) -> {
                    TableCell t = new TableCell<Object, Object>() {
                HBox box;

                Button btn = new Button("action");

                @Override
                protected void updateItem(Object item, boolean empty) {
                    btn.setOnAction((event) -> {
                        Formation f = (Formation) getTableRow().getItem();
                     

                        try {
                            Parent root;
                            FXMLLoader loader = new FXMLLoader(getClass().getResource("Particpationformationformateuer.fxml"));
                            root = loader.load();
                               ParticpationformationformateuerController controller = loader.getController();
                            controller.setformation(f.getId());

                            btn.getScene().setRoot(root);
                        } catch (IOException ex) {
                            Logger.getLogger(FormationDachboardFormateuerController.class.getName()).log(Level.SEVERE, null, ex);
                        }

                    });

                    super.updateItem(item, empty); //To change body of generated methods, choose Tools | Templates.
                    box = new HBox(btn);

                    if (!empty) {
                        setGraphic(box);
                    }
                }

            };

                    return t; //To change body of generated lambdas, choose Tools | Templates.
                }
        );
        // TODO
        table();
        paysfx.setItems(payss);
        typefx.setItems(options);
        typefx.setItems(options);
        filterbyDate.setOnAction(e -> {
            LocalDate localDate = filterbyDate.getValue();
            java.sql.Date datetocmpareith = java.sql.Date.valueOf(localDate);

            ObservableList<Formation> filteredPeople = FXCollections.observableArrayList(sf.afficherAllBYOwnerId(35));
            //    ObservableList<Person> filteredPeople = people.filtered(p -> p.getAge() >= 30 && p.getAge() < 40);  

            ObservableList<Formation> newdata = filteredPeople.stream()
                    .filter(n -> n.getDebut().compareTo(datetocmpareith) == 0 || n.getFin().compareTo(datetocmpareith) == 0
                    )
                    .collect(Collectors.toCollection(FXCollections::observableArrayList));

            table.setItems(newdata);
            filterbyDate.setValue(null);

            // Perform any other actions that you need to take when the date changes
        });

    }

    @FXML
    private void ajouter_Produit(ActionEvent event) {
        if (isInputValid()) {
            Formation f = new Formation();
            LocalDate localDate = debutpicker.getValue();
            LocalDate localDate1 = finpicker.getValue();
            java.sql.Date sqlDate = java.sql.Date.valueOf(localDate);
            java.sql.Date sqlDate1 = java.sql.Date.valueOf(localDate1);

            f.setPays(paysfx.getValue());
            f.setDebut(sqlDate);
            f.setFin(sqlDate1);
            f.setType(typefx.getValue());
            f.setDescription(descriptionfx.getText());
            f.setTitre(titrefx.getText());
            sf.add(f);
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Creation de la Produit");
            alert.setHeaderText("Creation de la Produit");
            alert.setContentText("Produit crée!");
            alert.showAndWait();

            titrefx.setText("");
            descriptionfx.setText("");
            debutpicker.setValue(null);
            finpicker.setValue(null);
            typefx.setValue("");
            paysfx.setValue("");

            table();

        }
    }

    @FXML
    private void modifier_Produit(ActionEvent event) {
        if (isInputValid()) {
            int myIndex = table.getSelectionModel().getSelectedIndex();
            int id = Integer.parseInt(String.valueOf(table.getItems().get(myIndex).getId()));
            String title = titrefx.getText();
            String descr = descriptionfx.getText();
            LocalDate localDate = finpicker.getValue();
            java.sql.Date finnn = java.sql.Date.valueOf(localDate);
            LocalDate localDate1 = debutpicker.getValue();
            java.sql.Date debutt = java.sql.Date.valueOf(localDate1);
            String paysss = paysfx.getValue();
            String typeee = typefx.getValue();
            int idduser = Integer.parseInt(String.valueOf(table.getItems().get(myIndex).getOwnerid()));
            boolean conffff = Boolean.valueOf(table.getItems().get(myIndex).isConfirmation());

            Formation p = new Formation(id, idduser, descr, title, paysss, typeee, conffff, debutt, finnn);
            sf.modifier(p);
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Formation Registationn");

            alert.setHeaderText("Formation Registation");
            alert.setContentText("Updateddd!");

            alert.showAndWait();
            table();
        }
    }

    @FXML
    private void supprimer_Produit(ActionEvent event) {
        int myIndex = table.getSelectionModel().getSelectedIndex();
        int id = Integer.parseInt(String.valueOf(table.getItems().get(myIndex).getId()));
        sf.supprimerbyid(id);
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Produit Registationn");
        table();

        alert.setHeaderText("Produit Registation");
        alert.setContentText("Deleted!");

        alert.showAndWait();
    }

    public void table() {

        table.setItems(FXCollections.observableArrayList(sf.afficherAllBYOwnerId(35)));
        TITREcol.setCellValueFactory(new PropertyValueFactory<>("titre"));
        DESCRIPTIONcol.setCellValueFactory(new PropertyValueFactory<>("description"));
        Type.setCellValueFactory(new PropertyValueFactory<>("type"));
        Pays.setCellValueFactory(new PropertyValueFactory<>("pays"));
        debut.setCellValueFactory(new PropertyValueFactory<>("debut"));
        fin.setCellValueFactory(new PropertyValueFactory<>("fin"));

        Conf.setCellValueFactory(new PropertyValueFactory<>("confirmation"));

        table.setEditable(true);

        table.setRowFactory(tv -> {
            TableRow<Formation> myRow = new TableRow<>();
            myRow.setOnMouseClicked((event)
                    -> {
                if (event.getClickCount() == 1 && (!myRow.isEmpty())) {

                    int myIndex = table.getSelectionModel().getSelectedIndex();
                    //       debutpicker.setValue(table.getItems().get(m yIndex).getDebut());
                    //LocalDate localDate = sqlDate.toLocalDate()
                    int id = Integer.parseInt(String.valueOf(table.getItems().get(myIndex).getId()));
                    Date debutttttttt = (Date) table.getItems().get(myIndex).getDebut();
                    LocalDate localDate = debutttttttt.toLocalDate();
                    Date finnnnnnn = (Date) table.getItems().get(myIndex).getFin();
                    LocalDate localDate1 = finnnnnnn.toLocalDate();

                    titrefx.setText(table.getItems().get(myIndex).getTitre());
                    descriptionfx.setText(table.getItems().get(myIndex).getDescription());
                    typefx.setValue(table.getItems().get(myIndex).getType());
                    paysfx.setValue(table.getItems().get(myIndex).getPays());

                    debutpicker.setValue(localDate);
                    finpicker.setValue(localDate1);
//                            fxCategorieChoiceBox.
                }
            });
            return myRow;
        });

    }

    private boolean isInputValid() {
        String errorMessage = "";
        LocalDate currentDate = LocalDate.now();

        if (titrefx.getText() == null || titrefx.getText().length() == 0 || titrefx.getText().matches("[0-9]+") || containsBadWords(titrefx.getText())) {
            errorMessage += "Invalide Titre!\n";
        }
        if (descriptionfx.getText() == null || descriptionfx.getText().length() == 0 || descriptionfx.getText().matches("[0-9]+") || containsBadWords(descriptionfx.getText())) {
            errorMessage += "Invalide Description!\n";
        }
        if (paysfx.getValue() == null || paysfx.getValue().length() == 0 || paysfx.getValue().matches("[0-9]+") || paysfx.getValue() == "" || containsBadWords(paysfx.getValue())) {
            errorMessage += "Invalide Pays champ!\n";
        }
        if (typefx.getValue() == null || typefx.getValue().length() == 0 || typefx.getValue().matches("[0-9]+") || typefx.getValue() == "" || containsBadWords(typefx.getValue())) {
            errorMessage += "Invalide Type champ!\n";
        }

        if (debutpicker.getValue() == null) {
            errorMessage += "Invalide Date de debut!\n";
        }

        if (debutpicker.getValue().compareTo(currentDate) < 0) {
            errorMessage += "Invalide Date de debut!\n";
        }

        if (debutpicker.getValue() == currentDate) {
            errorMessage += "Invalide Date de debut!\n";
        }
        if (finpicker.getValue() == null) {
            errorMessage += "Invalide Date de fin!\n";
        }
        if (finpicker.getValue() == currentDate) {
            errorMessage += "Invalide Date de fin!\n";
        }
        if (finpicker.getValue().compareTo(currentDate) < 0) {
            errorMessage += "Invalide Date de fin!\n";
        }
        if (errorMessage.length() == 0) {
            return true;
        } else {
            // Show the error message.
            Alert alert = new Alert(Alert.AlertType.ERROR);

            alert.setTitle("Invalide champs");
            alert.setHeaderText("***Please correct champs **");
            alert.setContentText(errorMessage);

            alert.showAndWait();

            return false;
        }
    }

    @FXML
    private void filter(KeyEvent event) {
        ObservableList<Formation> filteredPeople = FXCollections.observableArrayList(sf.afficherAllBYOwnerId(35));
        //    ObservableList<Person> filteredPeople = people.filtered(p -> p.getAge() >= 30 && p.getAge() < 40);  

        ObservableList<Formation> newdata = filteredPeople.stream().filter(n
                -> n.getDescription().toLowerCase().contains(search.getText())
                || n.getPays().toLowerCase().contains(search.getText().toLowerCase())
                || n.getPays().toLowerCase().equals(search.getText())
                || n.getTitre().toLowerCase().contains(search.getText().toLowerCase())
                || n.getTitre().toLowerCase().equals(search.getText())
                || n.getType().toLowerCase().contains(search.getText().toLowerCase())
                || n.getType().toLowerCase().equals(search.getText())).collect(Collectors.toCollection(FXCollections::observableArrayList));

        table.setItems(newdata);

    }

     public  boolean containsBadWords(String line) {
        
        List<String> strings = Arrays.asList("abortion", "anal", "anus", "arse", "ass", "ass-fucker", "asses", "asshole", "assholes", "ballbag", "balls", "bastard", "bellend", "bestial", "bestiality", "bitch", "bitches", "bitching", "bloody", "blowjob", "bollok", "boob", "boobs", "breasts", "buceta", "bum", "butt", "carpet muncher", "chink", "cipa", "clitoris", "cock", "cock-sucker", "cocks", "coon", "crap", "cum", "cumshot", "cunillingus", "cunt", "damn", "dick", "dildo", "dildos", "dink", "dog-fucker", "duche", "dyke", "ejaculate", "ejaculated", "ejaculates", "ejaculating", "ejaculation", "fag", "fagging", "faggot", "fagot", "fagots", "fanny", "felching", "fellatio", "flange", "fuck", "fucked", "fucker", "fuckers", "fucking", "fuckings", "fucks", "fudge packer", "god-damned", "goddamn", "hell", "hore", "horny", "jerk-off", "kock", "labia", "lust", "lusting", "masochist", "masturbate", "mother fucker", "nazi", "nigger", "niggers", "orgasim", "orgasm", "orgasms", "pecker", "penis", "piss", "pissed", "pisser", "pisses", "pissing", "pissoff", "poop", "porn", "porno", "pornography", "prick", "pricks", "pube", "pussies", "pussy", "rape", "rapist", "rectum", "retard", "rimming", "sadist", "screwing", "scrotum", "semen", "sex", "shag", "shagging", "shemale", "shit", "shite", "shits", "shitted", "shitting", "shitty", "skank", "slut", "sluts", "smegma", "smut", "snatch", "son-of-a-bitch", "spac", "spunk", "testicle", "tit", "tits", "titt", "turd", "vagina", "viagra", "vulva", "wang", "wank", "whore", "xrated", "xxx");
boolean found = false;
        String[] words = line.split("\\s+");
        for (String word : words) {
            
            for (String str : strings) {
                if (word.equals(str)) {
                    found = true;
                    break;
                }
            }

        }
        return found;
    }

}
