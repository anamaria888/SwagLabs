package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import testData.CheckoutData;


public class CheckoutPage {
	WebDriver driver;
	
	public CheckoutPage(WebDriver driver) {
		this.driver = driver;
	}
	
	//Elements
	private By firstNameInput = By.id("first-name");
	private By lastNameInput = By.id("last-name");
	private By postaleCodeInput = By.id("postal-code");
	private By continueButton = By.xpath("//input[@id=\"continue\"]");
	private By userError = By.xpath("//div[@class=\"checkout_info\"]/div[4]/h3");
	
	//actions
	public void enterFirstName(String firstName) {
		driver.findElement(firstNameInput).sendKeys(firstName);
	}
	
	public void enterLastName(String lastName) {
		driver.findElement(lastNameInput).sendKeys(lastName);
	}
	
	public void enterPostalCode(String postalCode) {
		driver.findElement(postaleCodeInput).sendKeys(postalCode);
	}
	
	public void clickOnContinueButton() {
		driver.findElement(continueButton).click();
	}
	
	public String getError() {
		return driver.findElement(userError).getText();
	}
	
	public void addCheckoutInformations(CheckoutData checkoutdata) {
		enterFirstName(checkoutdata.getFirstName());
		enterLastName(checkoutdata.getLastName());
		enterPostalCode(checkoutdata.getPostalCode());
		clickOnContinueButton();
	}
	
	public void addCheckoutInformations(String firstName, String lastName, String postalCode) {
		clearFields();
		enterFirstName(firstName);
		enterLastName(lastName);
		enterPostalCode(postalCode);	
	}
	
	public void clearFields() {
		driver.findElement(firstNameInput).sendKeys(Keys.chord(Keys.CONTROL,"a", Keys.DELETE));;
		driver.findElement(lastNameInput).sendKeys(Keys.chord(Keys.CONTROL,"a", Keys.DELETE));;
		driver.findElement(postaleCodeInput).sendKeys(Keys.chord(Keys.CONTROL,"a", Keys.DELETE));;
	}

}
