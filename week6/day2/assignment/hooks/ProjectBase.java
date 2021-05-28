package week6.day2.assignment.hooks;


import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import io.cucumber.java.AfterStep;
import io.github.bonigarcia.wdm.WebDriverManager;



public class ProjectBase {

	    int i =1;
	    public static String number;
		public static Set<String> allWindowHandles;
		public static List<String> lstWindowHandles;
	    
		public static ChromeDriver driver;
		
		@BeforeMethod
		public void init() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://dev103117.service-now.com");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		}
		
		
		@AfterStep
		public void takeSnap() throws IOException {
			File src = driver.getScreenshotAs(OutputType.FILE);
		
			FileUtils.copyFile(src, new File("./snaps"+(i ++)+".jpg"));
		}
		
		
		public static void clickParentwindow()
		{

			Set<String> allWindowHandles = driver.getWindowHandles();
			System.out.println("WindowHandling: " + allWindowHandles.size());
			List<String> lstWindowHandles = new ArrayList<String>(allWindowHandles);

			driver.switchTo().window(lstWindowHandles.get(0));

			System.out.println("Parent-Window Title: " + driver.getTitle());	
			driver.switchTo().frame(0);
			
		}
		
		public static void clickPopUp()
		{
			
				Set<String> allWindowHandles = driver.getWindowHandles();			
				List<String> lstWindowHandles = new ArrayList<String>(allWindowHandles);

				driver.switchTo().window(lstWindowHandles.get(1));
				System.out.println("Sub-Window Title: " + driver.getTitle());			
		}
		
		@AfterMethod

		public void teardown() {
			
			
			driver.close();
		}
		
	}

