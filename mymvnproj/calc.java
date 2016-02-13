package prac1;

import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class calc 
{

	public static void main(String[] args) throws Exception
	{
		WebDriver driver;
		
		DesiredCapabilities cap = new DesiredCapabilities();
        cap.setCapability("device","Android");
        cap.setCapability("platformName", "Android");        
        cap.setCapability("deviceName", "Lenovo A7000-a");        
        cap.setCapability("appPackage", "com.android.calculator2");  
        cap.setCapability("appActivity", "com.android.calculator2.Calculator"); 
        driver = new RemoteWebDriver(new URL("http://127.0.0.1:4723/wd/hub"), cap);
        Thread.sleep(5000);
        driver.findElement(By.name("6")).click();
        Thread.sleep(2000);
		driver.findElement(By.xpath("//android.widget.Button[@content-desc='times']")).click();
		Thread.sleep(2000);
		driver.findElement(By.name("2")).click();
		Thread.sleep(2000);
		driver.findElement(By.name("=")).click();
		Thread.sleep(3000);
		String str=driver.findElement(By.xpath("//android.widget.EditText")).getText();
		if(Integer.parseInt(str)==12)
			System.out.println("value is correct");
		else
			System.out.println("value is not correct");
		

	}

}
