package Test2;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/*
Для реалізації другого завдання було реалізовано класс User у файлі User.java,
і для демонстрації роботи його алгоритму, написана невелика демо програма,
яка виконна з допомогою javafx і загрузка якої починається із цього файлу.
 */


public class Main extends Application {

    public static void main(String[] args) {
        launch();
    }


    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/main.fxml"));
        primaryStage.setTitle("Users");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }
}
