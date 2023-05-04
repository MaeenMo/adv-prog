package proggroup.advprogmt;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ListView;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Librarian extends User{
    public Librarian(String Username,String Password,String Type,String FirstName,String LastName,String Address,int CellPhone,String Email){
        super(Username,Password,Type,FirstName,LastName,Address,CellPhone,Email);
    }

    public Librarian() {

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
    public ListView<Home.HBoxCell> searchUsers(){
        ArrayList<Home.HBoxCell> list = new ArrayList<>();
        for (String i: Search.usersArr) {
            if (i!= null) {
                System.out.println("user "+ i + " added");
                list.add(new Home.HBoxCell(i, "remove","red","","","Librarian"));
            }
        }
        ListView<Home.HBoxCell> listView = new ListView<>();
        ObservableList<Home.HBoxCell> myObservableList = FXCollections.observableList(list);
        listView.setItems(myObservableList);
        return listView;
    }
    public ListView<Home.HBoxCell> searchBooks(){
        ArrayList<Home.HBoxCell> list = new ArrayList<>();
        for (String i: search.booksArr) {
            if (i!= null) {
                System.out.println("element "+ i + " added");
                list.add(new Home.HBoxCell(i, "Rent","limegreen","Remove","crimson","Librarian"));
            }
        }
        ListView<Home.HBoxCell> listView = new ListView<>();
        ObservableList<Home.HBoxCell> myObservableList = FXCollections.observableList(list);
        listView.setItems(myObservableList);

        listView.setStyle("-fx-background-radius:0;-fx-focus-color:transparent;-fx-faint-focus-color:transparent;-fx-background-color:black;-fx-cell;-fx-cursor:hand;");
        return listView;
    }
}
