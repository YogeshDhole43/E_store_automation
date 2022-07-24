
package com.Estore.testclass;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.Estore.base.Baseclass;
import com.Estore.dataprovider.DataProviders;
import com.Estore.pom.AddToCartPage;
import com.Estore.pom.IndexPage;
import com.Estore.pom.OrderPage;
import com.Estore.pom.SearchResultPage;

public class OrderPageTest extends Baseclass {

	private IndexPage index;
	private SearchResultPage searchResultPage;
	private AddToCartPage addToCartPage;
	private OrderPage orderPage;
	
	@Test(groups = "Regression",dataProvider = "getProduct", dataProviderClass = DataProviders.class)
	public void verifyTotalPrice(String productName, String qty, String size) throws Throwable {
		
		index= new IndexPage(null);
		searchResultPage=index.searchProduct(productName);
		addToCartPage=searchResultPage.clickOnProduct();
		addToCartPage.enterQuantity(qty);
		addToCartPage.selectSize(size);
		addToCartPage.clickOnAddToCart();
		orderPage=addToCartPage.clickOnCheckOut();
		Double unitPrice=orderPage.getUnitPrice();
		Double totalPrice=orderPage.getTotalPrice();
		Double totalExpectedPrice=(unitPrice*(Double.parseDouble(qty)))+2;
		Assert.assertEquals(totalPrice, totalExpectedPrice);
		
	}
}
