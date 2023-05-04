package proggroup.advprogmt;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.util.ArrayList;

public class Reader extends User{

    public Reader(String Username,String Password,String Type,String FirstName,String LastName,String Address,int CellPhone,String Email,boolean isBlocked){
        super(Username,Password,Type,FirstName,LastName,Address,CellPhone,Email);
        this.isBlocked=isBlocked;
    }
    public Reader(){

    }

    public static boolean validate(Label msg){
        if (isBlocked) {
            msg.setText("This user is blocked. Please contact the library for more information.");
            msg.setStyle("-fx-text-fill:red");
            return false;
        }
        return true;
    }
    public ListView<Home.HBoxCell> searchBooks(){
        ArrayList<Home.HBoxCell> list = new ArrayList<>();
        for (String i: search.booksArr) {
            if (i!= null) {
                System.out.println("element "+ i + " added");
                list.add(new Home.HBoxCell(i, "Rent","limegreen"));

            }
        }
        ListView<Home.HBoxCell> listView = new ListView<>();
        ObservableList<Home.HBoxCell> myObservableList = FXCollections.observableList(list);
        listView.setItems(myObservableList);
        return listView;
    }
}
