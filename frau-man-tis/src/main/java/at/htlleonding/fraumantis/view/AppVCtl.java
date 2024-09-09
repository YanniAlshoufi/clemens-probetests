package at.htlleonding.fraumantis.view;

import at.htlleonding.fraumantis.controller.AppController;
import at.htlleonding.fraumantis.model.FmtTask;
import at.htlleonding.fraumantis.model.FmtTasksRepository;
import at.htlleonding.fraumantis.model.FmtUser;
import at.htlleonding.fraumantis.model.FmtUsersRepository;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;

public class AppVCtl {

    public TableView<FmtTask> mTasks;
    @FXML
    private TableColumn<FmtTask, String> mDescription;
    @FXML
    private TableColumn<FmtTask, Integer> mStartingTime;
    @FXML
    private TableColumn<FmtTask, Integer> mEndTime;
    @FXML
    private TableColumn<FmtTask, Boolean> mIsDone;

    @FXML
    private ComboBox<FmtUser> userNameCombo;

    public void initialize() {
        userNameCombo.getItems().setAll(FmtUsersRepository.getUsers());

        mDescription.setCellValueFactory(new PropertyValueFactory<FmtTask, String>("Description"));
        mStartingTime.setCellValueFactory(new PropertyValueFactory<FmtTask, Integer>("StartingTime"));
        mEndTime.setCellValueFactory(new PropertyValueFactory<FmtTask, Integer>("EndTime"));
        mIsDone.setCellValueFactory(new PropertyValueFactory<FmtTask, Boolean>("IsDone"));
    }

    @FXML
    private void onUserSelected() {
        FmtUser user = userNameCombo.getSelectionModel().getSelectedItem();
        if(user == null) {
            AppController.getInstance().handleException(new AUserHasToBeSelected("You have to selected a user first"));
        }

        ObservableList<FmtTask> tasksOfUser = FmtTasksRepository.getInstance().getFmtTasks();

        String userName = user.getUsername();
        tasksOfUser.filtered(x -> x.getFromWho() == userName);

        mTasks.setItems(tasksOfUser);
        mTasks.refresh();
    }

    @FXML
    private void onRemoveButtonClick(ActionEvent actionEvent) {

        FmtTask fmtTask = mTasks.getSelectionModel().getSelectedItem();

        if(fmtTask == null) {
            AppController.getInstance().handleException(new NothingIsSelectedException("Nothing is selected"));
        }
        else {
            AppController.getInstance().removeTask(fmtTask);
        }
    }


    @FXML
    private void onUpsertButtonClick(ActionEvent actionEvent) throws IOException {
        FmtTask fmtTask = mTasks.getSelectionModel().getSelectedItem();

        Node source = (Node) actionEvent.getSource();
        Stage stage = (Stage) source.getScene().getWindow();

        if(fmtTask == null) {
            AppVMetaData.getInstance().setIsSelected(true);
        }
        else {
            AppVMetaData.getInstance().setIsSelected(false);
        }

        ViewHelper.showScene(new Stage(), ViewMetaData.UPSERT_VIEW, stage);
    }
}