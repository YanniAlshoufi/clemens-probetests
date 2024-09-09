package at.htlleonding.settignsmanager.domain.models;

import javafx.beans.property.SimpleStringProperty;

public class Property {

    private final SimpleStringProperty mName = new SimpleStringProperty();
    private final SimpleStringProperty mValue = new SimpleStringProperty();

    public Property(String name, String value) {
        this.mName.set(name);
        this.mValue.set(value);
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

    public String getValue() {
        return mValue.get();
    }

    public SimpleStringProperty getValueProperty() {
        return mValue;
    }

    public void setValue(String mValue) {
        this.mValue.set(mValue);
    }

    @Override
    public String toString() {
        return "%s %s".formatted(getName(), getValue());
    }
}
