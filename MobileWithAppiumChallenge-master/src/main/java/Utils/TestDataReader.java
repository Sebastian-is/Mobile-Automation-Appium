package Utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class TestDataReader {
    private static Properties properties = new Properties();

    static {
        try {
            FileInputStream fileInput = new FileInputStream("src/main/resources/test-data.properties");
            properties.load(fileInput);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String get(String key) {
        return properties.getProperty(key);
    }
}
