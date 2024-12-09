package Adapter.Screens;

import Adapter.Bases.BaseMobileScreen;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GlobalNavigationScreen extends BaseMobileScreen {

    @AndroidFindBy(id = "com.imdb.mobile:id/navigation_home")
    private AndroidElement homeButton;

    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.imdb.mobile:id/navigation_search_browse\")")
    private AndroidElement searchButton;

    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.imdb.mobile:id/navigation_user_profile\")")
    private AndroidElement profileButton;

    public GlobalNavigationScreen(AndroidDriver<AndroidElement> driver) {
        super(driver);
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    public HomeScreen clickHomeButton() {
        homeButton.click();
        return new HomeScreen(driver);
    }

    public SearchScreen clickSearchButton() {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOf(searchButton));

        searchButton.click();
        searchButton.click();

        return new SearchScreen(driver);
    }

    public ProfileScreen clickProfileButton() {
        profileButton.click();
        return new ProfileScreen(driver);
    }

}
