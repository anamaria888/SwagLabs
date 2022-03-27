package tests;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import messages.Checkout;
import messages.Login;
import messages.URL;

public class ProductsTests extends BaseTest{
	@Before @Override
	public void before() {
		super.before();
		page.login.authenticate(testData.mainUser);
		Assert.assertEquals(URL.PRODUCTS,driver.getCurrentUrl());
	}
		
	
	@Test
	public void viewProductDetails() throws Exception {
		page.products.clickOnProduct(testData.itemOne.getTitle());
		Assert.assertEquals(URL.ITEM(testData.itemOne.getId()),driver.getCurrentUrl());
		Assert.assertEquals(testData.itemOne.getTitle(),page.item.getTitle());
		Assert.assertEquals(testData.itemOne.getDescription(), page.item.getDescription());
		Assert.assertEquals(testData.itemOne.getPrice(), page.item.getPrice());	
	}
	
	@Test
	public void addAndRemoveProductFromCart() throws Exception {
		page.products.clickOnProduct(testData.itemOne.getTitle());
		Assert.assertEquals(URL.ITEM(testData.itemOne.getId()),driver.getCurrentUrl());
		//add product
		page.item.clickOnAddToCartButton();
		page.products.clickOnCart();
		Assert.assertEquals(URL.CART, driver.getCurrentUrl());
		List<String> items = page.cart.getItemsList();
		Assert.assertTrue("list data:"+items,items.contains(testData.itemOne.getTitle()));
		Assert.assertEquals(testData.itemOne.getTitle(),page.cart.getItemTitle(testData.itemOne.getTitle()));
		//remove product
		page.cart.removeItem(testData.itemOne.getId());
		List<String> itemsAfterRemoving = page.cart.getItemsList();
		Assert.assertFalse("list data:"+itemsAfterRemoving,itemsAfterRemoving.contains(testData.itemOne.getTitle()));				
	}
	
	
	@Test
	public void validateSenderInvalidData() throws Exception {
		page.products.clickOnProduct(testData.itemOne.getTitle());
		Assert.assertEquals(URL.ITEM(testData.itemOne.getId()),driver.getCurrentUrl());
		//add product
		page.item.clickOnAddToCartButton();
		page.products.clickOnCart();
		Assert.assertEquals(URL.CART, driver.getCurrentUrl());
		page.cart.clickOnCheckoutButton();
		Assert.assertEquals(URL.CHECKOUT_INFO, driver.getCurrentUrl());
		//leave all fields empty
		page.checkout.clickOnContinueButton();
		Assert.assertEquals(Checkout.MISSING_FIRSTNAME_ERROR, page.checkout.getError());
		//leave first name field empty
		page.checkout.addCheckoutInformations( "",testData.checkoutInfo.getLastName(), testData.checkoutInfo.getPostalCode());
		page.checkout.clickOnContinueButton();
		Assert.assertEquals(Checkout.MISSING_FIRSTNAME_ERROR, page.checkout.getError());
		//leave last name field empty
		page.checkout.addCheckoutInformations(testData.checkoutInfo.getFirstName(), "", testData.checkoutInfo.getPostalCode());
		page.checkout.clickOnContinueButton();
		Assert.assertEquals(Checkout.MISSING_LASTNAME_ERROR, page.checkout.getError());
		//leave postal code field empty
		page.checkout.addCheckoutInformations(testData.checkoutInfo.getFirstName(),testData.checkoutInfo.getLastName(),"");
		page.checkout.clickOnContinueButton();
		Assert.assertEquals(Checkout.MISSING_POSTALCODE_ERROR, page.checkout.getError());	
		
	}
	
	
	@Test
	public void createBookingForOneProduct() throws Exception {
		page.products.clickOnProduct(testData.itemOne.getTitle());
		Assert.assertEquals(URL.ITEM(testData.itemOne.getId()),driver.getCurrentUrl());
		//add product
		page.item.clickOnAddToCartButton();
		page.products.clickOnCart();
		Assert.assertEquals(URL.CART, driver.getCurrentUrl());
		page.cart.clickOnCheckoutButton();
		Assert.assertEquals(URL.CHECKOUT_INFO, driver.getCurrentUrl());
		page.checkout.addCheckoutInformations(testData.checkoutInfo);
		Assert.assertEquals(URL.CHECKOUT_OVERVIEW, driver.getCurrentUrl());
		//check data
		List<String> items = page.cart.getItemsList();
		Assert.assertTrue("list data:"+items,items.contains(testData.itemOne.getTitle()));
		Assert.assertEquals(testData.itemOne.getTitle(),page.cart.getItemTitle(testData.itemOne.getTitle()));
		Assert.assertEquals(testData.itemOne.getPrice(),page.cart.getItemPrice(testData.itemOne.getPrice()));
		Assert.assertEquals(page.checkoutOverview.getFinalPrice(), page.checkoutOverview.getTotalValue(), 0);
		//click on finish button
		page.checkoutOverview.clickOnFinishButton();
		Assert.assertEquals(URL.CHECKOUT_COMPLETE, driver.getCurrentUrl());
		Assert.assertEquals(Checkout.ORDER_COMPLETED, page.checkoutComplete.getCompleteText());
		
	}
	
	@Test
	public void createBookingForTwoProducts() {
		page.products.clickOnAddToCardButton(testData.itemOne.getTitle());
		page.products.clickOnAddToCardButton(testData.itemTwo.getTitle());
		page.products.clickOnCart();
		Assert.assertEquals(URL.CART, driver.getCurrentUrl());
		page.cart.clickOnCheckoutButton();
		Assert.assertEquals(URL.CHECKOUT_INFO, driver.getCurrentUrl());
		page.checkout.addCheckoutInformations(testData.checkoutInfo);
		Assert.assertEquals(URL.CHECKOUT_OVERVIEW, driver.getCurrentUrl());
		//check data
		List<String> items = page.cart.getItemsList();
		Assert.assertTrue("list data:"+items,items.contains(testData.itemOne.getTitle()));
		Assert.assertTrue("list data:"+items,items.contains(testData.itemTwo.getTitle()));
		Assert.assertEquals(testData.itemOne.getTitle(),page.cart.getItemTitle(testData.itemOne.getTitle()));
		Assert.assertEquals(testData.itemOne.getPrice(),page.cart.getItemPrice(testData.itemOne.getPrice()));
		Assert.assertEquals(testData.itemTwo.getTitle(),page.cart.getItemTitle(testData.itemTwo.getTitle()));
		Assert.assertEquals(testData.itemTwo.getPrice(),page.cart.getItemPrice(testData.itemTwo.getPrice()));
		Assert.assertEquals(page.checkoutOverview.getFinalPrice(), page.checkoutOverview.getTotalValue(), 0);
		//click on finish button
		page.checkoutOverview.clickOnFinishButton();
		Assert.assertEquals(URL.CHECKOUT_COMPLETE, driver.getCurrentUrl());
		Assert.assertEquals(Checkout.ORDER_COMPLETED, page.checkoutComplete.getCompleteText());
	}
	

	@Test
	public void filterProductsList() throws InterruptedException {
		//	sort ascending by name
		page.products.sortBy("az");
		List<String> titleValuesAsc = page.products.getProductsList();
		List<String> titleValuesSorted = new ArrayList<String>();
		titleValuesSorted.addAll(titleValuesAsc);
		Collections.sort(titleValuesSorted);
		
		Assert.assertTrue("List original:"+titleValuesAsc+" List expected:"+titleValuesSorted, 
				titleValuesSorted.equals(titleValuesAsc));
		
		//	sort descending by name
		page.products.sortBy("za");
		List<String> titleValues = page.products.getProductsList();
		Collections.sort(titleValuesSorted, Collections.reverseOrder());
		
		Assert.assertTrue("List original:"+titleValues+" List expected:"+titleValuesSorted, 
				titleValuesSorted.equals(titleValues)); 
		
		// sort by low to high price
		page.products.sortBy("lohi");
		List<Float> productsPrice = page.products.getProductsPrice();		
		List<Float> productsPriceSorted = new ArrayList<Float>();
		productsPriceSorted.addAll(productsPrice);
		Collections.sort(productsPriceSorted);
		Assert.assertTrue("List original:"+productsPrice+" List expected:"+productsPriceSorted, 
				productsPriceSorted.equals(productsPrice)); 
		
		// sort by low to high price
		page.products.sortBy("hilo");
		List<Float> productsPriceDesc = page.products.getProductsPrice();
		Collections.sort(productsPriceSorted, Collections.reverseOrder());
		Assert.assertTrue("List original:"+productsPriceDesc+" List expected:"+productsPriceSorted, 
				productsPriceSorted.equals(productsPriceDesc));
		
	}
	
}
