package at.htlleonding.fraumantis.model;

import at.htlleonding.fraumantis.view.AppView;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import javax.imageio.plugins.jpeg.JPEGImageReadParam;
import java.awt.desktop.AppReopenedEvent;
import java.nio.file.Files;
import java.nio.file.Path;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Optional;

public class FmtTasksRepository {

    private Connection mConnection;
    private final static String mGetConnectionToNewDatabase = "jdbc:h2:./db/database;INIT=RUNSCRIPT FROM './db/createdb.sql'";
    private final static String mGetConnectionToExistingDatabase = "jdbc:h2:/db/database";

    private final ObservableList<FmtTask> mFmtTasks = FXCollections.observableArrayList();

    private static FmtTasksRepository mInstance;

    private FmtTasksRepository() {

        mFmtTasks.add(new FmtTask("Yanni", false, "asdfjaksl", 230, 230));
        mFmtTasks.add(new FmtTask("Yanni", false, "asdf", 230, 230));
        mFmtTasks.add(new FmtTask("Yanni", true, "jklö", 230, 230));
        mFmtTasks.add(new FmtTask("Clemens", true, "jklö", 230, 230));
        mFmtTasks.add(new FmtTask("Clemens", true, "jklö", 230, 230));

    }

    public static FmtTasksRepository getInstance() {
        if (mInstance == null) {
            mInstance = new FmtTasksRepository();
        }

        return mInstance;
    }

    public ObservableList<FmtTask> getFmtTasks() {
        return mFmtTasks;
    }

    public void connectToDatabase() {
        try {
            mConnection = DriverManager.getConnection(Files.exists(Path.of("./db/database.mv.db")) ? mGetConnectionToExistingDatabase : mGetConnectionToNewDatabase);
        } catch (SQLException e) {
            throw new RuntimeException();
        }
    }

    public void addTask(FmtTask fmtTask) {
        try (PreparedStatement preparedStatement = mConnection.prepareStatement("INSERT INTO Task (fromWho, isDone,description, startingTime, endTime) VALUES (?,?,?,?,?)")) {

            preparedStatement.setString(1, fmtTask.getFromWho());
            preparedStatement.setBoolean(2, fmtTask.isDone());
            preparedStatement.setString(5, fmtTask.getDescription());
            preparedStatement.setInt(3, fmtTask.getStartingTime());
            preparedStatement.setInt(4, fmtTask.getEndTime());

            var asdf = FmtTasksRepository.getInstance().getFmtTasks();

            Optional<FmtTask> optional = asdf.stream().findAny();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void closeConnection() {
        try {
            mConnection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
