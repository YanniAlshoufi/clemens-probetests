package at.htlleonding.settignsmanager.view;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class AppView {
    public void initialize(Stage stage) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(AppView.class.getResource("app-view.fxml"));
            Scene scene = new Scene(fxmlLoader.load(), 600, 500); // TODO handle this error
            stage.setTitle("Hello!");
            stage.setScene(scene);
            stage.show();
        } catch(Exception e) {

        }
    }
}
