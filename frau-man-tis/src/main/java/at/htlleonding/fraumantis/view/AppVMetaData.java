package at.htlleonding.fraumantis.view;

public class AppVMetaData {

    private boolean mIsSelected;

    private static AppVMetaData mInstance;

    private AppVMetaData() {
    }

    public static AppVMetaData getInstance() {
        if(mInstance == null) {
            mInstance = new AppVMetaData();
        }

        return mInstance;
    }

    public void setIsSelected(boolean isSelected) {
        mIsSelected = isSelected;

    }

    public boolean isSelected() {
        return mIsSelected;
    }
}
