import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WindowHandle {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "D:\\eclipse-workspace1\\Important_in_Selenium\\useful_driver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://www.globalsqa.com/demo-site/select-dropdown-menu/");
		driver.manage().window().maximize();
		
		driver.findElement(By.xpath("//div[@class='subheader_inside']/a[5]")).click();
		driver.findElement(By.xpath("//div[@class='subheader_inside']/a[4]")).click();
		
		// parrent window
		String parentWindow = driver.getWindowHandle();
		
		// Store all window
		
		Set<String> allWindows = driver.getWindowHandles();
		for(String window:allWindows) {
			if(!window.equals(allWindows)) {

				driver.switchTo().window(window);
				System.out.println("Visited window title is" + driver.getTitle());
				//break;
			}
			
			//Return to parent window
			
			driver.switchTo().window(parentWindow);
			driver.close();
		}
		
		
		System.out.println("Checking Git Stuff");
		
		

	}

}
