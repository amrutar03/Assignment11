package Assignment;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;
public class Utility {

	  public static void main(String[] args) {
	        ChromeOptions options = new ChromeOptions();
	        options.addArguments("--remote-allow-origins=*");
	        WebDriver driver = new ChromeDriver(options);
	        driver.get("https://login.yahoo.com/?.intl=in");

	        WebElement element = driver.findElement(By.xpath("//div[@class='mbr-login-hd txt-align-center']"));
	        captureScreenshotOfWebElement(driver, element);
	        driver.quit();
	    }

	    public static void captureScreenshotOfWebElement(WebDriver driver, WebElement element) {
	        try {
	            String screenshotDir = "element_screenShot";
	            Files.createDirectories(Paths.get(screenshotDir));

	            // Capture screenshot of the entire page
	            File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

	            // Generate a unique filename using date and time
	            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd_HHmmss");
	            String timestamp = dateFormat.format(new Date());

	            // Create the screenshot file path
	            String screenshotFilePath = screenshotDir + File.separator + "screenshot_" + timestamp + ".png";
	            File elementScreenshotFile = new File(screenshotFilePath);

	            // Use the element's location and size to crop the screenshot
	            FileUtils.copyFile(screenshotFile, elementScreenshotFile);
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
    
	}	
	
//Task4	
		public static void waitForElement(WebDriver driver, By locator, int timeout) {
	        int retries = timeout;

	        while (retries > 0) {
	            try {
	                WebElement element = driver.findElement(locator);

	                if (element.isEnabled()) {
	                    return;  // Element found and enabled, exit the method
	                }
	            } catch (NoSuchElementException  e) {
	            	  // Log the exception for debugging or analysis
	                System.out.println("NoSuchException occurred: " + e.getMessage());
	            }
	         
	          catch (StaleElementReferenceException  e) {
          	  // Log the exception for debugging or analysis
              System.out.println("StaleException occurred: " + e.getMessage());
          }
	            retries--;

	            try {
	                Thread.sleep(1000);  // Sleep for 1 second before the next retry
	            } catch (InterruptedException e) {
	                Thread.currentThread().interrupt();
	            }
	        }

	        // Element not found or not enabled within the specified timeout
	        throw new NoSuchElementException("Element not found or not enabled within the specified timeout");
	    }
	
	
}
	
