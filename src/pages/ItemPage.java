package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ItemPage {
	WebDriver driver;
	
	public ItemPage(WebDriver driver) {
		this.driver = driver;
	}
	
	//Elements
	private By title = By.xpath("//div[@class=\"inventory_details_desc_container\"]/div[1]");
	private By description = By.xpath("//div[@class=\"inventory_details_desc_container\"]/div[2]");
	private By price = By.xpath("//div[@class=\"inventory_details_desc_container\"]/div[3]");
	private By addToCartButton = By.xpath("//div[@class=\"inventory_details_desc_container\"]/button");
	
	//actions
	public String getTitle() {
		return driver.findElement(title).getText();
	}
	
	public String getDescription() {
		return driver.findElement(description).getText();
	}
	
	public String getPrice() {
		return driver.findElement(price).getText();
	}
	
	public void clickOnAddToCartButton() {
		driver.findElement(addToCartButton).click();	
	}
	

}
