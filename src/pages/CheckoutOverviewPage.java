package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutOverviewPage {
	WebDriver driver;
	
	public CheckoutOverviewPage(WebDriver driver) {
		this.driver = driver;
	}
	
	//Elements
	private By cartItems = By.xpath("//div[@class=\"cart_item_label\"]/a/div");
	private By finishButton = By.id("finish");
	private By itemsTotal = By.xpath("//div[@class=\"summary_subtotal_label\"]");
	private By itemsTax = By.xpath("//div[@class=\"summary_tax_label\"]");
	private By totalValue = By.xpath("//div[@class=\"summary_total_label\"]");
	
	//actions
	public double getItemsTotalWithoutTax() {
		String itemsTotalStr = driver.findElement(itemsTotal).getText();
		double totalPrice =  Double.parseDouble(itemsTotalStr.replace("Item total: $", ""));

		return  totalPrice;
	}
	
	public double getItemsTax() {
		String itemTaxStr = driver.findElement(itemsTax).getText();
		double tax = Double.parseDouble(itemTaxStr.replace("Tax: $", ""));
		
		return tax;
		
	}
	
	public double getTotalValue() {
		String totalValueStr = driver.findElement(totalValue).getText();
		double totalValue = Double.parseDouble(totalValueStr.replace("Total: $", ""));
		
		return totalValue;
		
	}
	
	public double getFinalPrice() {
		double totalPrice = getItemsTotalWithoutTax() + getItemsTax();
		
		return  totalPrice;
	}
	
	public void clickOnFinishButton() {
		driver.findElement(finishButton).click();
	}

}
