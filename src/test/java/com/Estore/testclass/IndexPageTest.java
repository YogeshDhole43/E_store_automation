
package com.Estore.testclass;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.Estore.base.Baseclass;
import com.Estore.pom.IndexPage;

public class IndexPageTest extends Baseclass {
	private IndexPage indexPage;
    
	@Test(groups = "Smoke")
	public void verifyLogo() throws Throwable {
		
		indexPage= new IndexPage(null);
		boolean result=indexPage.validateLogo();
		Assert.assertTrue(result);
		
	}
	
	@Test(groups = "Smoke")
	public void verifyTitle() {
		
		String actTitle=indexPage.getMyStoreTitle();
		Assert.assertEquals(actTitle, "My Store1");
		
	}

	
}
