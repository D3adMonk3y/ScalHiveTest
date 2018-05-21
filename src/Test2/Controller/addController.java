package Test2.Controller;

import Test2.User;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.regex.Pattern;

/*
Controller for addUser.fxml file
the window have text field where must be type name for user
a checkbox that says if user is paid or free
and another textfield where we can put a different numbers of paid days
 */

public class addController implements Initializable {

    @FXML
    private TextField userName;
    @FXML
    private CheckBox isPaid;
    @FXML
    private TextField userPaidDays;
    @FXML
    private Button createBtn;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        userPaidDays.setText("0");
        userPaidDays.setDisable(true);
    }

    //if paid checkbox is selected the textfield with paid days is set enable and in him put default value of 30
    @FXML
    public void isPaid(javafx.event.ActionEvent actionEvent){
        if(isPaid.isSelected()){
            userPaidDays.setDisable(false);
            userPaidDays.setText("30");
        }else{
            // if paid checkbox is unselected then paid days textfield disabled and its default value set to 0
            userPaidDays.setDisable(true);
            userPaidDays.setText("0");
        }
    }

    //this method is called when a button create is pressed
    @FXML
    public void createUser(javafx.event.ActionEvent actionEvent){

        //create a regular expression for name text field
        String nameRegex = "^[a-zA-Z_0-9\\-.]*$";
        Pattern namePattern = Pattern.compile(nameRegex);

        //create regular expression for userPaidDays text field
        String paidDaysRegex = "^[0-9]*?";
        Pattern paidDaysPattern = Pattern.compile(paidDaysRegex);

        //checks if the name of new user is satisfies the conditions that it is not empty and consists only with "[a-z][A-Z][0-9]-._"
        if(!userName.getText().equals("") && namePattern.matcher(userName.getText()).matches()) {
            User user = new User(userName.getText(), isPaid.isSelected());
            if(isPaid.isSelected()){
                //checks if userPaidDays text field matches regular expression
                if(paidDaysPattern.matcher(userPaidDays.getText()).matches())
                    user.setPaidDays(Integer.parseInt(userPaidDays.getText()));
                else{
                    //if text filed is not satisfies the conditions  then alert dialog is displayed
                    Alert alert = new Alert(Alert.AlertType.WARNING);
                    alert.setTitle("Error");
                    alert.setContentText("User paid days text field must be fill up only with number.");
                    alert.showAndWait();
                }
            }
            Controller.addToUsers(user);
            Stage stage = (Stage)createBtn.getScene().getWindow();
            stage.close();
        }else{

            //if text filed is not satisfies the conditions  then alert dialog is displayed
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Error");
            alert.setContentText("User name can only be english letters numbers and '.', '_', '-'\n" +
                    "and can't be empty.");
            alert.showAndWait();

        }
    }
}
