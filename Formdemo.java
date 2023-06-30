package seliniumproject5;
import java.io.File;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.Select;



public class Formdemo {

	public static void main(String[] args) throws InterruptedException, IOException {
		System.setProperty("webdriver.chrome.driver","D:\\chromedriver_win32\\chromedriver.exe");
		ChromeOptions options=new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		WebDriver driver=new ChromeDriver(options);
		driver.get("https://demoqa.com/automation-practice-form/");
		driver.manage().window().maximize();
		Thread.sleep(2000);
		driver.findElement(By.id("firstName")).sendKeys("Nancy Leema");
		driver.findElement(By.id("lastName")).sendKeys("Karunakaran");
		driver.findElement(By.id("userEmail")).sendKeys("nancyleema.k0911@gmail.com");
		//radiobuttons
		WebElement radio2= driver.findElement(By.xpath("//label[contains(text(),'Female')]"));
		radio2.click();
		System.out.println(radio2.isSelected());
		driver.findElement(By.id("userNumber")).sendKeys("7358339748");
		driver.findElement(By.id("dateOfBirthInput")).click();
		//Dateof birth dropdown
		WebElement dropdown=driver.findElement(By.xpath("//body/div[@id='app']/div[1]/div[1]/div[2]/div[2]/div[2]/form[1]/div[5]/div[2]/div[2]/div[2]/div[1]/div[1]/div[2]/div[1]/div[2]/div[1]/select[1]"));
		WebElement dropdown1=driver.findElement(By.xpath("//body/div[@id='app']/div[1]/div[1]/div[2]/div[2]/div[2]/form[1]/div[5]/div[2]/div[2]/div[2]/div[1]/div[1]/div[2]/div[1]/div[2]/div[2]/select[1]"));
		Select dd=new Select(dropdown);
		Select dd1=new Select(dropdown1);
		dd.selectByVisibleText("November");
		dd1.selectByVisibleText("2000");
		driver.findElement(By.xpath("//*[@id=\"dateOfBirth\"]/div[2]/div[2]/div/div/div[2]/div[2]/div[2]/div[5]")).click();
		//checklist
		WebElement Music=driver.findElement(By.xpath(" //label[contains(text(),'Music')]"));
		Music.click();
		WebElement Sports=driver.findElement(By.xpath("//label[contains(text(),'Sports')]"));
		Sports.click();
		//unclick
	    Sports.click();
	    //upload file
	    driver.findElement(By.xpath("//*[@id=\"uploadPicture\"]")).sendKeys("C:\\Users\\Admin\\Desktop\\images");
	    driver.findElement(By.xpath("//textarea[@id='currentAddress']")).sendKeys("No.8Thulukanathamman koil,8th cross Street ,Pallikaranai,chennai-600100");
	    //Screenshot
		TakesScreenshot srcshot=(TakesScreenshot)driver;
		File src=srcshot.getScreenshotAs(OutputType.FILE);
		File des=new File("C:\\Users\\Admin\\Desktop\\screenshot\\snap.jpg");
		FileHandler.copy(src, des);
		driver.quit();
		
	
	}
}
