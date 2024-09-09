package at.htlleonding.fraumantis.controller;

import at.htlleonding.fraumantis.model.FmtTask;
import at.htlleonding.fraumantis.view.AppView;

public class AppController {

    private static AppController mInstance;

    private AppController() {
    }

    public static AppController getInstance() {
        if(mInstance == null) {
            mInstance = new AppController();
        }

        return mInstance;
    }

    public void removeTask(FmtTask fmtTask) {
        throw new RuntimeException("not implemented yet");
    }

    public void addTask(String description, int startTime, int endTime) {
        throw new RuntimeException("not implemented yet");
    }

    public void updateTask(String description, int startTime, int endTime, boolean isDone) {
        throw new RuntimeException("not implemented yet");
    }

    public void handleException(Exception e) {
        AppView.getInstance().showException(e);
    }
}
