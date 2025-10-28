package week2.day2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class DeleteLead {

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
		//click the Leads link
		driver.findElement(By.xpath("//a[text()='Leads']")).click();
		//click the find leads link
		driver.findElement(By.xpath("//a[text()='Find Leads']")).click();
		//click the phone tab
		driver.findElement(By.xpath("//span[text()='Phone']")).click();
		//Enter the phone number
		driver.findElement(By.xpath("//input[@name='phoneNumber']")).sendKeys("99");
		//click find leads button
		driver.findElement(By.xpath("//button[contains(text(),'Find Leads')]")).click();
		//find firstleadid, capture and print
		WebElement firstLeadID=driver.findElement(By.xpath("(//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a[@class='linktext'])[1]"));
		String leadID = firstLeadID.getText();
		System.out.println("the leadid which is to deleted is "+leadID);
		Thread.sleep(5000);
		// click the firstleadid
		firstLeadID.click();
		//Delete the lead
	driver.findElement(By.xpath("//a[text()='Delete']")).click();
	
	//click the find leads link
			driver.findElement(By.xpath("//a[text()='Find Leads']")).click();
			
			
			//Enter the captured leadid in the leadid textbox
			driver.findElement(By.xpath("//input[@name='id']")).sendKeys(leadID);
			
			//click find leads button
			driver.findElement(By.xpath("//button[contains(text(),'Find Leads')]")).click();
			
			String resultText = driver.findElement(By.xpath("//div[@class='x-paging-info']")).getText();
			
			if(resultText.equals("No records to display"))
					{
				System.out.println("LeadID deleted successfully");
					}
			else {
				System.out.println("LeadID not deleted successfully");
			}
			
			
		
		
	}

}
