package pages;

import org.openqa.selenium.WebDriver;

public class BasePage {
	WebDriver driver;
	public BasePage(WebDriver driver) {
		this.driver = driver;
		
		login = new LoginPage(driver);
		products = new ProductsPage(driver);
		item = new ItemPage(driver);
		cart = new CartPage(driver);
		checkout = new CheckoutPage(driver);
		checkoutOverview = new CheckoutOverviewPage(driver);
		checkoutComplete = new CheckoutCompletePage(driver);
		menu = new MenuPage(driver);
		
   }
	
	public LoginPage login;
	public ProductsPage products;
	public ItemPage item;
	public CartPage cart;
	public CheckoutPage checkout;
	public CheckoutOverviewPage checkoutOverview;
	public CheckoutCompletePage checkoutComplete;
	public MenuPage menu;
}
