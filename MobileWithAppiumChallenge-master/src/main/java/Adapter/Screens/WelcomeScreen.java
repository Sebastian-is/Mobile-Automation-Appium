package Adapter.Screens;

import Adapter.Bases.BaseMobileScreen;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class WelcomeScreen extends BaseMobileScreen {

    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.imdb.mobile:id/welcome_dialog_continue\")")
    private AndroidElement continueButton;

    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.imdb.mobile:id/splash_not_now\")")
    private AndroidElement notNowButton;

    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.imdb.mobile:id/imdb_auth_portal\")")
    private AndroidElement imdbButton;

    public WelcomeScreen(AndroidDriver driver) {
        super(driver);
    }

    public void clickContinue() {
        continueButton.click();
    }

    public HomeScreen clickNotNow() {
        notNowButton.click();
        return new HomeScreen(driver);
    }

    public imdbAccountScreen clickIMDB(){
        imdbButton.click();
        return new imdbAccountScreen(driver);
    }
}