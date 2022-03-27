package pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class ProductsPage {
	WebDriver driver;
	
	public ProductsPage(WebDriver driver) {
		this.driver = driver;
	}

	//Elements
	private By itemName (String name) { return By.xpath("//descendant::div[@class=\"inventory_item_label\"]/a/div[contains(.,\""+name+"\")]");}
	private By shoppingCart = By.xpath("//a[@class=\"shopping_cart_link\"]");
	private By productsName = By.xpath("//div[@class=\"inventory_item_label\"]/a/div");
	private By addToCartButton (String name) {return By.xpath("//descendant::div[@class=\"inventory_item_label\"]/a/div[contains(.,\""+name+"\")]//ancestor::div[@class=\"inventory_item_label\"]//following-sibling::div[@class=\"pricebar\"]/button");}
	private By sortField = By.xpath("//span[@class=\"select_container\"]/select");
	private By productsPrice = By.xpath("//div[@class=\"inventory_item_price\"]");
	
	

	//actions
	public void clickOnProduct(String name) throws Exception {
		driver.findElement(itemName(name)).click();
		Thread.sleep(1000);
	}

	public void clickOnCart() {
		driver.findElement(shoppingCart).click();
	}

	public List<String> getProductsList(){
		List<WebElement> productElements = driver.findElements(productsName);
		List<String> productValues = new ArrayList<String>();

		for(WebElement item:productElements) {
			if (!item.getText().isBlank()) {
				productValues.add(item.getText());
			}
		}
		return productValues;
	}

	public void sortBy(String sortOption) {
		Select dropdownSort = new Select (driver.findElement(sortField));	
		dropdownSort.selectByValue(sortOption);
	}

	public void clickOnAddToCardButton(String name) {
		driver.findElement(addToCartButton(name)).click();
	}
	
	public List<Float> getProductsPrice(){
		List<WebElement> productElements = driver.findElements(productsPrice);
		List<Float> productValues = new ArrayList<Float>();

		for(WebElement item:productElements) {
			if (!item.getText().isBlank()) {
				String priceString = item.getText().replace("$", "");
				Float price = Float.parseFloat(priceString);
				productValues.add(price);
			}
		}
		return productValues;
	}

	
	
}
