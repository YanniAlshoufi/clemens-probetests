package at.htlleonding.fraumantis.model;

import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class FmtTask {
    private final SimpleBooleanProperty mIsDone;
    private final SimpleStringProperty mDescription;
    private final SimpleIntegerProperty mStartingTime;
    private final SimpleIntegerProperty mEndTime;

    public FmtTask(boolean isDone, String description, int startingTime, int endTime) {
        mIsDone = new SimpleBooleanProperty(isDone);
        mDescription = new SimpleStringProperty(description);
        mStartingTime = new SimpleIntegerProperty(startingTime);
        mEndTime = new SimpleIntegerProperty(endTime);
    }

    public boolean isIsDone() {
        return mIsDone.get();
    }

    public SimpleBooleanProperty isDoneProperty() {
        return mIsDone;
    }

    public void setIsDone(boolean isDone) {
        this.mIsDone.set(isDone);
    }

    public String getDescription() {
        return mDescription.get();
    }

    public SimpleStringProperty descriptionProperty() {
        return mDescription;
    }

    public void setDescription(String description) {
        this.mDescription.set(description);
    }

    public int getStartingTime() {
        return mStartingTime.get();
    }

    public SimpleIntegerProperty startingTimeProperty() {
        return mStartingTime;
    }

    public void setStartingTime(int startingTime) {
        this.mStartingTime.set(startingTime);
    }

    public int getEndTime() {
        return mEndTime.get();
    }

    public SimpleIntegerProperty endTimeProperty() {
        return mEndTime;
    }

    public void setEndTime(int endTime) {
        this.mEndTime.set(endTime);
    }

    @Override
    public String toString() {
        return "FmtTask{mIsDone=%s, mDescription=%s, mStartingTime=%s, mEndTime=%s}"
            .formatted(mIsDone, mDescription, mStartingTime, mEndTime);
    }
}


