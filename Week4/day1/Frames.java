package Week4.day1;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Frames {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		// navigate to url
		driver.get("https://www.w3schools.com/js/tryit.asp?filename=tryjs_confirm\r\n" + 
				"");

		// maximize the window
		driver.manage().window().maximize();
        driver.switchTo().frame("iframeResult");
		driver.findElement(By.xpath("//button[text()='Try it']")).click();
		Alert alert = driver.switchTo().alert();
		alert.accept();
		
		String text = driver.findElement(By.id("demo")).getText();
		System.out.println(text);
		driver.switchTo().defaultContent();

		
	}

}
