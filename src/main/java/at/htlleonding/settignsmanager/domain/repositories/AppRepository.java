package at.htlleonding.settignsmanager.domain.repositories;

import at.htlleonding.settignsmanager.domain.exceptions.CouldNotGetPropertyFromDatabaseException;
import at.htlleonding.settignsmanager.domain.exceptions.CouldNotGetSettingsFromDatabaseException;
import at.htlleonding.settignsmanager.domain.exceptions.CouldNotInsertIntoDatabaseException;
import at.htlleonding.settignsmanager.domain.models.Property;
import at.htlleonding.settignsmanager.domain.models.Setting;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.nio.file.Files;
import java.nio.file.Path;
import java.sql.*;

public class AppRepository {

    private static final String mConnectionToNewDb = "jdbc:h2:./db/database;INIT=RUNSCRIPT FROM './db/createdb.sql'";
    private static final String mConnectionToDb = "jdbc:h2:./db/database";

    private Connection mConnection;


    private ObservableList<Setting> mSettings = FXCollections.observableArrayList();

    private static AppRepository mAppRepository;

    private AppRepository() {

        ObservableList<Property> propertysTextReplacement = FXCollections.observableArrayList();
        propertysTextReplacement.add(new Property("sgduh", "Sehr geehrte Damen und Herren!"));
        propertysTextReplacement.add(new Property("sgf", "Sehr geehrte Frau "));
        propertysTextReplacement.add(new Property("sgh", "Sehr geehrter Herr "));

        Setting settingTextReplacement = new Setting("Text Replacement", true, propertysTextReplacement);


        ObservableList<Property> propertysLanguageAndRegion = FXCollections.observableArrayList();
        propertysLanguageAndRegion.add(new Property("Country", "AUSTRIA"));
        propertysLanguageAndRegion.add(new Property("County", "UPPER AUSTRIA"));
        propertysLanguageAndRegion.add(new Property("Language", "English (US)"));
        propertysLanguageAndRegion.add(new Property("Currency", "€"));

        Setting settingLanguageAndRegion = new Setting("Language and Region", true, propertysLanguageAndRegion);



        ObservableList<Property> propertysAccountInfo = FXCollections.observableArrayList();
        propertysAccountInfo.add(new Property("Email", "john.doe@example.com"));
        propertysAccountInfo.add(new Property("Age", "19"));

        Setting settingAccountInfo = new Setting("Account Info", false, propertysAccountInfo);


        ObservableList<Property> propertysStyles = FXCollections.observableArrayList();
        propertysStyles.add(new Property("Theme", "Light"));

        Setting settingStyles = new Setting("Text Replacement", true, propertysStyles);

        mSettings.add(settingTextReplacement);
        mSettings.add(settingLanguageAndRegion);
        mSettings.add(settingAccountInfo);
        mSettings.add(settingStyles);
    }

    public static AppRepository getInstance() {
        if(mAppRepository == null) {
            mAppRepository = new AppRepository();
        }

        return mAppRepository;
    }

    public void initialize() {
        try {
            DriverManager.getConnection(Files.exists(Path.of("./db/database.mv.db")) ? mConnectionToDb : mConnectionToNewDb);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void getPropertyFromDb() throws CouldNotGetPropertyFromDatabaseException {
        try(PreparedStatement preparedStatement = mConnection.prepareStatement("SELECT * FROM Property")) {
            try(ResultSet resultSet = preparedStatement.executeQuery()) {
                while(resultSet.next()){

                    resultSet.getString("name");
                    resultSet.getString("isEditAble");
                    resultSet.getArray("propertyList");


                }
            }
        } catch (SQLException e) {
            throw new CouldNotGetPropertyFromDatabaseException(e.getMessage());
        }
    }

    public void getSettingsFromDb() throws CouldNotGetSettingsFromDatabaseException {

        try(PreparedStatement preparedStatement = mConnection.prepareStatement("SELECT * FROM Setting LEFT JOIN Property WHERE...")) {
            try(ResultSet resultSet = preparedStatement.executeQuery()) {
                while(resultSet.next()){

                    resultSet.getString("name");
                    resultSet.getString("isEditAble");
                    resultSet.getArray("propertyList");




                }
            }
        } catch (SQLException e) {
            throw new CouldNotGetSettingsFromDatabaseException(e.getMessage());
        }
    }

    public void insertSettingIntoDb(String name, boolean isEditable) throws CouldNotInsertIntoDatabaseException {

        try(PreparedStatement preparedStatement = mConnection.prepareStatement("INSERT INTO Setting (name, isEditable) VALUES (?, ?)", Statement.RETURN_GENERATED_KEYS)) {

            preparedStatement.setString(1, name);
            preparedStatement.setBoolean(1, isEditable);

            preparedStatement.execute();

        } catch (SQLException e) {
            throw new CouldNotInsertIntoDatabaseException(e.getMessage());
        }

    }

    public void addProperty(Setting setting, Property property) {
        setting.getPropertyList().add(property);
    }

    public void deleteProperty(Setting setting, Property property) {
        setting.getPropertyList().remove(property);
    }

    public ObservableList<Setting> getSettings() {
        return mSettings;
    }
}