import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import java.net.URL;
public class AppiumTest {
    public static void main(String[] args) {
        try {
            UiAutomator2Options options = new UiAutomator2Options();
            options.setPlatformName("Android");
            options.setDeviceName("Pixel_3");
            options.setAutomationName("UiAutomator2");
            options.setAppPackage("app-release.apk");
            options.setAppActivity(".MainActivity");
            options.setNoReset(true);
            // Khởi tạo URL Appium Server (localhost)
            URL appiumServerURL = new URL("http://127.0.0.1:4723");
            // Khởi tạo driver cho Android (kết nối với Appium Server)
            AppiumDriver driver = new AndroidDriver(appiumServerURL, options);
            // Kiểm tra session
            System.out.println("Session created successfully!");
            driver.quit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}