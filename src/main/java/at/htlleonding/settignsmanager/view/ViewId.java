package at.htlleonding.settignsmanager.view;

public enum ViewId {

    APPVIEW("Settings", 500, 500, "app-view.fxml"),
    EDITPROPERTYVIEW("Edit", 400, 400, "edit-property-view.fxml"),

    ;

    private final String mTitle;
    private final int mWidth;
    private final int mHeight;
    private final String mFileName;

    ViewId(String title, int width, int height, String filename) {
        mTitle = title;
        mWidth = width;
        mHeight = height;
        mFileName = filename;
    }

    public String getTitle() {
        return mTitle;
    }

    public int getWidth() {
        return mWidth;
    }

    public int getHeight() {
        return mHeight;
    }

    public String getFileName() {
        return mFileName;
    }
}
