
package com.Estore.testclass;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.Estore.base.Baseclass;
import com.Estore.dataprovider.DataProviders;
import com.Estore.pom.AddToCartPage;
import com.Estore.pom.IndexPage;
import com.Estore.pom.SearchResultPage;

public class AddToCartPageTest extends Baseclass {
	
	private IndexPage index;
	private SearchResultPage searchResultPage;
	private AddToCartPage addToCartPage;

	
	@Test(groups = {"Regression","Sanity"}, dataProvider = "getProduct", dataProviderClass = DataProviders.class)
	public void addToCartTest(String productName, String qty, String size) throws Throwable {
		
		index= new IndexPage(null);
		searchResultPage=index.searchProduct(productName);
		addToCartPage=searchResultPage.clickOnProduct();
		addToCartPage.enterQuantity(qty);
		addToCartPage.selectSize(size);
		addToCartPage.clickOnAddToCart();
		boolean result=addToCartPage.validateAddtoCart();
		Assert.assertTrue(result);
		
		
	}
}
