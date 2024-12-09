package Adapter.Screens;

import Adapter.Bases.BaseMobileScreen;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class imdbAccountScreen extends BaseMobileScreen {

    public imdbAccountScreen(AndroidDriver driver){
        super(driver);
    }

    @AndroidFindBy(uiAutomator = "new UiSelector().className(\"android.widget.EditText\").instance(0)")
    private AndroidElement signInEmail;

    @AndroidFindBy(uiAutomator = "new UiSelector().className(\"android.widget.EditText\").instance(1)")
    private AndroidElement passwordField;

    @AndroidFindBy(xpath = "//android.widget.Button[@text=\"Sign in\"]")
    private AndroidElement signInButton;


    public void setSignInEmail(String email){
        signInEmail.sendKeys(email);
    }

    public void setPassword(String password){
        passwordField.sendKeys(password);
    }

    public SearchScreen clickSignIn() {
        WebDriverWait wait = new WebDriverWait(driver, 10);

        wait.until(ExpectedConditions.visibilityOf(signInButton));
        signInButton.click();
        return new SearchScreen(driver);
    }

    private boolean isElementVisible(AndroidElement element) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, 2);
            wait.until(ExpectedConditions.visibilityOf(element));
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
