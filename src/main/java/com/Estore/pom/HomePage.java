
package com.Estore.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.Estore.base.Baseclass;

import actiondriver.Action;

public class HomePage {
	
	Action action= new Action();
	WebDriver driver = null;
	
	@FindBy(xpath="//span[text()='My wishlists']")
	private WebElement myWishList;
	
	@FindBy(xpath = "//span[text()='Order history and details']")
	private WebElement orderHistory;
	
	public HomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	
	public boolean validateMyWishList() throws Throwable {
		return action.isDisplayed(driver, myWishList);
	}
	
	public boolean validateOrderHistory() throws Throwable {
		return action.isDisplayed(driver, orderHistory);
	}
	
	public String getCurrURL() throws Throwable {
		String homePageURL=action.getCurrentURL(driver);
		return homePageURL;
	}
}
