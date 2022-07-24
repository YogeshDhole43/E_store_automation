package actiondriver;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Action 
{

	//Scroll by visibility of element
	public void scrollByVisibilityOfElement(WebDriver driver, WebElement ele) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", ele);

	}
	
	//Click action
	
	public void click(WebDriver driver, WebElement ele) {

		Actions act = new Actions(driver);
		act.moveToElement(ele).click().build().perform();

	}
	
	//Find element
	
	public boolean findElement(WebDriver driver, WebElement ele) {
		boolean value = false;
		try {
			ele.isDisplayed();
			value = true;
		} catch (Exception e) {
			
		// System.out.println("Location not found: "+locatorName);
			value = false;
			
		} finally {
			if (value) {
				System.out.println("Successfully Found element at");

			} else {
				System.out.println("Unable to locate element at");
			}
		}
		return value;
	}
	
	//Display element
	
	public boolean isDisplayed(WebDriver driver, WebElement ele) {
		boolean value = false;
		value = findElement(driver, ele);
		if (value) {
			value = ele.isDisplayed();
			if (value) {
				System.out.println("The element is Displayed");
			} else {
				System.out.println("The element is not Displayed");
			}
		} else {
			System.out.println("Not displayed ");
		}
		return value;
	}
	
	//Is selected
	
	public boolean isSelected(WebDriver driver, WebElement ele) {
		boolean value = false;
		value = findElement(driver, ele);
		if (value) {
			value = ele.isSelected();
			if (value) {
				System.out.println("The element is Selected");
			} else {
				System.out.println("The element is not Selected");
			}
		} else {
			System.out.println("Not selected ");
		}
		return value;
	}
	
	//Is enabled
	
	public boolean isEnabled(WebDriver driver, WebElement ele) {
		boolean value = false;
		value = findElement(driver, ele);
		if (value) {
			value = ele.isEnabled();
			if (value) {
				System.out.println("The element is Enabled");
			} else {
				System.out.println("The element is not Enabled");
			}
		} else {
			System.out.println("Not Enabled ");
		}
		return value;
	}
	
	//Send keys
	
	public boolean type(WebElement ele, String text) {
		boolean value = false;
		try {
			value = ele.isDisplayed();
			ele.clear();
			ele.sendKeys(text);
			// logger.info("Entered text :"+text);
			value = true;
		} catch (Exception e) {
			System.out.println("Location Not found" + ele);
			value = false;
		} finally {
			if (value) {
				System.out.println("Successfully entered value");
			} else {
				System.out.println("Unable to enter value" + ele);
			}

		}
		return value;
	}
	
	//Select by index (Drop down)
	
	public boolean selectByIndex(WebElement element, int index) {
		boolean value = false;
		try {
			Select s = new Select(element);
			s.selectByIndex(index);
			value = true;
			return true;
		} catch (Exception e) {
			return false;
		} finally {
			if (value) {
				System.out.println("Option selected by Index");
			} else {
				System.out.println("Option not selected by Index" + element);
			}
		}
	}
	
	
	//Select by value
	
	public boolean selectByValue(WebElement element,String value) {
		boolean flag = false;
		try {
			Select s = new Select(element);
			s.selectByValue(value);
			flag = true;
			return true;
		} catch (Exception e) {

			return false;
		} finally {
			if (flag) {
				System.out.println("Option selected by Value");
			} else {
				System.out.println("Option not selected by Value" + element);
			}
		}
	}
	
	
	//Select by visible text
	
	public boolean selectByVisibleText(String visibletext, WebElement ele) {
		boolean value = false;
		try {
			Select s = new Select(ele);
			s.selectByVisibleText(visibletext);
			value = true;
			return true;
		} catch (Exception e) {
			return false;
		} finally {
			if (value) {
				System.out.println("Option selected by VisibleText");
			} else {
				System.out.println("Option not selected by VisibleText" + ele);
			}
		}
	}
	
	//mouse hover by java script
	
	public boolean mouseHoverByJavaScript(WebDriver driver,WebElement ele) {
		boolean value = false;
		try {
			WebElement mo = ele;
			String javaScript = "var evObj = document.createEvent('MouseEvents');"
					+ "evObj.initMouseEvent(\"mouseover\",true, false, window, 0, 0, 0, 0, 0, false, false, false, false, 0, null);"
					+ "arguments[0].dispatchEvent(evObj);";
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript(javaScript, mo);
			value = true;
			return true;
		}

		catch (Exception e) {

			return false;
		} finally {
			if (value) {
				System.out.println("MouseOver Action is performed");
			} else {
				System.out.println("MouseOver Action is not performed");
			}
		}
	}
	
	
	//Switch to frame by id
	
	public boolean switchToFrameById(WebDriver driver,String idValue) {
		boolean value = false;
		try {
			driver.switchTo().frame(idValue);
			value = true;
			return true;
		} catch (Exception e) {

			e.printStackTrace();
			return false;
		} finally {
			if (value) {
				System.out.println("Frame with Id \"" + idValue + "\" is selected");
			} else {
				System.out.println("Frame with Id \"" + idValue + "\" is not selected");
			}
		}
	}
	
	//Switch to frame by name
	
	public boolean switchToFrameByName(WebDriver driver,String nameValue) {
		boolean value = false;
		try {
			driver.switchTo().frame(nameValue);
			value = true;
			return true;
		} catch (Exception e) {

			return false;
		} finally {
			if (value) {
				System.out.println("Frame with Name \"" + nameValue + "\" is selected");
			} else if (!value) {
				System.out.println("Frame with Name \"" + nameValue + "\" is not selected");
			}
		}
	}
	
	//Switch to default frame
	
	public boolean switchToDefaultFrame(WebDriver driver) {
		boolean value = false;
		try {
			driver.switchTo().defaultContent();
			value = true;
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		} finally {
			if (value) {
				// SuccessReport("SelectFrame ","Frame with Name is selected");
			} else if (!value) {
				// failureReport("SelectFrame ","The Frame is not selected");
			}
		}
	}
	
	//mouse over element by web driver
	
	public void mouseOverElement(WebDriver driver,WebElement element) {
		boolean value = false;
		try {
			new Actions(driver).moveToElement(element).build().perform();
			value = true;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (value) {
				System.out.println(" MouserOver Action is performed on ");
			} else {
				System.out.println("MouseOver action is not performed on" + element);
			}
		}
	}
	
	// Move to element 
	
	public boolean moveToElement(WebDriver driver, WebElement ele) {
		boolean value = false;
		try {
			// WebElement element = driver.findElement(locator);
			JavascriptExecutor executor = (JavascriptExecutor) driver;
			executor.executeScript("arguments[0].scrollIntoView(true);", ele);
			Actions actions = new Actions(driver);
			// actions.moveToElement(driver.findElement(locator)).build().perform();
			actions.moveToElement(ele).build().perform();
			value = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return value;
	}

	// mouse over
	
	@SuppressWarnings("unused")
	public boolean mouseover(WebDriver driver, WebElement ele) {
		boolean value = false;
		try {
			new Actions(driver).moveToElement(ele).build().perform();
			value = true;
			return true;
		} catch (Exception e) {
			return false;
		} finally {
			/*
			 * if (flag) {
			 * SuccessReport("MouseOver ","MouserOver Action is performed on \""+locatorName
			 * +"\""); } else {
			 * failureReport("MouseOver","MouseOver action is not performed on \""
			 * +locatorName+"\""); }
			 */
		}
	}
	
	//dragable 
	
	public boolean draggable(WebDriver driver,WebElement source, int x, int y) {
		boolean value = false;
		try {
			new Actions(driver).dragAndDropBy(source, x, y).build().perform();
			Thread.sleep(5000);
			value = true;
			return true;

		} catch (Exception e) {
		
			return false;
			
		} finally {
			if (value) {
				System.out.println("Draggable Action is performed on \""+source+"\"");			
			} else if(!value) {
				System.out.println("Draggable action is not performed on \""+source+"\"");
			}
		}
	}
	
	//drag and drop
	
	public boolean draganddrop(WebDriver driver,WebElement source, WebElement target) {
		boolean value = false;
		try {
			new Actions(driver).dragAndDrop(source, target).perform();
			value = true;
			return true;
		} catch (Exception e) {

			return false;
		} finally {
			if (value) {
				System.out.println("DragAndDrop Action is performed");
			} else if(!value) {
				System.out.println("DragAndDrop Action is not performed");
			}
		}
	}
	
	//slide
	
	public boolean slider(WebDriver driver,WebElement ele, int x, int y) {
		boolean value = false;
		try {
			// new Actions(driver).dragAndDropBy(dragitem, 400, 1).build()
			// .perform();
			new Actions(driver).dragAndDropBy(ele, x, y).build().perform();// 150,0
			Thread.sleep(5000);
			value = true;
			return true;
		} catch (Exception e) {

			return false;
		} finally {
			if (value) {
				System.out.println("Slider Action is performed");
			} else {
				System.out.println("Slider Action is not performed");
			}
		}
	}
	
	//right click
	
	public boolean rightclick(WebDriver driver,WebElement ele) {
		boolean value = false;
		try {
			Actions clicker = new Actions(driver);
			clicker.contextClick(ele).perform();
			value = true;
			return true;
			// driver.findElement(by1).sendKeys(Keys.DOWN);
		} catch (Exception e) {

			return false;
		} finally {
			if (value) {
				System.out.println("RightClick Action is performed");
			} else {
				System.out.println("RightClick Action is not performed" + ele);
			}
		}
	}
	
	//switch window by title
	
	public boolean switchWindowByTitle(WebDriver driver,String windowTitle, int count) {
		boolean value = false;
		try {
			Set<String> windowList = driver.getWindowHandles();

			String[] array = windowList.toArray(new String[0]);

			driver.switchTo().window(array[count-1]);

			if (driver.getTitle().contains(windowTitle)){
				value = true;
			}else{
				value = false;
			}
			return value;
		} catch (Exception e) {
			//flag = true;
			return false;
		} finally {
			if (value) {
				System.out.println("Navigated to the window with title");
			} else {
				System.out.println("The Window with title is not Selected");
			}
		}
	}
	 
	//switch to new window
	
	public boolean switchToNewWindow(WebDriver driver) {
		boolean value = false;
		try {

			Set<String> s=driver.getWindowHandles();
			Object popup[]=s.toArray();
			driver.switchTo().window(popup[1].toString());
			value = true;
			return value;
		} catch (Exception e) {
			value = false;
			return value;
		} finally {
			if (value) {
				System.out.println("Window is Navigated with title");				
			} else {
				System.out.println("The Window with title: is not Selected");
			}
		}
	}
	
	//switch to old window
	
	public boolean switchToOldWindow(WebDriver driver) {
		boolean value = false;
		try {

			Set<String> s=driver.getWindowHandles();
			Object popup[]=s.toArray();
			driver.switchTo().window(popup[0].toString());
			value = true;
			return value;
		} catch (Exception e) {
			value = false;
			return value;
		} finally {
			if (value) {
				System.out.println("Focus navigated to the window with title");			
			} else {
				System.out.println("The Window with title: is not Selected");
			}
		}
	}
	
	//alert
	
	public boolean Alert(WebDriver driver) {
		boolean presentvalue = false;
		Alert alert = null;

		try {
			// Check the presence of alert
			alert = driver.switchTo().alert();
			// if present consume the alert
			alert.accept();
			presentvalue = true;
		} catch (NoAlertPresentException ex) {
			// Alert present; set the flag

			// Alert not present
			ex.printStackTrace();
		} finally {
			if (!presentvalue) {
				System.out.println("The Alert is handled successfully");		
			} else{
				System.out.println("There was no alert to handle");
			}
		}

		return presentvalue;
	}
	
	// check if alert is present or not
	
	public boolean isAlertPresent(WebDriver driver) 
	{ 
		try 
		{ 
			driver.switchTo().alert(); 
			return true; 
		}   // try 
		catch (NoAlertPresentException Ex) 
		{ 
			return false; 
		}   // catch 
	}
	
	// get title of page
	
	public String getTitle(WebDriver driver) {
		boolean value = false;

		String text = driver.getTitle();
		if (value) {
			System.out.println("Title of the page is: \""+text+"\"");
		}
		return text;
	}
	
	//get current url
	
	public String getCurrentURL(WebDriver driver)  {
		boolean value = false;

		String text = driver.getCurrentUrl();
		if (value) {
			System.out.println("Current URL is: \""+text+"\"");
		}
		return text;
	}
	
	// fluent wait
	
	public void fluentWait(WebDriver driver,WebElement element, int timeOut) {
	    Wait<WebDriver> wait = null;
	    try {
	        wait = new FluentWait<WebDriver>((WebDriver) driver)
	        		.withTimeout(Duration.ofSeconds(20))
	        	    .pollingEvery(Duration.ofSeconds(2))
	        	    .ignoring(Exception.class);
	        wait.until(ExpectedConditions.visibilityOf(element));
	        element.click();
	    }catch(Exception e) {
	    }
	}
	
	// implicit wait 
	
	@SuppressWarnings("deprecation")
	public void implicitWait(WebDriver driver, int timeOut) {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	// explicit wait
	
	public void explicitWait(WebDriver driver, WebElement element, Duration timeOut ) {
		WebDriverWait wait = new WebDriverWait(driver,timeOut);
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	
	// page load time out
	
	@SuppressWarnings("deprecation")
	public void pageLoadTimeOut(WebDriver driver, int timeOut) {
		driver.manage().timeouts().pageLoadTimeout(timeOut, TimeUnit.SECONDS);
	}
	
	//Screen shot 
	
	public static void Screenshot(WebDriver driver) throws IOException
	{
		Date d = new Date();
		File org 	= ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		
		String path = "./Screenshot//"+d.toString().replaceAll(":", "_")+"E-bank.pnj";         //--------->modify path as per need
		File f = new File(path);
		FileHandler.copy(org, f);
		
	}
	
	//simple and full page screenshot
	
	/*public static String ScreenShot(WebDriver driver) throws IOException, HeadlessException, AWTException
	{
		try
		{

			Date d = new Date();

			File org 	= ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			
			String path = "./Screenshot//"+d.toString().replaceAll(":", "_")+"E-bank.jpg";                               //--------->modify path as per need
			File f = new File(path);
			FileHandler.copy(org, f);
			return path ;
			
		}catch(UnhandledAlertException e)
		{
			Date d = new Date();

			BufferedImage bi = new Robot().createScreenCapture(new Rectangle(Toolkit.getDefaultToolkit().getScreenSize()));
			String path = "./Screenshot//"+d.toString().replaceAll(":", "_")+"E-bank.jpg";                                    //--------->modify path as per need
			
			ImageIO.write(bi, "jpg",new File(path));
			return path;
		}

		
	}
	*/
	
	
	//get current time
	
	public String getCurrentTime() {
		String currentDate = new SimpleDateFormat("yyyy-MM-dd-hhmmss").format(new Date());
		return currentDate;
	}
	
	//
	
}
