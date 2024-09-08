package at.htlleonding.settignsmanager.view;

import javafx.fxml.FXML;
import javafx.scene.control.TableView;

public class AppVCtl {
    @FXML
    private TableView<??????> propertiesTableView;

    public void initialize() {
        propertiesTableView.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY_FLEX_NEXT_COLUMN);
    }
}