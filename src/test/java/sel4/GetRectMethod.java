package sel4;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.Rectangle;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class GetRectMethod {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String path = System.getProperty("user.dir");
		System.out.println(path);
		System.setProperty("webdriver.chrome.driver", path + "\\resources\\chromedriver.exe");

		ChromeOptions options = new ChromeOptions();
		options.addArguments("incognito");
		WebDriver driver = new ChromeDriver(options);
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("https://opensource-demo.orangehrmlive.com/");

		WebElement username = driver.findElement(By.xpath("//input[@id='txtUsername']"));
		//Selenium3
		Dimension userdim=username.getSize();
		System.out.println(userdim.getHeight());
		System.out.println(userdim.getWidth());
		
		Point p=username.getLocation();
		System.out.println(p.getX());
		System.out.println(p.getY());
		
		//Selenium4
		Rectangle user = username.getRect();
		System.out.println(user.getHeight());
		System.out.println(user.getWidth());
		System.out.println(user.getX());
		System.out.println(user.getY());

	}

}
