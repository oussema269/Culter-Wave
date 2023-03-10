
package user.GUI;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import java.util.Properties;
import java.util.Random;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javax.mail.*;
import javax.mail.internet.*;
import javax.swing.JOptionPane;
import user.Entities.personne;
import user.Utils.MyDB;
import user.services.personneservice;
/**
 * FXML Controller class
 *
 */
public class ModifierPasswordController implements Initializable {

    @FXML
    private TextField Email;
       @FXML
    private Button btncon;
       @FXML
    private Button next;

    // String verificationCode = personneservice.generateVerificationCode();
     Connection cnx;

    @FXML
   private void upadte(MouseEvent event) throws IOException {


      String verificationCode = personneservice.generateVerificationCode();
      String lien = "http://127.0.0.1:8000 "  ;
        //String bb = generateVerificationCode();

        String to = Email.getText();
        String from = "kdidifiras30@gmail.com";
        String host = "smtp.gmail.com"; // replace with your SMTP server address
        final String username = "kdidifiras30@gmail.com";
        final String password = "zxafotrttjdcfqsv";
        final String subject = "Password Reset Verification Code";
        final String emailBody = "Dear User,\n\nPlease use the following verification code to reset your password: %s\n\nYou can reset your password by clicking on the following link: %s\n\nRegards,\nYour Website Team";


        // Set the email properties
        Properties properties = new Properties();
        properties.put("mail.smtp.host", host);
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.port", "587"); // replace with your SMTP server port number
        properties.put("mail.smtp.starttls.enable", "true");

        // Create a session with the SMTP server
        Session session = Session.getInstance(properties, new Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
        });

        try {
             // Create the email message
            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress(from));
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
            message.setSubject(subject);
            message.setText(String.format(emailBody,verificationCode,lien ));
            ajoutercode(verificationCode,to);



            // Send the email
            Transport.send(message);


            JOptionPane.showMessageDialog(null, "Email sent successfully.");
            btncon.getScene().getWindow().hide();
                   Parent root = FXMLLoader.load(getClass().getResource("interfacemtp2.fxml"));
                   Stage mainStage = new Stage();
                   Scene scene = new Scene(root);
                   mainStage.setScene(scene);
                   mainStage.show();

        } catch (MessagingException ex) {
            System.err.println("Error sending email: " + ex.getMessage());
        }




    }
    public void ajoutercode(String a,String to) {

        try {
        String qry = "INSERT INTO `code` (`codeEmail`, `email`) VALUES ('" + a + "', '" + to + "')";
       cnx = MyDB.getInsatnce().getCnx();
            Statement stm = cnx.createStatement();
            stm.executeUpdate(qry);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());

        }

    }
      public static String generateVerificationCode() {
         StringBuilder sb = new StringBuilder();
        int codeLength = 6;
        Random random = new Random();

        for (int i = 0; i < codeLength; i++) {
            sb.append(random.nextInt(10));
        }
        return sb.toString();
    }

//   @FXML
//    void nextM(MouseEvent event) throws IOException {
//
//       next.getScene().getWindow().hide();
//                   Parent root = FXMLLoader.load(getClass().getResource("interfacemtp2.fxml"));
//                   Stage mainStage = new Stage();
//                   Scene scene = new Scene(root);
//                   mainStage.setScene(scene);
//                   mainStage.show();
//
//    }








    @Override
    public void initialize(URL location, ResourceBundle resources) {


}   }