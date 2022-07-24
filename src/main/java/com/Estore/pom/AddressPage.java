
package com.Estore.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import actiondriver.Action;

public class AddressPage  {
	
	Action action= new Action();
	WebDriver driver = null;
	@FindBy(xpath="//span[text()='Proceed to checkout']")
	private WebElement proceedToCheckOut;
	
	public AddressPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public ShippingPage clickOnCheckOut() throws Throwable {
		action.click(driver, proceedToCheckOut);
		return new ShippingPage();
	}
	
}
