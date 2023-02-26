/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package workshop3a24.GUI;

import com.mysql.jdbc.UpdatableResultSet;
import static com.sun.xml.internal.fastinfoset.alphabet.BuiltInRestrictedAlphabets.table;
import java.net.URL;
import java.util.Date;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.PieChart.Data;
import javafx.scene.control.Button;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.TreeTableColumn;
import javafx.scene.control.TreeTableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;
import javafx.util.Callback;
import javax.print.DocFlavor;
import workshop3a24.Entities.Formation;
import workshop3a24.Services.Formationservice;
import workshop3a24.Entities.DateUtils;

/**
 * FXML Controller class
 *
 * @author dell
 */
public class CardFormationController implements Initializable {

    @FXML
    private Text title;
    @FXML
    private Text pays;
   @FXML
    private Text desc;
    @FXML
    private Text type;
    @FXML
    private Text debut;
    @FXML
    private Text fin; 
    @FXML
    private Text test;
   
    

       String d = "2015-03-31";
DateUtils s=new DateUtils();

       java.sql.Date d1 = new java.sql.Date(2023 - 1900, 13 - 01, 13);
    Formation f = new Formation(1235495, "hello every one we are the best and this javafx make me sick i cant understand anything", "test", "syria",d1,d1, "test", false);
    
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
     type.setText(f.getType());
     title.setText(f.getTitre());
     pays.setText(f.getPays());
     String m= s.formatDate(f.getDebut());
     String m1= s.formatDate(f.getFin());
        System.out.println(m);
        debut.setText(m);
        fin.setText(m1);
        desc.setText(f.getDescription());
        
    
        // TODO
    }

}
