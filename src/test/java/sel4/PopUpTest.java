package sel4;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class PopUpTest {

	public static void main(String[] args) throws IOException {
		// http://www.popuptest.com/

		String path = System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver", path + "\\resources\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get(" http://www.popuptest.com/");
		WebElement popupimg = driver.findElement(By.xpath("//img[@alt='Test your popup killer software']"));
		takescreenshot(popupimg, "popupimg");
		driver.quit();
	}

	public static void takescreenshot(WebElement element, String filename) throws IOException {
		File src = element.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src, new File("./target/screens/" + filename + ".png"));

	}

}
