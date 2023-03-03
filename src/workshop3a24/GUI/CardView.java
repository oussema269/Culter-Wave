/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package workshop3a24.GUI;

/**
 *
 * @author dell
 */

import java.text.SimpleDateFormat;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import workshop3a24.Entities.Formation;
import workshop3a24.Entities.Participationformation;
import workshop3a24.Services.ServiceParticipationformation;

public class CardView extends Pane {
      
      private static final int WIDTH = 400;
    private static final int HEIGHT = 300;
    private static final String BACKGROUND_COLOR = "#e9ebf0";
    private static final String BORDER_COLOR = "#566588";
    private static final String TEXT_COLOR = "#2596be";
    private static final String TITLE_COLOR = "#F4F6F7";
    private static final String DATE_COLOR = "#2596be";
    private static final String TYPE_COLOR = "#2596be";

    private Formation formation;
         Participationformation patriceba =new Participationformation();
       ServiceParticipationformation spf=new ServiceParticipationformation();

    public CardView(Formation formation) {
    
        this.formation = formation;

        setPrefSize(WIDTH, HEIGHT);
        setBackground(new Background(new BackgroundFill(Color.web(BACKGROUND_COLOR), new CornerRadii(10), Insets.EMPTY)));
        setBorder(new Border(new BorderStroke(Color.web(BORDER_COLOR), BorderStrokeStyle.SOLID, new CornerRadii(10), new BorderWidths(1))));
        //Creating a Button
      Button button = new Button();
      //Setting text to the button
      button.setText("envoie demande de participation");
      //Setting the location of the button
    button.setPrefWidth(250);
      button.setTranslateY(200);
      button.setTranslateX(50);

        Label titleLabel = new Label(formation.getTitre());
        titleLabel.setFont(Font.font("Arial", 18));
       
        titleLabel.setTextFill(Color.web(TITLE_COLOR));
        titleLabel.setAlignment(Pos.CENTER);
        titleLabel.setPrefWidth(WIDTH - 20);
        titleLabel.setLayoutY(20);
        
titleLabel.setStyle("-fx-background-color: #c86c34;");
        Label descriptionLabel = new Label("Description: " + formation.getDescription());
        descriptionLabel.setFont(Font.font("Arial", 14));
        descriptionLabel.setTextFill(Color.web(TEXT_COLOR));
        descriptionLabel.setWrapText(true);
        descriptionLabel.setPrefWidth(WIDTH - 40);
        descriptionLabel.setAlignment(Pos.CENTER);
        descriptionLabel.setLayoutY(50);

        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        String debutDateStr = dateFormat.format(formation.getDebut());
        String finDateStr = dateFormat.format(formation.getFin());
        Label dateLabel = new Label("Date de debut :"+debutDateStr + " -  Date de fin :" + finDateStr);
        dateLabel.setFont(Font.font("Arial", 14));
        dateLabel.setTextFill(Color.web(DATE_COLOR));
        dateLabel.setWrapText(true);
        dateLabel.setAlignment(Pos.CENTER);
        dateLabel.setPrefWidth(WIDTH - 40);
        dateLabel.setLayoutY(120);

        Label paysLabel = new Label("Pays: " + formation.getPays()+"Type"+formation.getType());
        paysLabel.setFont(Font.font("Arial", 14));
        paysLabel.setTextFill(Color.web(TEXT_COLOR));
        paysLabel.setWrapText(true);
        paysLabel.setAlignment(Pos.CENTER);
        paysLabel.setPrefWidth(WIDTH - 40);
        paysLabel.setLayoutY(75);

       /* Label typeLabel = new Label("Type:"+formation.getType());
        typeLabel.setFont(Font.font("Arial", 14));
        typeLabel.setTextFill(Color.web(TYPE_COLOR));
        typeLabel.setWrapText(true);
        typeLabel.setPrefWidth(WIDTH - 40);
        typeLabel.setLayoutY(90);*/

        BorderPane borderPane = new BorderPane();
        borderPane.setPadding(new Insets(10, 10, 0, 10));
      //     borderPane.setBorder(new Insets(10, 10, 0, 10));
        borderPane.setTop(titleLabel);
        borderPane.setCenter(descriptionLabel);
        borderPane.setBottom(new Pane(dateLabel, paysLabel,button));
        //typeLabel

        getChildren().addAll(borderPane);
       
    
    button.setOnAction(event->{
        patriceba.setIdFormation(formation.getId());
        patriceba.setIdUser(formation.getOwnerid());
    spf.add(patriceba);
     Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Your demand sent");

        alert.setHeaderText(" Partcipation");
        alert.setContentText("Your demand sent");

        alert.showAndWait();
    
    
    });
    
    
    }
}


