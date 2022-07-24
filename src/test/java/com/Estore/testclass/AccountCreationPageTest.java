package com.Estore.testclass;
import java.util.HashMap;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.Estore.base.Baseclass;
import com.Estore.dataprovider.DataProviders;
import com.Estore.pom.AccountCreationPage;
import com.Estore.pom.HomePage;
import com.Estore.pom.IndexPage;
import com.Estore.pom.LoginPage;


public class AccountCreationPageTest extends Baseclass {
	private IndexPage indexPage;
	private LoginPage loginPage;
	private AccountCreationPage acountCreationPage;
	private HomePage homePage;
	
	@Test(groups = "Sanity",dataProvider = "email", dataProviderClass = DataProviders.class)
	public void verifyCreateAccountPageTest(String email) throws Throwable {
		
		indexPage= new IndexPage(null);
		loginPage=indexPage.clickOnSignIn();
		acountCreationPage=loginPage.createNewAccount(email);
		boolean result=acountCreationPage.validateAcountCreatePage();
		Assert.assertTrue(result);
		
	}
	
	@Test(groups = "Regression",dataProvider = "newAcountDetailsData",dataProviderClass = DataProviders.class)
	public void createAccountTest(HashMap<String,String> hashMapValue) throws Throwable {
		
		indexPage= new IndexPage(null);
		loginPage=indexPage.clickOnSignIn();
		acountCreationPage=loginPage.createNewAccount(hashMapValue.get("Email"));
		acountCreationPage.createAccount(
				hashMapValue.get("Gender"),
				hashMapValue.get("FirstName"),
				hashMapValue.get("LastName"),
				hashMapValue.get("SetPassword"),
				hashMapValue.get("Day"),
				hashMapValue.get("Month"),
				hashMapValue.get("Year"),
				hashMapValue.get("Company"),
				hashMapValue.get("Address"),
				hashMapValue.get("City"),
				hashMapValue.get("State"),
				hashMapValue.get("Zipcode"),
				hashMapValue.get("Country"),
				hashMapValue.get("MobilePhone"));
		homePage=acountCreationPage.validateRegistration();
		Assert.assertEquals("http://automationpractice.com/index.php?controller=my-account", homePage.getCurrURL());
		
	}

}
