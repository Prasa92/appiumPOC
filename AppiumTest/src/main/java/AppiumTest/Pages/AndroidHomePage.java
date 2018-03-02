package AppiumTest.Pages;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import utilities.Results;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.HashMap;
import java.util.List;
import java.util.Objects;




public class AndroidHomePage {

    /** Verify the home page has loaded **/
	
	//Home page objects
	
	private By txt_Page_Title = By.xpath("//UIANavigationBar[1]");

	private By btn_Advance_Payment = By.xpath("//*[@label=\"Make an advance payment\"]");
	private By txt_bx_Pay_Amount = By.xpath("//*[contains(@name, \"Payment Amount regular\")]");
	private By btn_Pay_Bill = By.xpath("//*[@name= \"Pay bill\"]");
	private By btn_Done = By.xpath("//*[@label=\"Done\"]");
	private By txt_Select_Payment_Method = By.xpath("//*[@label=\"Select a payment method.\"]");
	private By txt_Payment_Credit_Card = By.xpath("//*[@label=\"Credit or debit card\"]");
	private By txt_bx_Enter_Card_Number = By.xpath("//*[contains(@label,\"Card number\")]");
	private By txt_dd_Card_Month = By.xpath("//*[contains(@label,\"MM picker item\")]");
	private By txt_dd_Card_Year = By.xpath("//*[contains(@label,\"YYYY picker item\")]");
	private By txt_bx_CVC_Number = By.xpath("//*[contains(@label,\"CVC regular\")]");
	private By txt_bx_Card_Zip = By.xpath("//*[contains(@label,\"Card ZIP Code regular\")]");
	private By txt_bx_Pay_Method_Nickname = By.xpath("//*[contains(@label,\"Payment method nickname regular\")]");
	
	
	
	public static void ebayLogin(AndroidDriver<WebElement> driver) throws Exception {
	
		driver.findElement(By.xpath("")).sendKeys("");
		driver.findElement(By.xpath("")).click();
		
		WebDriverWait wait = new WebDriverWait(driver, 50);
		WebElement element = wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath(" ")));
		if(element.isDisplayed()) {
			Results.updateresult("Home page is getting displayed", "Passed");
		}else {
			Results.updateresult("Home page is not getting displayed", "Failed");
		}
		
	}
    
	
	public static void searchForItem(AndroidDriver<WebElement> driver) throws Exception {
		
		driver.findElement(By.xpath("")).sendKeys("");
		driver.findElement(By.xpath("")).click();
		WebDriverWait wait = new WebDriverWait(driver, 50);
		WebElement element = wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath(" ")));
		if(element.isDisplayed()) {
			Results.updateresult("Element that is searched is displayed", "Passed");
		}else {
			for (int i1 = 0; i1 < 7; i1++) {
				JavascriptExecutor js2 = driver;
				HashMap<String, String> scrollObject2 = new HashMap<String, String>();
				scrollObject2.put("direction", "up");
				js2.executeScript("mobile: swipe", scrollObject2);
				Thread.sleep(2000);

			}
		}
		
		//If multiple items found
		
		List<WebElement> otherItemss = driver
				.findElements(By.xpath(""));
		java.util.Iterator<WebElement> o1 = otherItemss.iterator();
		int i = 0;
		while (o1.hasNext()) {
			WebElement textItem = o1.next();
				if(textItem.getAttribute("name").equalsIgnoreCase("")) {
						Results.updateresult("Depletion type Fullfillment is selected", "Done");
						break;
				}
			}
		}
	
	
	public static void addToCart(AndroidDriver<WebElement> driver) throws Exception {
		
		//Tapping on x and y cordinates
		
		WebElement text = driver.findElement(By.xpath("//XCUIElementTypeStaticText[1]"));
		int radioX = text.getLocation().getX();
		int radioY = text.getLocation().getY();
		tapElement(radioX, radioY, driver);
	}
	
	public static boolean tapElement(int x, int y, AndroidDriver<WebElement> driver) {
		try {
			new TouchAction(driver).tap(x, y).perform();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	public static void purchase(AndroidDriver<WebElement> driver) throws Exception {
		
		driver.findElement(By.xpath("")).sendKeys("");
	}
}
