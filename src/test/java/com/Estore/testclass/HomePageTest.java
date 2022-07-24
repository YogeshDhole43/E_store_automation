
package com.Estore.testclass;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.Estore.base.Baseclass;
import com.Estore.dataprovider.DataProviders;
import com.Estore.pom.HomePage;
import com.Estore.pom.IndexPage;
import com.Estore.pom.LoginPage;

public class HomePageTest extends Baseclass {
	private IndexPage indexPage;
	private LoginPage loginPage;
	private HomePage homePage;
	
	@Test(groups = "Smoke",dataProvider = "credentials", dataProviderClass = DataProviders.class)
	public void wishListTest(String uname, String pswd) throws Throwable {
		
		indexPage= new IndexPage(null);
		loginPage=indexPage.clickOnSignIn();
		homePage=loginPage.login(uname,pswd,homePage);
		boolean result=homePage.validateMyWishList();
		Assert.assertTrue(result);
		
	}
	
	@Test(groups = "Smoke",dataProvider = "credentials", dataProviderClass = DataProviders.class)
	public void orderHistoryandDetailsTest(String uname, String pswd) throws Throwable {
		
		indexPage= new IndexPage(null);
		loginPage=indexPage.clickOnSignIn();
		homePage=loginPage.login(uname,pswd,homePage);
		boolean result=homePage.validateOrderHistory();
		Assert.assertTrue(result);
			}
	
}
