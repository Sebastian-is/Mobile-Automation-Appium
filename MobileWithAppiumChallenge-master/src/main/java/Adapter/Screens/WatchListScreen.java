package Adapter.Screens;

import Adapter.Bases.BaseMobileScreen;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class WatchListScreen extends BaseMobileScreen {
    public WatchListScreen(AndroidDriver driver){
        super(driver);
    }

    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.imdb.mobile:id/primary_view\")")
    private AndroidElement movieInWatchList;

    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.imdb.mobile:id/user_lists_overflow_menu\")")
    private AndroidElement movieMenu;

    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.imdb.mobile:id/delete_list_item\")")
    private AndroidElement removeMovie;

    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"android:id/button1\").text(\"Remove\")")
    private AndroidElement yesRemoveButton;


    public void clickMovieMenu() {
        movieMenu.click();
    }

    public void removeMovie() {
        removeMovie.click();
    }

    public void yesRemove() {
        yesRemoveButton.click();
    }

    public SelectedMovieScreen clickMovieInWatchList(){
        movieInWatchList.click();
        return new SelectedMovieScreen(driver);
    }
}
