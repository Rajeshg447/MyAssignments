package marathon1;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Testcase1 {
	
	public static void main(String[] args) throws InterruptedException {
		
		//Launching the browser
		ChromeDriver driver = new ChromeDriver();
		
		
		//2) Load the Url "https://www.pvrcinemas.com/";
		driver.get("https://www.pvrcinemas.com/");
		
		//maximising the window
		driver.manage().window().maximize();
		Thread.sleep(3000);
		//click on arrow dropdown
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		Thread.sleep(3000);
		
		//driver.findElement(By.xpath("(//div[@class='custom-dropdown-arrow'])[1]")).click();
		//Thread.sleep(3000);
		Actions act =new Actions(driver);
		
		WebElement location = driver.findElement(By.xpath("(//img[@alt='map'])[1]"));
		act.moveToElement(location).perform();
		location.click();
		
		//3) //Choose Your location as "Chennai"
		driver.findElement(By.xpath("//h6[contains(text(),'Chennai')]")).click();
		

		//4) Click on Cinema under Quick Book
		driver.findElement(By.xpath("(//span[contains(text(),'Cinema')])[1]")).click();

		//5) Select Your Cinema
		driver.findElement(By.xpath("(//span[contains(text(),'Select Cinema')])[1]")).click();
		driver.findElement(By.xpath("//span[contains(text(),'Virugambakkam')]")).click();
		driver.findElement(By.xpath("//span[contains(text(),'Select Date')]")).click();
		//6) Select Your Date as Tomorrow
		
		driver.findElement(By.xpath("//span[contains(text(),'Tomorrow')]")).click();

		//7) Select Your Movie
		driver.findElement(By.xpath("//span[contains(text(),'BAAHUBALI - THE EPIC')]")).click();
		//8) Select Your Show Time
		driver.findElement(By.xpath("//span[contains(text(),'06:25 PM')]")).click();
		//9) Click on Book Button
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		//10) Click Accept on Term and Condition
		driver.findElement(By.xpath("//button[contains(text(),'Accept')]")).click();
		
		//11) Click any one available seat
		driver.findElement(By.xpath("//span[contains(text(),'SILVER ')]//following::span[@class='seat-current-pvr']")).click();
		
		//12) Click Proceed Button
		driver.findElement(By.xpath("//button[contains(text(),'Proceed')]")).click();
		
		//14) Print the grand total under book summary
		String totalAmount = driver.findElement(By.xpath("//div[@class='grand-tota col-md-3']//span")).getText();
		System.out.println("Grand Total Amount Is : "+totalAmount);
				
				
		//15) Click Continue
		driver.findElement(By.xpath("//button[text()='Continue']")).click();
					
					
		//16) Close the popup
		driver.findElement(By.xpath("(//i[@class='pi pi-times'])[2]")).click();
					
		//17) Print Your Current Page title
		String title = driver.getTitle();
		System.out.println("Current Browser Title Is : "+title);
					
		//18) Close Browser
		driver.quit();
				
		}
}
