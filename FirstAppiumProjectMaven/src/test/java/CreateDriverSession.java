import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import java.net.URL;
public class CreateDriverSession {
    public static void main(String[] args) {
        try {
            UiAutomator2Options options = new UiAutomator2Options();
            options.setPlatformName("Android");
            options.setDeviceName("Pixel_3");
            options.setAutomationName("UiAutomator2");
            options.setAppActivity(".MainActivity");
            options.setAppPackage("/Downloads/FirstAppiumProject/FirstAppiumProjectMaven/src/test/resources/app/app-release.apk");
            options.setNoReset(true);

            URL appiumServerURL = new URL("http://127.0.0.1:4723/");

            AppiumDriver driver = new AndroidDriver(appiumServerURL, options);
            System.out.println("session_id " + driver.getSessionId());
            System.out.println("Session created successfully!");
            driver.quit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}