package messages;

public class URL {
	public final static String LOGIN = "https://www.saucedemo.com/";
	
	public final static String PRODUCTS = "https://www.saucedemo.com/inventory.html";
	
	public final static String ITEM (String id) {
		return "https://www.saucedemo.com/inventory-item.html?id="+id;
	}
	
	public final static String CART = "https://www.saucedemo.com/cart.html";
	
	public final static String CHECKOUT_INFO = "https://www.saucedemo.com/checkout-step-one.html";
	
	public final static String CHECKOUT_OVERVIEW = "https://www.saucedemo.com/checkout-step-two.html";
	
	public final static String CHECKOUT_COMPLETE = "https://www.saucedemo.com/checkout-complete.html";

}
