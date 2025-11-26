package week5.day2;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

public class Snapdeal {

	public static void main(String[] args) throws InterruptedException, IOException {
		// TODO Auto-generated method stub
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		
		
		//Launch the browser
		ChromeDriver driver=new ChromeDriver(options);
		
		//Launch the URL
		driver.get("https://www.snapdeal.com/");
		
		//Maximise the window
		driver.manage().window().maximize();
		
		//wait to load the page 
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		// Create object for actions class
		Actions act = new Actions(driver);
		
		// Got to men's fashion
		WebElement go_Men = driver.findElement(By.xpath("//div[@id='tab-category-0']"));
		act.moveToElement(go_Men).perform();
		go_Men.click();

		//click on sports shoes
		WebElement sport_Shoes = driver.findElement(By.xpath("//div[text()='Sports Shoes']"));
		sport_Shoes.click();
		
		
		//get and print the count of sport shoes
		WebElement getCount = driver.findElement(By.xpath("//h1[@class='category-name']/following-sibling::span"));
		String getCountText = getCount.getText();
		String replace_Count = getCountText.replaceAll("[^0-9]","");
		System.out.println("The total items are "+replace_Count);
		
		//click on training shoes
		WebElement trainingShoes = driver.findElement(By.xpath("//div[text()='Training Shoes']"));
		trainingShoes.click();
		
		//sort the products by "Low to High"
		driver.findElement(By.xpath("//div[@class='sort-drop clearfix']")).click();
		
		driver.findElement(By.xpath("(//li[@class='search-li'])[1]")).click();
		
		Thread.sleep(3000);
		
		//Get the all the amounts from the list of products
				List<WebElement> getAmount = driver.findElements(By.xpath("//span[@class='lfloat product-price']"));
				List<Integer> amountDetails = new ArrayList<>();
		
				//Covert the value into integer and store into the list<integer> amount Details
		for (WebElement each : getAmount) {
			String value = each.getText();
			value=value.replaceAll("[^0-9]","");
			amountDetails.add(Integer.parseInt(value));
			
		}
		System.out.println(amountDetails);
		
		//Check the displayed items are sorted correctly. 
		for (int i = 0; i < amountDetails.size()-1; i++) {
			int a=amountDetails.get(i);
			int b=amountDetails.get(i+1);
			if(a>b)
			{
				System.out.println("Sorting is incorrect");
			}
			
			else {
				System.out.println("Sorting is correct between a and b");
			}
		}
		
		
		// enter from value
		WebElement fromValue = driver.findElement(By.xpath("//input[@name='fromVal']"));
		fromValue.clear();
		fromValue.sendKeys("500");
		
		// enter to value
		WebElement toValue = driver.findElement(By.xpath("//input[@name='toVal']"));
		toValue.clear();
		toValue.sendKeys("700");
		
		// click go button
		driver.findElement(By.xpath("//div[contains(text(),'GO')]")).click();
		
		Thread.sleep(3000);
		//Filter by color
		//WebElement filterColor = driver.findElement(By.xpath("//label[contains(@for,'Color')]"));
		//WebElement filterColor = driver.findElement(By.xpath("//span[@class='filter-color-tile White&Blue ']"));
		WebElement filterColor = driver.findElement(By.xpath("//label[@for='Color_s-White%20%26%20Blue']"));
		act.scrollToElement(filterColor).perform();
		filterColor.click();
		
		//Mouse hover on the first resulting "Training Shoes"
		//WebElement productMouseHover = driver.findElement(By.xpath("(//section[contains(@class,'js-section')]/div)[1]"));
		WebElement productMouseHover = driver.findElement(By.xpath("(//img[@class='product-image wooble'])[1]"));
		act.moveToElement(productMouseHover).perform();
	
		
		Thread.sleep(3000);
		//Click the "Quick View" button.
		driver.findElement(By.xpath("(//div[contains(text(),'Quick View')])[1]")).click();
		
		//Print the cost
		WebElement priceDetails = driver.findElement(By.xpath("//span[@class='payBlkBig']"));
		String priceAmount = priceDetails.getText();
		System.out.println("Price amount is "+priceAmount);
		
		//Print the discount percentage
		WebElement dicountPercentage = driver.findElement(By.xpath("//span[contains(@class,'percent-desc')]"));
		String discount = dicountPercentage.getText();
		String discount1=discount.replace("[^0-9]", "");
		System.out.println("discount is "+discount1);
		
		//Take a snapshot of the shoes.
		WebElement product = driver.findElement(By.xpath("//img[@class='cloudzoom']"));
		File source = product.getScreenshotAs(OutputType.FILE);
		File destination = new File("./screenshots/shoeimage.png");
		FileUtils.copyFile(source, destination);

		//Close the current window. 
		driver.findElement(By.xpath("(//i[@class='sd-icon sd-icon-delete-sign'])[3]")).click();
		
		//close the main window
		driver.close();
	}

}
