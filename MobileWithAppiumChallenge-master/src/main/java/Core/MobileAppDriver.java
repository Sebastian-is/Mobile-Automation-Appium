package Core;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

public class MobileAppDriver {
    private AndroidDriver<AndroidElement> driver;

    public AndroidDriver<AndroidElement> GetMoviesAppDriver(DesiredCapabilities capabilities)  {
            try {
                driver = new AndroidDriver<AndroidElement>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);

            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
        return driver;
    }
}
