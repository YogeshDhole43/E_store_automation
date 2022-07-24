package com.Estore.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import actiondriver.Action;

public class IndexPage  {
	
	Action action= new Action();
	WebDriver driver = null;
	
	@FindBy(xpath = "//a[@class='login']") 
	private WebElement signInBtn;
	
	@FindBy(xpath = "//img[@class='logo img-responsive']")
	private WebElement myStoreLogo;
	
	@FindBy(id="search_query_top")
	private WebElement searchProductBox;
	
	@FindBy(name="submit_search")
	private WebElement searchButton;
	
	public IndexPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public LoginPage clickOnSignIn() throws Throwable {
		action.fluentWait(driver, signInBtn, 10);
		action.click(driver, signInBtn);
		return new LoginPage(driver);
	}
	
	public boolean validateLogo() throws Throwable {
		return action.isDisplayed(driver, myStoreLogo);
	}
	
	public String getMyStoreTitle() {
		String myStoreTitel=driver.getTitle();
		return myStoreTitel;
	}
	
	public SearchResultPage searchProduct(String productName) throws Throwable {
		action.type(searchProductBox, productName);
		action.scrollByVisibilityOfElement(driver, searchButton);
		action.click(driver, searchButton);
		Thread.sleep(3000);
		return new SearchResultPage();
	}
	
	

}
