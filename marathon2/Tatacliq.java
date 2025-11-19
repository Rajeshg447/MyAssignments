package marathon2;

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
import org.openqa.selenium.support.ui.Select;

public class Tatacliq {

	public static void main(String[] args) throws InterruptedException, IOException {
		// TODO Auto-generated method stub
		ChromeOptions options = new ChromeOptions();
		options.addArguments("guest");
		
		//instantiate the browser driver 
		ChromeDriver driver=new ChromeDriver(options);
		
		//1. Load the url as https://www.tatacliq.com/
		driver.get("https://www.tatacliq.com/");
		//maximising the window
		driver.manage().window().maximize();
		Thread.sleep(3000);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	
		
		//2. MouseHover on 'Brands'
		Thread.sleep(3000);
		WebElement mouseHover = driver.findElement(By.xpath("//div[text()='Brands']"));
		//instantiate Action class
		Actions act=new Actions(driver);
		act.moveToElement(mouseHover).perform();
		
		Thread.sleep(3000);
		
		//3. MouseHover on 'Watches & Accessories'
		WebElement mouseHoverWatch = driver.findElement(By.xpath("//div[text()='Watches & Accessories']"));
		act.moveToElement(mouseHoverWatch).perform();
		
		
		Thread.sleep(3000);
		
		//4. Choose the first option from the 'Featured brands'.
		driver.findElement(By.xpath("//div[text()='Casio']")).click();
		
		Thread.sleep(5000);
		
		//5. Select sortby: New Arrivals
		WebElement sortbyDD = driver.findElement(By.xpath("//select[@label='Popularity']"));
		Select sel=new Select(sortbyDD);
		sel.selectByValue("New Arrivals");
		
		//6. choose men from catagories filter.
		driver.findElement(By.xpath("(//div[text()='Men'])[1]")).click();
		
		//7. print all price of watches
		List<WebElement> pricelist = driver.findElements(By.xpath("//h3[@class='ProductDescription__boldText']"));
		
		List<String> priceall = new ArrayList<String>();
		
		for (WebElement obj : pricelist) {
			WebElement prices = obj;
		String allPrices=	prices.getText();
		String all_Prices = allPrices.replaceAll("[^0-9]", "");
		priceall.add(all_Prices);
	}
		System.out.println(priceall);	
		
		//8. click on the first resulting watch.
		WebElement findProduct = driver.findElement(By.xpath("//div[@class='ProductModule__dummyDiv']"));
		act.scrollToElement(findProduct).perform();
		findProduct.click();
		
		//switch to child window
		Set<String> windowHandles =driver.getWindowHandles();
		List<String> allWindows= new ArrayList<String>(windowHandles);
		driver.switchTo().window(allWindows.get(1));
		
		//9. compare two price are similar
		WebElement getamount = driver.findElement(By.xpath("//div[contains(@class,'ProductDetailsMainCard')]//h3"));
		String price=	getamount.getText();
		price=price.replaceAll("[^0-9]","");
		if(priceall.get(0).equals(price))
		{
			System.out.println("Both the Screen watch prices are same");
		}
		else
		{
			System.out.println("Both the Screen watch prices are not same");
		}
		
		//10. click Add to cart and get count from the cart icon.
		WebElement addToBagButton = driver.findElement(By.xpath("//span[text()='ADD TO BAG']"));
		act.scrollToElement(addToBagButton).perform();
		addToBagButton.click();
		
		
		WebElement getCountValue = driver.findElement(By.xpath("//span[@class='DesktopHeader__cartCount']"));
		String cartCount = getCountValue.getText();
		System.out.println("Cart count is"+cartCount);
		
		//11. Click on the cart
		 driver.findElement(By.xpath("//div[@class='DesktopHeader__myBagShow']")).click();
		
			//12. Take a snap of the resulting page
			File source = driver.getScreenshotAs(OutputType.FILE);
			//path
			File destination=new File("./snaps/tatacliq.png");
			//connect source and destination

			FileUtils.copyFile(source, destination);
		
			//13. Close All the opened windows one by one.
			driver.close();
			driver.switchTo().window(allWindows.get(0));
			driver.close();
	}
}	
				


