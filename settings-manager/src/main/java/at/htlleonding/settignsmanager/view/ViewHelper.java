package at.htlleonding.settignsmanager.view;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;

public class ViewHelper {

    public static void showView(Stage stage, ViewId viewId, Stage parentStage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(AppView.class.getResource(viewId.getFileName()));
        Scene scene = new Scene(fxmlLoader.load(), viewId.getHeight(), viewId.getWidth());

        if(parentStage != null) {
            stage.initModality(Modality.WINDOW_MODAL);
            stage.initOwner(parentStage);
        }

        stage.setTitle(viewId.getTitle());
        stage.setScene(scene);
        stage.show();
    }

    public static Stage getStage(ActionEvent actionEvent) {
        Node source = (Node) actionEvent.getSource();
        return (Stage) source.getScene().getWindow();
    }
}
