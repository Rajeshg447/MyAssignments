package week4.day2;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Myntra {

	public static void main(String[] args) throws InterruptedException {
		//To Launch the application in the guest mode	
		ChromeOptions options = new ChromeOptions();
		options.addArguments("guest");
		
		//instantiate the browser driver 
		ChromeDriver driver=new ChromeDriver(options);
		
		//load the URL
		driver.get("https://www.myntra.com/");
		//maximize the browser
		driver.manage().window().maximize();
		
		//wait sometime to load the page
		Thread.sleep(3000);
		
		//search the bags
		driver.findElement(By.xpath("//input[@class='desktop-searchBar']")).sendKeys("bags" , Keys.ENTER);
		
		//wait sometime to load the page
		Thread.sleep(3000);
		
		//select men filter
		driver.findElement(By.xpath("(//label[@class='common-customRadio gender-label'])[1]")).click();
		
		//wait sometime to load the page
		Thread.sleep(3000);
		
		//Under the "Category" click "Laptop Bags"
		driver.findElement(By.xpath("//label[contains(text(),'Laptop Bag')]")).click();
		
		//print the result count
		Thread.sleep(3000);
		String resultCount = driver.findElement(By.xpath("//span[@class='title-count']")).getText();
		System.out.println("Results Counts For The Laptop Bag : "+resultCount);
				
		
		Thread.sleep(3000);
		//find the products
		List<WebElement> productBrands = driver.findElements(By.xpath("//h3[@class='product-brand']"));
		//find the bagNames
		List<WebElement> bagNames = driver.findElements(By.xpath("//h4[@class='product-product']"));
		
		//declare the list for the products
		List<String> getList_products = new ArrayList();
		//declare the list for the bags
		List<String> getList_bagNames = new ArrayList();
		
		//Add all the products into the product list
		for (WebElement prod : productBrands) {
			String text = prod.getText();
			getList_products.add(text);
		}
		
		//Add all the bags into the bagnames list
		for (WebElement prod : bagNames) {
			String text = prod.getText();
			getList_bagNames.add(text);
		}
		
		//Print the product list
		System.out.println(getList_products);
		//Print the bagNames List
		System.out.println(getList_bagNames);
		
		//Print the number of products
		System.out.println(getList_products.size());
		//Print the number of bags
		System.out.println(getList_bagNames.size());
		
		driver.close();

	}

}
