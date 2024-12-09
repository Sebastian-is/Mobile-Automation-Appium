package Core;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.pmw.tinylog.Logger;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.nio.file.Paths;

public class ConfigCapabilities {
    private static final String DEVICE_NAME = "appium:deviceName";
    private static final String PLATFORM_NAME = "platformName";
    private static final String APP_PACKAGE = "appium:appPackage";
    private static final String APP_ACTIVITY = "appium:appActivity";
    private static final String JSON_FILE_PATH = Paths.get("src", "main", "resources", "Capabilities.json").toString();
    private static JsonParser parser = new JsonParser();
    private static DesiredCapabilities capabilities = new DesiredCapabilities();

    private static void ApplicationSetUp(DesiredCapabilities capabilities){
        capabilities.setCapability(DEVICE_NAME, getJsonDataProperty(DEVICE_NAME));
        capabilities.setCapability(APP_PACKAGE, getJsonDataProperty(APP_PACKAGE));
        capabilities.setCapability(APP_ACTIVITY, getJsonDataProperty(APP_ACTIVITY));
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, getJsonDataProperty(PLATFORM_NAME));
        capabilities.setCapability("automationName", "UiAutomator2");
    }

    private static String getJsonDataProperty(String property) {
        try {
            Object obj = parser.parse(new FileReader(JSON_FILE_PATH));
            JsonObject jsonObject = (JsonObject) obj;
            return jsonObject.get(property).getAsString();
        } catch (FileNotFoundException e) {
            Logger.error("Archivo JSON no encontrado: " + e.getMessage(), e);
        } catch (Exception e) {
            Logger.error("Error al leer el archivo JSON: " + e.getMessage(), e);
        }
        return "";
    }

    public static DesiredCapabilities getCapabilities(){
        ApplicationSetUp(capabilities);
        return capabilities;
    }
}
