package pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CartPage {
	WebDriver driver;
	
	
	public CartPage(WebDriver driver) {
		this.driver = driver;
	}
	
	//Elements
	private By removeButton (String id) {return By.xpath("//a[@id=\"item_"+id+"_title_link\"]/following-sibling::div[2]/button");}
	private By checkoutButton = By.id("checkout");
	private By itemName (String name) { return By.xpath("//div[@class=\"cart_item_label\"]/a/div[contains(.,\""+name+"\")]");}
	private By cartItems = By.xpath("//div[@class=\"cart_item_label\"]/a/div");
	private By itemPrice (String price) { return By.xpath("//div[@class=\"cart_item_label\"]/div[2]/div[contains(.,\""+price+"\")]");}
	
	//actions
	public String getItemTitle(String name) {
		return driver.findElement(itemName(name)).getText();
	}
	
	public String getItemPrice(String price) {
		return driver.findElement(itemPrice(price)).getText();
	}
	
	public List<String> getItemsList(){
		List<WebElement> itemElements = driver.findElements(cartItems);
		List<String> itemValues = new ArrayList<String>();
		
		for(WebElement item:itemElements) {
			if (!item.getText().isBlank()) {
				itemValues.add(item.getText());
			}
		}
		return itemValues;
	}
	
	public void removeItem(String id) {
		 driver.findElement(removeButton(id)).click();
	}
	
	public void clickOnCheckoutButton() {
		driver.findElement(checkoutButton).click();
	}
}
