
package com.Estore.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import actiondriver.Action;

public class PaymentPage  {
	
	Action action= new Action();
	WebDriver driver = null;
	
	@FindBy(xpath = "//a[contains(text(),'Pay by bank wire')]")
	private WebElement bankWireMethod;
	
	@FindBy(xpath = "//a[contains(text(),'Pay by check')]")
	private WebElement payByCheckMethod;
	
	public PaymentPage() {
		PageFactory.initElements(driver, this);
	}
	
	public OrderSummary clickOnPaymentMethod() throws Throwable {
		action.click(driver, bankWireMethod);
		return new OrderSummary();
	}

}
