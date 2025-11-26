package week5.day2;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

public class Bigbasket {

	public static void main(String[] args) throws IOException, InterruptedException {
		// TODO Auto-generated method stub
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		
		
		//Launch the browser
		ChromeDriver driver=new ChromeDriver(options);
		
		//Launch the URL
		driver.get("https://www.bigbasket.com/");
		
		//Maximise the window
		driver.manage().window().maximize();
		
		//wait to load the page 
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		//click Shop By Category option
		WebElement category = driver.findElement(By.xpath("(//span[text()='Category'])[2]"));
		Actions act = new Actions(driver);
		act.moveToElement(category).perform();
		category.click();
		
		
		//Locate and Mouse Hover to "Foodgrains, Oil & Masala"		
		WebElement foodGrains = driver.findElement(By.xpath("(//a[text()='Foodgrains, Oil & Masala'])[2]"));
		act.moveToElement(foodGrains).perform();
		foodGrains.click();
				
				
		//Locate and Mouse Hover To Rice and Rice Products		
		WebElement riceProducts = driver.findElement(By.xpath("//a[text()='Rice & Rice Products']"));
		act.moveToElement(riceProducts).perform();
		riceProducts.click();
		
		//click boiled and steam rice
		driver.findElement(By.xpath("//a[text()='Boiled & Steam Rice']")).click();
		
		//Scroll and Click The "BB Royal" brand
		WebElement findBBRoyal = driver.findElement(By.xpath("//input[@id='i-bbRoyal']"));
		act.scrollToElement(findBBRoyal).perform();
		Thread.sleep(5000);
		act.doubleClick(findBBRoyal).perform();
		
		//Click on "Tamil Ponni Boiled Rice"
		driver.findElement(By.xpath("//h3[text()='Tamil Ponni Boiled - Rice']")).click();
		
		Set<String> windowHandles = driver.getWindowHandles();
		List<String> allWindowHandles= new ArrayList<String>(windowHandles);
		driver.switchTo().window(allWindowHandles.get(1));
		
		//Select the 5 Kg bag.
		WebElement findFiveKG = driver.findElement(By.xpath("(//span[text()='5 kg']"));
		act.scrollToElement(findFiveKG).perform();
		findFiveKG.click();
		
		// get the price
		WebElement getAmountDetails = driver.findElement(By.xpath("//div[contains(@class,'StickyPdDetail')]"));
		String ricePrice = getAmountDetails.getText();
		ricePrice = ricePrice.replaceAll("[^0-9]", "");
		System.out.println("Rice Price is : "+ricePrice);
		
		//Click "Add" to add the bag to your cart.
		driver.findElement(By.xpath("//button[text()='Add to basket']")).click();
		
		//Verify the success message that confirms the item was added to your cart
		String textMessage= driver.findElement(By.xpath("//p[text()='An item has been added to your basket successfully']")).getText();
		System.out.println(textMessage);
		
		String successMessage="An item has been added to your basket successfully";
		
		if (textMessage.equalsIgnoreCase(successMessage)) {
			System.out.println("Item successfully added to the cart");
		} else {
			System.out.println("Item not added");
		}
		
		File source=driver.getScreenshotAs(OutputType.FILE);
		File destination= new File("/screenshots/ItemAdded.png");
		FileUtils.copyFile(source, destination);
		
		//Close the current window
		driver.close();
				
		//Switch to main window
		driver.switchTo().window(allWindowHandles.get(0));
				
		//Close the main window
		driver.close();
				
		
		
		
	}

}
