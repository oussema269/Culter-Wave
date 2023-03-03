/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package workshop3a24.GUI;

import com.itextpdf.text.Document;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.URL;
import java.sql.Date;
import java.time.LocalDate;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.InputMethodEvent;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javax.mail.MessagingException;
import javax.swing.text.StyledEditorKit;
import workshop3a24.Entities.Formation;
import workshop3a24.Entities.Participationformation;
import workshop3a24.Services.ServiceParticipationformation;
import static workshop3a24.Workshop3A24.sendEmail;

/**
 * FXML Controller class
 *
 * @author dell
 */
public class ParticpationformationformateuerController implements Initializable {
    ServiceParticipationformation sp=new ServiceParticipationformation();


    @FXML
    private TableView<Participationformation> table;
    private TableColumn<Participationformation, Integer> id;
    @FXML
    private TableColumn<Participationformation, String> TITREcol;
    @FXML
    private TableColumn<Participationformation, Integer> formation;
    private TableColumn<Participationformation, Integer> user;
    @FXML
    private TableColumn<Participationformation, Boolean> Conf;
    @FXML
    private Button btnaceppter;
    @FXML
    private Button btnrefuser;
    @FXML
    private TableColumn<Participationformation, String> nom;
    @FXML
    private TableColumn<Participationformation, String> email;
    @FXML
    private Button filechosser;
    @FXML
    private Button pdf;
int x;
    @FXML
    private Text idformation;
    /**
     * Initializes the controller class.
     */
  public int setformation(int labnom) {
      idformation.setText(String.valueOf(labnom));
         x=labnom;
         System.out.println(x);
         
       Table0();
      return x=labnom;
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        idformation.setVisible(false);
        System.out.println("fffff");
        getData();
        getData();
     //Table0();
      /*  try {
    // Wait for 5 seconds
    Thread.sleep(2000);
     Table1();
    // Code to be executed after 5 seconds
  
} catch (InterruptedException e) {
    // Handle the exception
    e.printStackTrace();
}*/
       
        // TODO
    }    


    @FXML
    private void refuser(ActionEvent event) {
         int myIndex = table.getSelectionModel().getSelectedIndex();
        int id = Integer.parseInt(String.valueOf(table.getItems().get(myIndex).getIdParticipationFormation()));
        sp.refuser(id);
          Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("User refused");

        alert.setHeaderText("modifaction Registation");
        alert.setContentText("Updateddd!");

        alert.showAndWait();
        Table0();
    }

    @FXML
    private void aceepter(ActionEvent event) {
         int myIndex = table.getSelectionModel().getSelectedIndex();
        int id = Integer.parseInt(String.valueOf(table.getItems().get(myIndex).getIdParticipationFormation()));
        String titre=(table.getItems().get(myIndex).getTitre());
        String email=(table.getItems().get(myIndex).getEmail());
        sp.accept(id);
         try {
    sendEmail("mhmad.hafez@hotmail.com", "Test email", "you have been accepted in"+titre+" ");
} catch (MessagingException e) {
    System.out.println("Error sending email: " + e.getMessage());
}
         Alert alert = new Alert(Alert.AlertType.INFORMATION);
         
        alert.setTitle("User accepted");

        alert.setHeaderText("modifaction Registation");
        alert.setContentText("Updateddd!");

        alert.showAndWait();
        Table0();
    }
   
     
  

  

    @FXML
  public void Table0() {
    
      System.out.println(x);
Participationformation p=new Participationformation();
        table.setItems(FXCollections.observableArrayList(sp.afficherbyidformation(Integer.valueOf(idformation.getText()))));
        nom.setCellValueFactory(new PropertyValueFactory<>("nom"));
        Conf.setCellValueFactory(new PropertyValueFactory<>("confirmation"));
       email.setCellValueFactory(new PropertyValueFactory<>("email"));
          formation.setCellValueFactory(new PropertyValueFactory<>("titre"));
        table.setEditable(true);  System.out.println("Five seconds have passed!");
    System.out.println(idformation.getText()+"hhhhhhhh");
           
}

    @FXML
    private void onChooseFileButtonClicked(ActionEvent event) {
         // Create a new file chooser
        FileChooser fileChooser = new FileChooser();

        // Set the initial directory (optional)
        fileChooser.setInitialDirectory(new File(System.getProperty("user.home")));

        // Set the title of the file chooser dialog
        fileChooser.setTitle("Choose a directory to save the file");

        // Show the file chooser dialog and wait for the user to select a directory
        File selectedDirectory = fileChooser.showSaveDialog(new Stage());

        // If the user selected a directory, get the absolute path of the directory as a string
        if (selectedDirectory != null) {
            String directoryPath = selectedDirectory.getAbsolutePath();
            System.out.println("Selected directory: " + directoryPath);
            // Do something with the directory path...
        
           try {
         writeExcel(directoryPath,sp.afficher());
} catch (Exception e) {
    System.out.println("Error sending email: " + e.getMessage());

        }
    }
    
}



 public static void writeExcel(String pathfile , List<Participationformation> m) throws Exception {
    PrintWriter writer = new PrintWriter( new OutputStreamWriter(new FileOutputStream(pathfile+".csv"), "UTF-8"));
          ServiceParticipationformation sm=new ServiceParticipationformation();

    
        
        List<Participationformation> Formations = m;
       writer.write("Nom,Type,Description,Confirmation\n");
               for (Participationformation obj : Formations) {
                   
            writer.write(obj.getEmail());
            writer.write(",");
            writer.write(obj.getNom());
            writer.write(",");
             writer.write(obj.getTitre());
            writer.write(",");
            writer.write(obj.getConfirmation().toString());
            writer.write("\n");

               }
               writer.flush();
               writer.close();
}
 public static void writepdf(String path,List<Participationformation> m) throws Exception {
    Document document = new Document();
    PdfWriter.getInstance(document, new FileOutputStream(path+".pdf"));
    document.open();
    
  
    List<Participationformation> pdf =m ;
    
    PdfPTable table = new PdfPTable(4); // 3 columns
    table.addCell("Nom");
    table.addCell("Type");
    table.addCell("Titre");
    table.addCell("confirmation");
    
    for (Participationformation obj : pdf) {
        table.addCell(obj.getEmail());
        table.addCell(obj.getNom());
        table.addCell(obj.getTitre());
        table.addCell(obj.getConfirmation().toString());
        
    }
    
    document.add(table);
    document.close();
}

    @FXML
    private void filechosserpdf(ActionEvent event) {
            // Create a new file chooser
        FileChooser fileChooser = new FileChooser();

        // Set the initial directory (optional)
        fileChooser.setInitialDirectory(new File(System.getProperty("user.home")));

        // Set the title of the file chooser dialog
        fileChooser.setTitle("Choose a directory to save the file");

        // Show the file chooser dialog and wait for the user to select a directory
        File selectedDirectory = fileChooser.showSaveDialog(new Stage());

        // If the user selected a directory, get the absolute path of the directory as a string
        if (selectedDirectory != null) {
            String directoryPath = selectedDirectory.getAbsolutePath();
            System.out.println("Selected directory: " + directoryPath);
            // Do something with the directory path...
        
           try {
         writepdf(directoryPath,sp.afficher());
} catch (Exception e) {
    System.out.println("Error sending email: " + e.getMessage());

        }
    }
    
        
        
    }

    @FXML
    private void data(InputMethodEvent event) {
    }
    
    
    private void getData(){
         System.out.println(x);
Participationformation p=new Participationformation();
        table.setItems(FXCollections.observableArrayList(sp.afficherbyidformation(Integer.valueOf(idformation.getText()))));
        nom.setCellValueFactory(new PropertyValueFactory<>("nom"));
        Conf.setCellValueFactory(new PropertyValueFactory<>("confirmation"));
       email.setCellValueFactory(new PropertyValueFactory<>("email"));
          formation.setCellValueFactory(new PropertyValueFactory<>("titre"));
        table.setEditable(true);  System.out.println("Five seconds have passed!");
    System.out.println(idformation.getText()+"hhhhhhhh");
        
    }
}