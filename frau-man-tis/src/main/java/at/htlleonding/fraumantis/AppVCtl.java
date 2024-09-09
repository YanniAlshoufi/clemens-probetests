package at.htlleonding.fraumantis;

import at.htlleonding.fraumantis.model.FmtUser;
import at.htlleonding.fraumantis.model.FmtUsersRepository;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;

import java.util.Arrays;

public class AppVCtl {
    @FXML
    private ComboBox<FmtUser> userNameCombo;

    public void initialize() {
        userNameCombo.getItems().setAll(FmtUsersRepository.getUsers());
    }

    public void onUserSelected() {
        var user = userNameCombo.getSelectionModel().getSelectedItem();
        System.out.println(user);
    }
}