package prac1;

import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Google
{

	WebDriver driver;
	DesiredCapabilities ds=new DesiredCapabilities();
	
	@Test
	@Parameters({"dev"})
	public void test(String device) throws Exception
	{
		
	    if(device.matches("a1"))	    	
	    {
	    	ds.setCapability("platformName","Android");
			ds.setCapability("deviceName", "Lenovo A7000-a");
			ds.setCapability("app", "chrome");
	    }
	    if(device.matches("sony"))
	    {
	    	ds.setCapability("platformName","Android");
			ds.setCapability("deviceName", "Xperia Z1");
			ds.setCapability("app", "chrome");
	    }
	  	
		driver = new RemoteWebDriver(new URL("http://127.0.0.1:4723/wd/hub"), ds);
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		
		driver.get("http://www.google.co.in");
		driver.findElement(By.name("q")).sendKeys("java");
		driver.findElement(By.name("btnG")).click();
	}
}
