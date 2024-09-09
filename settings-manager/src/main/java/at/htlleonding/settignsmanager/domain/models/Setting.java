package at.htlleonding.settignsmanager.domain.models;

import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleListProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.ObservableList;

import java.util.List;

public class Setting {

    private final SimpleStringProperty mName = new SimpleStringProperty();
    private final SimpleBooleanProperty mIsEditable = new SimpleBooleanProperty();
    private final SimpleListProperty<Property> mPropertyList = new SimpleListProperty<>();


    public Setting(String name, boolean isEditable, List<Property> list) {
        this.mName.set(name);
        this.mIsEditable.set(isEditable);
        this.mPropertyList.set((ObservableList<Property>) list);
    }

    public String getName() {
        return mName.get();
    }

    public SimpleStringProperty getNameProperty() {
        return mName;
    }

    public void setName(String mName) {
        this.mName.set(mName);
    }

    public boolean isEditable() {
        return mIsEditable.get();
    }

    public SimpleBooleanProperty getIsEditableProperty() {
        return mIsEditable;
    }

    public void setIsEditable(boolean mIsEditable) {
        this.mIsEditable.set(mIsEditable);
    }

    public ObservableList<Property> getPropertyList() {
        return mPropertyList.get();
    }

    public SimpleListProperty<Property> gePropertyListProperty() {
        return mPropertyList;
    }

    public void setPropertyList(ObservableList<Property> mPropertyList) {
        this.mPropertyList.set(mPropertyList);
    }

    @Override
    public String toString() {
        return getName();
    }
}
