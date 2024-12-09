package Adapter.Screens;

import Adapter.Bases.BaseMobileScreen;
import io.appium.java_client.MobileBy;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.touch.TapOptions;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.ElementOption;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

public class SelectedMovieScreen extends BaseMobileScreen {
    public SelectedMovieScreen(AndroidDriver driver){
        super(driver);
    }

    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.imdb.mobile:id/title\")")
    private AndroidElement title;

    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.imdb.mobile:id/plot_overview\")")
    private AndroidElement overview;

    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.imdb.mobile:id/watchlist_button_icon\")")
    private AndroidElement addToWatchList;

    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.imdb.mobile:id/notification_dont_ask_me_again\")")
    private AndroidElement notificationPopUp;

    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.imdb.mobile:id/your_rating_group\")")
    private AndroidElement rateButton;

    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.imdb.mobile:id/rate_title_button\")")
    private AndroidElement ratingButton;

    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.imdb.mobile:id/title\").text(\"Rating saved\")")
    private AndroidElement ratingSavedTitle;

    @AndroidFindBy(uiAutomator = "new UiSelector().className(\"android.widget.ImageButton\")")
    private AndroidElement goBack;


    public boolean isTitleVisible(){
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOf(title));
        return title.isDisplayed();
    }

    public String getTitle(){
        return title.getText();
    }


    public String getOverviewText() {
        return overview.getText();
    }

    public void clickAddToWatchList(){
        addToWatchList.click();
    }

    public ProfileScreen goToProfile(){
        getGlobalNavigation().clickProfileButton();
        return new ProfileScreen(driver);
    }

    public void clickNotAgain(){
        notificationPopUp.click();
    }


    public void manualScrollDown() {
        try {
            driver.findElementByAndroidUIAutomator(
                    "new UiScrollable(new UiSelector().scrollable(true)).scrollForward()");
        } catch (Exception e) {
            System.out.println("Error realizando el scroll: " + e.getMessage());
        }
    }

    public void clickRateButton() {
        manualScrollDown();

        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOf(rateButton));
        wait.until(ExpectedConditions.elementToBeClickable(rateButton));

        try {
            rateButton.click(); // Intentamos hacer clic normalmente
        } catch (Exception e) {
            TouchAction<?> action = new TouchAction<>(driver);
            action.tap(TapOptions.tapOptions().withElement(ElementOption.element(rateButton))).perform();
        }
    }

    public List<AndroidElement> getStarElements() {
        return driver.findElements(MobileBy.AndroidUIAutomator(
                "new UiSelector().resourceIdMatches(\"com.imdb.mobile:id/star_\\d+\")"));
    }

    public void selectRandomStar() {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(MobileBy.AndroidUIAutomator(
                "new UiSelector().resourceIdMatches(\"com.imdb.mobile:id/star_\\d+\")")));

        List<AndroidElement> stars = getStarElements();
        if (!stars.isEmpty()) {
            Random rand = new Random();
            int randomIndex = rand.nextInt(stars.size());
            stars.get(randomIndex).click();
        } else {
            throw new IllegalStateException("No stars found on the screen.");
        }
    }

    public void clickRatingButton(){
        ratingButton.click();
    }

    public boolean isRatingSavedDisplayed() {
        try {
            return ratingSavedTitle.isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public WatchListScreen goBackToWatchList(){
        goBack.click();
        return new WatchListScreen(driver);
    }





}
