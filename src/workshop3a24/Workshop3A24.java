/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package workshop3a24;
import com.itextpdf.text.Document;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.FileOutputStream;
import java.io.File;
import javax.mail.*;
import javax.mail.internet.*;
import java.util.Properties;
import java.util.Properties;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.List;
import org.apache.poi.ss.usermodel.*;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import static org.bouncycastle.asn1.iana.IANAObjectIdentifiers.directory;
import workshop3a24.Entities.Formation;
import workshop3a24.Entities.Participationformation;
import workshop3a24.Entities.Personne;
import workshop3a24.Services.Formationservice;
import workshop3a24.Services.Personneservice;
import workshop3a24.Services.ServiceParticipationformation;
import workshop3a24.Utils.MyDB;

/**
 *
 * @author Mohamed
 */
public class Workshop3A24 {

    /**
     * @param args the command line arguments
     */
   
    public static void main(String[] args) {
        
        //System.out.println(containsBadWords("fuck world"));
//     A a = A.getInstance();
//     A a1 =A.getInstance();
//        System.out.println(a.hashCode());
//        System.out.println(a1.hashCode());
//        MyDB a = MyDB.getInstance();
//        MyDB a1 = MyDB.getInstance();
//        System.out.println(a.hashCode());
//        System.out.println(a1.hashCode());
        String d = "2015-03-31";
        Date d1 = new Date(2023 - 1900, 13 - 01, 13);
        //System.out.println(d);
        /*             SimpleDateFormat d1 = new SimpleDateFormat("yyyy-MM-dd");
        int year = 2023;
        int month = 03;
        int day = 9;
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.YEAR, year);
        cal.set(Calendar.MONTH, month - 1); 
        cal.set(Calendar.DAY_OF_MONTH, day);

        java.sql.Date date = new java.sql.Date(cal.getTimeInMillis());
        System.out.println(d1.format(date));*/
        //  Personne p = new Personne(8888, "hafez", "Mohamed AKA abou Maher");
        
     
        //  Participationformation p=new Participationformation(132585658,1112,true);
        //ServiceParticipationformation p1 =new ServiceParticipationformation();
        Personneservice p = new Personneservice();
        
        Personne p1= p.afficherByiduser(28);
//System.out.println(p.afficherByiduser(28));
        Formationservice sf = new Formationservice();
        // sf.add(f);
        //System.out.println(sf.afficher());
          Formation f = new Formation(28, "test", "test", "syria", d1, d1, "test", false);
          ServiceParticipationformation sff=new ServiceParticipationformation();
         System.out.println(sff.afficher()); 
         
         
       
        //  Personne p = new Personne(8888, "hafez", "Mohamed AKA abou Maher");
        // ServicePersonne sp = new ServicePersonne();
        //  sp.add(p);
        //System.out.println(sf.afficher());
        //System.out.println(sf.afficherAccept());
        //p1.add(p);
        //System.out.println(p1.afficher()); 



 /*try {
    writeExcel();
} catch (Exception e) {
    System.out.println("Error sending email: " + e.getMessage());
}*/
    
 try {
    writepdf();
} catch (Exception e) {
    System.out.println("Error sending email: " + e.getMessage());
}
      /*  try {
    sendEmail("mhmad.hafez@hotmail.com", "Test email", "This is a test email");
} catch (MessagingException e) {
    System.out.println("Error sending email: " + e.getMessage());
}*/

    }
    public static void writePDF() throws Exception {
    PrintWriter writer = new PrintWriter( new OutputStreamWriter(new FileOutputStream("C:\\Users\\dell\\Desktop\\Metier.pdf"), "UTF-8"));
          ServiceParticipationformation sm=new ServiceParticipationformation();

    
        
        List<Participationformation> metiers = sm.afficher();
       writer.write("Nom,Type,Description,Confirmation\n");
               for (Participationformation obj : metiers) {
                   
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

    
 
     public static void writeExcel(String pathfile , List<Participationformation> m) throws Exception {
    PrintWriter writer = new PrintWriter( new OutputStreamWriter(new FileOutputStream(pathfile), "UTF-8"));
          ServiceParticipationformation sm=new ServiceParticipationformation();

    
        
        List<Participationformation> metiers = m;
       writer.write("Nom,Type,Description,Confirmation\n");
               for (Participationformation obj : metiers) {
                   
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
 
    

 public static void sendEmail(String recipientEmail, String subject, String message) throws MessagingException {

        // Sender's email ID needs to be mentioned
        String senderEmail = "heelos.gcfhvgjbhknj@gmail.com";

        // Sender's email password needs to be mentioned
        String password = "fbubwijawfdcvesg";

        // SMTP server address
        String host = "smtp.gmail.com";

        // Get system properties
        Properties properties = System.getProperties();

        // Setup mail server
        properties.setProperty("mail.smtp.host", host);
        properties.setProperty("mail.smtp.port", "587");
        properties.setProperty("mail.smtp.starttls.enable", "true");
        properties.setProperty("mail.smtp.auth", "true");

        // Get the default Session object.
        Session session = Session.getInstance(properties, new Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(senderEmail, password);
            }
        });

        // Create a default MimeMessage object.
        MimeMessage mimeMessage = new MimeMessage(session);

        // Set From: header field of the header.
        mimeMessage.setFrom(new InternetAddress(senderEmail));

        // Set To: header field of the header.
        mimeMessage.addRecipient(Message.RecipientType.TO, new InternetAddress(recipientEmail));

        // Set Subject: header field
        mimeMessage.setSubject(subject);

        // Now set the actual message
        mimeMessage.setText(message);

        // Send message
        Transport.send(mimeMessage);

        System.out.println("Email sent successfully to " + recipientEmail);
    }
 public static void writepdf() throws Exception {
    Document document = new Document();
    PdfWriter.getInstance(document, new FileOutputStream("C:\\Users\\dell\\Desktop\\Metier.pdf"));
    document.open();
    
    ServiceParticipationformation sm=new ServiceParticipationformation();
    List<Participationformation> metiers = sm.afficher();
    
    PdfPTable table = new PdfPTable(4); // 3 columns
    table.addCell("Nom");
    table.addCell("Type");
    table.addCell("Titre");
    table.addCell("confirmation");
    
    for (Participationformation obj : metiers) {
        table.addCell(obj.getEmail());
        table.addCell(obj.getNom());
        table.addCell(obj.getTitre());
        table.addCell(obj.getConfirmation().toString());
        
    }
    
    document.add(table);
    document.close();
}

}





/*Calendar calendar = Calendar.getInstance();
            calendar.set(Calendar.YEAR, 2022);
            calendar.set(Calendar.MONTH, Calendar.DECEMBER);
            calendar.set(Calendar.DAY_OF_MONTH, 25);
            java.util.Date specifiedDate = calendar.getTime();
            Date sqlDate = new Date(specifiedDate.getTime());*/
/*public void ToPdf(){
   try {
            Document document = new Document(PageSize.A4, 50, 50, 50, 50);
            PdfWriter.getInstance(document, new FileOutputStream("table.pdf"));
            document.open();

            PdfPTable pdfTable = new PdfPTable(table.getColumns().size());
            addTableHeader(pdfTable, table);
            addRows(pdfTable, table);
            
            document.add(pdfTable);
            
            document.close();
        } catch (IOException | DocumentException e) {
            e.printStackTrace();
        }

}
    private void addTableHeader(PdfPTable pdfTable, TableView<Produit> tableView) {
        for (TableColumn<Produit, ?> column : tableView.getColumns()) {
            PdfPCell header = new PdfPCell();
            header.setPhrase(new com.itextpdf.text.Phrase(column.getText()));
            pdfTable.addCell(header);
        }
    }

    private void addRows(PdfPTable pdfTable, TableView<Produit> tableView) {
        for (Produit person : tableView.getItems()) {
            pdfTable.addCell(Integer.toString(person.getId()));
            pdfTable.addCell(person.getTitle());
            pdfTable.addCell(person.getDescription());
            SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
            pdfTable.addCell(formatter.format(person.getDate_ajout()));
            pdfTable.addCell(person.getEtat_produit().name());
            
            pdfTable.addCell(Float.toString(person.getPrix()));
           
            pdfTable.addCell(person.getCategorie().getTitre());
            pdfTable.addCell(person.getUser().getNom());
            
            
            
           
        }
    }*/