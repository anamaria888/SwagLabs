package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutCompletePage {
	WebDriver driver;
	
	public CheckoutCompletePage(WebDriver driver) {
		this.driver = driver;
	}
	
	//Elements
	private By completeText = By.xpath("//div[@class=\"checkout_complete_container\"]/div");
	
	//actions
	public String getCompleteText() {
		return driver.findElement(completeText).getText();
	}

}
