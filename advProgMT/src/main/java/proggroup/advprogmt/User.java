package proggroup.advprogmt;

import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class User {
//    (Username(ID),Password,Type,FirstName,LastName,Address,CellPhone,Email,isBlocked).
    public static String userName;
    public String password;
    public static String type;
    public String firstName;
    public String lastName;
    public String address;
    public int cellPhone;
    public String email;
    static BufferedReader brv;
    static String temp;
    static boolean isBlocked = false;
    public User(){

    };
    public User(String Username,String Password,String Type,String FirstName,String LastName,String Address,int CellPhone,String Email){
        this.userName=Username;
        this.password=Password;
        this.type=type;
        this.firstName=FirstName;
        this.lastName=LastName;
        this.address=Address;
        this.cellPhone=CellPhone;
        this.email=Email;
    }

    public static boolean validate(TextField username, PasswordField password,TextField passShown , Label msg){
        if (!onClick(username,password,passShown,msg)){
            return false;
        }
        boolean matches = false;
        try {
            brv = new BufferedReader(new FileReader("src/main/java/proggroup/advprogmt/Database/Users.txt"));
            while ((temp = brv.readLine())!= null){
                if (username.getText().equals(temp.split(",")[0])){
                    if (password.getText().equals(temp.split(",")[1])) {
                        isBlocked = temp.split(",")[8].equals("true");
                        matches = true;
                        type = temp.split(",")[2];
                        userName = temp.split(",")[0];
                        break;
                    }else {
                        msg.setText("Wrong Credentials");
                        msg.setStyle("-fx-text-fill:red");
                    }
                        username.clear();
                        passShown.clear();
                        password.clear();
                } else {
                    msg.setText("Wrong Credentials");
                    msg.setStyle("-fx-text-fill:red");
                }
            }
            brv.close();
        } catch (IOException e) {
        }
        return matches;
    }

    public static boolean onClick(TextField username, PasswordField password,TextField passShown , Label msg) {
        if (password.getText().isEmpty())
            password.setText(passShown.getText());
        if (username.getText().isEmpty() && password.getText().isEmpty()) {
            msg.setText("Please enter your Username & Password");
            msg.setStyle("-fx-text-fill:red");
            return false;
        } else if (username.getText().isEmpty()) {
            msg.setText("Please enter your Username");
            msg.setStyle("-fx-text-fill:red");
            return false;
        } else if (password.getText().isEmpty() && passShown.getText().isEmpty()) {
            msg.setText("Please enter your Password");
            msg.setStyle("-fx-text-fill:red");
            return false;
        }
            return true;
//        else if (!(username.getText().isEmpty() && password.getText().isEmpty() && passShown.getText().isEmpty())) {
//
//            valid(username, password, msg);
//
//            passShown.clear();
//            password.clear();
//        }
    }


//    public String getUserData() {
//        return Username + "," + Password + "," + Type + "," + FirstName + "," + LastName + "," + Address + "," + CellPhone + "," + Email + "," + isBlocked;
//    }
}
