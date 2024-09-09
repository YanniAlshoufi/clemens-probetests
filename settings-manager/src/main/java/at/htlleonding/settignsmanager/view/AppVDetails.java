package at.htlleonding.settignsmanager.view;

import at.htlleonding.settignsmanager.controller.AppController;
import at.htlleonding.settignsmanager.domain.models.Setting;

public class AppVDetails {

    private static Setting mSetting;


    private static AppVDetails mAppController;

    private AppVDetails(){
    }

    public static AppVDetails getInstance() {
        if(mAppController == null) {
            mAppController = new AppVDetails();
        }

        return mAppController;
    }

    public static Setting getSetting() {
        return mSetting;
    }

    public static void setSetting(Setting mSetting) {
        AppVDetails.mSetting = mSetting;
    }
}
