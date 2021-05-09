package Week4.day1;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

//import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WindowHandle {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		// navigate to url
		driver.get("http://leafground.com/pages/Window.html");
		driver.findElement(By.xpath("//button[text()='Do not close me ']")).click();
		
		Set <String> allwindowhandles = driver.getWindowHandles();
		System.out.println(allwindowhandles);

		
		List<String> lstwindows = new ArrayList<String>(allwindowhandles);
		String secwinhandle = lstwindows.get(2);
		driver.switchTo().window(secwinhandle);
		System.out.println(driver.getTitle());
		
		driver.close();
		 secwinhandle = lstwindows.get(1);
		driver.switchTo().window(secwinhandle);
		System.out.println(driver.getTitle());
		driver.close();
		
		 secwinhandle = lstwindows.get(0);
			driver.switchTo().window(secwinhandle);
			System.out.println(driver.getTitle());
		
		
	}

}
