package week2.day1;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class CreateAccount {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		//To Launch the application in the guest mode	
		ChromeOptions options = new ChromeOptions();
		options.addArguments("guest");
		
		//instantiate the browser driver 
		ChromeDriver driver=new ChromeDriver(options);
		//maximise the window
		driver.manage().window().maximize();
		//Load the url
		driver.get("http://leaftaps.com/opentaps/");
		//enter username
		driver.findElement(By.xpath("//input[@id='username']")).sendKeys("demosalesmanager");
		//enter password
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys("crmsfa");
		//click login button
		driver.findElement(By.xpath("//input[@class='decorativeSubmit']")).click();
		//click crmsfa
		driver.findElement(By.xpath("//a[contains(text(),'CRM/SFA')]")).click();
		//click Accounts tab
		driver.findElement(By.xpath("//a[contains(text(),'Accounts')]")).click();
		//click create Account
		Thread.sleep(3000);
		
		//driver.findElement(By.xpath("(//a[text()='Create Account']")).click();
			driver.findElement(By.xpath("//a[contains(text(),'Create Account')]")).click();
		//driver.findElement(By.linkText("Create Account")).click();
		//Enter the accountname
		driver.findElement(By.xpath("//input[@id='accountName']")).sendKeys("Rajesh12345");
		
		//enter the description
		driver.findElement(By.xpath("//textarea[@name='description']")).sendKeys("Selenium Auomation Tester");
		
		//enter the number of employees
		driver.findElement(By.xpath("//input[@id='numberEmployees']")).sendKeys("70");
		
		//enter the site Name
		driver.findElement(By.xpath("//input[@id='officeSiteName']")).sendKeys("LeafTaps");
		
		//click createAccount button
		driver.findElement(By.xpath("//input[@value='Create Account']")).click();
		
		String title = driver.getTitle();	
		System.out.println("Title of the page is "+title);
		//Thread.sleep(3000);
		
		driver.close();
		
	}

}
