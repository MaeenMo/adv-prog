package proggroup.advprogmt;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class Alert {

    public void display(String title,String message, String color){
        Stage alertStage = new Stage();
        alertStage.initModality(Modality.APPLICATION_MODAL);

        alertStage.setTitle(title);
        alertStage.getIcons().add(new Image(Login.class.getResourceAsStream("online-library.png")));

        Label msg = new Label();
        msg.setText(message);
        msg.setStyle("-fx-font-weight:bold;-fx-text-fill:"+ color);

        Button ok = new Button("OK");
        ok.setStyle("-fx-background-radius:7;-fx-focus-color:transparent;-fx-faint-focus-color:transparent;-fx-cursor:hand");
        ok.setPadding(new Insets(10,20,10,20));
        ok.setOnAction(e -> alertStage.close());

        VBox Vbox1= new VBox();
        Vbox1.getChildren().addAll(msg,ok);
        Vbox1.setAlignment(Pos.CENTER);
        Vbox1.setSpacing(10);

        Scene alert = new Scene(Vbox1,250,100);

        alertStage.setResizable(false);
        alertStage.setScene(alert);
        alertStage.showAndWait();
    }
}
