package prac1;

import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

public class redbus 
{

	WebDriver driver;
	DesiredCapabilities ds;
	@Test
	public void open() throws Exception
	{
		try
		{
	  	ds=new DesiredCapabilities();
	  	ds.setCapability("platformName","Android");
		ds.setCapability("deviceName", "Lenovo A7000-a");
		ds.setCapability("app", "chrome");
		driver = new RemoteWebDriver(new URL("http://127.0.0.1:4723/wd/hub"), ds);
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		driver.get("http://m.redbus.in");
		search();
		}
		catch(Exception e)
		{ 
			driver.quit();
		}
	}
	public void search() throws Exception
	{
		driver.findElement(By.id("rb_src_city")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//li[text()='Hyderabad']")).click();
		Thread.sleep(2000);
		driver.findElement(By.id("rb_dest_city")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//li[text()='Bangalore']")).click();
		Thread.sleep(2000);
		driver.findElement(By.id("rb_doj")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[@class='rb-right-arrow']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//table[@class='monthTable first last']//td[text()='18']")).click();
		Thread.sleep(2000);
		driver.findElement(By.id("rb_continue")).click();
	}
}
