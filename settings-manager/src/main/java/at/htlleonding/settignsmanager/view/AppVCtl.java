package at.htlleonding.settignsmanager.view;

import at.htlleonding.settignsmanager.controller.AppController;
import at.htlleonding.settignsmanager.domain.models.Property;
import at.htlleonding.settignsmanager.domain.models.Setting;
import at.htlleonding.settignsmanager.domain.repositories.AppRepository;
import at.htlleonding.settignsmanager.view.exceptions.NothingIsSelectedException;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;

public class AppVCtl {
    @FXML
    private ListView<Setting> mSettings = new ListView<>();

    @FXML
    private TableColumn<Property, String> mName;

    @FXML
    private TableColumn<Property, String> mValue;

    @FXML
    private TableView<Property> mPropertiesTableView;

    public void initialize() {
        mPropertiesTableView.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY_FLEX_NEXT_COLUMN);

        mName.setCellValueFactory(new PropertyValueFactory<Property, String>("name"));
        mValue.setCellValueFactory(new PropertyValueFactory<Property, String>("value"));



        mSettings.setItems(AppRepository.getInstance().getSettings());
    }

    @FXML
    private void onSettingClick() {

        Setting setting = mSettings.getSelectionModel().getSelectedItem();

        if(setting == null) {
            AppController.getInstance().handleException(new NothingIsSelectedException("Nothing is selected"));
            return;
        }

        ObservableList<Property> properties = setting.getPropertyList();

        mPropertiesTableView.setItems(properties);
    }

    @FXML
    private void onOpenEditViewClick(ActionEvent actionEvent) throws IOException {
        Setting setting = mSettings.getSelectionModel().getSelectedItem();

        if(setting == null) {
            AppController.getInstance().handleException(new NothingIsSelectedException("Nothing is selected"));
            return;
        }

        Stage stage = ViewHelper.getStage(actionEvent);
        ViewHelper.showView(new Stage(), ViewId.EDIT_PROPERTY_VIEW, stage);

    }
}