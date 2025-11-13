package week4.day2;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class WindowHandling {
	
	public static void main(String[] args) throws InterruptedException {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("guest");
		
		//instantiate the browser driver 
		ChromeDriver driver=new ChromeDriver(options);
		
		//load the URL
		driver.get("http://leaftaps.com/opentaps/control/login");
		//maximize the browser
		driver.manage().window().maximize();
		//wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		//Enter the username
		driver.findElement(By.id("username")).sendKeys("DemoSalesManager");
		
		//Enter the password
		driver.findElement(By.id("password")).sendKeys("crmsfa");
		
		//click login button
		driver.findElement(By.className("decorativeSubmit")).click();
		
		//click CRMSFA link
		driver.findElement(By.linkText("CRM/SFA")).click();
		
		//click Contacts button
		driver.findElement(By.xpath("//a[text()='Contacts']")).click();
		
		//click merge contact button
		driver.findElement(By.xpath("//a[contains(text(),'Merge Contacts')]")).click();
		
		 // Get current window handle (Parent)
		String parentWindow = driver.getWindowHandle();
		
		//click the widget of the "From Contacts"
		driver.findElement(By.xpath("(//img[@alt='Lookup'])[1]")).click();
		
		
		//wait for sometime
		Thread.sleep(2000);
		
		//store the all the windows
		Set<String> allwindows= driver.getWindowHandles();
		
		//Store into the list
		List<String> listWindows = new ArrayList<String>(allwindows);
		
		//Switch to child window
		for (String eachWindows : listWindows) {
			if (!eachWindows.equals(parentWindow)) {
				driver.switchTo().window(eachWindows);
			}
		}
		
		//wait for sometime
		Thread.sleep(3000);
		
		//maximize the new window
		driver.manage().window().maximize();
		
		//click the first value
		driver.findElement(By.xpath("(//table[@class='x-grid3-row-table']//td[contains(@class,'cell-first ')]//a)[1]")).click();
				
		//Again switch to parent window
		driver.switchTo().window(parentWindow);
		
		driver.findElement(By.xpath("(//img[@alt='Lookup'])[2]")).click();
		
		
		//store the all the windows
		Set<String> allwindows1= driver.getWindowHandles();
		
		//Store into the list
		List<String> listWindows1 = new ArrayList<String>(allwindows1);
		
		//Switch to child window
		for (String eachWindows : listWindows1) {
			if (!eachWindows.equals(parentWindow)) {
				driver.switchTo().window(eachWindows);
			}
		}
		
		//wait for sometime
		Thread.sleep(3000);
		
		//maximize the new window
		driver.manage().window().maximize();
		
		//click the second value
		driver.findElement(By.xpath("(//table[@class='x-grid3-row-table']//td[contains(@class,'cell-first ')]//a)[2]")).click();
		
		//Again switch to parent window
		driver.switchTo().window(parentWindow);
		
		//click on Merge button
		driver.findElement(By.xpath("//a[@class='buttonDangerous']")).click();
		
		//swith to the control to alert
		Alert alert =driver.switchTo().alert();
		
		//Accept the alert
		alert.accept();
		
		//wait for sometime
		Thread.sleep(3000);
		
		//get title of current window and print
		String currentWindowTitle = driver.getTitle();
		System.out.println("Current Window Title Is : "+currentWindowTitle);
		
		//close the browser
		driver.close();
		
		
	}
	}
	
