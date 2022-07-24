
package com.Estore.testclass;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.Estore.base.Baseclass;
import com.Estore.dataprovider.DataProviders;
import com.Estore.pom.IndexPage;
import com.Estore.pom.SearchResultPage;

public class SearchResultPageTest extends Baseclass {
	private IndexPage index;
	private SearchResultPage searchResultPage;
	
	@Test(groups = "Smoke",dataProvider = "searchProduct", dataProviderClass = DataProviders.class)
	public void productAvailabilityTest(String productName) throws Throwable {
		
		index= new IndexPage(null);
		searchResultPage=index.searchProduct(productName);
		boolean result=searchResultPage.isProductAvailable();
		Assert.assertTrue(result);
		
	}

}
