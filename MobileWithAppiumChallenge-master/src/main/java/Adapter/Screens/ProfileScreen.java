package Adapter.Screens;

import Adapter.Bases.BaseMobileScreen;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class ProfileScreen extends BaseMobileScreen {
    public ProfileScreen(AndroidDriver driver){
        super(driver);
    }

    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.imdb.mobile:id/user_watchlists\")")
    private AndroidElement userWatchList;

    public WatchListScreen clickWatchList(){
        userWatchList.click();
        return new WatchListScreen(driver);
    }


}
