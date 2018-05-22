package Test2.Controller;

import Test2.User;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

/*
Controller for main.fxml file.
it has storage for user represented by list of users, hes purpose is not to safe data
when application is not running, but contains a several user when it running.
This window has table where all user from list are showing, a four button for add new user
do action for selected user, make user paid and the button that simulates a next day
 */

public class Controller implements Initializable {
    //list to store user during the running of the program
    private static List<User> userList = new ArrayList<>();
    //at the start add two default users
    static {userList.add(new User("oleg", false));
        userList.add(new User("roma", true));}

    @FXML
    private TableView<User> userTable;
    @FXML
    private TableColumn<User, Integer> idColumn;
    @FXML
    private TableColumn<User, String> nameColumn;
    @FXML
    private TableColumn<User, Integer> levelColumn;
    @FXML
    private TableColumn<User, Integer> experienceColumn;
    @FXML
    private TableColumn<User, Integer> APDColumn;
    @FXML
    private TableColumn<User, Integer> paidDaysColumn;

    // method that run automatically at the start and fill up the table with users from userList
    @Override
    public void initialize(URL location, ResourceBundle resources) {

        idColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("userName"));
        levelColumn.setCellValueFactory(new PropertyValueFactory<>("level"));
        experienceColumn.setCellValueFactory(new PropertyValueFactory<>("experience"));
        APDColumn.setCellValueFactory(new PropertyValueFactory<>("actionPerDay"));
        paidDaysColumn.setCellValueFactory(new PropertyValueFactory<>("paidDays"));

        ObservableList<User> allUser = FXCollections.observableArrayList(userList);
        userTable.setItems(allUser);
    }

    //method that displayed "add new user" window, and when its closed refresh the table
    @FXML
    public void addUser(javafx.event.ActionEvent actionEvent){
        try{
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/addUser.fxml"));
            Parent root = fxmlLoader.load();
            Stage stage = new Stage();
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setTitle("Add new User2");
            stage.setScene(new Scene(root));
            stage.show();
            stage.setOnHiding((WindowEvent we) ->{

                ObservableList<User> allUser = FXCollections.observableArrayList(userList);
                userTable.setItems(allUser);
            });
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    //do action for selected user then refresh table, if no user is selected show warning message
    @FXML
    public void doAction(javafx.event.ActionEvent actionEvent){
        User user = userTable.getSelectionModel().getSelectedItem();
        if(user != null){
            user.doAction();
            ObservableList<User> allUser = FXCollections.observableArrayList(userList);
            userTable.setItems(allUser);
            userTable.refresh();
        }else{
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Error");
            alert.setContentText("No User2 has been selected!");
            alert.showAndWait();
        }
    }

    //make user paid the refresh the table, if no user is selected show warning message
    @FXML
    public void makePaid(javafx.event.ActionEvent actionEvent){
        User user = userTable.getSelectionModel().getSelectedItem();
        if(user != null){
            user.setPaid(true);
            ObservableList<User> allUser = FXCollections.observableArrayList(userList);
            userTable.setItems(allUser);
            userTable.refresh();
        }else{
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Error");
            alert.setContentText("No User2 has been selected!");
            alert.showAndWait();
        }
    }

    // simulates a next day for all users (method nextDay reset action per day and decrease paid days if user is paid)
    //and refresh the table
    @FXML
    public void nextDay(javafx.event.ActionEvent actionEvent) {
        for (User anUserList : userList) {
            anUserList.nextDay();
        }
        ObservableList<User> allUser = FXCollections.observableArrayList(userList);
        userTable.setItems(allUser);
        userTable.refresh();
    }

    // add new user to list
    static void addToUsers(User user){
        userList.add(user);
    }
}
