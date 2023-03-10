package workshop3a24.GUI;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import javafx.embed.swing.SwingFXUtils;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.layout.Pane;

/**
 * FXML Controller class
 */
public class Qr_codrController implements Initializable {

    @FXML
    private ImageView imgqrcode;

    /**
     * Initializes the controller class.
     */
    
    
    private static String encodeURIComponent(String s) {
    try {
        return URLEncoder.encode(s, "UTF-8")
                .replaceAll("\\+", "%20")
                .replaceAll("\\%21", "!")
                .replaceAll("\\%27", "'")
                .replaceAll("\\%28", "(")
                .replaceAll("\\%29", ")")
                .replaceAll("\\%26", "&")
                .replaceAll("\\%3D", "=")
                .replaceAll("\\%7E", "~");
    } catch (UnsupportedEncodingException e) {
        e.printStackTrace();
        return s;
    }
}
    @Override
    public void initialize(URL url, ResourceBundle rb) { 
        
        
        imgqrcode.setOnMouseClicked(event -> {
            
    String myWeb = "https://www.facebook.com";
    String subject = "visiter notre site "; // Le sujet de l'e-mail
    String body = "Notre site web propose une grande variété d'événements et de formations liés à l'art, la culture,"
            + " la musique, la foire et bien plus encore. Nous avons rassemblé une communauté de "
            + "passionnés qui partagent une passion commune pour la créativité et l'expression artistique."
            + " Nous offrons des cours et des ateliers pour tous les niveaux, du débutant à l'expert,"
            + " ainsi que des événements en direct tels que des concerts, des expositions d'art et des foires "
            + "pour promouvoir les talents locaux et internationaux. Notre objectif est de fournir une plateforme"
            + " pour les artistes émergents et établis afin qu'ils puissent présenter leur travail"
            + " et interagir avec un public engagé et diversifié. Nous sommes convaincus que l'art "
            + "et la culture sont des moyens puissants de "
            + "connecter les gens et de promouvoir un monde plus créatif et harmonieux.\n"+myWeb; // Le corps de l'e-mail

    // Créez un objet URI pour l'adresse e-mail
    URI mailto = URI.create(String.format("mailto:?subject=%s&body=%s", 
            encodeURIComponent(subject), encodeURIComponent(body)));

    // Ouvre l'application de messagerie par défaut
    try {
        Desktop.getDesktop().mail(mailto);
       // Desktop.getDesktop().browse(new URI(myWeb));
    } catch (IOException e) {
        e.printStackTrace();
    }     
});
        
        
         QRCodeWriter qrCodeWriter = new QRCodeWriter();

        String myWeb = "https://www.facebook.com";
       // mettre l'URL du site web que vous voulez générer le code QR ici
        int width = 300;
        int height = 300;

        BufferedImage bufferedImage = null;
        try {
            BitMatrix byteMatrix = qrCodeWriter.encode(myWeb, BarcodeFormat.QR_CODE, width, height);
            bufferedImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
            bufferedImage.createGraphics();

            Graphics2D graphics = (Graphics2D) bufferedImage.getGraphics();
            graphics.setColor(Color.WHITE);
            graphics.fillRect(0, 0, width, height);
            graphics.setColor(Color.BLACK);

            for (int i = 0; i < height; i++) {
                for (int j = 0; j < width; j++) {
                    if (byteMatrix.get(i, j)) {
                        graphics.fillRect(i, j, 1, 1);
                    }
                }
            }

            System.out.println("Success...");

        } catch (WriterException ex) {
            Logger.getLogger(Qr_codrController.class.getName()).log(Level.SEVERE, null, ex);
        }

        ImageView qrView = new ImageView();
        qrView.setImage(SwingFXUtils.toFXImage(bufferedImage, null));
      

   //ImageView qrView = new ImageView();
        imgqrcode.setImage(SwingFXUtils.toFXImage(bufferedImage, null));

    }
        
        
    }

     /*   QRCodeWriter qrCodeWriter = new QRCodeWriter();

        String myWeb = "https://www.facebook.com"; // mettre l'URL du site web que vous voulez générer le code QR ici
        int width = 300;
        int height = 300;

        BufferedImage bufferedImage = null;
        try {
            BitMatrix byteMatrix = qrCodeWriter.encode(myWeb, BarcodeFormat.QR_CODE, width, height);
            bufferedImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
            bufferedImage.createGraphics();

            Graphics2D graphics = (Graphics2D) bufferedImage.getGraphics();
            graphics.setColor(Color.WHITE);
            graphics.fillRect(0, 0, width, height);
            graphics.setColor(Color.BLACK);

            for (int i = 0; i < height; i++) {
                for (int j = 0; j < width; j++) {
                    if (byteMatrix.get(i, j)) {
                        graphics.fillRect(i, j, 1, 1);
                    }
                }
            }

            System.out.println("Success...");

        } catch (WriterException ex) {
            Logger.getLogger(Qr_codrController.class.getName()).log(Level.SEVERE, null, ex);
        }

        ImageView qrView = new ImageView();
        qrView.setImage(SwingFXUtils.toFXImage(bufferedImage, null));
        qrView.setOnMouseClicked(new EventHandler<MouseEvent>() {   

            @Override
            public void handle(MouseEvent event) {
            System.out.println("here ");

                Desktop desktop = Desktop.getDesktop();
String mailto = "mailto:ahmedwajih.benhmida5@gmail.tn?subject=QRCode&body=" + myWeb;
                try {
                    desktop.mail(new URI(mailto));
                } catch (IOException | URISyntaxException e) {
                    e.printStackTrace();
                }
            }
           
        });

   //ImageView qrView = new ImageView();
        imgqrcode.setImage(SwingFXUtils.toFXImage(bufferedImage, null));

    }*/


