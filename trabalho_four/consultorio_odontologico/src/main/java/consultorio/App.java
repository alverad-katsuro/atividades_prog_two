package consultorio;

import javafx.application.Application;
import javafx.stage.Stage;
/*
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
*/
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.fxml.FXMLLoader;

public class App extends Application {
    
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        FXMLLoader fxmlloader = new FXMLLoader(getClass().getResource("login.fxml"));
        Parent root = fxmlloader.load();
        Scene tela = new Scene(root);

        primaryStage.setTitle("Teste");
        primaryStage.setScene(tela);
        primaryStage.show();
        
    }
    
}
