package proggroup.advprogmt;

import javafx.scene.control.ChoiceBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Librarian extends User{
    public Librarian(String Username,String Password,String Type,String FirstName,String LastName,String Address,int CellPhone,String Email){
        super(Username,Password,Type,FirstName,LastName,Address,CellPhone,Email);
    }
    public void addUser(TextField username, TextField password, ChoiceBox type, TextField firstname, TextField lastname,TextField address , TextField cellphone, TextField email){
        BufferedWriter bw;
        {
            try {
                bw = new BufferedWriter(new FileWriter("src/main/resources/proggroup/advprogmt/Users.txt",true));
                bw.write(username + "," + password + "," + type + "," + firstname + "," + lastname + "," + address+ "," + cellphone + "," + email + "," + false);
                bw.newLine();
                bw.flush();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
    public void removeUser(){

    }
}
