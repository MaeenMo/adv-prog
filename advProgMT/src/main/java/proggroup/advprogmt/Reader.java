package proggroup.advprogmt;

import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class Reader extends User{

    public Reader(String Username,String Password,String Type,String FirstName,String LastName,String Address,int CellPhone,String Email,boolean isBlocked){
        super(Username,Password,Type,FirstName,LastName,Address,CellPhone,Email);
        this.isBlocked=isBlocked;
    }

    public static boolean validate(Label msg){
        if (isBlocked) {
            msg.setText("This user is blocked. Please contact the library for more information.");
            msg.setStyle("-fx-text-fill:red");
            return false;
        }
        return true;
    }
}
