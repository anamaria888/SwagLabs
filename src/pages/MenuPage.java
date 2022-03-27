package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MenuPage {
	WebDriver driver;
	
	public MenuPage(WebDriver driver) {
		this.driver = driver;
	}
	
	//Elements
	private By menu = By.xpath("//div[@class=\"bm-burger-button\"]/button");
	private By logoutLink = By.xpath("//nav[@class=\"bm-item-list\"]/a[3]");
	
	
	//actions
	public void clickOnMenu() {
		driver.findElement(menu).click();
	}
	
	public void clickOnLogoutLink() {
		driver.findElement(logoutLink).click();
	}

}
