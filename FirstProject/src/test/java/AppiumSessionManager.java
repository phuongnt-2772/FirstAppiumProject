import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class AppiumSessionManager {

    private AppiumDriver driver;

    public void startSession() {
        Properties properties = new Properties();

        try (FileInputStream input = new FileInputStream("path/to/your/config.properties")) {
            // Tải thông tin từ file config
            properties.load(input);

            // Địa chỉ Appium Server
            String appiumUrl = "http://127.0.0.1:" + properties.getProperty("port") + "/wd/hub";

            // Tạo Map để chứa các thông số cần thiết
            Map<String, Object> capabilities = new HashMap<>();
            capabilities.put("platformName", "Android");
            capabilities.put("automationName", properties.getProperty("androidAutomationName"));
            capabilities.put("appPackage", properties.getProperty("androidAppPackage"));
            capabilities.put("appActivity", properties.getProperty("androidAppActivity"));
            capabilities.put("avd", properties.getProperty("androidAvd")); // Nếu sử dụng AVD
            capabilities.put("app", properties.getProperty("androidAppLocation"));
            capabilities.put("noReset", true);
            capabilities.put("fullReset", false); // Không thực hiện full reset

            driver = new AndroidDriver (new URL(appiumUrl), String.valueOf(capabilities));

            System.out.println("Session đã được khởi động thành công với UiAutomator2!");

        } catch (IOException e) {
            System.err.println("Không thể đọc file config: " + e.getMessage());
        } catch (Exception e) {
            System.err.println("Lỗi khi khởi động session: " + e.getMessage());
        }
    }

    public AppiumDriver getDriver() {
        return driver;
    }

    public void stopSession() {
        if (driver != null) {
            driver.quit();
            System.out.println("Session đã được đóng!");
        }
    }
}
