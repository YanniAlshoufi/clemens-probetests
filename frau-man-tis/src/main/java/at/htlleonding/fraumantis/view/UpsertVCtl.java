package at.htlleonding.fraumantis.view;

import at.htlleonding.fraumantis.controller.AppController;
import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;

public class UpsertVCtl {

    @FXML
    private TextField mStartTime;
    @FXML
    private TextField mEndTime;
    @FXML
    private CheckBox mIsDone;

    public void initialize() {

        boolean isSelected = AppVMetaData.getInstance().isSelected();

        if(!isSelected) {
            mIsDone.setVisible(false);
        }
    }
}
