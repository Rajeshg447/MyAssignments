package week5.day1;

import java.time.Duration;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class FinanceYahoo {

	public static void main(String[] args) throws InterruptedException {
		
		//create a object for ChromeDriver to launch the browser
		ChromeDriver driver= new ChromeDriver();
		
		//Maximize the browser
		driver.manage().window().maximize();
		
		
		//wait to load the page 
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		
		//load the URL
		driver.get("https://finance.yahoo.com/");
		
		//Using actions for mouse hover
		Actions act=new Actions(driver);
		
		WebElement click_More = driver.findElement(By.xpath("//span[text()='More']"));
		act.moveToElement(click_More).perform();
		
		
		
		//clicking the crypto option
		driver.findElement(By.xpath("(//a[contains(text(),'Crypto')])[3]")).click();
		
		// Get crypto elements
		List<WebElement> cryptoNamesList = driver.findElements(By.xpath("//table[@class='yf-14a4l34 bd']/tbody/tr/td[2]/div"));
		
		//Get Cryptonames from the cryptolist
		for (WebElement each : cryptoNamesList) {
			String cryptoNames = each.getText();
			System.out.println(cryptoNames);
		}
		
		driver.close();
	}

}
