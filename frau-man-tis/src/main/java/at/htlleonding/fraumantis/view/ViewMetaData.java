package at.htlleonding.fraumantis.view;

import java.lang.invoke.MethodType;

public enum ViewMetaData {

    MAIN_VIEW("asdf", 500, 500, "main-view.fxml"),
    UPSERT_VIEW("jklö", 400, 400, "upsert-view.fxml")

    ;

    private final String mTitle;
    private final int mWidth;
    private final int mHeight;
    private final String mNameOfFile;


    ViewMetaData(String title, int width, int height, String nameOfFile) {
        mTitle = title;
        mWidth = width;
        mHeight = height;
        mNameOfFile = nameOfFile;
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

    public String getNameOfFile() {
        return mNameOfFile;
    }
}
