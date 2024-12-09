package Adapter.Screens;

import Adapter.Bases.BaseMobileScreen;
import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.Random;

public class SearchScreen extends BaseMobileScreen {
    public SearchScreen(AndroidDriver driver){
        super(driver);
    }

    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.imdb.mobile:id/search_src_text\")")
    private AndroidElement searchBar;

    public void inputTttle(String movieTitle) {
        if (searchBar.isDisplayed() && searchBar.isEnabled()) {
            WebDriverWait wait = new WebDriverWait(driver, 10);
            wait.until(ExpectedConditions.visibilityOf(searchBar));
            searchBar.click();
            wait.until(ExpectedConditions.elementToBeClickable(searchBar));
            searchBar.sendKeys(movieTitle);
        } else {
            throw new IllegalStateException("The search bar is not interactable.");
        }
    }

    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.imdb.mobile:id/holder\")")
    private List<AndroidElement> searchResults;

    public SelectedMovieScreen selectFirstMovie() {
        if (searchResults.size() > 1) {
            searchResults.get(0).click();
            return new SelectedMovieScreen(driver);
        } else {
            throw new IllegalStateException("No movies found in the search results.");
        }
    }

    public SelectedMovieScreen anyMovie(){
        Random random = new Random();
        AndroidElement randomMovie = searchResults.get(random.nextInt(searchResults.size()));
        randomMovie.click();
        return new SelectedMovieScreen(driver);
    }

    public void navigateToSearch() {
        getGlobalNavigation().clickSearchButton();
    }




}
