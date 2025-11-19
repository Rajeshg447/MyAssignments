package marathon2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import io.github.sukgu.Shadow;

public class OrderingMobile {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		ChromeOptions options = new ChromeOptions();
		options.addArguments("guest");
		
		//instantiate the browser driver 
		ChromeDriver driver=new ChromeDriver();
		
		//Launching the browser
		driver.get("https://dev273042.service-now.com/");
		//maximising the window
		driver.manage().window().maximize();
				
		driver.findElement(By.xpath("//input[@id='user_name']")).sendKeys("admin");
		
		driver.findElement(By.xpath("//input[@id='user_password']")).sendKeys("*w6ndQP4vI$G");
		
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		
		Shadow sh = new Shadow(driver);
		sh.setImplicitWait(30);
		sh.findElementByXPath("//div[text()='All']").click();
		
		Thread.sleep(3000);
		sh.findElementByXPath("//span[text()='Service Catalog']").click();
		
		
		//Switch to frame
		WebElement findFrame = sh.findElementByXPath("//iframe[@id='gsft_main']");
		driver.switchTo().frame(findFrame);
				
				
		driver.findElement(By.xpath("//h2[contains(text(),'Mobiles')]")).click();
		
		driver.findElement(By.xpath("//strong[text()='Apple iPhone 13 pro']")).click();
		
		driver.findElement(By.xpath("//label[text()='Yes']")).click();
		
		
		Actions at = new Actions(driver);
		WebElement findPhoneNumber = driver.findElement(By.xpath("(//input[contains(@class,'form-control')])[2]"));
		at.scrollToElement(findPhoneNumber).perform();
		findPhoneNumber.sendKeys("99");
		
		WebElement dropdown = driver.findElement(By.xpath("//span[@id='status.IO:ff1f478e9747011021983d1e6253af68']"));
		Select sel = new Select(dropdown);
		sel.selectByValue("Unlimited");
		
		WebElement selectColor = driver.findElement(By.xpath("//label[text()='Sierra Blue']"));
		at.scrollToElement(selectColor).perform();
		selectColor.click();
		
		WebElement selectStorage = driver.findElement(By.xpath("//label[text()='512 GB']"));
		at.scrollToElement(selectStorage).perform();
		selectStorage.click();
		
		WebElement findOrderButton = driver.findElement(By.xpath("//button[text()='Order Now']"));
		at.scrollToElement(findOrderButton).perform();
		findOrderButton.click();
		
		WebElement getMessage = driver.findElement(By.xpath("//div[@class='notification notification-success']"));
		String getSuccessMessage = getMessage.getText();
		
		if(getSuccessMessage.contains("Submitted"))
		{
			System.out.println("Order got submitted Successfully");
			System.out.println(getSuccessMessage);
		}
		else {
			System.out.println("sorry your order is not placed, Please try after sometime");
		}
		
		
		WebElement getRequestid=driver.findElement(By.xpath("//a[@id='requesturl']/b"));
		String requestNumber=getRequestid.getText();
		System.out.println("Your order request number is"+requestNumber);
		
		
		
		
		
		
		
		
	}

}
