
package com.Estore.testclass;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.Estore.base.Baseclass;
import com.Estore.dataprovider.DataProviders;
import com.Estore.pom.HomePage;
import com.Estore.pom.IndexPage;
import com.Estore.pom.LoginPage;


public class LoginPageTest extends Baseclass {
	private IndexPage indexPage;
	private LoginPage loginPage;
	private HomePage homePage;
	
	@Test(groups = {"Smoke","Sanity"},dataProvider = "credentials", dataProviderClass = DataProviders.class)
	public void loginTest(String uname, String pswd) throws Throwable {
		
		indexPage= new IndexPage(null);
		
		loginPage=indexPage.clickOnSignIn();
		
	    //homePage=loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		homePage=loginPage.login(uname,pswd,homePage);
	    String actualURL=homePage.getCurrURL();
	    String expectedURL="http://automationpractice.com/index.php?controller=my-account";
	    
	    Assert.assertEquals(actualURL, expectedURL);
	    
	}

}
