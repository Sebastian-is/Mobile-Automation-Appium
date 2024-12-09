package Adapter.Bases;


import Adapter.Screens.GlobalNavigationScreen;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;

public abstract class BaseMobileScreen {
    protected AndroidDriver<AndroidElement> driver;
    private GlobalNavigationScreen globalNavigation;

    public BaseMobileScreen(AndroidDriver<AndroidElement> driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    protected GlobalNavigationScreen getGlobalNavigation() {
        if (globalNavigation == null) {
            globalNavigation = new GlobalNavigationScreen(driver);
        }
        return globalNavigation;
    }
}


