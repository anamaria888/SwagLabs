package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import testData.User;

public class LoginPage {
WebDriver driver;
	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}
	
	//Elements
	private By pageHeader = By.xpath("//*[@id=\"root\"]/div/div[1]");
	private By usernameInput = By.id("user-name");
	private By passwordInput = By.id("password");
	private By loginButton = By.id("login-button");
	private By userError = By.xpath("//*[@id=\"login_button_container\"]/div/form/div[3]/h3");
	
	//actions
	public void enterUsername(String username) {
		driver.findElement(usernameInput).sendKeys(username);
	}
	
	public void enterPassword(String password) {
		driver.findElement(passwordInput).sendKeys(password);
	}
	
	public void clickLoginButton() {
		driver.findElement(loginButton).click();
	}
	
	public String getHeaderText() {
		return driver.findElement(pageHeader).getText();
	}
	
	public String getError() {
		return driver.findElement(userError).getText();
	}
	
	public void authenticate(User user) {
		enterUsername(user.getUsername());
		enterPassword(user.getPassword());
		clickLoginButton();
	}

}
