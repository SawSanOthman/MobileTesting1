import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class TestCase {

	DesiredCapabilities caps = new DesiredCapabilities();
	String AppiumURL = "http://127.0.0.1:4723/wd/hub";
	AndroidDriver driver;

	Random rand = new Random();
	
	
	@BeforeTest

	public void SetUp() {

		caps.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
		caps.setCapability(MobileCapabilityType.DEVICE_NAME, "sama");
		File Myapplication = new File("src/calculator.apk");
		caps.setCapability(MobileCapabilityType.APP, Myapplication.getAbsolutePath());

	}

	@Test(priority = 1)
	public void AddTwoNumber() throws MalformedURLException {
		driver = new AndroidDriver(new URL(AppiumURL), caps);

		driver.findElement(By.id("com.google.android.calculator:id/digit_5")).click();
		driver.findElement(By.id("com.google.android.calculator:id/op_add")).click();
		driver.findElement(By.id("com.google.android.calculator:id/digit_9")).click();
		String ActualResult = driver.findElement(By.id("com.google.android.calculator:id/result_preview")).getText();
		String ExpectedResult = "14";
		Assert.assertEquals(ActualResult, ExpectedResult);
		
	}

	@Test(priority=2)
	public void ClickAllButtons () throws MalformedURLException {
		driver = new AndroidDriver(new URL(AppiumURL), caps);

		List<WebElement> AllButtons = driver.findElements(By.className("android.widget.ImageButton"));
		
	 for(int i =0 ; i<AllButtons.size();i++) {
		 
		 AllButtons.get(i).click();	
		  
	 }
		
		
	}
	
	@Test(priority=3)
	public void ClickOnEvenNumber () throws MalformedURLException {
		driver = new AndroidDriver(new URL(AppiumURL), caps);

		List<WebElement> AllButtons = driver.findElements(By.className("android.widget.ImageButton"));
		 for(int i =0 ; i<AllButtons.size();i++) {
			 
			 //easy
			//if(AllButtons.get(i).getAttribute("resource-id").contains("2")
					//||AllButtons.get(i).getAttribute("resource-id").contains("4")
					// ||AllButtons.get(i).getAttribute("resource-id").contains("6")
					
					// ||AllButtons.get(i).getAttribute("resource-id").contains("8")	) {
				// AllButtons.get(i).click();
		//	} 
			 
			 //hard
			if(AllButtons.get(i).getAttribute("resource-id").contains("digit")) {
				
				String Thenumber = AllButtons.get(i).getAttribute("resource-id").replace("com.google.android.calculator:id/digit_", "");

				int thenumberasint = Integer.parseInt(Thenumber);
				
				if(thenumberasint % 2 == 0) {
					AllButtons.get(i).click();

				}
				
				
				
			} 
			 
			 
			 
		 }

		
		
		
		
		
	}
	
	
	
	
	
}
	

