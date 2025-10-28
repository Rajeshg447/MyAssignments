package week2.day1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FacebookLogin {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//instantiate the browser
		ChromeDriver driver=new ChromeDriver();
		
		//Launch the application
		driver.get("https://www.facebook.com/");
		
		//maximise the browser window
		driver.manage().window().maximize();
		
		
		  //Enter the email id as testleaf.2023@gmail.com
		  driver.findElement(By.id("email")).sendKeys("testleaf.2023@gmail.com");
		  
		  //Enter the password as Tuna@321
		  driver.findElement(By.id("pass")).sendKeys("Tuna@321");
		  
		  //click login button
		  driver.findElement(By.xpath("//button[@name='login']")).click();
		  
		  //get and print the title driver.getTitle(); 
		  //System.out.println(driver.getTitle());
		  
		  String title = driver.getTitle();
		  System.out.println("title of the page is "+title);
		 
		
		/*
		 * //Enter the email id as testleaf.2023@gmail.com
		 * driver.findElement(By.id("email")).sendKeys("rajesh.gunasekhar@gmail.com");
		 * 
		 * //Enter the password as Tuna@321
		 * driver.findElement(By.id("pass")).sendKeys("******");
		 * 
		 * //click login button
		 * driver.findElement(By.xpath("//button[@name='login']")).click();
		 * 
		 * //get and print the title driver.getTitle();
		 * System.out.println(driver.getTitle());
		 */
	}

}
