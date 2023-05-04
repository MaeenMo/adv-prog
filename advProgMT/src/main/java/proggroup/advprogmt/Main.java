package proggroup.advprogmt;

import javafx.application.Application;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class Main extends Application {
    Stage MainStage;
    Login LoginWindow = new Login();
    Home HomeWindow = new Home();
    @Override
    public void start(Stage mainStage){
        MainStage=mainStage;

        LoginWindow.Login();
        HomeWindow.Home();

        mainSetup();
        mainStage.show();
    }
    public void mainSetup(){
        MainStage.setTitle("Library System - Login");

        MainStage.setResizable(false);
        MainStage.getIcons().add(new Image(Login.class.getResourceAsStream("online-library.png")));

        MainStage.setScene(LoginWindow.loginScene);
        LoginWindow.loginBtn.setOnAction(e -> logIn());
        HomeWindow.logOut.setOnAction(e -> logOut());
        LoginWindow.showPass.setGraphic(LoginWindow.hideIco);
    }
    public void logIn(){
        if(User.validate(LoginWindow.textField1, LoginWindow.passField, LoginWindow.passShown, LoginWindow.label3)) {
            if(User.type.equals("Reader")){
                if (!Reader.validate(LoginWindow.label3)){
                    logOut();
                }else homeScreen();
            } else if (User.type.equals("Librarian")) {
                homeScreen();
                HomeWindow.ctrlStage();
            };
        }
    }
    public void homeScreen(){
        MainStage.setTitle("Library System - Home - " + User.type + ": " + User.userName);
        LoginWindow.label3.setText("");
        new Alert().display("Welcome "+User.type,"Login Successful!","green");
        MainStage.setScene(HomeWindow.homeScene);
        HomeWindow.checkType();
    }

    public void logOut(){
        mainSetup();
        LoginWindow.textField1.clear();
        LoginWindow.passField.clear();
        HomeWindow.searchbar.clear();
        HomeWindow.bp.setCenter(null);
        HomeWindow.type.setValue("Book");
    }
}