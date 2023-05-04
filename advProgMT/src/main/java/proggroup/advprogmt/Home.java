package proggroup.advprogmt;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;

import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;

public class Home{
    ControlPanel controlPanel = new ControlPanel();
    Stage cp = new Stage();
    Alert alert = new Alert();
    Scene homeScene;
    BorderPane bp = new BorderPane();
    HBox topMenu = new HBox();
    HBox body = new HBox();
//    VBox body = new VBox();
//    ListView<String> listView = new ListView<>();
    TextField searchbar = new TextField();
    Button searchBtn = new Button("Search");
    Button ctrlPanel = new Button();
    Tooltip toolTip1 = new Tooltip("Control Panel");
    Button logOut = new Button();
    Tooltip toolTip2 = new Tooltip("LogOut");
    ComboBox<String> type;
    ImageView icon1 = new ImageView(new Image(Home.class.getResourceAsStream("settings.png")));
    ImageView icon2 = new ImageView(new Image(Home.class.getResourceAsStream("exit.png")));
    Label text = new Label();
    static boolean ctrlPanel_opened = true;
//    static Button rent = new Button("Rent");
    Search search = new Search();
    public void Home(){
        searchbar.setPromptText("Search");
        searchbar.setMinWidth(240);
        searchbar.setStyle("-fx-focus-color:grey;");

        searchBtn.setStyle("-fx-focus-color:transparent;-fx-faint-focus-color:transparent;-fx-cursor:hand;");
        searchBtn.setOnAction(e -> {

            search.searchfor(searchbar.getText(), type.getValue());
            bp.setCenter(null);
            if (search.i==0) {
                searchedBooks();
//                bp.setLeft(null);
            }else {
                bp.setCenter(null);
                System.out.println(search.result +"from home");
                text.setText(search.result);
                bp.setCenter(body);
//                bp.setCenter(null);
            }
//            text.setText(search.booksArr[search.i]);
        });
        searchbar.setOnKeyPressed(e -> {
            if (e.getCode().equals(KeyCode.ENTER)) {
                searchBtn.fire();
                searchBtn.requestFocus();
            }
        });

        type = new ComboBox<>();
        type.getItems().addAll("Book","User");
        type.setValue("Book");
        type.setTranslateX(12);
        type.setStyle("-fx-focus-color:transparent;-fx-faint-focus-color:transparent");

        icon1.setFitHeight(20);
        icon1.setPreserveRatio(true);
        ctrlPanel.setGraphic(icon1);
        ctrlPanel.setStyle("-fx-background-color:transparent;-fx-cursor:hand");
        ctrlPanel.setTranslateX(28);
        ctrlPanel.setTooltip(toolTip1);
        toolTip1.setStyle("-fx-show-delay:1ms");
        ctrlPanel.setOnAction(e -> {
            if (!ctrlPanel_opened){
                ctrlStage();
                Home.ctrlPanel_opened = true;
            }else alert.display("Error","Control Panel is already opened!","red");
        });
        cp.setOnCloseRequest(event -> {
            System.out.println("Stage is closing");
            controlPanel.root.getChildren().clear();git stas
            Home.ctrlPanel_opened = false;
        });

        icon2.setFitHeight(20);
        icon2.setPreserveRatio(true);
        logOut.setGraphic(icon2);
        logOut.setStyle("-fx-background-color:transparent;-fx-cursor:hand");
        logOut.setTranslateX(36);
        logOut.setTooltip(toolTip2);
        toolTip2.setStyle("-fx-show-delay:1ms");

        topMenu.setPadding(new Insets(20,20,20,20));
        topMenu.setSpacing(0);
        topMenu.setStyle("-fx-background-color:lightgrey");
        topMenu.getChildren().addAll(searchbar,searchBtn,type,ctrlPanel,logOut);


        text.setStyle("-fx-font-size:16");
        body.getChildren().addAll(text);
        body.setAlignment(Pos.TOP_CENTER);
//        rent.setStyle("-fx-background-radius:7;-fx-focus-color:transparent;-fx-faint-focus-color:transparent;-fx-background-color:limegreen;-fx-cursor:hand;");
//        rent.setPadding(new Insets(5,40,5,40));

//        String [] arr = new String[]{"a", "b", "c","d","d","d","d","d","d","d","d","d","d","d","d","d","d","d","d"};

//        listView.setPadding(new Insets(20,80,20,80));
//        listView.getItems().addAll(arr);

        bp.setTop(topMenu);

        homeScene = new Scene(bp,500,300);
    }
    public void checkType(){
        ctrlPanel.setVisible(!User.type.equals("Reader"));
    }

    public void ctrlStage(){
        controlPanel.start(cp);
        ctrlPanel_opened = true;
    }

    /////////////////////////////////////////////////////////////////////////////////////////////

    public static class HBoxCell extends HBox {
//        Label label = new Label();
//        Button button = new Button();
        Label text = new Label();
        Button rent = new Button("Rent");

        HBoxCell(String labelText, String buttonText) {
            super();
            text.setStyle("-fx-font-size:16");
            text.setText(labelText);
            text.setMaxWidth(Double.MAX_VALUE);
            HBox.setHgrow(text, Priority.ALWAYS);

            rent.setText(buttonText);
            rent.setStyle("-fx-background-radius:7;-fx-focus-color:transparent;-fx-faint-focus-color:transparent;-fx-background-color:limegreen;-fx-cursor:hand;");
            rent.setPadding(new Insets(5,40,5,40));
            this.getChildren().addAll(text, rent);
        }
    }

    public void searchedBooks() {
        ArrayList<HBoxCell> list = new ArrayList<>();

        for (String i: search.booksArr) {
            if (i!= null) {
                System.out.println("element "+ i + " added");
                list.add(new HBoxCell(i, "Rent"));
            }
        }

        ListView<HBoxCell> listView = new ListView<>();
        ObservableList<HBoxCell> myObservableList = FXCollections.observableList(list);
        listView.setItems(myObservableList);
        bp.setCenter(listView);
    }

    public void searchedUsers() {
        ArrayList<HBoxCell> list = new ArrayList<>();

//        for (String i: search.booksArr) {
//            if (i!= null) {
//                System.out.println("element "+ i + " added");
//                list.add(new HBoxCell(i, "Rent"));
//            }
//        }

        ListView<HBoxCell> listView = new ListView<>();
        ObservableList<HBoxCell> myObservableList = FXCollections.observableList(list);
        listView.setItems(myObservableList);
        bp.setCenter(listView);
    }

    ///////////////////////////////////////////////////////////////////////////////////
}
