package marathon1;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Testcase2 {

	public static void main(String[] args) throws InterruptedException {
		
		
		//To Launch the application in the guest mode	
		ChromeOptions options = new ChromeOptions();
		options.addArguments("guest");
		
		//instantiate the browser driver 
		ChromeDriver driver=new ChromeDriver(options);
				
				
		//2) Load the Url "https://www.pvrcinemas.com/";
		driver.get("https://www.amazon.in/");
				
		//maximising the window
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	//03) Type "Bags for boys" in the Search box
		driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']")).sendKeys("bags for boys",Keys.ENTER);
		
		// 04) Choose the item in the result (bags for boys)
		// 05) Print the total number of results (like 50000)
		//1-48 of over 50,000 results for "bags for boys"
		
		String result=	driver.findElement(By.xpath("(//h2[@class='a-size-base a-spacing-small a-spacing-top-small a-text-normal']/span)[1]")).getText();
		System.out.println("Result is "+result);
		

		//	06) Select the first 2 brands in the left menu
		driver.findElement(By.xpath("(//div[@id='brandsRefinements']//div[contains(@class,'a-checkbox-fancy')]//label)[1]")).click();
		driver.findElement(By.xpath("(//div[@id='brandsRefinements']//div[contains(@class,'a-checkbox-fancy')]//label)[2]")).click();
		
		//07) Choose New Arrivals (Sort) 	
		driver.findElement(By.xpath("//span[text()='Featured']")).click();
		driver.findElement(By.xpath("//a[text()='Newest Arrivals']")).click();
		Thread.sleep(3000);
		
	//08) Print the first resulting bag info (name, discounted price)
			String productName = driver.findElement(By.xpath("//h2[@class='a-size-base-plus a-spacing-none a-color-base a-text-normal']")).getText();
			System.out.println("Product Name Is : "+productName);
			String productPrice = driver.findElement(By.xpath("(//div[@class='a-row']//span//span)[1]")).getText();
			System.out.println("Product Price Details Are : "+productPrice);
		
		//09) Get the page title and close the browser(driver.close())
			String title = driver.getTitle();
			System.out.println("Browser Current Title Is : "+title);
		
		//close the browser
			driver.quit();
	}

}
