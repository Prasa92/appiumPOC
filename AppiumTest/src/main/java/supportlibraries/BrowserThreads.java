package supportlibraries;

import io.appium.java_client.AppiumDriver;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import AppiumTest.Pages.AndroidHomePage;

import java.net.URL;
import java.util.Date;
import java.util.concurrent.TimeUnit;


public class BrowserThreads {

    private AppiumDriver driver;

  
    protected AndroidHomePage home;

    /**
     * wait wraps Helpers.wait *
     */
  

    /**
     * Keep the same date prefix to identify job sets. *
     */
    private static final Date date = new Date();


    /**
     * Run before each test *
     */
    @Before
   public void setup() {
    	
    }
    /**
     * Run after each test *
     */
    @After
    public void tearDown() throws Exception {
        if (driver != null) driver.quit();
    }

}
