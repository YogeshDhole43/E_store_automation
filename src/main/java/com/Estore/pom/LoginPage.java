
package com.Estore.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import actiondriver.Action;

public class LoginPage  {
	
	Action action= new Action();
	WebDriver driver;
	
	@FindBy(id="email")
	private WebElement userName;
	
	@FindBy(id="passwd")
	private WebElement password;

	@FindBy(id="SubmitLogin")
	private WebElement signInBtn;
	
	@FindBy(name="email_create")
	private WebElement emailForNewAccount;
	
	@FindBy(name="SubmitCreate")
	private WebElement createNewAccountBtn;
	
	public LoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public HomePage login(String uname, String pswd,HomePage homePage) throws Throwable {
		action.scrollByVisibilityOfElement(driver, userName);
		action.type(userName, uname);
		action.type(password, pswd);
		action.click(driver, signInBtn);
		Thread.sleep(2000);
		homePage=new HomePage(driver);
		return homePage;
	}
	
	public AddressPage login(String uname, String pswd,AddressPage addressPage) throws Throwable {
		action.scrollByVisibilityOfElement(driver, userName);
		action.type(userName, uname);
		action.type(password, pswd);
		action.click(driver, signInBtn);
		Thread.sleep(2000);
		addressPage=new AddressPage(driver);
		return addressPage;
	}
	
	public AccountCreationPage createNewAccount(String newEmail) throws Throwable {
		action.type(emailForNewAccount, newEmail);
		action.click(driver, createNewAccountBtn);
		return new AccountCreationPage(driver);
	}
	
}






