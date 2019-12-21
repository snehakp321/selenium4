package sel4;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class OrangeHRMS {

	public static void main(String[] args) throws IOException {

		String path = System.getProperty("user.dir");
		System.out.println(path);
		System.setProperty("webdriver.chrome.driver", path + "\\resources\\chromedriver.exe");
		/*
		 * System.setProperty("webdriver.chrome.driver",
		 * "C:\\Users\\sneha.k.p\\Desktop\\selenium\\chromedriver_win32_new1\\chromedriver.exe"
		 * );
		 */
		ChromeOptions options = new ChromeOptions();
		options.addArguments("incognito");
		WebDriver driver = new ChromeDriver(options);
		// driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("https://opensource-demo.orangehrmlive.com/");

		//sel4 can take screenshot of single element
		WebElement username = driver.findElement(By.xpath("//input[@id='txtUsername']"));
		takeScreenshot(username, "username");
		
		// selenium4 can take screenshot for group of elements
		WebElement login = driver.findElement(By.xpath("//form[@id='frmLogin']"));
		takeScreenshot(login, "loginFrame1");

		WebElement orangeimg = driver.findElement(By.xpath("//div[@id='divLogo']"));
		takeScreenshot(orangeimg, "orangeimg");

		driver.quit();
	}

	/*
	 * public static void takeScreenshot(WebElement element, String filename) throws
	 * IOException { File src = element.getScreenshotAs(OutputType.FILE);
	 * FileUtils.copyFile(src, new File("./target/screens/" + filename + ".png")); }
	 * //method 1
	 */

	public static void takeScreenshot(WebElement element, String filename) throws IOException {
		TakesScreenshot src = ((TakesScreenshot) element); // method 2
		File src1 = src.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src1, new File("./target/screens/" + filename + ".png"));
	}

}
