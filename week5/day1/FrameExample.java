package week5.day1;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class FrameExample {

	public static void main(String[] args) {
		
		//create a object for ChromeDriver to launch the browser
		ChromeDriver driver = new ChromeDriver();

		//Maximize the browser
		driver.manage().window().maximize();
		
		//load the URL
		driver.get("https://www.w3schools.com/js/tryit.asp?filename=tryjs_prompt");

		//wait to load the page 
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));


		//switch To frame
		driver.switchTo().frame("iframeResult");
		
		//click the option
		driver.findElement(By.xpath("//button[(text()='Try it')]")).click();

		//swith to alert
		Alert alert=driver.switchTo().alert();
		
		//Accept the alert
				alert.accept();
		
		// get the text and validate the message is successfull
		String getText = driver.findElement(By.id("demo")).getText();
		System.out.println("the text displayed is "+getText);
		
		String expected_Msg = "Hello Harry Potter! How are you today?";

		if (getText.equals(expected_Msg)) {
					System.out.println("The Ok button is clicked and alert is accepted");
		} else {
					System.out.println("The Cancel button is clicked and alert is dimissed");
		}

				// To Quit the browser window
				driver.quit();
		
		
	}

}
