
package com.Estore.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import actiondriver.Action;

public class OrderConfirmationPage {
	
	Action action= new Action();
	WebDriver driver = null;
	
	@FindBy(xpath="//p/strong[contains(text(),'Your order on My Store is complete.')]")
	private WebElement confirmMessag;
	
	public OrderConfirmationPage() {
		PageFactory.initElements(driver, this);
	}
	
	public String validateConfirmMessage() {
		String confirmMsg=confirmMessag.getText();
		return confirmMsg;
	}

	
}
