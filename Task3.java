package Assignment;


	
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import ru.yandex.qatools.ashot.AShot;
	import ru.yandex.qatools.ashot.Screenshot;
	import ru.yandex.qatools.ashot.shooting.ShootingStrategies;

	import javax.imageio.ImageIO;
	import java.io.File;
	import java.io.IOException;

	public class Task3 {
	    public static void main(String[] args) {
	    	ChromeOptions options = new ChromeOptions();
	        options.addArguments("--remote-allow-origins=*");
	        WebDriver driver = new ChromeDriver(options);
	        driver.get("https://login.yahoo.com/?.intl=in");


	        // Capture the screenshot using AShot
	        Screenshot screenshot = new AShot()
	                .shootingStrategy(ShootingStrategies.viewportPasting(100))
	                .takeScreenshot(driver);

	        // Define the file path for saving the screenshot
	        String screenshotFilePath = "myscreenshot.png";

	        // Save the screenshot to the specified file path
	        try {
	            ImageIO.write(screenshot.getImage(), "PNG", new File(screenshotFilePath));
	            System.out.println("Screenshot saved successfully");
	        } catch (IOException e) {
	            System.out.println("Failed to save screenshot: " + e.getMessage());
	        }

	        // Close the WebDriver instance
	        driver.quit();
	    }
	}

