package proggroup.advprogmt;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.input.KeyCode;

public class Login{
    Scene loginScene;
    VBox box1 = new VBox();
    Label label1 = new Label("Username");
    TextField textField1 = new TextField();
    Label label2 = new Label("Password");
    PasswordField passField = new PasswordField();
    TextField passShown = new TextField();
    Button showPass = new Button();
    ImageView hideIco = new ImageView(new Image(Home.class.getResourceAsStream("eye-slash.png")));
    ImageView showIco = new ImageView(new Image(Home.class.getResourceAsStream("eye.png")));
    Label label3 = new Label();
    Button loginBtn = new Button("Login");

    public void Login (){
        label1.setStyle("-fx-font-weight:bold");
        textField1.setPromptText("Enter Your Username");
        textField1.setStyle("-fx-background-radius:15");
        textField1.setOnKeyPressed(e -> {
            if (e.getCode().equals(KeyCode.ENTER))
                passField.requestFocus();
        });

        label2.setStyle("-fx-font-weight:bold");
        passField.setPromptText("Enter Your Password");
        passField.setStyle("-fx-background-radius:15");
        passShown.setPromptText("Enter Your Password");
        passShown.setStyle("-fx-background-radius:15");
        passShown.setTranslateY(-35);
        passShown.setVisible(false);
        passField.setOnKeyPressed(e -> {
            if (e.getCode().equals(KeyCode.ENTER)) {
                loginBtn.fire();
                loginBtn.requestFocus();
            }
        });
        passShown.setOnKeyPressed(e -> {
            if (e.getCode().equals(KeyCode.ENTER)) {
                loginBtn.fire();
                loginBtn.requestFocus();
            }
        });

        hideIco.setFitHeight(15);
        showIco.setFitHeight(15);
        hideIco.setPreserveRatio(true);
        showIco.setPreserveRatio(true);
        showPass.setGraphic(hideIco);
        showPass.setStyle("-fx-background-color:transparent;-fx-cursor:hand");
        showPass.setTranslateX(225);
        showPass.setTranslateY(-35);
        showPass.setOnAction(e -> showPass());

        label3.setWrapText(true);
        loginBtn.setPadding(new Insets(10,40,10,40));
        loginBtn.setStyle("-fx-background-radius:7;-fx-focus-color:transparent;-fx-faint-focus-color:transparent;-fx-cursor:hand");
        loginBtn.setTranslateX(80);

        box1.setPadding(new Insets(50,120,30,120));
        box1.getChildren().addAll(label1,textField1,label2,passField,passShown,showPass,label3,loginBtn);
        box1.setSpacing(10);
        box1.setStyle("-fx-background-color:lightgrey;");

        VBox.setMargin(showPass,new Insets(0,0,-35,0));
        VBox.setMargin(passShown,new Insets(0,0,-35,0));

        loginScene = new Scene(box1,500,300);
// box1.setStyle("-fx-background-image:url('https://wallpaperaccess.com/full/4907599.jpg');-fx-background-repeat: no-repeat;-fx-background-size: 500 300;-fx-background-position: center;");
    }
    public void showPass(){
        if(showPass.getGraphic()==hideIco){
            showPass.setGraphic(showIco);
            passShown.setText(passField.getText());
            passShown.setVisible(true);
            passField.setVisible(false);
        }else {
            showPass.setGraphic(hideIco);
            passField.setText(passShown.getText());
            passField.setVisible(true);
            passShown.setVisible(false);
        };
    }
//    public void logIn(){
//        onClick(LoginWindow.textField1, LoginWindow.passField, LoginWindow.passShown, LoginWindow.label3);
//        if(Login.UserIsAuth) {
//            MainStage.setTitle("Library System - Home - " + Validation.Type + ": " + Validation.Username);
//            label3.setText("");
//            new Alert().display("Welcome "+Validation.Type,"Login Successful!","green");
//            MainStage.setScene(HomeWindow.homeScene);
//            HomeWindow.checkType();
//        }
//    }
//    public void logOut(){
//        MainStage.setTitle("Library System - Login");
//        MainStage.setScene(LoginWindow.loginScene);
//        Login.UserIsAuth =false;
//        loginBtn.setOnAction(event -> logIn());
//        showPass.setGraphic(hideIco);
//        HomeWindow.searchbar.clear();
//        HomeWindow.bp.setCenter(null);
//        HomeWindow.type.setValue("Book");
//    }
}


