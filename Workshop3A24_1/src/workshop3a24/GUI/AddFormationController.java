/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package workshop3a24.GUI;

import java.net.URL;
import java.sql.Date;
import java.time.LocalDate;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import workshop3a24.Entities.Formation;
import workshop3a24.Services.Formationservice;

/**
 * FXML Controller class
 *
 * @author dell
 */
public class AddFormationController implements Initializable {

    @FXML
    private ChoiceBox<String> type;
    @FXML
    private ChoiceBox<String> pays;
    @FXML
    private DatePicker debut;
    @FXML
    private DatePicker fin;
    @FXML
    private TextArea desc;
    @FXML
    private TextField titre;
    @FXML
    private Button btn;
    Formationservice sf = new Formationservice();
    Formation f = new Formation();

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ObservableList<String> options = FXCollections.observableArrayList("LANGUE", "musique", "littérature", "Cuisson");
        type.setItems(options);
        ObservableList<String> payss = FXCollections.observableArrayList("Afghanistan", "Albania", "Algeria", "Andorra", "Angola", "Antigua and Barbuda", "Argentina", "Armenia", "Australia", "Austria", "Azerbaijan", "Bahamas", "Bahrain", "Bangladesh", "Barbados", "Belarus", "Belgium", "Belize", "Benin", "Bhutan", "Bolivia", "Bosnia and Herzegovina", "Botswana", "Brazil", "Brunei", "Bulgaria", "Burkina Faso", "Burundi", "Cabo Verde", "Cambodia", "Cameroon", "Canada", "Central African Republic (CAR)", "Chad", "Chile", "China", "Colombia", "Comoros", "Costa Rica", "Cote d'Ivoire", "Croatia", "Cuba", "Cyprus", "Czech Republic", "Democratic Republic of the Congo", "Denmark", "Djibouti", "Dominica", "Dominican Republic", "Ecuador", "Egypt", "El Salvador", "Equatorial Guinea", "Eritrea", "Estonia", "Ethiopia", "Fiji", "Finland", "France", "Gabon", "Gambia", "Georgia", "Germany", "Ghana", "Greece", "Grenada", "Guatemala", "Guinea", "Guinea-Bissau", "Guyana", "Haiti", "Honduras", "Hungary", "Iceland", "India", "Indonesia", "Iran", "Iraq", "Ireland", "Italy", "Jamaica", "Japan", "Jordan", "Kazakhstan", "Kenya", "Kiribati", "Kosovo", "Kuwait", "Kyrgyzstan", "Laos", "Latvia", "Lebanon", "Lesotho", "Liberia", "Libya", "Liechtenstein", "Lithuania", "Luxembourg", "Macedonia", "Madagascar", "Malawi", "Malaysia", "Maldives", "Mali", "Malta", "Marshall Islands", "Mauritania", "Mauritius", "Mexico", "Micronesia", "Moldova", "Monaco", "Mongolia", "Montenegro", "Morocco", "Mozambique", "Myanmar (Burma)", "Namibia", "Nauru", "Nepal", "Netherlands", "New Zealand", "Nicaragua", "Niger", "Nigeria", "North Korea", "Norway", "Oman", "Pakistan", "Palau", "Palestine", "Panama", "Papua New Guinea", "Paraguay", "Peru", "Philippines", "Poland", "Portugal", "Qatar", "Republic of the Congo", "Romania", "Russia", "Rwanda", "Saint Kitts and Nevis", "Saint Lucia", "Saint Vincent and the Grenadines", "Samoa", "San Marino", "Sao Tome and Principe", "Saudi Arabia", "Senegal", "Serbia", "Seychelles", "Sierra Leone", "Singapore", "Slovakia", "Slovenia", "Solomon Islands", "Somalia", "South Africa", "South Korea", "South Sudan", "Spain", "Sri Lanka", "Syria", "Tunisia");

        pays.setItems(payss);

        btn.setOnAction((ActionEvent event) -> {
            LocalDate localDate = debut.getValue();
            LocalDate localDate1 = fin.getValue();
            Date sqlDate = Date.valueOf(localDate);
            Date sqlDate1 = Date.valueOf(localDate1);
            System.out.println(f.getType());
            System.out.println(f.getDebut());
            f.setPays(pays.getValue());
            f.setDebut(sqlDate);
            f.setFin(sqlDate1);
            f.setType(type.getValue());
            f.setDescription(desc.getText());
            f.setTitre(titre.getText());
           sf.add(f);
           Alert alert = new Alert(AlertType.INFORMATION);
alert.setTitle("Form Added");
alert.setHeaderText(null);
alert.setContentText("The form has been added successfully.");

alert.showAndWait();
            System.out.println(f);

        });
        // TODO
    }

}
 /*// set an event handler for the Submit button
        submitButton.setOnAction(event -> {
            // check if the TextArea is empty
            if (textArea.getText().isEmpty()) {
                // display an error message
                errorLabel.setVisible(true);
            } else {
                // hide the error message and submit the form
                errorLabel.setVisible(false);
                System.out.println("Text Value: " + textArea.getText());
            }
        });
    }
*/