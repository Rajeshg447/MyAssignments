package week2.day1;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class CreateLead {

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
	//click  on the "CRM/SFA" link. 
	driver.findElement(By.xpath("//a[contains(text(),'CRM/SFA')]")).click();
	//click on the Leads tab
	driver.findElement(By.xpath("//a[contains(text(),'Leads')]")).click();
	//click on the Create Lead button
	driver.findElement(By.xpath("//a[contains(text(),'Create Lead')]")).click();
	//enter the first name
	driver.findElement(By.xpath("//input[@id='createLeadForm_firstName']")).sendKeys("firstRaj");
	//enter the last name
	driver.findElement(By.xpath("//input[@id='createLeadForm_lastName']")).sendKeys("LastGuna");
	//enter the company name
	driver.findElement(By.xpath("//input[@id='createLeadForm_companyName']")).sendKeys("Accenture");
	//enter the title
	driver.findElement(By.xpath("//input[@id='createLeadForm_generalProfTitle']")).sendKeys("Mr.");
	//click on create Lead button
	driver.findElement(By.xpath("//input[@name='submitButton']")).click();
	//print the title
	String titleOfCurrentWindow = driver.getTitle();
	System.out.println("title of current window is "+titleOfCurrentWindow);
	Thread.sleep(3000);
	//close the window
	driver.close();
	


	}

}
