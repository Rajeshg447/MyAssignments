package week2.day2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

public class EditLead {

	public static void main(String[] args) {
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
		//Enter the company name
		driver.findElement(By.xpath("//input[@id='createLeadForm_companyName']")).sendKeys("TestLeaf");
		//Enter the firstName
		driver.findElement(By.xpath("//input[@id='createLeadForm_firstName']")).sendKeys("Rajesh4478");
		//Enter the lastName
		driver.findElement(By.xpath("//input[@id='createLeadForm_lastName']")).sendKeys("Gunasekhar1");
		//Enter the firstName local
		driver.findElement(By.xpath("//input[@id='createLeadForm_firstNameLocal']")).sendKeys("Raj");
		//Enter the department field
		driver.findElement(By.xpath("//input[@id='createLeadForm_departmentName']")).sendKeys("QA");
		//Enter the description field
		driver.findElement(By.xpath("//textarea[@id='createLeadForm_description']")).sendKeys("This is Rajesh Gunasekhar");
		//Enter the email field
		driver.findElement(By.xpath("//input[@id='createLeadForm_primaryEmail']")).sendKeys("rajeshsekhar447@gmail.com");
		//Enter the state/Province
		WebElement StateDD=driver.findElement(By.xpath("//select[@id='createLeadForm_generalStateProvinceGeoId']"));
		Select sel1= new Select(StateDD);
		sel1.selectByVisibleText("New York");
		//click on CreateLead button
		driver.findElement(By.xpath("//input[@name='submitButton']")).click();
		//click on Edit button
		driver.findElement(By.xpath("//a[(text()='Edit')]")).click();
		//clear the description field
		driver.findElement(By.xpath("//textarea[@id='updateLeadForm_description']")).clear();
		//Fill the important note field
		driver.findElement(By.xpath("//textarea[@id='updateLeadForm_importantNote']")).sendKeys("important notes");
		//click on update button
		driver.findElement(By.xpath("//input[@value='Update']")).click();
		//get the title of the page
		String title = driver.getTitle();
		System.out.println("title of the resulting page "+title);
		//close the browser
		driver.close();
	}

}
