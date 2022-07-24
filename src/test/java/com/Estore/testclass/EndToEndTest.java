
package com.Estore.testclass;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.Estore.base.Baseclass;
import com.Estore.dataprovider.DataProviders;
import com.Estore.pom.AddToCartPage;
import com.Estore.pom.AddressPage;
import com.Estore.pom.IndexPage;
import com.Estore.pom.LoginPage;
import com.Estore.pom.OrderConfirmationPage;
import com.Estore.pom.OrderPage;
import com.Estore.pom.OrderSummary;
import com.Estore.pom.PaymentPage;
import com.Estore.pom.SearchResultPage;
import com.Estore.pom.ShippingPage;

public class EndToEndTest extends Baseclass {
	
	private IndexPage index;
	private SearchResultPage searchResultPage;
	private AddToCartPage addToCartPage;
	private OrderPage orderPage;
	private LoginPage loginPage;
	private AddressPage addressPage;
	private ShippingPage shippingPage;
	private PaymentPage paymentPage;
	private OrderSummary orderSummary;
	private OrderConfirmationPage orderConfirmationPage;

	@Test(groups = "Regression",dataProvider = "getProduct", dataProviderClass = DataProviders.class)
	public void endToEndTest(String productName, String qty, String size) throws Throwable {
		
		index= new IndexPage(null);
		searchResultPage=index.searchProduct(productName);
		addToCartPage=searchResultPage.clickOnProduct();
		addToCartPage.enterQuantity(qty);
		addToCartPage.selectSize(size);
		addToCartPage.clickOnAddToCart();
		orderPage=addToCartPage.clickOnCheckOut();
		loginPage=orderPage.clickOnCheckOut();
		addressPage=loginPage.login(prop.getProperty("username"), prop.getProperty("password"),addressPage);
		shippingPage=addressPage.clickOnCheckOut();
		shippingPage.checkTheTerms();
		paymentPage=shippingPage.clickOnProceedToCheckOut();
		orderSummary=paymentPage.clickOnPaymentMethod();
		orderConfirmationPage=orderSummary.clickOnconfirmOrderBtn();
		String actualMessage=orderConfirmationPage.validateConfirmMessage();
		String expectedMsg="Your order on My Store is complete.";
		Assert.assertEquals(actualMessage, expectedMsg);
		
	}

}
