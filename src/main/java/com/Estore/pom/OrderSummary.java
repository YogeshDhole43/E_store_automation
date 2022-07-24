
package com.Estore.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import actiondriver.Action;

public class OrderSummary {
	
	Action action= new Action();
	WebDriver driver = null;
	
	@FindBy(xpath="//span[contains(text(),'I confirm my order')]")
	private WebElement confirmOrderBtn;
	
	public OrderSummary() {
		PageFactory.initElements(driver, this);
	}

	public OrderConfirmationPage clickOnconfirmOrderBtn() throws Throwable {
		action.click(driver, confirmOrderBtn);
		return new OrderConfirmationPage();
	}
	
}
