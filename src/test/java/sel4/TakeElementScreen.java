package sel4;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TakeElementScreen {

	public static void main(String[] args) throws IOException {

		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\sneha.k.p\\Desktop\\selenium\\chromedriver_win32_new1\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://newtours.demoaut.com/");

		WebElement username = driver.findElement(By.xpath("//input[@name='userName']"));
		takeScreenshot(username, "usernameElement");

		WebElement signin = driver.findElement(By.xpath("//input[@name='login']"));
		takeScreenshot(signin, "signinElement");
		driver.quit();
	}

	public static void takeScreenshot(WebElement element, String filename) throws IOException {
		File src = element.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src, new File("./target/screens/" + filename + ".png"));
	}

}
