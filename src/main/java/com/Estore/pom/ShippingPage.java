
package com.Estore.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import actiondriver.Action;

public class ShippingPage {
	
	Action action= new Action();
	WebDriver driver = null;
	
	@FindBy(id="cgv")
	private WebElement terms;
	
	@FindBy(xpath="//button/span[contains(text(),'Proceed to checkout')]")
	private WebElement proceedToCheckOutBtn;
	
	public ShippingPage() {
		PageFactory.initElements(driver, this);
	}
	
	public void checkTheTerms() throws Throwable {
		action.click(driver, terms);
	}
	
	public PaymentPage clickOnProceedToCheckOut() throws Throwable {
		action.click(driver, proceedToCheckOutBtn);
		return new PaymentPage();
	}

}
