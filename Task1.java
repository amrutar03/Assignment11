package Assignment;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Task1 {

	public static void main(String[] args) throws InterruptedException {
		ChromeOptions opt=new ChromeOptions();
		opt.addArguments("--remote-allow-origins=*");
		ChromeDriver driver =new ChromeDriver(opt);
		driver.get("http://seleniumpractise.blogspot.com/2016/08/how-to-use-explicit-wait-in-selenium.html");
		
	    WebElement ele= driver.findElement(By.xpath("//button[text()='Click me to start timer']"));
	    ele.click();
	    String s=ele.getText();
	    System.out.println(s);
	    WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(30));
	   
	    for(int i=0;i<=30;i++)
	    {
	    WebElement ele1=driver.findElement(By.xpath("//p[@id='demo']"));
	    String s1=ele1.getText();
	    System.out.println("thiossssssssss"+s1);
	    Thread.sleep(1000);
	   
	        if(s1.contains("WebDriver"))
	         {
	         	System.out.println("This is txt Found:");
	    	     System.out.println( ele1.getText());
	    	     break;
	    	 }
	        else {
	           System.out.println("HIIIII This is not match Wait  ");
	              }
	    }
	    driver.close();


	}

}
