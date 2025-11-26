package week5.day2;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Amazon {

	public static void main(String[] args) throws IOException {
		
		ChromeOptions options = new ChromeOptions();
		options.addArguments("guest");
		
		//Launch the browser
		ChromeDriver driver=new ChromeDriver(options);
		
		//Launch the URL
		driver.get("https://www.amazon.in/");
		
		//Maximise the window
		driver.manage().window().maximize();
		
		//wait to load the page 
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		
		//Search the input and click enter
		driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']")).sendKeys("oneplus 9 pro",Keys.ENTER);
		
		//take the first price of the product
		WebElement price = driver.findElement(By.xpath("(//span[@class='a-price-whole'])[1]"));
		String text = price.getText();
		System.out.println("Price of the first item "+text);
		
		
		//take the first product rating
		WebElement getRatingCount = driver.findElement(By.xpath("//div[contains(@class,'a-size-small')]/a/span"));
		String ratingCount = getRatingCount.getText();
		ratingCount = ratingCount.replace("(", "").replace(")", "");
		System.out.println("Number Of Ratings Give For The First Product : "+ratingCount);
	
		
		
		String parentWindow=driver.getWindowHandle();
		System.out.println("Address of the Parent window "+parentWindow);
		
		//click the first product image
		WebElement firstProductlink = driver.findElement(By.xpath("(//h2[@class='a-size-medium a-spacing-none a-color-base a-text-normal'])[1]"));
		firstProductlink.click();
		
		//To store the multiple windows
		Set<String> windowHandles = driver.getWindowHandles();
		//Store the multiple windows into the List
		List<String> allwindowHandles = new ArrayList<String>(windowHandles);
		
		//switch to the child window
		driver.switchTo().window(allwindowHandles.get(1));
		
		//Take screenshot of the product image and save
		WebElement product = driver.findElement(By.id("imgTagWrapperId"));
		File source=product.getScreenshotAs(OutputType.FILE);
		File destination= new File("./screenshots/product.png");
		FileUtils.copyFile(source, destination);
		
		// Click Add to cart option
		driver.findElement(By.xpath("//input[@id='add-to-cart-button']")).click();
		
		//Get & Print the Whole Value
		WebElement subTotal = driver.findElement(By.xpath("(//span[@class='a-price-whole'])[1]"));
		String subTotalText = subTotal.getText();
		System.out.println("Subtotal price is "+subTotalText);
		
		//checking the First product amount and subtotalamount
		if (text.equalsIgnoreCase(subTotalText)) {
			System.out.println("Price are same");
		} else {
			System.out.println("Price are Different");
		}
	
		//close all browsers
		driver.quit();
		}
}
