package Adapter.Screens;

import Adapter.Bases.BaseMobileScreen;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomeScreen extends BaseMobileScreen {
    public HomeScreen(AndroidDriver driver){
        super(driver);
    }

    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"Search for shows, movies, people…\")")
    private AndroidElement searchBar;

    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"android:id/autofill_save_no\")")
    private AndroidElement neverSavePasswordButton;

    public SearchScreen clickSearchBar(){
        searchBar.click();
        return new SearchScreen(driver);
    }

    public void clickNever() {
        neverSavePasswordButton.click();
    }



}
